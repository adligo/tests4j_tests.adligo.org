package org.adligo.tests4j_tests.jacoco.plugin.whitelists;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.helpers.AfterSourceFileTrialTestsProcessor;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.report.summary.TestDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.data.coverage.LazyPackageCoverage;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.jacoco.plugin.data.common.A_CocoDataCmnPkgTrials;
import org.adligo.tests4j_tests.jacoco.plugin.data.coverage.A_CocoCoveragePkgTrials;
import org.adligo.tests4j_tests.jacoco.plugin.data.inst.A_CocoPlugInstPkgTrials;
import org.adligo.tests4j_tests.jacoco.plugin.data.multi.A_CocoPlugMultiPkgTrials;

public class A_CocoPlugWhitelistsPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_CocoPlugWhitelistsPkgTrials>, I_CountingPackageTrials {
	private A_CocoDataCmnPkgTrials dataCommon = new A_CocoDataCmnPkgTrials();
	private A_CocoPlugInstPkgTrials instr = new A_CocoPlugInstPkgTrials();
	private A_CocoCoveragePkgTrials cover = new A_CocoCoveragePkgTrials();
	private A_CocoPlugMultiPkgTrials multi = new A_CocoPlugMultiPkgTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_CocoPlugWhitelistsPkgTrials me = new A_CocoPlugWhitelistsPkgTrials();
			me.setParams(params);

			me.addTrials();
			
			params.setMetaTrialParams(me);
			params.addTrials(me);
			//params.setLogState(Tests4J_TrialsRunable.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			params.setLogState(TrialDisplay.class, false);
			params.setLogState(TestDisplay.class, true);
			params.setLogState(LazyPackageCoverage.class, true);
			params.setLogState(AfterSourceFileTrialTestsProcessor.class, true);
			params.setLogState(Recorder.class, true);
			//params.setLogState(ClassInstrumenter.class, true);
			//params.setLogState(OrderedClassDiscovery.class, true);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception{
		
	  add(BaseClassListTrial.class);
	  add(MockitoListTrial.class);
		add(RequiredListTrial.class);
	}

	@Override
	public A_CocoPlugWhitelistsPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		
		dataCommon.setParams(params);
		cover.setParams(params);
		instr.setParams(params);
		multi.setParams(params);
	}
}
