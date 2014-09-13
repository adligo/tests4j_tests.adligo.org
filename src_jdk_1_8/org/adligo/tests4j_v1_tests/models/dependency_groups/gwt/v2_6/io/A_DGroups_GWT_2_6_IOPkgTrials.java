package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.io;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroups_GWT_2_6_IOPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_GWT_2_6_IOPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_DGroups_GWT_2_6_IOPkgTrials me = new A_DGroups_GWT_2_6_IOPkgTrials();
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
		add(IOException_2_6_UseTrial.class);
		add(UnsupportedEncodingException_2_6_UseTrial.class);
		add(FilterOutputStream_2_6_UseTrial.class);
		
		add(OutputStream_2_6_UseTrial.class);
		add(PrintStream_2_6_UseTrial.class);
		add(Serializable_2_6_UseTrial.class);
	}


	@Override
	public A_DGroups_GWT_2_6_IOPkgTrials getTrialParams() {
		return this;
	}
}
