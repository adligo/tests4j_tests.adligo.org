package org.adligo.tests4j_tests.run.discovery;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.Dependency;
import org.adligo.tests4j.run.discovery.DependencyMutant;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Dependency.class)
public class DependencyTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(DependencyMutant.CLASS_NAME_MAY_NOT_BE_SET_TO_A_EMPTY_VALUE)),
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
		dm.setClazzName("foo");
		dm.addReference();
		dm.addReference();
		assertEquals("foo", dm.getClazzName());
		assertEquals(2, dm.getReferences());
		
		Dependency dep = new Dependency(dm);
		assertEquals("foo", dep.getClazzName());
		assertEquals(2, dep.getReferences());
	}
	
	@Test
	public void testComparatorImpl() {
		DependencyMutant dm = new DependencyMutant();
		dm.addReference();
		assertEquals(1, dm.getReferences());
		dm.setClazzName("someName");
		
		DependencyMutant dmB = new DependencyMutant();
		dmB.setClazzName("otherClassName");
		
		Dependency a = new Dependency(dm);
		Dependency b = new Dependency(dmB);
		
		
		assertEquals(1, b.compareTo(a));
		assertEquals(-1, a.compareTo(b));
	}
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 8;
	}

	@Override
	public int getUniqueAsserts() {
		return 5;
	}

}
