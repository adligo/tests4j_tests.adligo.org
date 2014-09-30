package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.sql;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroups_GWT_2_6_SqlPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_GWT_2_6_SqlPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_DGroups_GWT_2_6_SqlPkgTrials me = new A_DGroups_GWT_2_6_SqlPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
		
			//params.addTest(new Tests4J_Selection(ClassReferencesTrial.class, "testGetsSetsAndConstructor"));
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	
	public void addTrials() throws Exception {
		add(Date_2_6_UseTrial.class);
		add(Time_2_6_UseTrial.class);
		add(Timestamp_2_6_UseTrial.class);
	}


	@Override
	public A_DGroups_GWT_2_6_SqlPkgTrials getTrialParams() {
		return this;
	}
}
