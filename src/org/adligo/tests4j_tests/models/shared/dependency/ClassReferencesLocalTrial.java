package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassAlias;
import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.dependency.ClassDependenciesLocalMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassAlias;
import org.adligo.tests4j.models.shared.dependency.I_ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.I_XML_Builder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassDependenciesLocalMutant.class, minCoverage=30.0)
public class ClassReferencesLocalTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassDependenciesLocal(null);
					}
				});
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassDependenciesLocal(new ClassReferencesLocalMockNull());
					}
				});
		
	}
	
	@Test
	public void testGetsSetsAndConstructor() {
		ClassDependenciesLocalMutant ccrm = new ClassDependenciesLocalMutant(Class.class);
		assertEquals(Class.class.getName(), new ClassDependenciesLocal(ccrm).getName());
		
		assertFalse(ccrm.hasCircularDependencies());
		
		ccrm.setCircularReferences(new HashSet<I_ClassAliasLocal>());
		assertFalse(new ClassDependenciesLocal(ccrm).hasCircularDependencies());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		ClassDependenciesLocal ccr = new ClassDependenciesLocal(ccrm);
		assertTrue(ccr.hasCircularDependencies());
		Set<I_ClassAliasLocal> instCircles = ccr.getCircularDependenciesLocal();
		
		assertContains(instCircles, new ClassAliasLocal(Object.class));
		assertEquals(1, instCircles.size());
	}
	
	
	@Test
	public void testToString() {
		ClassDependenciesLocalMutant ccrm = new ClassDependenciesLocalMutant(Class.class);
		assertEquals("ClassDependenciesLocal [name=java.lang.Class]", 
				new ClassDependenciesLocal(ccrm).toString());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		assertEquals("ClassDependenciesLocal [name=java.lang.Class, circularRefs=[java.lang.Object]]", 
				new ClassDependenciesLocal(ccrm).toString());
	}
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 10;
	}

	@Override
	public int getUniqueAsserts() {
		return 9;
	}
}
