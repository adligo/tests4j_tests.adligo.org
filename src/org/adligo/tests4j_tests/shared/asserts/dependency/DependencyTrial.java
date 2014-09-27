package org.adligo.tests4j_tests.shared.asserts.dependency;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_AssertsDependency_DependencyGroup;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Dependency_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.ClassAlias;
import org.adligo.tests4j.shared.asserts.dependency.Dependency;
import org.adligo.tests4j.shared.asserts.dependency.DependencyMutant;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Dependency.class)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
public class DependencyTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(DependencyMutant.CLASS_ALIAS_MAY_NOT_BE_SET_TO_A_NULL_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						DependencyMutant dm = new DependencyMutant();
						new Dependency(dm);
					}
				});
	}
	
	@Test
	public void testCopyConstructor() {
		DependencyMutant dm = new DependencyMutant();
		ClassAlias ca = new ClassAlias("foo");
		dm.setAlias(ca);
		dm.addReference();
		dm.addReference();
		assertEquals(ca, dm.getAlias());
		assertEquals(2, dm.getReferences());
		
		Dependency dep = new Dependency(dm);
		assertEquals(ca, dep.getAlias());
		assertEquals(2, dep.getReferences());
	}
	
	@Test
	public void testComparatorImpl() {
		DependencyMutant dm = new DependencyMutant();
		dm.addReference();
		assertEquals(1, dm.getReferences());
		dm.setAlias(new ClassAlias("someName"));
		
		DependencyMutant dmB = new DependencyMutant();
		dmB.setAlias(new ClassAlias("otherClassName"));
		
		Dependency a = new Dependency(dm);
		Dependency b = new Dependency(dmB);
		
		
		assertEquals(1, b.compareTo(a));
		assertEquals(-1, a.compareTo(b));
	}
	
	@Test
	public void testToString() {
		DependencyMutant dm = new DependencyMutant();
		dm.setAlias(new ClassAlias("foo"));
		dm.addReference();
		dm.addReference();
		assertEquals("Dependency [alias=foo, references=2]", new Dependency(dm).toString());
		
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 9;
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
		int thisUniqueAsserts = 6;
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
