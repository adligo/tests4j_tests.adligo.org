package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		//params.setLogState(ClassDiscovery.class, true);
		
		//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
		params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		
		//params.addTest(new Tests4J_Selection(ClassReferencesTrial.class, "testGetsSetsAndConstructor"));
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(GWT_2_6_LangTrial.class);
		trials.add(GWT_2_6_IOTrial.class);
		trials.add(GWT_2_6_AnnotTrial.class);
		trials.add(GWT_2_6_UtilTrial.class);
		
		trials.addAll(
				new org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.annotation.RunPkgTrials()
				.getTrials());
		trials.addAll(
				new org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.io.RunPkgTrials()
				.getTrials());
		trials.addAll(
				new org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.lang.RunPkgTrials()
				.getTrials());
		trials.addAll(
				new org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.util.RunPkgTrials()
				.getTrials());
		return trials;
	}
}
