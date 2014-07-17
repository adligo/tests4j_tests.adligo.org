package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.UniformThrownAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.ThrowableUniformEvaluator;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=UniformThrownAssertCommand.class, minCoverage=70.0)
public class UniformThrownAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				new Tests4J_AssertionInputMessages().getExpectedThrownDataRequiresThrowable())),
				new I_Thrower() {
					
					@Override
					public void run() {
						new UniformThrownAssertCommand("failure message", null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				UniformThrownAssertCommand.UNIFORM_THROWN_ASSERT_COMMAND_REQUIRES_A_EVALUATOR)),
				new I_Thrower() {
					
					
					@Override
					public void run() {
						new UniformThrownAssertCommand("failure message", 
								new ExpectedThrownData(new IllegalArgumentException("failure message")), null);
					}
				});
	}
	
	@Test
	public void testGettersBeforeEvaluate() {
		IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> utac = new UniformThrownAssertCommand
				<Throwable, I_TextLinesCompareResult>
				("failure message", etd, new ThrowableUniformEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		I_AssertionData data =  utac.getData();
		
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
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> utac = new UniformThrownAssertCommand
				<Throwable, I_TextLinesCompareResult>
				("failure message",  etd, new ThrowableUniformEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
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
		
		assertTrue(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		
		data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		tad = (ThrownAssertionData) data;
		keys = tad.getKeys();
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
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> utac = new UniformThrownAssertCommand
				<Throwable, I_TextLinesCompareResult>
				("failure message", etd, new ThrowableUniformEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
	
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
		
		
		assertTrue(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		
		data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		tad = (ThrownAssertionData) data;
		keys = tad.getKeys();
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
		
		I_Evaluation<I_TextLinesCompareResult> eval =  utac.getEvaluation();
		assertTrue(eval.isSuccess());
		assertNull(eval.getData());
	}
	
	@Test
	public void testEvaluateFail() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> utac = new UniformThrownAssertCommand
				<Throwable, I_TextLinesCompareResult>("failure message", 
				etd, new ThrowableUniformEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		
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
		
		
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalArgumentException("expected exception messsage 2");
			}
		}));
		
		data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		tad = (ThrownAssertionData) data;
		keys = tad.getKeys();
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
		
		I_Evaluation<I_TextLinesCompareResult> eval =  utac.getEvaluation();
		assertFalse(eval.isSuccess());
		assertEquals(new Tests4J_AssertionResultMessages().getTheTextWasNOT_Uniform(), eval.getFailureReason());
		
		I_TextLinesCompareResult txt = (I_TextLinesCompareResult) eval.getData();
		assertNotNull(txt);
	}
	
	
	@Test
	public void testEqualsHashCode() {
		ThrowableUniformEvaluator tue = new ThrowableUniformEvaluator();
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> a = 
				new UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult>("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> b = 
				new UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult>("failure message 2", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> c = 
				new UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult>("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> d = 
				new UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult>("failure message", 
				new ExpectedThrownData(new IllegalStateException("expected exception messsage")), tue);
		UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult> e = 
				new UniformThrownAssertCommand<Throwable, I_TextLinesCompareResult>("failure message", 
				new ExpectedThrownData(new IllegalStateException("expected exception messsage")), tue);
		
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
		}));
		assertNotEquals(a, c);
		assertNotEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(),d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}

	@Override
	public int getTests() {
		return 6;
	}

	@Override
	public int getAsserts() {
		return 127;
	}

	@Override
	public int getUniqueAsserts() {
		return 62;
	}
}
