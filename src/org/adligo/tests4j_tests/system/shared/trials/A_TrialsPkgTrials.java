package org.adligo.tests4j_tests.system.shared.trials;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_TrialsPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_TrialsPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_TrialsPkgTrials me = new A_TrialsPkgTrials();
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
		//in dependency order
		add(I_TrialParamValueTrial.class);
		add(I_TrialParamsTrial.class);
		add(I_TrialParamsAwareTrial.class);
		add(I_TrialParamsFactoryTrial.class);
		
		add(I_AbstractTrialTrial.class);
		add(I_TrialTrial.class);
		add(I_ApiTrialTrial.class);
		
		add(I_ProgressTrial.class);
		add(I_SourceFileTrialTrial.class);
		add(I_SubProgressTrial.class);
		add(I_TrialBindingsTrial.class);
		add(I_UseCaseTrialTrial.class);
		
		add(I_MetaTrialParamsTrial.class);
		add(I_MetaTrialParamsAwareTrial.class);
		add(I_MetaTrialInputDataTrial.class);
		add(I_MetaTrialTrial.class);
		
		add(AfterTrialTrial.class);
		add(BeforeTrialTrial.class);
		
		add(TrialTypeAnnotationTrial.class);
		add(AdditionalInstrumentationTrial.class);
		add(TargetedPlatformTrial.class);
		add(PackageScopeTrial.class);
		add(PlatformTypeTrial.class);
		add(SourceFileScopeTrial.class);
		add(SuppressOutputTrial.class);
		add(TargetedPlatformTrial.class);
		
		add(TrialTimeoutTrial.class);
		add(UseCaseScopeTrial.class);
		
		add(TestTrial.class);
		add(IgnoreTestTrial.class);
		add(IgnoreTrialTrial.class);
		add(TrialRecursionTrial.class);
		
		add(TrialRunContextTrial.class);
		add(TrialParamValueTrial.class);
		add(TrialParamValue_XML_ConsumerTrial.class);
		
		add(TrialParamsMutantTrial.class);
		add(TrialParamsTrial.class);
		
		add(TrialBindingsTrial.class);
		add(SubProgressTrial.class);
		
		add(AbstractTrialTrial.class);
		add(SourceFileTrialTrial.class);
		add(ApiTrialTrial.class);
		add(UseCaseTrialTrial.class);
		add(TrialDelegateTrial.class);
		add(MetaTrialTrial.class);
	}
	
	@Override
	public A_TrialsPkgTrials getTrialParams() {
		return this;
	}
}
