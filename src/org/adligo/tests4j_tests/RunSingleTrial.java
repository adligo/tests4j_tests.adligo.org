package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.TestDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.discovery.InitialDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.TrialInstrumenter;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.ReferenceTrackingClassVisitorTrial;
import org.adligo.tests4j_tests.models.shared.common.I_TrialTypeTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		//params.addTrial(NoPackageScopeAnnotationTrial.class);
		//params.addTrial(ReferenceTrackingClassVisitorTrial.class);
		//params.addTrial(ReferenceTrackingMethodVisitorTrial.class);
		params.addTrial(I_TrialTypeTrial.class);
		//params.addTrial(ReferenceTrackingClassVisitorTrial.class);
		//params.addTrial(BadUseCaseTrials_Trial.class);
		//params.addTest(new Tests4J_Selection(DiscoveryApiTrial.class, "test2003_MockWithTriangleA"));
		
		//params.setLogState(MultiProbesMap.class, true);
		
		params.setLogState(TrialDisplay.class, false);
		params.setLogState(TestDisplay.class, true);
		params.setLogState(ClassInstrumenter.class, true);
		params.setLogState(TrialInstrumenter.class, true);
		params.setLogState(InitialDependenciesDiscovery.class, true);
		//params.setLogState(ReferenceTrackingClassVisitor.class, true);
		
		//logging from jacoco
		//params.addLoggingClass(AbstractPlugin.class);
		//params.setLogState(Recorder.class, true);
		params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		Tests4J.run(params);
	}

}

