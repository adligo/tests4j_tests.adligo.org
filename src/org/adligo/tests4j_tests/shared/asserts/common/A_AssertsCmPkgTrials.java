package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_AssertsCmPkgTrials extends SimplePackageTrials 
	implements I_MetaTrialParams<A_AssertsCmPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_AssertsCmPkgTrials me = new A_AssertsCmPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.setMetaTrialParams(me);
			params.addTrials(me);
			params.setRecommendedSetupThreadCount(1);
			
			
			//params.setCoveragePluginConfiguratorClass(ScopedJacocoPluginConfigurator.class);
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		add(I_AssertCommandTrial.class);
		add(I_AssertCompareFailureTrial.class);
		add(I_AssertionDataTrial.class);
		add(I_AssertListenerTrial.class);
		add(I_AssertsTrial.class);
		add(I_AssertThrownFailureTrial.class);
		add(I_AssertTypeTrial.class);
		add(I_CollectionAssertionDataTrial.class);
		add(I_CollectionContainsAssertionDataTrial.class);
		add(I_CompareAssertCommandTrial.class);
		add(I_CompareAssertionDataTrial.class);
		add(I_ExpectedThrownDataTrial.class);
		add(I_SimpleAssertCommandTrial.class);
		add(I_SimpleCompareAssertCommandTrial.class);
		add(I_SourceTestFailureTrial.class);
		
		add(I_TestFailureTrial.class);
		add(I_TestFailureTypeTrial.class);
		
		add(I_ThrowableInfoTrial.class);
		add(I_ThrowerTrial.class);
		add(I_ThrownAssertCommandTrial.class);
		add(I_ThrownAssertionDataTrial.class);
		
		add(AssertTypeTrial.class);
		add(CompareAssertionDataTrial.class);
		add(ExpectedThrownDataTrial.class);
		add(ThrownAssertionDataMutantTrial.class);
		add(ThrownAssertionDataTrial.class);
		
		add(AssertCompareFailureMutantTrial.class);
		add(AssertCompareFailureTrial.class);
		
		add(TestFailureTypeTrial.class);
		add(TestFailureMutantTrial.class);
		add(TestFailureTrial.class);
		add(TestFailureBuilderTrial.class);
		
		add(SourceTestFailureMutantTrial.class);
		add(SourceTestFailureTrial.class);
		
		add(AssertThrownFailureMutantTrial.class);
		add(AssertThrownFailureTrial.class);
		
		add(ThrowableInfoMutantTrial.class);
		add(ThrowableInfoTrial.class);
	}

	@Override
	public A_AssertsCmPkgTrials getTrialParams() {
		return this;
	}
	
}
