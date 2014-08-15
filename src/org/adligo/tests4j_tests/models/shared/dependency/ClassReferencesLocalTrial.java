package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassAlias;
import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.ClassReferencesLocal;
import org.adligo.tests4j.models.shared.dependency.ClassReferencesLocalMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassAlias;
import org.adligo.tests4j.models.shared.dependency.I_ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferencesLocal;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.I_XML_Builder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassReferencesLocalMutant.class, minCoverage=30.0)
public class ClassReferencesLocalTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassReferencesLocal(null);
					}
				});
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassReferencesLocal(new ClassReferencesLocalMockNull());
					}
				});
		
	}
	
	@Test
	public void testGetsSetsAndConstructor() {
		ClassReferencesLocalMutant ccrm = new ClassReferencesLocalMutant(Class.class);
		assertEquals(Class.class.getName(), new ClassReferencesLocal(ccrm).getName());
		
		assertFalse(ccrm.hasCircularReferences());
		
		ccrm.setCircularReferences(new HashSet<I_ClassAliasLocal>());
		assertFalse(new ClassReferencesLocal(ccrm).hasCircularReferences());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		ClassReferencesLocal ccr = new ClassReferencesLocal(ccrm);
		assertTrue(ccr.hasCircularReferences());
		Set<I_ClassAliasLocal> instCircles = ccr.getCircularReferencesLocal();
		
		assertContains(instCircles, new ClassAliasLocal(Object.class));
		assertEquals(1, instCircles.size());
	}
	
	
	@Test
	public void testToString() {
		ClassReferencesLocalMutant ccrm = new ClassReferencesLocalMutant(Class.class);
		assertEquals("ClassReferencesLocal [name=java.lang.Class]", 
				new ClassReferencesLocal(ccrm).toString());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		assertEquals("ClassReferencesLocal [name=java.lang.Class, circularRefs=[java.lang.Object]]", 
				new ClassReferencesLocal(ccrm).toString());
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
