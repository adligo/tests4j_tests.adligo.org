package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.dependency.ClassAlias;
import org.adligo.tests4j.models.shared.dependency.DependencyMutant;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=DependencyMutant.class, minCoverage=80.0)
public class DependencyMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testSetterExceptions() {
		final DependencyMutant dm = new DependencyMutant();
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DependencyMutant.CLASS_ALIAS_MAY_NOT_BE_SET_TO_A_NULL_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						dm.setAlias(null);
					}
				});
	}
	@Test
	public void testGetsSetsAndConstructor() {
		DependencyMutant dm = new DependencyMutant();
		assertNull(dm.getAlias());
		assertEquals(0, dm.getReferences());
		
		dm.addReference();
		assertEquals(1, dm.getReferences());
		
		ClassAlias ca = new ClassAlias("someName");
		dm.setAlias(ca);
		assertEquals(ca, dm.getAlias());
		
		DependencyMutant copy = new DependencyMutant(dm);
		assertEquals(1, copy.getReferences());
		assertEquals(ca, copy.getAlias());
		
		
	}
	
	
	@Test
	public void testComparatorImpl() {
		DependencyMutant dm = new DependencyMutant();
		dm.addReference();
		dm.addReference();
		assertEquals(2, dm.getReferences());
		
		ClassAlias ca = new ClassAlias("someName");
		dm.setAlias(ca);
		assertEquals(ca, dm.getAlias());
		
		DependencyMutant dmB = new DependencyMutant();
		assertEquals(0, dmB.getReferences());
		ca = new ClassAlias("otherClassName");
		dmB.setAlias(ca);
		assertEquals(ca, dmB.getAlias());
		
		assertEquals(2, dmB.compareTo(dm));
		assertEquals(-2, dm.compareTo(dmB));
		
		DependencyMutant dmC = new DependencyMutant(dm);
		dmC.setAlias(new ClassAlias("someOtherName"));
		
		//compare the names
		assertEquals(-1, dm.compareTo(dmC));
		assertEquals(1, dmC.compareTo(dm));
		
		Set<I_Dependency> order = new TreeSet<I_Dependency>();
		order.add(dm);
		order.add(dmB);
		order.add(dmC);
		
		Iterator<I_Dependency> it = order.iterator();
		assertEquals(dm, it.next());
		assertEquals(dmC, it.next());
		assertEquals(dmB, it.next());
	}

	@Test
	public void testComparatorImpl_FromMockWithMethodException() {
		DependencyMutant dmObj = new DependencyMutant();
		dmObj.setAlias(new ClassAlias(Object.class));
		for (int i = 0; i < 4; i++) {
			dmObj.addReference();
		}
		
		DependencyMutant dmExc = new DependencyMutant();
		dmExc.setAlias(new ClassAlias(Exception.class));
		for (int i = 0; i < 4; i++) {
			dmExc.addReference();
		}
		
		DependencyMutant dmMe = new DependencyMutant();
		dmMe.setAlias(new ClassAlias(MockException.class));
		for (int i = 0; i < 4; i++) {
			dmMe.addReference();
		}
		
		DependencyMutant dmN = new DependencyMutant();
		dmN.setAlias(new ClassAlias(MockWithNothing.class));
		for (int i = 0; i < 4; i++) {
			dmN.addReference();
		}
		
		DependencyMutant dmMw = new DependencyMutant();
		dmMw.setAlias(new ClassAlias(MockWithMethodException.class));
		
		Set<I_Dependency> order = new TreeSet<I_Dependency>();
		order.add(dmObj);
		order.add(dmExc);
		order.add(dmMe);
		order.add(dmN);
		order.add(dmMw);
		
		Iterator<I_Dependency> it = order.iterator();
		assertEquals(dmExc, it.next());
		assertEquals(dmObj, it.next());
		assertEquals(dmMe, it.next());
		assertEquals(dmN, it.next());
		assertEquals(dmMw, it.next());
	}
	
	@Test
	public void testToString() {
		DependencyMutant dm = new DependencyMutant();
		dm.setAlias(new ClassAlias("foo"));
		dm.addReference();
		dm.addReference();
		assertEquals("DependencyMutant [alias=foo, references=2]", dm.toString());
		
		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 24;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 21;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
