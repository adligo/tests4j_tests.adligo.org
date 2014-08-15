package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.TestDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.ClassReferencesDiscoveryTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		//params.addTrial(NoPackageScopeAnnotationTrial.class);
		//params.addTrial(ReferenceTrackingClassVisitorTrial.class);
		//params.addTrial(ReferenceTrackingMethodVisitorTrial.class);
		params.addTrial(ClassReferencesDiscoveryTrial.class);

		
		params.setLogState(MultiProbesMap.class, true);
		
		params.setLogState(TrialDisplay.class, false);
		params.setLogState(TestDisplay.class, true);
		//params.setLogState(ClassReferencesDiscovery.class, true);
		
		//logging from jacoco
		//params.addLoggingClass(AbstractPlugin.class);
		//params.setLogState(Recorder.class, true);
		
		//params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		Tests4J.run(params);
	}

}

