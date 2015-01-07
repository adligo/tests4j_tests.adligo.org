package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_EnPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_EnPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_EnPkgTrials me = new A_EnPkgTrials();
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
		add(Tests4J_AssertionResultMessages_Trial.class);
		add(Tests4J_AssertionInputMessages_Trial.class);
		add(Tests4J_AnnotationMessagesTrial.class);
		
		add(Tests4J_EclipseMessages_Trial.class);
		add(Tests4J_EnglishConstants_Trial.class);
		
		add(Tests4J_LineDiffTextDisplayMessages_Trial.class);
		add(Tests4J_LogMessages_Trial.class);
		
		add(Tests4J_ParamsReaderMessages_Trial.class);
		add(Tests4J_ReportMessages_Trial.class);
		
	}

	@Override
	public A_EnPkgTrials getTrialParams() {
		return this;
	}

}
