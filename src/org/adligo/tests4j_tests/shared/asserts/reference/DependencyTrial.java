package org.adligo.tests4j_tests.shared.asserts.reference;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.ClassAlias;
import org.adligo.tests4j.shared.asserts.reference.Dependency;
import org.adligo.tests4j.shared.asserts.reference.DependencyMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;

@SourceFileScope (sourceClass=Dependency.class)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class DependencyTrial extends SourceFileCountingTrial {

  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(DependencyMutant.CLASS_ALIAS_MAY_NOT_BE_SET_TO_A_NULL_VALUE)),
				new I_Thrower() {
					
					
          @Override
					public void run() {
						DependencyMutant dm = new DependencyMutant();
						new Dependency(dm);
					}
				});
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testConstructorCopy() {
		DependencyMutant dm = new DependencyMutant();
		ClassAlias ca = new ClassAlias("foo");
		dm.setAlias(ca);
		dm.addReference();
		dm.addReference();
		
		Dependency dep = new Dependency(dm);
		assertEquals(ca, dep.getAlias());
		assertEquals(2, dep.getReferences());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testMethodComparatorImpl() {
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
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodEqualsHashCodes() {
    DependencyMutant dm = new DependencyMutant();
    dm.setAlias(new ClassAlias("someName"));
    Dependency dm1 = new Dependency(dm);
    Dependency dm2 = new Dependency(dm1);
    
    
    DependencyMutant dmB = new DependencyMutant();
    dmB.setAlias(new ClassAlias("otherClassName"));
    Dependency dmB1 = new Dependency(dmB);
    
    DependencyMutant dmC = new DependencyMutant(dm);
    dmC.setAlias(new ClassAlias("otherClassName"));
    dmC.addReference();
    dmC.addReference();
    dmC.addReference();
    Dependency dmC1 = new Dependency(dmC);
    
    assertEquals(dm.hashCode(), dm1.hashCode());
    assertTrue(dm.equals(dm1));
    assertTrue(dm1.equals(dm));
    assertEquals(dm1.hashCode(), dm2.hashCode());
    assertTrue(dm2.equals(dm1));
    assertTrue(dm1.equals(dm2));
    
    assertNotEquals(dm.hashCode(), dmB1.hashCode());
    assertFalse(dm.equals(dmB1));
    assertFalse(dmB1.equals(dm));
    
    assertNotEquals(dm.hashCode(), dmC1.hashCode());
    assertFalse(dm.equals(dmC1));
    assertFalse(dmC1.equals(dm));
  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 19;
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
