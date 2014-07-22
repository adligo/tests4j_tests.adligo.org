package org.adligo.tests4j_tests.run;

import java.util.concurrent.atomic.AtomicBoolean;

import org.adligo.tests4j.models.shared.system.DefaultLogger;
import org.adligo.tests4j.models.shared.system.DefaultSystem;
import org.adligo.tests4j.models.shared.system.I_Tests4J_System;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Delegate;
import org.adligo.tests4j.models.shared.system.I_Tests4J_DelegateFactory;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Logger;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Params;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.AfterTrial;
import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_Controls;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.MockTests4J_DelegateFactory;
import org.adligo.tests4j_tests.run.mocks.MockTests4J;
import org.adligo.tests4j_tests.run.mocks.MockTests4J_Listener;

@SourceFileScope (sourceClass=Tests4J.class, minCoverage= 80.0)
public class Tests4JTrial extends SourceFileCountingTrial implements I_Tests4J_Delegate {
	private I_Tests4J_DelegateFactory originalFactory;
	private I_Tests4J_DelegateFactory factory = new MockTests4J_DelegateFactory(this);
	private I_Tests4J_Listener lastSetupListener;
	private I_Tests4J_Params lastSetupParams;
	private I_Tests4J_Logger lastLogger;
	private I_Tests4J_System lastSystem;
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
		lastLogger  = null;
		lastSystem  = null;
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
		
		assertEquals(DefaultSystem.class.getName(), lastSystem.getClass().getName());
		assertEquals(DefaultLogger.class.getName(), lastLogger.getClass().getName());
		assertEquals(params, lastSetupParams);
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
		assertEquals(DefaultSystem.class.getName(), lastSystem.getClass().getName());
		assertEquals(DefaultLogger.class.getName(), lastLogger.getClass().getName());
		assertSame(params, lastSetupParams);
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
		
		assertEquals(DefaultSystem.class.getName(), lastSystem.getClass().getName());
		assertEquals(DefaultLogger.class.getName(), lastLogger.getClass().getName());
		assertSame(params, lastSetupParams);
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
		
		assertEquals(DefaultSystem.class.getName(), lastSystem.getClass().getName());
		assertEquals(DefaultLogger.class.getName(), lastLogger.getClass().getName());
		assertSame(params, lastSetupParams);
		assertSame(listener, lastSetupListener);
	}
	
	@Test
	public void testInstanceRunWithSettersAndGetters() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		controllsToSend = new Tests4J_Controls();
		
		MockTests4J mock = new MockTests4J();
		I_Tests4J_Logger logger = new DefaultLogger();
		I_Tests4J_System system = new DefaultSystem();
		mock.setLoggerDelegate(logger);
		assertSame(logger, mock.getLoggerDelegate());
		
		mock.setSystemDelegate(system);
		assertSame(system, mock.getSystemDelegate());
		
		I_Tests4J_Controls controls =  mock.instanceRunDelegate(params, null);
		assertSame(controllsToSend, controls);
		
		assertSame(params, lastSetupParams);
		assertNull(lastSetupListener);
	}
	
	@Test
	public void testInstanceRunWithListener() {
		assertSame(factory, MockTests4J.getFactory());
		
		Tests4J_Params params = new Tests4J_Params();
		
		controllsToSend = new Tests4J_Controls();
		I_Tests4J_Listener listener = new MockTests4J_Listener();
		
		
		MockTests4J mock = new MockTests4J();
		I_Tests4J_Logger logger = new DefaultLogger();
		I_Tests4J_System system = new DefaultSystem();
		mock.setLoggerDelegate(logger);
		assertSame(logger, mock.getLoggerDelegate());
		
		mock.setSystemDelegate(system);
		assertSame(system, mock.getSystemDelegate());
		
		I_Tests4J_Controls controls =  mock.instanceRunDelegate(params, listener);
		assertSame(controllsToSend, controls);
		assertTrue(ran.get());
		
		assertSame(params, lastSetupParams);
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
		I_Tests4J_Logger logger = new DefaultLogger();
		I_Tests4J_System system = new DefaultSystem();
		mock.setLoggerDelegate(logger);
		assertSame(logger, mock.getLoggerDelegate());
		
		mock.setSystemDelegate(system);
		assertSame(system, mock.getSystemDelegate());
		
		I_Tests4J_Controls controls =  mock.instanceRunDelegate(params, listener);
		assertSame(controllsToSend, controls);
		assertFalse(ran.get());
		
		assertSame(params, lastSetupParams);
		assertSame(listener, lastSetupListener);	
	}
	
	

	@Override
	public boolean setup(I_Tests4J_Listener listener, I_Tests4J_Params params) {
		lastSetupListener = listener;
		lastSetupParams = params;
		
		return setupResultToSend.get();
	}


	@Override
	public  void run() {
		ran.set(true);
	}


	@Override
	public  I_Tests4J_Controls getControls() {
		return controllsToSend;
	}


	@Override
	public  void setLogger(I_Tests4J_Logger logger) {
		lastLogger = logger;
	}


	@Override
	public  void setSystem(I_Tests4J_System system) {
		lastSystem = system;
	}
	
	
	@Override
	public int getTests() {
		return 7;
	}

	@Override
	public int getAsserts() {
		return 51;
	}

	@Override
	public int getUniqueAsserts() {
		return 48;
	}

}
