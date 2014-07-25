package org.adligo.tests4j_tests.models.shared.system;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.results.ApiTrialResultMutant;
import org.adligo.tests4j.models.shared.results.TrialRunResultMutant;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Logger;
import org.adligo.tests4j.models.shared.system.Tests4J_ListenerDelegator;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Clumsey_Tests4J_Listener;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tracking_Tests4J_Listener;

@SourceFileScope (sourceClass=Tests4J_ListenerDelegator.class, minCoverage=86.0)
public class Tests4J_ListenerDelegateTrial extends SourceFileCountingTrial implements I_Tests4J_Logger {
	private Throwable thrown;
	
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(Tests4J_ListenerDelegator.TRIAL_RUN_LISTENER_DELEGATE_REQUIRES_A_I_TESTS4J_LOGGER)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_ListenerDelegator(new Clumsey_Tests4J_Listener(), null);
					}
				});
	}
	
	@Test
	public void testThrowableCatches() {
		Tests4J_ListenerDelegator delegate = new Tests4J_ListenerDelegator(new Clumsey_Tests4J_Listener(), this);
		thrown = null;
		delegate.onMetadataCalculated(null);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onMetadataCalculated", thrown.getMessage());
		
		thrown = null;
		delegate.onRunCompleted(null);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onRunCompleted", thrown.getMessage());
		
		thrown = null;
		delegate.onStartingTest(null, null);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onStartingTest", thrown.getMessage());
		
		thrown = null;
		delegate.onStartingTrial(null);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onStartingTrial", thrown.getMessage());
		
		thrown = null;
		delegate.onTestCompleted(null, null, true);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onTestCompleted", thrown.getMessage());
		
		thrown = null;
		delegate.onTrialCompleted(null);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onTrialCompleted", thrown.getMessage());
		
	}
	
	@Test
	public void testNullDelegate() {
		Tests4J_ListenerDelegator delegate = new Tests4J_ListenerDelegator(null, this);
		thrown = null;
		delegate.onMetadataCalculated(null);
		assertNull(thrown);
		
		thrown = null;
		delegate.onRunCompleted(null);
		assertNull(thrown);
		
		thrown = null;
		delegate.onStartingTest(null, null);
		assertNull(thrown);
		
		thrown = null;
		delegate.onStartingTrial(null);
		assertNull(thrown);
		
		thrown = null;
		delegate.onTestCompleted(null, null, true);
		assertNull(thrown);
		
		thrown = null;
		delegate.onTrialCompleted(null);
		assertNull(thrown);
		
	}
	
	@Test
	public void testPassThroughs() {
		Tracking_Tests4J_Listener mock = new Tracking_Tests4J_Listener();
		Tests4J_ListenerDelegator delegate = new Tests4J_ListenerDelegator(mock, this);
		
		thrown = null;
		mock.clear();
		assertNull(mock.getLastMetadata());
		TrialRunMetadataMutant trm = new TrialRunMetadataMutant();
		delegate.onMetadataCalculated(trm);
		assertNull(thrown);
		assertSame(trm, mock.getLastMetadata());
		
		thrown = null;
		mock.clear();
		assertNull(mock.getLastResult());
		TrialRunResultMutant trrm = new TrialRunResultMutant();
		delegate.onRunCompleted(trrm);
		assertNull(thrown);
		assertSame(trrm, mock.getLastResult());
		
		thrown = null;
		mock.clear();
		assertNull(mock.getLastTestName());
		assertNull(mock.getLastTrialName());
		delegate.onStartingTest("trialName", "testName");
		assertNull(thrown);
		assertEquals("testName", mock.getLastTestName());
		assertEquals("trialName", mock.getLastTrialName());
		
		thrown = null;
		mock.clear();
		assertNull(mock.getLastTrialName());
		delegate.onStartingTrial("trialName");
		assertNull(thrown);
		assertEquals("trialName", mock.getLastTrialName());
		
		thrown = null;
		mock.clear();
		assertNull(mock.getLastTestName());
		assertNull(mock.getLastTrialName());
		assertNull(mock.getLastPassed());
		delegate.onTestCompleted("trialName", "testName", true);
		assertNull(thrown);
		assertEquals("testName", mock.getLastTestName());
		assertEquals("trialName", mock.getLastTrialName());
		assertTrue(mock.getLastPassed());
		
		thrown = null;
		mock.clear();
		assertNull(mock.getLastResult());
		ApiTrialResultMutant atrm = new ApiTrialResultMutant();
		delegate.onTrialCompleted(atrm);
		assertNull(thrown);
		assertSame(atrm, mock.getLastTrialResult());
		
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 49;
	}

	@Override
	public int getUniqueAsserts() {
		return 22;
	}



	@Override
	public void onException(Throwable p) {
		thrown = p;
	}

	@Override
	public boolean isMainReporter() {
		return false;
	}
}
