package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.TestDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_tests.trials_api.AssertionsWithNullExpectedFail_Trial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		//params.addTrial(NoPackageScopeAnnotationTrial.class);
		//params.addTrial(ReferenceTrackingClassVisitorTrial.class);
		//params.addTrial(ReferenceTrackingMethodVisitorTrial.class);
		//params.addTrial(ClassReferencesDiscoveryTrial.class);
		params.addTrial(AssertionsWithNullExpectedFail_Trial.class);
				

		params.setLogState(TrialDisplay.class, false);
		params.setLogState(TestDisplay.class, true);
		//params.setLogState(ClassReferencesDiscovery.class, true);
		params.setLogState(ClassDependenciesDiscovery.class, true);
		
		//logging from jacoco
		//params.addLoggingClass(AbstractPlugin.class);
		//params.setLogState(Recorder.class, true);
		
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		Tests4J.run(params);
	}

}

