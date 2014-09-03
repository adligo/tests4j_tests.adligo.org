package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.data.coverage.LazyPackageCoverage;
import org.adligo.tests4j_4jacoco.plugin.data.coverage.LazyPackageCoverageFactory;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.TrialInstrumenter;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.annotation.A_DGroup_GWT_2_6_AnnotPkgTrials;
import org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.io.A_DGroups_GWT_2_6_IOPkgTrials;
import org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.lang.A_DGroups_GWT_2_6_LangPkgTrials;
import org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.util.A_DGroup_GWT_2_6_UtilPkgTrials;

public class A_DGroups_GWT_2_6_PkgTrials extends SimplePackageTrials 
implements I_TrialParams<A_DGroups_GWT_2_6_PkgTrials>, I_CountingPackageTrials {
	private static final A_DGroups_GWT_2_6_LangPkgTrials lang = new A_DGroups_GWT_2_6_LangPkgTrials();
	private static final A_DGroup_GWT_2_6_AnnotPkgTrials annot = new A_DGroup_GWT_2_6_AnnotPkgTrials();
	private static final A_DGroups_GWT_2_6_IOPkgTrials io = new A_DGroups_GWT_2_6_IOPkgTrials();
	private static final A_DGroup_GWT_2_6_UtilPkgTrials util = new A_DGroup_GWT_2_6_UtilPkgTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DGroups_GWT_2_6_PkgTrials me = new A_DGroups_GWT_2_6_PkgTrials();
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
		add(GWT_2_6_LangTrial.class);
		add(GWT_2_6_IOTrial.class);
		add(GWT_2_6_AnnotTrial.class);
		add(GWT_2_6_UtilTrial.class);
		
		lang.addTrials();
		add(lang.getCountingTrials());
		annot.addTrials();
		add(annot.getCountingTrials());
		io.addTrials();
		add(io.getCountingTrials());
		util.addTrials();
		add(util.getCountingTrials());
	}
	
	@Override
	public A_DGroups_GWT_2_6_PkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		lang.setParams(params);
		annot.setParams(params);
		io.setParams(params);
		util.setParams(params);
	}
}
