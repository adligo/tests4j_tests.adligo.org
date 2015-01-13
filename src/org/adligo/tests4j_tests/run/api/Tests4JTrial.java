package org.adligo.tests4j_tests.run.api;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.common.I_JseSystem;
import org.adligo.tests4j.run.common.JseSystem;
import org.adligo.tests4j.run.helpers.Tests4J_Controls;
import org.adligo.tests4j.shared.common.DefaultSystem;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Delegate;
import org.adligo.tests4j.system.shared.api.I_Tests4J_DelegateFactory;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.api.mocks.MockTests4J;
import org.adligo.tests4j_tests.run.api.mocks.MockTests4J_Listener;
import org.adligo.tests4j_tests.run.helpers.MockTests4J_DelegateFactory;

import java.util.concurrent.atomic.AtomicBoolean;

@SourceFileScope (sourceClass=Tests4J.class, minCoverage= 48.0)
public class Tests4JTrial extends SourceFileCountingTrial implements I_Tests4J_Delegate {
	private I_Tests4J_DelegateFactory originalFactory;
	private MockTests4J_DelegateFactory factory = new MockTests4J_DelegateFactory(this);
	private I_Tests4J_Listener lastSetupListener;
	private I_Tests4J_Params lastSetupParams;
	private final AtomicBoolean ran = new AtomicBoolean();
	private final AtomicBoolean setupResultToSend = new AtomicBoolean();
	private I_Tests4J_Controls controllsToSend;
	
	
	@Override
	public void afterTests() {
		//set it back for the test thread
		MockTests4J.setFactory(originalFactory);
	}
	
	@Override
	public void beforeTests() {
		originalFactory = MockTests4J.getFactory();
		
		//set it each time for the test thread
		MockTests4J.setFactory(factory);
		lastSetupListener = null;
		lastSetupParams  = null;
		factory.clear();
		ran.set(false);
		setupResultToSend.set(true);
		controllsToSend = null;
	}

	
	
	@Test
	public void testStaticRunNoListener() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		controllsToSend = new Tests4J_Controls();
		I_Tests4J_Controls controlls =  Tests4J.run(params);
		assertSame(controllsToSend, controlls);
		assertTrue(ran.get());
		
		assertNotSame(params, lastSetupParams);
    assertEquals(Tests4J_EnglishConstants.ENGLISH, lastSetupParams.getConstants());
		assertNull(lastSetupListener);
		
		
	}
	
	@Test
	public void testStaticRunNoListenerSetupFails() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		controllsToSend = new Tests4J_Controls();
		setupResultToSend.set(false);
		
		I_Tests4J_Controls controlls =  Tests4J.run(params);
		assertSame(controllsToSend, controlls);
		
		assertFalse(ran.get());
		assertNotSame(params, lastSetupParams);
    assertEquals(Tests4J_EnglishConstants.ENGLISH, lastSetupParams.getConstants());
		assertNull(lastSetupListener);
		assertFalse(ran.get());
		
	}
	
	@Test
	public void testStaticRunWithListener() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		controllsToSend = new Tests4J_Controls();
		I_Tests4J_Listener listener = new MockTests4J_Listener();
		I_Tests4J_Controls controlls =  Tests4J.run(params, listener);
		assertSame(listener, lastSetupListener);
		assertSame(controllsToSend, controlls);
		assertTrue(ran.get());
		
		assertNotSame(params, lastSetupParams);
    assertEquals(Tests4J_EnglishConstants.ENGLISH, lastSetupParams.getConstants());
		assertSame(listener, lastSetupListener);
	}
	
	@Test
	public void testStaticRunWithListenerSetupFails() {
		
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		setupResultToSend.set(false);
		controllsToSend = new Tests4J_Controls();
		I_Tests4J_Listener listener = new MockTests4J_Listener();
		I_Tests4J_Controls controlls =  Tests4J.run(params, listener);
		assertSame(listener, lastSetupListener);
		assertSame(controllsToSend, controlls);
		assertFalse(ran.get());
		
		assertEquals(JseSystem.class.getName(), factory.getLastSystem().getClass().getName());
		assertNotSame(params, lastSetupParams);
		assertEquals(Tests4J_EnglishConstants.ENGLISH, lastSetupParams.getConstants());
		assertSame(listener, lastSetupListener);
	}
	
	@Test
	public void testInstanceRunWithSettersAndGetters() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		controllsToSend = new Tests4J_Controls();
		
		MockTests4J mock = new MockTests4J();
		I_JseSystem system = new JseSystem();
		
		mock.setSystemDelegate(system);
		assertSame(system, mock.getSystemDelegate());
		
		I_Tests4J_Controls controls =  mock.instanceRunDelegate(params, null);
		assertSame(controllsToSend, controls);
		
		assertEquals(JseSystem.class.getName(), factory.getLastSystem().getClass().getName());
		assertNotSame(params, lastSetupParams);
    assertEquals(Tests4J_EnglishConstants.ENGLISH, lastSetupParams.getConstants());
		assertNull(lastSetupListener);
	}
	
	@Test
	public void testInstanceRunWithListener() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		controllsToSend = new Tests4J_Controls();
		I_Tests4J_Listener listener = new MockTests4J_Listener();
		
		
		MockTests4J mock = new MockTests4J();
		I_JseSystem system = new JseSystem();
		
		mock.setSystemDelegate(system);
		assertSame(system, mock.getSystemDelegate());
		
		I_Tests4J_Controls controls =  mock.instanceRunDelegate(params, listener);
		assertSame(controllsToSend, controls);
		assertTrue(ran.get());
		
		assertEquals(JseSystem.class.getName(), factory.getLastSystem().getClass().getName());
		assertNotSame(params, lastSetupParams);
    assertEquals(Tests4J_EnglishConstants.ENGLISH, lastSetupParams.getConstants());
		assertSame(listener, lastSetupListener);
	}
	
	@Test
	public void testInstanceRunSetupFails() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		controllsToSend = new Tests4J_Controls();
		setupResultToSend.set(false);
		I_Tests4J_Listener listener = new MockTests4J_Listener();
		
		MockTests4J mock = new MockTests4J();
		I_JseSystem system = new JseSystem();
		
		mock.setSystemDelegate(system);
		assertSame(system, mock.getSystemDelegate());
		
		I_Tests4J_Controls controls =  mock.instanceRunDelegate(params, listener);
		assertSame(controllsToSend, controls);
		assertFalse(ran.get());
		
		assertEquals(JseSystem.class.getName(), factory.getLastSystem().getClass().getName());
		assertNotSame(params, lastSetupParams);
    assertEquals(Tests4J_EnglishConstants.ENGLISH, lastSetupParams.getConstants());
		assertSame(listener, lastSetupListener);	
	}
	
	

	@Override
	public boolean setup(I_Tests4J_Listener listener, I_Tests4J_Params params) {
		lastSetupListener = listener;
		lastSetupParams = params;
		
		return setupResultToSend.get();
	}


	@Override
	public  void runOnAnotherThreadIfAble() {
		ran.set(true);
	}


	@Override
	public  I_Tests4J_Controls getControls() {
		return controllsToSend;
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 7);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 51;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 48;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
