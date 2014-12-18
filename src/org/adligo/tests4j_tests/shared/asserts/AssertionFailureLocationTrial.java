package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.shared.asserts.AssertionFailureLocation;
import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.StackTraceBuilder;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;
import org.adligo.tests4j_tests.shared.asserts.common.AssertTypeTrial;

//TODO look at the code coverage it should be 100.0
@SourceFileScope (sourceClass=AssertionFailureLocation.class, minCoverage=73.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class AssertionFailureLocationTrial extends SourceFileCountingTrial {

	
	@Test
	public void testAssertionStack() {
		AssertionFailureLocation afl = new AssertionFailureLocation(null);
		StackTraceElement [] elements =  afl.getStackTrace();
		assertGreaterThanOrEquals(10, elements.length);
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionFailureLocationTrial.class.getName(),  e.getClassName());
		assertEquals("testAssertionStack",  e.getMethodName());
		assertEquals(22,  e.getLineNumber());
		
		TextLines lines = new TextLines(StackTraceBuilder.toString(afl, true), true);
		assertUniform("	org.adligo.tests4j.shared.asserts.AssertionFailureLocation", lines.getLine(0));
		assertUniform("\tat org.adligo.tests4j_tests.shared.asserts."
				+ "AssertionFailureLocationTrial.testAssertionStack("
				+ "AssertionFailureLocationTrial.java:22)", lines.getLine(1));
		
	}

	
	@SuppressWarnings("boxing")
  @Test
  public void testAssertionStackWithTrial() {
    AssertionFailureLocation afl = new AssertionFailureLocation(new AssertTypeTrial());
    StackTraceElement [] elements =  afl.getStackTrace();
    assertGreaterThanOrEquals(10, elements.length);
    
    StackTraceElement e = elements[0];
    assertEquals(AssertTypeTrial.class.getName(),  e.getClassName());
    assertEquals("init",  e.getMethodName());
    assertEquals(1,  e.getLineNumber());
    
    e = elements[1];
    assertEquals(AssertionFailureLocationTrial.class.getName(),  e.getClassName());
    assertEquals("testAssertionStackWithTrial",  e.getMethodName());
    assertEquals(43,  e.getLineNumber());
    
    TextLines lines = new TextLines(StackTraceBuilder.toString(afl, true), true);
    assertUniform("\torg.adligo.tests4j.shared.asserts.AssertionFailureLocation", lines.getLine(0));
    assertUniform("\tat org.adligo.tests4j_tests.shared.asserts.common."
        + "AssertTypeTrial.init("
        + "AssertTypeTrial.java:1)", lines.getLine(1));
    assertUniform("\tat org.adligo.tests4j_tests.shared.asserts."
        + "AssertionFailureLocationTrial.testAssertionStackWithTrial("
        + "AssertionFailureLocationTrial.java:43)", lines.getLine(2));
    
  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 16;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 3);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 13;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
