package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.shared.asserts.ContainsAssertCommand;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.shared.asserts.common.I_CollectionContainsAssertionData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;

import java.util.Collections;
import java.util.List;

@SourceFileScope (sourceClass=ContainsAssertCommand.class, minCoverage=70.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class ContainsAssertCommandTrial extends SourceFileCountingTrial {

  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
		I_Tests4J_AssertionInputMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getTheExpectedValueShouldNeverBeNull())),
				new I_Thrower() {
		  
          @Override
					public void run() {
						new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH,
						    "failure message", null, null);
					}
				});
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testEqualsHashCode() {
		ContainsAssertCommand a = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				    Collections.singletonList("hey"), "hey");
		ContainsAssertCommand b = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				    Collections.singletonList("hey1"), "hey");
		ContainsAssertCommand c = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				    Collections.singletonList("hey"), "hey");
		ContainsAssertCommand d = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message1", 
				    Collections.singletonList("hey"), "hey");
		ContainsAssertCommand e = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				    Collections.singletonList("hey"), "hey1");
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	
	@Test
	public void testGetters() {
		List<String> col = Collections.singletonList("hey");
		String hey = "hey";
		ContainsAssertCommand a = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", col, hey);
		I_AssertionData data = a.getData();
		assertNotNull(data);
		I_CollectionContainsAssertionData ccad  = (I_CollectionContainsAssertionData) data;
		
		assertSame(col, ccad.getCollection());
		assertSame(hey, ccad.getValue());
		assertSame(a, a.getData());
		assertEquals("failure message", a.getFailureMessage());
		assertEquals(AssertType.AssertContains, a.getType());
	}
	
	@Test
	public void testEvaluate() {
		List<String> col = Collections.singletonList("hey");
		String hey = "hey";
		ContainsAssertCommand a = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", col, hey);
		assertTrue(a.evaluate());
		
		ContainsAssertCommand b = 
				new ContainsAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", col, "he");
		assertFalse(b.evaluate());
	
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 19;
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
