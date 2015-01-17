package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.StringMethods;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;

@SourceFileScope (sourceClass=StringMethods.class, minCoverage=92.0)
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
public class StringMethodsTrial extends SourceFileCountingTrial {

  @SuppressWarnings("boxing")
  @Test
  public void testStaticMethodOrderLine() {
    
    assertEquals("a c", StringMethods.orderLine(true, "a"," ","c"));
    I_Tests4J_Constants constantsMock = mock(I_Tests4J_Constants.class);
    when(constantsMock.isLeftToRight()).thenReturn(false);
    assertEquals("c a", StringMethods.orderLine(false, "a"," ","c"));
  }
  
	@SuppressWarnings("boxing")
  @Test
	public void testMethods() {
		assertTrue(StringMethods.isEmpty(null));
		assertTrue(StringMethods.isEmpty(""));
		assertTrue(StringMethods.isEmpty("\t"));
		assertTrue(StringMethods.isEmpty("\n"));
		assertFalse(StringMethods.isEmpty("hey"));
		
		assertThrown(new ExpectedThrowable(new IllegalArgumentException("null message.")), new I_Thrower() {
			
			@Override
			public void run() {
				StringMethods.isEmpty(null, "null message.");
			}
		});
		
		assertEquals(0, StringMethods.indexBoundsFix("hey", -1));
		assertEquals(0, StringMethods.indexBoundsFix("hey", 0));
		assertEquals(3, StringMethods.indexBoundsFix("hey", 4));
		assertEquals(3, StringMethods.indexBoundsFix("hey", 3));
		assertEquals(1, StringMethods.indexBoundsFix("hey", 1));
		assertEquals(2, StringMethods.indexBoundsFix("hey", 2));
		

	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 14;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uasserts = 9;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
