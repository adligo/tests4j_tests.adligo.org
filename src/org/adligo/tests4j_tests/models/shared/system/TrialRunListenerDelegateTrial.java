package org.adligo.tests4j_tests.models.shared.system;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.results.ApiTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.results.TrialRunResultMutant;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Reporter;
import org.adligo.tests4j.models.shared.system.TrialRunListenerDelegate;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.helpers.ClumseyTrialRunListener;
import org.adligo.tests4j_tests.models.shared.system.helpers.TrialRunListenerTracker;

@SourceFileScope (sourceClass=TrialRunListenerDelegate.class, minCoverage=90.0)
public class TrialRunListenerDelegateTrial extends SourceFileCountingTrial implements I_Tests4J_Reporter {
	private Throwable thrown;
	
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(TrialRunListenerDelegate.TRIAL_RUN_LISTENER_DELEGATE_REQUIRES_A_I_TRIAL_RUN_LISTENER)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new TrialRunListenerDelegate(null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(TrialRunListenerDelegate.TRIAL_RUN_LISTENER_DELEGATE_REQUIRES_A_I_TESTS4J_REPORTER)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new TrialRunListenerDelegate(new ClumseyTrialRunListener(), null);
					}
				});
	}
	
	@Test
	public void testThrowableCatches() {
		TrialRunListenerDelegate delegate = new TrialRunListenerDelegate(new ClumseyTrialRunListener(), this);
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
	public void testPassThroughs() {
		TrialRunListenerTracker mock = new TrialRunListenerTracker();
		TrialRunListenerDelegate delegate = new TrialRunListenerDelegate(mock, this);
		
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
		return 3;
	}

	@Override
	public int getAsserts() {
		return 44;
	}

	@Override
	public int getUniqueAsserts() {
		return 22;
	}

	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public void onStartingTrial(String trialName) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public void onStartingTest(String trialName, String testName) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public void onTestCompleted(String trialName, String testName,
			boolean passed) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public void onTrialCompleted(I_TrialResult result) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public void onError(Throwable p) {
		thrown = p;
	}

	@Override
	public void setLogOn(Class<?> clazz) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public void setLogOff(Class<?> clazz) {
		//mock this for I_Tests4j_Reporter
		
	}

	@Override
	public boolean isSnare() {
		//mock this for I_Tests4j_Reporter
		return false;
	}

	@Override
	public boolean isRedirect() {
		//mock this for I_Tests4j_Reporter
		return false;
	}

	@Override
	public void setListRelevantClassesWithoutTrials(boolean p) {
		//mock this for I_Tests4j_Reporter
		
	}
}
