package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_AssertsLtRunPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_AssertsLtRunPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_AssertsLtRunPkgTrials me = new A_AssertsLtRunPkgTrials();
			me.setParams(params);
			me.addTrials();
			
			params.setMetaTrialParams(me);
			params.addTrials(me);
			params.setRecommendedSetupThreadCount(1);
				
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		add(DiffIndexesTrial.class);
		add(DiffIndexesMutantTrial.class);
		add(DiffIndexesPairTrial.class);
		
		add(LineDiffMutantTrial.class);
		add(LineDiffTrial.class);
		add(LineDiffTypeTrial.class);
		add(LineSplitterTrial.class);
		
		add(TextLinesCompareResultTrial.class);
		add(TextLinesCompareTrial.class);
		add(TextLinesTrial.class);
		
	}

	@Override
	public A_AssertsLtRunPkgTrials getTrialParams() {
		return this;
	}

}
