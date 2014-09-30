package org.adligo.tests4j_tests.shared.asserts.uniform;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_AssertsUniPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_AssertsUniPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			//params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_AssertsUniPkgTrials me = new A_AssertsUniPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.setMetaTrialParams(me);
			params.addTrials(me);
			params.setRecommendedSetupThreadCount(1);
			
			//params.setLogState(Tests4J_ThreadFactory.class, true);
			//params.setLogState(MultiProbeDataStore.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			//params.setLogState(Tests4J_TrialsRunable.class, true);
			
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		add(EvaluationMutantTrial.class);
		add(EvaluationTrial.class);
		add(EvaluatorLookupMutantTrial.class);
		add(EvaluatorLookupTrial.class);
		add(StringUniformEvaluatorTrial.class);
		add(ThrowableUniformEvaluatorTrial.class);
		
	}

	@Override
	public A_AssertsUniPkgTrials getTrialParams() {
		return this;
	}
	
}
