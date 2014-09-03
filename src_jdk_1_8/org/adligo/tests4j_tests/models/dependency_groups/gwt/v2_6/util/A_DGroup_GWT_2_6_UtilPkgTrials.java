package org.adligo.tests4j_tests.models.dependency_groups.gwt.v2_6.util;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroup_GWT_2_6_UtilPkgTrials extends SimplePackageTrials 
implements I_TrialParams<A_DGroup_GWT_2_6_UtilPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_DGroup_GWT_2_6_UtilPkgTrials me = new A_DGroup_GWT_2_6_UtilPkgTrials();
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
		add(ConcurrentModificationException_2_6_UseTrial.class);
		add(EmptyStackException_2_6_UseTrial.class);
		add(MissingResourceException_2_6_UseTrial.class);
		add(NoSuchElementException_2_6_UseTrial.class);
		add(TooManyListenersException_2_6_UseTrial.class);
	}

	@Override
	public A_DGroup_GWT_2_6_UtilPkgTrials getTrialParams() {
		return this;
	}
}
