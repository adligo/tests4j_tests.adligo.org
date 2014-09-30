package org.adligo.tests4j_tests.models;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.models.shared.coverage.A_CoveragePkgTrials;
import org.adligo.tests4j_tests.models.shared.dependency.A_DepsPkgTrials;
import org.adligo.tests4j_tests.models.shared.metadata.A_MetaPkgTrials;
import org.adligo.tests4j_tests.models.shared.results.A_ResultsPkgTrials;

public class A_ModelsPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_ModelsPkgTrials>, I_CountingPackageTrials {
	private static A_CoveragePkgTrials cover = new A_CoveragePkgTrials();
	private static A_DepsPkgTrials deps = new A_DepsPkgTrials();
	private static A_MetaPkgTrials meta = new A_MetaPkgTrials();
	private static A_ResultsPkgTrials results = new A_ResultsPkgTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			

			
			A_ModelsPkgTrials me = new A_ModelsPkgTrials();
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

	public void addTrials()  throws Exception {
		
		cover.addTrials();
		add(cover.getCountingTrials());
		
		deps.addTrials();
		add(deps.getCountingTrials());
		
		meta.addTrials();
		add(meta.getCountingTrials());
		
		results.addTrials();
		add(results.getCountingTrials());
		
	}

	@Override
	public A_ModelsPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		cover.setParams(params);
		deps.setParams(params);
		meta.setParams(params);
		results.setParams(params);
	}
}
