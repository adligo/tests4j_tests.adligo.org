package org.adligo.tests4j_tests.mockito;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.ObjParams;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ObjParams.class, minCoverage=82.0)
public class ObjParamsTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@SuppressWarnings("unused")
          @Override
					public void run() throws Throwable {
						new ObjParams(null);
					}
				});
	}

	
	
	@Test
	public void testEqualsHashCode_AndToString() {
	  ObjParams a = new ObjParams(new Object[]{"ObjectA"});
	  ObjParams a1 = new ObjParams(new Object[]{"ObjectA"});
	  ObjParams b = new ObjParams(new Object[]{"ObjectB"});
	  ObjParams b1 = new ObjParams(new Object[]{"ObjectA","ObjectB"});
	  ObjParams c = new ObjParams(new Object[]{"ObjectA","ObjectC"});
	  
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		assertEquals("ObjParams [delegate_=[ObjectA]]", a.toString());
		
		assertEquals(a, a1);
    assertEquals(a.hashCode(), a1.hashCode());
    assertEquals("ObjParams [delegate_=[ObjectA]]", a1.toString());
    
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		assertEquals("ObjParams [delegate_=[ObjectB]]", b.toString());
		
		assertNotEquals(a, b1);
    assertNotEquals(a.hashCode(), b1.hashCode());
    assertEquals("ObjParams [delegate_=[ObjectA, ObjectB]]", b1.toString());
    
    assertNotEquals(b1, a);
    assertNotEquals(b1.hashCode(), a.hashCode());
    
    assertNotEquals(c, b1);
    assertNotEquals(c.hashCode(), b1.hashCode());
    assertEquals("ObjParams [delegate_=[ObjectA, ObjectC]]", c.toString());
    
    assertNotEquals(b1, c);
    assertNotEquals(b1.hashCode(), c.hashCode());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, false);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 20;
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
		int thisUniqueAsserts = 11;
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

