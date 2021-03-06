package org.adligo.tests4j_tests.shared.i18n;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_I18nPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_I18nPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_I18nPkgTrials me = new A_I18nPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	

	public void addTrials() throws Exception {
		add(I_Tests4J_AnnotationMessagesTrial.class);
		add(I_Tests4J_AssertionInputMessagesTrial.class);
		
		add(I_Tests4J_ConstantsTrial.class);
		add(I_Tests4J_CoveragePluginMessagesTrial.class);
		
		add(I_Tests4J_EclipseErrorsTrial.class);
		add(I_Tests4J_LineDiffTextDisplayMessagesTrial.class);
		add(I_Tests4J_LogMessagesTrial.class);
		add(I_Tests4J_ParamsReaderMessagesTrial.class);
		add(I_Tests4J_ReportMessagesTrial.class);
		add(I_Tests4J_ResultMessagesTrial.class);
		
	}

	@Override
	public A_I18nPkgTrials getTrialParams() {
		return this;
	}

}
