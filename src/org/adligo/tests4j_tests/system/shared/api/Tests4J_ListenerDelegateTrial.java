package org.adligo.tests4j_tests.system.shared.api;

import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.results.ApiTrialResultMutant;
import org.adligo.tests4j.models.shared.results.TrialRunResultMutant;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;
import org.adligo.tests4j.system.shared.api.Tests4J_ListenerDelegator;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_SystemApi_GwtReferenceGroup;
import org.adligo.tests4j_tests.system.shared.mocks.Clumsey_Tests4J_Listener;
import org.adligo.tests4j_tests.system.shared.mocks.Tracking_Tests4J_Listener;

@SourceFileScope (sourceClass=Tests4J_ListenerDelegator.class, minCoverage=73.0)
@AllowedReferences (groups=Tests4J_SystemApi_GwtReferenceGroup.class)
public class Tests4J_ListenerDelegateTrial extends SourceFileCountingTrial implements I_Tests4J_Log {
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
    delegate.onStartingSetup(null);
    assertNull(thrown);
    
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
    assertNull(mock.getLastParams());
    TrialRunMetadataMutant trm = new TrialRunMetadataMutant();
    I_Tests4J_Params params = mock(I_Tests4J_Params.class);
    
    delegate.onStartingSetup(params);
    assertNull(thrown);
    assertSame(params, mock.getLastParams());
    
		thrown = null;
		mock.clear();
		assertNull(mock.getLastMetadata());
		trm = new TrialRunMetadataMutant();
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
	public void onThrowable(Throwable p) {
		thrown = p;
	}

	@Override
	public boolean isMainLog() {
		return false;
	}

	@Override
	public String getLineSeperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLogEnabled(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 53;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 23;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

	@Override
	public String getCurrentThreadName() {
		// TODO Auto-generated method stub
		return null;
	}


  @Override
  public String getThreadWithGroupNameMessage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getThreadMessage() {
    // TODO Auto-generated method stub
    return null;
  }
}
