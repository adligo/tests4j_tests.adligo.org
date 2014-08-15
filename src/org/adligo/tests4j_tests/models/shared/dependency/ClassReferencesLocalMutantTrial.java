package org.adligo.tests4j_tests.models.shared.dependency;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.ClassReferencesLocalMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferencesLocal;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassReferencesLocalMutant.class, minCoverage=32.0)
public class ClassReferencesLocalMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassReferencesLocalMutant((I_ClassReferencesLocal) null);
					}
				});
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassReferencesLocalMutant((Class<?>) null);
					}
				});
	}
	
	@Test
	public void testGetsSetsAndConstructor() {
		ClassReferencesLocalMutant ccrm = new ClassReferencesLocalMutant(Class.class);
		assertEquals(Class.class.getName(), ccrm.getName());
		
		assertFalse(ccrm.hasCircularReferences());
		
		ccrm.setCircularReferences(new HashSet<I_ClassAliasLocal>());
		assertFalse(ccrm.hasCircularReferences());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		assertTrue(ccrm.hasCircularReferences());
		Set<I_ClassAliasLocal> instCircles = ccrm.getCircularReferencesLocal();
		
		assertContains(instCircles, new ClassAliasLocal(Object.class));
		assertEquals(1, instCircles.size());
	}
	
	
	@Test
	public void testToString() {
		ClassReferencesLocalMutant ccrm = new ClassReferencesLocalMutant(Class.class);
		assertEquals("ClassReferencesLocalMutant [name=java.lang.Class]", ccrm.toString());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		assertEquals("ClassReferencesLocalMutant [name=java.lang.Class, circularRefs=[java.lang.Object]]", ccrm.toString());
	
		ccrm.addParent(new ClassParentsLocal(Serializable.class));
		assertEquals("ClassReferencesLocalMutant [name=java.lang.Class, parents=[java.io.Serializable], circularRefs=[java.lang.Object]]"
				, ccrm.toString());
		
		ccrm.addReference(new ClassParentsLocal(Runnable.class));
		assertEquals("ClassReferencesLocalMutant [name=java.lang.Class, parents=[java.io.Serializable], circularRefs=[java.lang.Object],"
				+ " references=[java.lang.Runnable]]", ccrm.toString());
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 12;
	}

	@Override
	public int getUniqueAsserts() {
		return 11;
	}
}
