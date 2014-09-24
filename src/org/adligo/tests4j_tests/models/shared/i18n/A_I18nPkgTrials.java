package org.adligo.tests4j_tests.models.shared.i18n;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_I18nPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_I18nPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_I18nPkgTrials me = new A_I18nPkgTrials();
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
		add(I_Tests4J_AnnotationErrorsTrial.class);
		add(I_Tests4J_AssertionInputMessagesTrial.class);
		add(I_Tests4J_ConstantsTrial.class);
		add(I_Tests4J_EclipseErrorsTrial.class);
		add(I_Tests4J_LineDiffTextDisplayMessagesTrial.class);
		add(I_Tests4J_ParamsReaderMessagesTrial.class);
		add(I_Tests4J_ReportMessagesTrial.class);
		add(I_Tests4J_ResultMessagesTrial.class);
		
	}

	@Override
	public A_I18nPkgTrials getTrialParams() {
		return this;
	}

}
