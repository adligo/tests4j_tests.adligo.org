package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.NoTestsTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		//params.addTrial(NoPackageScopeAnnotationTrial.class);
		//params.addTrial(ReferenceTrackingClassVisitorTrial.class);
		//params.addTrial(ReferenceTrackingMethodVisitorTrial.class);
		params.addTrial(NoTestsTrial.class);
		//params.addTrial(ReferenceTrackingClassVisitorTrial.class);
		//params.addTrial(BadUseCaseTrials_Trial.class);
		//params.addTest(new Tests4J_Selection(DiscoveryApiTrial.class, "test2003_MockWithTriangleA"));
		
		//params.setLogState(MultiProbesMap.class, true);
		
		//params.setLogState(TrialDisplay.class, false);
		//params.setLogState(TestDisplay.class, true);
		//params.setLogState(ClassInstrumenter.class, true);
		//params.setLogState(TrialInstrumenter.class, true);
		//params.setLogState(InitialDependenciesDiscovery.class, true);
		//params.setLogState(ReferenceTrackingClassVisitor.class, true);
		
		//logging from jacoco
		//params.addLoggingClass(AbstractPlugin.class);
		//params.setLogState(Recorder.class, true);
		//params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		Tests4J.run(params);
	}

}

