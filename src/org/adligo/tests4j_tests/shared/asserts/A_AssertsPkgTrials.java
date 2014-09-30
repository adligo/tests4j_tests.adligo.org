package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.report.summary.TestDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.shared.asserts.common.A_AssertsCmPkgTrials;
import org.adligo.tests4j_tests.shared.asserts.dependency.A_AssertsDepPkgTrials;
import org.adligo.tests4j_tests.shared.asserts.line_text.A_AssertsLtRunPkgTrials;
import org.adligo.tests4j_tests.shared.asserts.uniform.A_AssertsUniPkgTrials;

public class A_AssertsPkgTrials  extends SimplePackageTrials 
implements I_MetaTrialParams<A_AssertsPkgTrials>, I_CountingPackageTrials {
	private A_AssertsCmPkgTrials cmtTrials = new A_AssertsCmPkgTrials();
	private A_AssertsDepPkgTrials depTrials = new A_AssertsDepPkgTrials();
	private A_AssertsLtRunPkgTrials lineTrials = new A_AssertsLtRunPkgTrials();
	private A_AssertsUniPkgTrials uniTrials = new A_AssertsUniPkgTrials();
	
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_AssertsPkgTrials me = new A_AssertsPkgTrials();
			me.setParams(params);

			me.addTrials();
			
			params.setMetaTrialParams(me);
			params.addTrials(me);
			//params.setLogState(Tests4J_TrialsRunable.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			params.setLogState(TrialDisplay.class, false);
			params.setLogState(TestDisplay.class, true);
			//params.setLogState(ClassReferencesDiscovery.class, true);
			params.setLogState(ClassInstrumenter.class, true);
			params.setLogState(OrderedClassDiscovery.class, true);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}


	public void addTrials() throws Exception {
		cmtTrials.addTrials();
		add(cmtTrials.getCountingTrials());
		
		depTrials.addTrials();
		add(depTrials.getCountingTrials());
		
		lineTrials.addTrials();
		add(lineTrials.getCountingTrials());
		
		uniTrials.addTrials();
		add(uniTrials.getCountingTrials());
		
		add(AbstractAssertCommandTrial.class);
		add(AbstractCompareAssertCommandTrial.class);
		add(AssertionFailureLocationTrial.class);
		add(AssertionProcessorTrial.class);
		add(BooleanAssertCommandTrial.class);
		add(ContainsAssertCommandTrial.class);
		add(DoubleAssertCommandTrial.class);
		add(IdenticalAssertCommandTrial.class);
		add(IdenticalStringAssertCommandTrial.class);
		
		add(ThrownAssertCommandTrial.class);
		add(UniformAssertCommandTrial.class);
		add(UniformThrownAssertCommandTrial.class);
		
	}

	@Override
	public A_AssertsPkgTrials getTrialParams() {
		return this;
	}


	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		cmtTrials.setParams(params);
		depTrials.setParams(params);
		lineTrials.setParams(params);
		uniTrials.setParams(params);
	}
	
}
