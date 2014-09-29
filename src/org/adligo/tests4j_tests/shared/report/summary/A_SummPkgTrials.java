package org.adligo.tests4j_tests.shared.report.summary;

import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_SummPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_SummPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_SummPkgTrials me = new A_SummPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
			
			//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		add(AbstractProgressDisplayTrial.class);
		add(LineDiffTextDisplayTrial.class);
		
		add(RemoteProgressDisplayTrial.class);
		add(SetupProgressDisplayTrial.class);
		
		add(TestDisplayTrial.class);
		add(TestFailedDisplayTrial.class);
		
		add(TestsProgressDisplayTrial.class);
		
		add(TrialDisplayTrial.class);
		add(TrialFailedDisplayTrial.class);
		add(TrialFailedDetailDisplayTrial.class);
		add(TrialsProgressDisplayTrial.class);
	}

	@Override
	public A_SummPkgTrials getTrialParams() {
		return this;
	}
}
