package org.adligo.tests4j_tests;

import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.shared.asserts.common.I_AssertCommandTrial;
import org.adligo.tests4j_tests.shared.common.ClassMethodsTrial;
import org.adligo.tests4j_tests.shared.common.DefaultSystemTrial;
import org.adligo.tests4j_tests.shared.common.I_ImmutableTrial;
import org.adligo.tests4j_tests.shared.common.I_PlatformContainerTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.annotation.Target_2_6_UseTrial;

public class RunSingleTrialWithStats extends SimplePackageTrials 
implements I_MetaTrialParams<RunSingleTrialWithStats>, I_CountingPackageTrials {
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
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

	public void addTrials() throws Exception {
		//add(ClassMethodsTrial.class);
		//add(DefaultSystemTrial.class);
		add(I_AssertCommandTrial.class);
	}
	
	@Override
	public RunSingleTrialWithStats getTrialParams() {
		return this;
	}

}

