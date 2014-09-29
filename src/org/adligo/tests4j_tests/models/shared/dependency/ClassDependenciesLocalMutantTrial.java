package org.adligo.tests4j_tests.models.shared.dependency;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.ClassDependenciesLocalMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAliasLocal;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_Dependency_DependencyGroup;

@SourceFileScope (sourceClass=ClassDependenciesLocalMutant.class, minCoverage=32.0)
@AllowedDependencies (groups=Tests4J_Dependency_DependencyGroup.class)
public class ClassDependenciesLocalMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassDependenciesLocalMutant((I_ClassDependenciesLocal) null);
					}
				});
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassDependenciesLocalMutant((Class<?>) null);
					}
				});
	}
	
	@Test
	public void testGetsSetsAndConstructor() {
		ClassDependenciesLocalMutant ccrm = new ClassDependenciesLocalMutant(Class.class);
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
		ClassDependenciesLocalMutant ccrm = new ClassDependenciesLocalMutant(Class.class);
		assertEquals("ClassDependenciesLocalMutant [name=java.lang.Class]", ccrm.toString());
		
		Set<I_ClassAliasLocal> circles = new HashSet<I_ClassAliasLocal>();
		circles.add(new ClassAliasLocal(Object.class));
		ccrm.setCircularReferences(circles);
		assertEquals("ClassDependenciesLocalMutant [name=java.lang.Class, circularRefs=[java.lang.Object]]", ccrm.toString());
	
		ccrm.addParent(new ClassParentsLocal(Serializable.class));
		assertEquals("ClassDependenciesLocalMutant [name=java.lang.Class, parents=[java.io.Serializable], circularRefs=[java.lang.Object]]"
				, ccrm.toString());
		
		ccrm.addDependency(new ClassParentsLocal(Runnable.class));
		assertEquals("ClassDependenciesLocalMutant [name=java.lang.Class, parents=[java.io.Serializable], circularRefs=[java.lang.Object],"
				+ " references=[java.lang.Runnable]]", ccrm.toString());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
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
