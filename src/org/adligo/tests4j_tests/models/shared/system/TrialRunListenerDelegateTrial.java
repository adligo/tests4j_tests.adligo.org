package org.adligo.tests4j_tests.models.shared.system;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.results.ApiTrialResultMutant;
import org.adligo.tests4j.models.shared.results.TrialRunResultMutant;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Logger;
import org.adligo.tests4j.models.shared.system.TrialRunListenerDelegator;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.helpers.ClumseyTrialRunListener;
import org.adligo.tests4j_tests.models.shared.system.helpers.TrialRunListenerTracker;

@SourceFileScope (sourceClass=TrialRunListenerDelegator.class, minCoverage=90.0)
public class TrialRunListenerDelegateTrial extends SourceFileCountingTrial implements I_Tests4J_Logger {
	private Throwable thrown;
	
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(TrialRunListenerDelegator.TRIAL_RUN_LISTENER_DELEGATE_REQUIRES_A_I_TESTS4J_LOGGER)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new TrialRunListenerDelegator(new ClumseyTrialRunListener(), null);
					}
				});
	}
	
	@Test
	public void testThrowableCatches() {
		TrialRunListenerDelegator delegate = new TrialRunListenerDelegator(new ClumseyTrialRunListener(), this);
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
		TrialRunListenerDelegator delegate = new TrialRunListenerDelegator(null, this);
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
		TrialRunListenerTracker mock = new TrialRunListenerTracker();
		TrialRunListenerDelegator delegate = new TrialRunListenerDelegator(mock, this);
		
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
	public void onError(Throwable p) {
		thrown = p;
	}

	@Override
	public boolean isMainReporter() {
		return false;
	}
}
