package org.adligo.tests4j_tests;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.jacoco.api_trials.ReferenceAssertionFailuresTrial;
import org.adligo.tests4j_tests.shared.asserts.common.AssertTypeTrial;

public class RunSingleTrialWithStats extends SimplePackageTrials 
implements I_MetaTrialParams<RunSingleTrialWithStats>, I_CountingPackageTrials {
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			RunSingleTrialWithStats me = new RunSingleTrialWithStats();
			me.setParams(params);
			me.addTrials();
			
			params.setMetaTrialParams(me);
			params.addTrials(me);
			//params.setLogState(Tests4J_TrialsRunable.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			//params.setLogState(InitialDependenciesDiscovery.class, true);
			//params.setLogState(TrialInstrumenter.class, true);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	/**
	 * if you need to run a @TrialRecursion trial 
	 * try RunSingleTrial
	 * 
	 * @throws Exception
	 */
	public void addTrials() throws Exception {
		//add(ClassMethodsTrial.class);
		//add(DefaultSystemTrial.class);
		//add(AbstractAssertCommandTrial.class);
		add(ReferenceAssertionFailuresTrial.class);
	}
	
	@Override
	public RunSingleTrialWithStats getTrialParams() {
		return this;
	}

}

