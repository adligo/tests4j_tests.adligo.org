package org.adligo.tests4j_tests.system.shared;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.system.shared.api.A_SysApiPkgTrials;
import org.adligo.tests4j_tests.system.shared.report.summary.A_SummPkgTrials;
import org.adligo.tests4j_tests.system.shared.trials.A_TrialsPkgTrials;

public class A_SysPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_SysPkgTrials>, I_CountingPackageTrials {
	private A_SysApiPkgTrials api = new A_SysApiPkgTrials();
	private A_TrialsPkgTrials trials = new A_TrialsPkgTrials();
	private A_SummPkgTrials summary = new A_SummPkgTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_SysPkgTrials me = new A_SysPkgTrials();
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
		trials.addTrials();
		add(trials.getCountingTrials());
		
		api.addTrials();
		add(api.getCountingTrials());
		
		summary.addTrials();
		add(summary.getCountingTrials());
	}

	@Override
	public A_SysPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		trials.setParams(params);
		api.setParams(params);
		summary.setParams(params);
	}
}
