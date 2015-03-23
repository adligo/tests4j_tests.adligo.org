package org.adligo.tests4j_v1_tests.gwt_refs.v2_6;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.annotation.A_DGroup_GWT_2_6_AnnotPkgTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.io.A_DGroups_GWT_2_6_IOPkgTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang.A_DGroups_GWT_2_6_LangPkgTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.math.A_DGroups_GWT_2_6_MathPkgTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.sql.A_DGroups_GWT_2_6_SqlPkgTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.util.A_DGroup_GWT_2_6_UtilPkgTrials;

public class A_DGroups_GWT_2_6_PkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_GWT_2_6_PkgTrials>, I_CountingPackageTrials {
	private static final A_DGroups_GWT_2_6_LangPkgTrials lang = new A_DGroups_GWT_2_6_LangPkgTrials();
	private static final A_DGroup_GWT_2_6_AnnotPkgTrials annot = new A_DGroup_GWT_2_6_AnnotPkgTrials();
	private static final A_DGroups_GWT_2_6_MathPkgTrials math = new A_DGroups_GWT_2_6_MathPkgTrials();
	
	private static final A_DGroups_GWT_2_6_IOPkgTrials io = new A_DGroups_GWT_2_6_IOPkgTrials();
	private static final A_DGroups_GWT_2_6_SqlPkgTrials sql = new A_DGroups_GWT_2_6_SqlPkgTrials();
	
	private static final A_DGroup_GWT_2_6_UtilPkgTrials util = new A_DGroup_GWT_2_6_UtilPkgTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
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
		add(GWT_2_6_AnnotTrial.class);
		add(GWT_2_6_MathTrial.class);
		
		add(GWT_2_6_IOTrial.class);
		add(GWT_2_6_SqlTrial.class);
		
		add(GWT_2_6_UtilTrial.class);
		add(GWT_2_6_LogTrial.class);
		
		lang.addTrials();
		add(lang.getCountingTrials());
		annot.addTrials();
		add(annot.getCountingTrials());
		math.addTrials();
		add(math.getCountingTrials());
		
		io.addTrials();
		add(io.getCountingTrials());
		sql.addTrials();
		add(sql.getCountingTrials());
		
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
		math.setParams(params);
		io.setParams(params);
		sql.setParams(params);
		util.setParams(params);
	}
}
