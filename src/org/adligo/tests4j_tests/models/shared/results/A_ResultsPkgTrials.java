package org.adligo.tests4j_tests.models.shared.results;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_ResultsPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_ResultsPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_ResultsPkgTrials me = new A_ResultsPkgTrials();
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
		super.add(I_ApiTrialResultTrial.class);
		super.add(I_DurationTrial.class);
		super.add(I_SourceFileTrialResultTrial.class);
		super.add(I_TestResultTrial.class);
		super.add(I_TrialFailureTrial.class);
		super.add(I_TrialResultTrial.class);
		super.add(I_TrialRunResultTrial.class);
		super.add(I_UseCaseTrialResultTrial.class);
		super.add(I_PhaseStateTrial.class);
		super.add(I_UnitTrialResultTrial.class);
		
		super.add(TestResultMutantTrial.class);
		super.add(TestResultTrial.class);
		
		super.add(BaseTrialResultMutantTrial.class);
		super.add(BaseTrialResultTrial.class);
		
		super.add(ApiTrialResultMutantTrial.class);
		super.add(ApiTrialResultTrial.class);
		
		super.add(SourceFileTrialResultMutantTrial.class);
		super.add(SourceFileTrialResultTrial.class);
		
		super.add(TrialFailureTrial.class);
		
		super.add(TrialRunResultMutantTrial.class);
		super.add(TrialRunResultTrial.class);
		
		super.add(UseCaseTrialResultMutantTrial.class);
		super.add(UseCaseTrialResultTrial.class);
		
		super.add(PhaseStateMutantTrial.class);
		super.add(PhaseStateTrial.class);
	}

	@Override
	public A_ResultsPkgTrials getTrialParams() {
		return this;
	}
}
