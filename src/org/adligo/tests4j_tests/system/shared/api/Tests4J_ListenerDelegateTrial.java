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
import org.adligo.tests4j_4mockito.MethodRecorder;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_SystemApi_GwtReferenceGroup;
import org.adligo.tests4j_tests.system.shared.mocks.Clumsey_Tests4J_Listener;
import org.adligo.tests4j_tests.system.shared.mocks.Tracking_Tests4J_Listener;

@SourceFileScope (sourceClass=Tests4J_ListenerDelegator.class, minCoverage=73.0)
@AllowedReferences (groups=Tests4J_SystemApi_GwtReferenceGroup.class)
public class Tests4J_ListenerDelegateTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MethodRecorder<Void> logRecord_;
  private MethodRecorder<Void> logLineRecord_;
  private MethodRecorder<Void> onThrowableRecord_;
  
  @Override
  public void beforeTests() {
    logMock_ = mock(I_Tests4J_Log.class);
    logRecord_ = new MethodRecorder<Void>();
    doAnswer(logRecord_).when(logMock_).log(any());
    logLineRecord_ = new MethodRecorder<Void>();
    doAnswer(logLineRecord_).when(logMock_).logLine(anyVararg());
    onThrowableRecord_ = new MethodRecorder<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.getLineSeperator()).thenReturn("lineSeperator");
  }
  
  @SuppressWarnings("unused")
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
		Tests4J_ListenerDelegator delegate = new Tests4J_ListenerDelegator(new Clumsey_Tests4J_Listener(), logMock_);
		
		delegate.onMetadataCalculated(null);
		Exception thrown = (Exception) onThrowableRecord_.getArgument(0);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onMetadataCalculated", thrown.getMessage());
		
		delegate.onRunCompleted(null);
		thrown = (Exception) onThrowableRecord_.getArgument(1);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onRunCompleted", thrown.getMessage());
		
		delegate.onStartingTest(null, null);
		thrown = (Exception) onThrowableRecord_.getArgument(2);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onStartingTest", thrown.getMessage());
		
		delegate.onStartingTrial(null);
		thrown = (Exception) onThrowableRecord_.getArgument(3);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onStartingTrial", thrown.getMessage());
		
		delegate.onTestCompleted(null, null, true);
		thrown = (Exception) onThrowableRecord_.getArgument(4);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onTestCompleted", thrown.getMessage());
		
		delegate.onTrialCompleted(null);
		thrown = (Exception) onThrowableRecord_.getArgument(5);
		assertNotNull(thrown);
		assertEquals(RuntimeException.class, thrown.getClass());
		assertEquals("mock from onTrialCompleted", thrown.getMessage());
		
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testNullDelegate() {
		Tests4J_ListenerDelegator delegate = new Tests4J_ListenerDelegator(null, logMock_);
		
    delegate.onStartingSetup(null);
    assertEquals(0, onThrowableRecord_.count());
    
		delegate.onMetadataCalculated(null);
		assertEquals(0, onThrowableRecord_.count());
		
		delegate.onRunCompleted(null);
		assertEquals(0, onThrowableRecord_.count());
		
		delegate.onStartingTest(null, null);
		assertEquals(0, onThrowableRecord_.count());
		
		delegate.onStartingTrial(null);
		assertEquals(0, onThrowableRecord_.count());
		
		delegate.onTestCompleted(null, null, true);
		assertEquals(0, onThrowableRecord_.count());
		
		delegate.onTrialCompleted(null);
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testPassThroughs() {
		Tracking_Tests4J_Listener mock = new Tracking_Tests4J_Listener();
		Tests4J_ListenerDelegator delegate = new Tests4J_ListenerDelegator(mock, logMock_);
		
    mock.clear();
    assertNull(mock.getLastParams());
    TrialRunMetadataMutant trm = new TrialRunMetadataMutant();
    I_Tests4J_Params params = mock(I_Tests4J_Params.class);
    
    delegate.onStartingSetup(params);
    assertEquals(0, onThrowableRecord_.count());
    assertSame(params, mock.getLastParams());
    
		mock.clear();
		assertNull(mock.getLastMetadata());
		trm = new TrialRunMetadataMutant();
		delegate.onMetadataCalculated(trm);
		assertEquals(0, onThrowableRecord_.count());
		assertSame(trm, mock.getLastMetadata());
		
		mock.clear();
		assertNull(mock.getLastResult());
		TrialRunResultMutant trrm = new TrialRunResultMutant();
		delegate.onRunCompleted(trrm);
		assertEquals(0, onThrowableRecord_.count());
		assertSame(trrm, mock.getLastResult());
		
		mock.clear();
		assertNull(mock.getLastTestName());
		assertNull(mock.getLastTrialName());
		delegate.onStartingTest("trialName", "testName");
		assertEquals(0, onThrowableRecord_.count());
		assertEquals("testName", mock.getLastTestName());
		assertEquals("trialName", mock.getLastTrialName());
		
		mock.clear();
		assertNull(mock.getLastTrialName());
		delegate.onStartingTrial("trialName");
		assertEquals(0, onThrowableRecord_.count());
		assertEquals("trialName", mock.getLastTrialName());
		
		mock.clear();
		assertNull(mock.getLastTestName());
		assertNull(mock.getLastTrialName());
		assertNull(mock.getLastPassed());
		delegate.onTestCompleted("trialName", "testName", true);
		assertEquals(0, onThrowableRecord_.count());
		assertEquals("testName", mock.getLastTestName());
		assertEquals("trialName", mock.getLastTrialName());
		assertTrue(mock.getLastPassed());
		
		mock.clear();
		assertNull(mock.getLastResult());
		ApiTrialResultMutant atrm = new ApiTrialResultMutant();
		delegate.onTrialCompleted(atrm);
		assertEquals(0, onThrowableRecord_.count());
		assertSame(atrm, mock.getLastTrialResult());
		
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
		int thisUniqueAsserts = 24;
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
}
