package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.UniformThrownAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.uniform.Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.ThrowableUniformEvaluator;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=UniformThrownAssertCommand.class)
public class UniformThrownAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				new Tests4J_AssertionInputMessages().getExpectedThrownDataRequiresThrowable())),
				new I_Thrower() {
					
					@Override
					public void run() {
						new UniformThrownAssertCommand("failure message", null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				new Tests4J_AssertionInputMessages().getExpectedThrownDataRequiresMessage())),
				new I_Thrower() {
					
					@Override
					public void run() {
						new UniformThrownAssertCommand("failure message", 
								new ExpectedThrownData(new IllegalArgumentException("")));
					}
				});
	}
	
	@Test
	public void testGettersBeforeEvaluate() {
		IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand("failure message", 
				etd);
		assertEquals("failure message", utac.getFailureMessage());
		assertEquals(iae, utac.getExpected());
		assertNull(utac.getActual());
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		Set<String> keys = tad.getKeys();
		assertEquals("java.util.Collections$UnmodifiableSet", keys.getClass().getName());
		assertEquals(4, keys.size());
		assertContains(keys, ThrownAssertionData.ACTUAL_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.ACTUAL_MESSAGE);
		assertContains(keys, ThrownAssertionData.EXPECTED_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.EXPECTED_MESSAGE);
		
		assertNull(data.getData(ThrownAssertionData.ACTUAL_THROWABLE_CLASS));
		assertNull(data.getData(ThrownAssertionData.ACTUAL_MESSAGE));
		assertEquals(IllegalArgumentException.class, data.getData(ThrownAssertionData.EXPECTED_THROWABLE_CLASS));
		assertEquals("expected exception messsage", data.getData(ThrownAssertionData.EXPECTED_MESSAGE));
		
		assertNull(tad.getActualMessage());
		assertNull(tad.getActualThrowable());
		assertEquals(IllegalArgumentException.class, tad.getExpectedThrowable());
		assertEquals("expected exception messsage", tad.getExpectedMessage());
		
	}
	
	@Test
	public void testGettersAfterEvaluate() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand("failure message", 
				etd);
		assertEquals("failure message", utac.getFailureMessage());
		assertEquals(iae, utac.getExpected());
		
		utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}, new ThrowableUniformEvaluator());
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		Set<String> keys = tad.getKeys();
		assertEquals("java.util.Collections$UnmodifiableSet", keys.getClass().getName());
		assertEquals(4, keys.size());
		assertContains(keys, ThrownAssertionData.ACTUAL_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.ACTUAL_MESSAGE);
		assertContains(keys, ThrownAssertionData.EXPECTED_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.EXPECTED_MESSAGE);
		
		assertEquals(IllegalArgumentException.class, data.getData(ThrownAssertionData.ACTUAL_THROWABLE_CLASS));
		assertEquals("expected exception messsage", data.getData(ThrownAssertionData.ACTUAL_MESSAGE));
		assertEquals(IllegalArgumentException.class, data.getData(ThrownAssertionData.EXPECTED_THROWABLE_CLASS));
		assertEquals("expected exception messsage", data.getData(ThrownAssertionData.EXPECTED_MESSAGE));
		
		assertEquals(IllegalArgumentException.class, tad.getActualThrowable());
		assertEquals("expected exception messsage", tad.getActualMessage());
		assertEquals(IllegalArgumentException.class, tad.getExpectedThrowable());
		assertEquals("expected exception messsage", tad.getExpectedMessage());
		
	}
	
	
	@Test
	public void testEvaluatePass() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand("failure message", 
				etd);
		assertEquals("failure message", utac.getFailureMessage());
		assertEquals(iae, utac.getExpected());
		
		assertTrue(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}, new ThrowableUniformEvaluator()));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		Set<String> keys = tad.getKeys();
		assertEquals("java.util.Collections$UnmodifiableSet", keys.getClass().getName());
		assertEquals(4, keys.size());
		assertContains(keys, ThrownAssertionData.ACTUAL_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.ACTUAL_MESSAGE);
		assertContains(keys, ThrownAssertionData.EXPECTED_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.EXPECTED_MESSAGE);
		
		assertEquals(IllegalArgumentException.class, data.getData(ThrownAssertionData.ACTUAL_THROWABLE_CLASS));
		assertEquals("expected exception messsage", data.getData(ThrownAssertionData.ACTUAL_MESSAGE));
		assertEquals(IllegalArgumentException.class, data.getData(ThrownAssertionData.EXPECTED_THROWABLE_CLASS));
		assertEquals("expected exception messsage", data.getData(ThrownAssertionData.EXPECTED_MESSAGE));
		
		assertEquals(IllegalArgumentException.class, tad.getActualThrowable());
		assertEquals("expected exception messsage", tad.getActualMessage());
		assertEquals(IllegalArgumentException.class, tad.getExpectedThrowable());
		assertEquals("expected exception messsage", tad.getExpectedMessage());
		
		I_Evaluation eval =  utac.getResult();
		assertTrue(eval.isSuccess());
		Map<String, Object> evalData = eval.getData();
		assertNotNull(evalData);
		assertEquals(0, evalData.size());
	}
	
	@Test
	public void testEvaluateFail() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand("failure message", 
				etd);
		assertEquals("failure message", utac.getFailureMessage());
		assertEquals(iae, utac.getExpected());
		
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalArgumentException("expected exception messsage 2");
			}
		}, new ThrowableUniformEvaluator()));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		Set<String> keys = tad.getKeys();
		assertEquals("java.util.Collections$UnmodifiableSet", keys.getClass().getName());
		assertEquals(4, keys.size());
		assertContains(keys, ThrownAssertionData.ACTUAL_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.ACTUAL_MESSAGE);
		assertContains(keys, ThrownAssertionData.EXPECTED_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionData.EXPECTED_MESSAGE);
		
		assertEquals(IllegalArgumentException.class, data.getData(ThrownAssertionData.ACTUAL_THROWABLE_CLASS));
		assertEquals("expected exception messsage 2", data.getData(ThrownAssertionData.ACTUAL_MESSAGE));
		assertEquals(IllegalArgumentException.class, data.getData(ThrownAssertionData.EXPECTED_THROWABLE_CLASS));
		assertEquals("expected exception messsage", data.getData(ThrownAssertionData.EXPECTED_MESSAGE));
		
		assertEquals(IllegalArgumentException.class, tad.getActualThrowable());
		assertEquals("expected exception messsage 2", tad.getActualMessage());
		assertEquals(IllegalArgumentException.class, tad.getExpectedThrowable());
		assertEquals("expected exception messsage", tad.getExpectedMessage());
		
		I_Evaluation eval =  utac.getResult();
		assertFalse(eval.isSuccess());
		assertEquals(new Tests4J_AssertionResultMessages().getTheTextWasNOT_Uniform(), eval.getFailureSubMessage());
		Map<String, Object> evalData = eval.getData();
		assertNotNull(evalData);
		assertEquals(1, evalData.size());
		I_TextLinesCompareResult txt = (I_TextLinesCompareResult) evalData.get(I_TextLinesCompareResult.DATA_KEY);
		assertNotNull(txt);
	}
	
	
	@Test
	public void testEqualsHashCode() {
		UniformThrownAssertCommand a = new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")));
		UniformThrownAssertCommand b = new UniformThrownAssertCommand("failure message 2", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")));
		UniformThrownAssertCommand c = new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")));
		UniformThrownAssertCommand d = new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalStateException("expected exception messsage")));
		UniformThrownAssertCommand e = new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalStateException("expected exception messsage")));
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertTrue(c.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalArgumentException("expected exception messsage");
			}
		}, new ThrowableUniformEvaluator()));
		assertNotEquals(a, c);
		assertNotEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(),d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(70.0, coverage.getPercentageCoveredDouble());
		}
	}


	@Override
	public int getTests() {
		return 6;
	}

	@Override
	public int getAsserts() {
		return 98;
	}

	@Override
	public int getUniqueAsserts() {
		return 64;
	}
}
