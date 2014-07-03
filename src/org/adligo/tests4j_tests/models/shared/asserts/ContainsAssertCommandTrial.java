package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.ContainsAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=ContainsAssertCommand.class)
public class ContainsAssertCommandTrial extends SourceFileTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				new Tests4J_AssertionResultMessages().getTheExpectedValueShouldNeverBeNull())),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ContainsAssertCommand("failure message", null, null);
					}
				});
	}
	
	@Test
	public void testEqualsHashCode() {
		ContainsAssertCommand a = 
				new ContainsAssertCommand("failure message", Collections.singletonList("hey"), "hey");
		ContainsAssertCommand b = 
				new ContainsAssertCommand("failure message", Collections.singletonList("hey1"), "hey");
		ContainsAssertCommand c = 
				new ContainsAssertCommand("failure message", Collections.singletonList("hey"), "hey");
		ContainsAssertCommand d = 
				new ContainsAssertCommand("failure message1", Collections.singletonList("hey"), "hey");
		ContainsAssertCommand e = 
				new ContainsAssertCommand("failure message", Collections.singletonList("hey"), "hey1");
		
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
				new ContainsAssertCommand("failure message", col, hey);
		Set<String> keys = a.getKeys();
		assertNotNull(keys);
		assertEquals(2, keys.size());
		assertTrue(keys.contains(ContainsAssertCommand.VALUE));
		assertTrue(keys.contains(ContainsAssertCommand.COLLECTION));
		
		assertSame(col, a.getData(ContainsAssertCommand.COLLECTION));
		assertSame(hey, a.getData(ContainsAssertCommand.VALUE));
		assertSame(a, a.getData());
		assertEquals("failure message", a.getFailureMessage());
		assertEquals(AssertType.AssertContains, a.getType());
	}
	
	@Test
	public void testEvaluate() {
		List<String> col = Collections.singletonList("hey");
		String hey = "hey";
		ContainsAssertCommand a = 
				new ContainsAssertCommand("failure message", col, hey);
		assertTrue(a.evaluate());
		
		ContainsAssertCommand b = 
				new ContainsAssertCommand("failure message", col, "he");
		assertFalse(b.evaluate());
	
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(19.0, p.getAssertions());
		assertGreaterThanOrEquals(9.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(70.0, coverage.getPercentageCoveredDouble());
		}
	}
}
