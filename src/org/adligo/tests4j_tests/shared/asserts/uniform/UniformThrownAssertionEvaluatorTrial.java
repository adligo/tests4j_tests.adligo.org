package org.adligo.tests4j_tests.shared.asserts.uniform;

import org.adligo.tests4j.shared.asserts.UniformThrownAssertCommand;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.shared.asserts.common.I_ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.common.I_ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.common.ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.UniformThrownAssertionEvaluator;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;

@SourceFileScope (sourceClass=UniformThrownAssertionEvaluator.class)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class UniformThrownAssertionEvaluatorTrial extends SourceFileCountingTrial {

	@SuppressWarnings("boxing")
  @Test
	public void test01_GettersAfterEvaluateFailNothingThrown() {
		
		ExpectedThrowable etd = new ExpectedThrowable(new IllegalArgumentException("bad exeception message\n\r"
				+ "123"));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH,"failure message",  etd, 
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
			}
		}));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		
		I_ExpectedThrowable expected = tad.getExpected();
		Throwable actual = tad.getActual();
		assertNull(actual);
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("bad exeception message\n\r123", expected.getMessage());
		
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getNothingWasThrown(), tad.getFailureReason());
		assertEquals(1, tad.getFailureThrowable());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void test05_EvaluatePass() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrowable etd = new ExpectedThrowable(iae);
		final UniformThrownAssertCommand utac = new UniformThrownAssertCommand(
		    Tests4J_EnglishConstants.ENGLISH, "failure message", etd,
		    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
		assertEquals("failure message", utac.getFailureMessage());
	
		assertThrown(new ExpectedThrowable(NullPointerException.class),
				new I_Thrower() {
					
					
					@Override
					public void run() {
						utac.getData();
					}
				});
		assertTrue(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		I_Evaluation<I_ThrownAssertionData> eval =  utac.getEvaluation();
		assertTrue(eval.isSuccess());
		I_ThrownAssertionData data = eval.getData();
		assertNotNull(data);
		assertNull(data.getFailureReason());
		assertEquals(0, data.getFailureThrowable());
		Throwable actual = data.getActual();
		assertNotNull(actual);
		assertEquals(IllegalArgumentException.class.getName(), actual.getClass().getName());
		assertSame(etd, data.getExpected());
		assertSame(data, utac.getData());
		
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 20;
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
		int thisUniqueAsserts = 19;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
