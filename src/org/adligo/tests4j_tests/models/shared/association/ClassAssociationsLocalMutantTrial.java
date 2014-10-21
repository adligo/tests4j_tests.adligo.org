package org.adligo.tests4j_tests.models.shared.association;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.association.ClassAssociationsLocalMutant;
import org.adligo.tests4j.models.shared.association.ClassParentsLocal;
import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAliasLocal;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Association_GwtReferenceGroup;

@SourceFileScope (sourceClass=ClassAssociationsLocalMutant.class, minCoverage=32.0)
@AllowedReferences (groups=Tests4J_Association_GwtReferenceGroup.class)
public class ClassAssociationsLocalMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassAssociationsLocalMutant((I_ClassAssociationsLocal) null);
					}
				});
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassAssociationsLocalMutant((Class<?>) null);
					}
				});
	}
	
	@Test
	public void testGetsSetsAndConstructor() {
		ClassAssociationsLocalMutant ccrm = new ClassAssociationsLocalMutant(Class.class);
		assertEquals(Class.class.getName(), ccrm.getName());
		
		assertFalse(ccrm.hasCircularDependencies());
		
		ccrm.setCircularReferences(new HashSet<I_ClassAliasLocal>());
		assertFalse(ccrm.hasCircularDependencies());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		assertTrue(ccrm.hasCircularDependencies());
		Set<I_ClassAliasLocal> instCircles = ccrm.getCircularDependenciesLocal();
		
		assertContains(instCircles, new ClassAliasLocal(Object.class));
		assertEquals(1, instCircles.size());
	}
	
	
	@Test
	public void testToString() {
		ClassAssociationsLocalMutant ccrm = new ClassAssociationsLocalMutant(Class.class);
		assertEquals("ClassAssociationsLocalMutant [name=java.lang.Class]", ccrm.toString());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		assertEquals("ClassAssociationsLocalMutant [name=java.lang.Class, circularRefs=[java.lang.Object]]", ccrm.toString());
	
		ccrm.addParent(new ClassParentsLocal(Serializable.class));
		assertEquals("ClassAssociationsLocalMutant [name=java.lang.Class, parents=[java.io.Serializable], circularRefs=[java.lang.Object]]"
				, ccrm.toString());
		
		ccrm.addDependency(new ClassParentsLocal(Runnable.class));
		assertEquals("ClassAssociationsLocalMutant [name=java.lang.Class, parents=[java.io.Serializable], circularRefs=[java.lang.Object],"
				+ " dependencies=[java.lang.Runnable]]", ccrm.toString());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 12;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 11;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
