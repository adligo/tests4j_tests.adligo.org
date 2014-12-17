package org.adligo.tests4j_tests.run.xml.io.use_cases.v1_0;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_RunXmlIOUseCasesPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_RunXmlIOUseCasesPkgTrials>, I_CountingPackageTrials {
  
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_RunXmlIOUseCasesPkgTrials me = new A_RunXmlIOUseCasesPkgTrials();
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
	  add(ObjectFactoryTrial.class);
	  add(StepTypeTrial.class);
	  add(UseCaseNameTypeTrial.class);
	  add(UseCaseTypeTrial.class);
	}

	@Override
	public A_RunXmlIOUseCasesPkgTrials getTrialParams() {
		return this;
	}
	
	@Override
  public void setParams(Tests4J_Params params) {
    super.setParams(params);
	}
}
