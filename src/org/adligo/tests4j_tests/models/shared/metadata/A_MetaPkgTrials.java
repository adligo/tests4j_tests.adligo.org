package org.adligo.tests4j_tests.models.shared.metadata;

import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_MetaPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_MetaPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_MetaPkgTrials me = new A_MetaPkgTrials();
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
		add(I_MachineMetadataTrial.class);
		add(I_SourceInfoMetadataTrial.class);
		add(I_TestMetadataTrial.class);
		add(I_TrialMetadataTrial.class);
		add(I_TrialRunMetadataTrial.class);
		add(I_UseCaseMetadataTrial.class);
		
		add(TestMetadataMutantTrial.class);
		add(TestMetadataTrial.class);
		add(TrialMetadataMutantTrial.class);
		add(TrialMetadataTrial.class);
		add(UseCaseMetadataTrial.class);
		
		add(MachineMetadataMutantTrial.class);
		add(MachineMetadataTrial.class);
		
		add(SourceInfoMetadataMutantTrial.class);
		add(SourceInfoMetadataTrial.class);
		
		add(TrialRunMetadataMutantTrial.class);
		add(TrialRunMetadataTrial.class);
	}

	@Override
	public A_MetaPkgTrials getTrialParams() {
		return this;
	}
}
