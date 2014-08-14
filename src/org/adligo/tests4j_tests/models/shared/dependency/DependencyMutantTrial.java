package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.DependencyMutant;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=DependencyMutant.class, minCoverage=80.0)
public class DependencyMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testSetterExceptions() {
		final DependencyMutant dm = new DependencyMutant();
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DependencyMutant.CLASS_NAME_MAY_NOT_BE_SET_TO_A_EMPTY_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						dm.setClassName(null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DependencyMutant.CLASS_NAME_MAY_NOT_BE_SET_TO_A_EMPTY_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						dm.setClassName("");
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
		
		dm.setClassName("someName");
		assertEquals("someName", dm.getClassName());
		
		DependencyMutant copy = new DependencyMutant(dm);
		assertEquals(1, copy.getReferences());
		assertEquals("someName", copy.getClassName());
	}
	
	
	@Test
	public void testComparatorImpl() {
		DependencyMutant dm = new DependencyMutant();
		dm.addReference();
		dm.addReference();
		assertEquals(2, dm.getReferences());
		
		dm.setClassName("someName");
		assertEquals("someName", dm.getClassName());
		
		DependencyMutant dmB = new DependencyMutant();
		assertEquals(0, dmB.getReferences());
		dmB.setClassName("otherClassName");
		assertEquals("otherClassName", dmB.getClassName());
		
		assertEquals(2, dmB.compareTo(dm));
		assertEquals(-2, dm.compareTo(dmB));
		
		DependencyMutant dmC = new DependencyMutant(dm);
		dmC.setClassName("someOtherName");
		
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
		dmObj.setClassName(Object.class.getName());
		for (int i = 0; i < 4; i++) {
			dmObj.addReference();
		}
		
		DependencyMutant dmExc = new DependencyMutant();
		dmExc.setClassName(Exception.class.getName());
		for (int i = 0; i < 4; i++) {
			dmExc.addReference();
		}
		
		DependencyMutant dmMe = new DependencyMutant();
		dmMe.setClassName(MockException.class.getName());
		for (int i = 0; i < 4; i++) {
			dmMe.addReference();
		}
		
		DependencyMutant dmN = new DependencyMutant();
		dmN.setClassName(MockWithNothing.class.getName());
		for (int i = 0; i < 4; i++) {
			dmN.addReference();
		}
		
		DependencyMutant dmMw = new DependencyMutant();
		dmMw.setClassName(MockWithMethodException.class.getName());
		
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
		dm.setClassName("foo");
		dm.addReference();
		dm.addReference();
		assertEquals("DependencyMutant [clazzName=foo, references=2]", dm.toString());
		
		
	}
	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 25;
	}

	@Override
	public int getUniqueAsserts() {
		return 22;
	}
}
