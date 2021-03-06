package org.adligo.tests4j_tests.shared.asserts.reference;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.ClassAlias;
import org.adligo.tests4j.shared.asserts.reference.DependencyMutant;
import org.adligo.tests4j.shared.asserts.reference.I_Dependency;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=DependencyMutant.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class DependencyMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testSetterExceptions() {
		final DependencyMutant dm = new DependencyMutant();
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				DependencyMutant.CLASS_ALIAS_MAY_NOT_BE_SET_TO_A_NULL_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						dm.setAlias(null);
					}
				});
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testMethodsGetsSetsAndConstructor() {
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
	
	
	@SuppressWarnings("boxing")
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
	public void testMethodComparatorImpl_FromMockWithMethodException() {
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
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodEqualsHashCodes() {
    DependencyMutant dm = new DependencyMutant();
    dm.setAlias(new ClassAlias("someName"));
   
    DependencyMutant dmA = new DependencyMutant();
    dmA.setAlias(new ClassAlias("someName"));
    
    DependencyMutant dmB = new DependencyMutant();
    dmB.setAlias(new ClassAlias("otherClassName"));
   
    DependencyMutant dmC = new DependencyMutant(dm);
    dmC.setAlias(new ClassAlias("someOtherName"));
    
    assertEquals(dm.hashCode(), dmA.hashCode());
    assertTrue(dm.equals(dmA));
    assertTrue(dmA.equals(dm));
    
    assertNotEquals(dm.hashCode(), dmB.hashCode());
    assertFalse(dm.equals(dmB));
    assertFalse(dmB.equals(dm));
    
    assertNotEquals(dm.hashCode(), dmC.hashCode());
    assertFalse(dm.equals(dmC));
    assertFalse(dmC.equals(dm));
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
		return super.getTests(type, 6, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 33;
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
		int thisUniqueAsserts = 26;
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
