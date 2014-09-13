package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.logging;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroups_GWT_2_6_LogPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_GWT_2_6_LogPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_DGroups_GWT_2_6_LogPkgTrials me = new A_DGroups_GWT_2_6_LogPkgTrials();
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

	public void addTrials() throws Exception{
		add(Formatter_2_6_UseTrial.class);
		add(Handler_2_6_UseTrial.class);
		add(Level_2_6_UseTrial.class);
		add(LogManager_2_6_UseTrial.class);
		add(LogRecord_2_6_UseTrial.class);
		add(Logger_2_6_UseTrial.class);
	}

	@Override
	public A_DGroups_GWT_2_6_LogPkgTrials getTrialParams() {
		return this;
	}
}
