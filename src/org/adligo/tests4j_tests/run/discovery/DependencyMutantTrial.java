package org.adligo.tests4j_tests.run.discovery;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.DependencyMutant;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=DependencyMutant.class)
public class DependencyMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testSetterExceptions() {
		final DependencyMutant dm = new DependencyMutant();
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DependencyMutant.CLASS_NAME_MAY_NOT_BE_SET_TO_A_EMPTY_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						dm.setClazzName(null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DependencyMutant.CLASS_NAME_MAY_NOT_BE_SET_TO_A_EMPTY_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						dm.setClazzName("");
					}
				});
	}
	@Test
	public void testGetsSetsAndConstructor() {
		DependencyMutant dm = new DependencyMutant();
		assertNull(dm.getClassName());
		assertEquals(0, dm.getReferences());
		
		dm.addReference();
		assertEquals(1, dm.getReferences());
		
		dm.setClazzName("someName");
		assertEquals("someName", dm.getClassName());
		
		DependencyMutant copy = new DependencyMutant(dm);
		assertEquals(1, copy.getReferences());
		assertEquals("someName", copy.getClassName());
	}
	
	
	@Test
	public void testComparatorImpl() {
		DependencyMutant dm = new DependencyMutant();
		dm.addReference();
		assertEquals(1, dm.getReferences());
		
		dm.setClazzName("someName");
		assertEquals("someName", dm.getClassName());
		
		DependencyMutant dmB = new DependencyMutant();
		assertEquals(0, dmB.getReferences());
		dmB.setClazzName("otherClassName");
		assertEquals("otherClassName", dmB.getClassName());
		
		assertEquals(1, dmB.compareTo(dm));
		assertEquals(-1, dm.compareTo(dmB));
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 14;
	}

	@Override
	public int getUniqueAsserts() {
		return 11;
	}
}
