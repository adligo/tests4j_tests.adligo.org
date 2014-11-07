package org.adligo.tests4j_v1_tests.gwt_refs;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.run.helpers.GWT_ClassesTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.A_DGroups_GWT_2_6_PkgTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.GWT_2_6_AnnotTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.GWT_2_6_IOTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.GWT_2_6_LangTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.GWT_2_6_LogTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.GWT_2_6_MathTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.GWT_2_6_SqlTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.GWT_2_6_UtilTrial;

public class A_DGroups_GWT_PkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_GWT_PkgTrials>, I_CountingPackageTrials {
	private static final A_DGroups_GWT_2_6_PkgTrials v2_6 = new A_DGroups_GWT_2_6_PkgTrials();

	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DGroups_GWT_PkgTrials me = new A_DGroups_GWT_PkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			//params.setLogState(TrialInstrumenter.class, true);
			//params.setLogState(LazyPackageCoverage.class, true);
			//params.setLogState(LazyPackageCoverageFactory.class, true);
			
			params.setMetaTrialParams(me);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		
		v2_6.addTrials();
		add(v2_6.getCountingTrials());
		
		add(GWT_DependencyGroupTrial.class);
		
	}
	
	@Override
	public A_DGroups_GWT_PkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		v2_6.setParams(params);
	}
}
