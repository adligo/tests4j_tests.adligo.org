package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.Tests4J_Selection;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingClassVisitor;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingMethodVisitor;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		params.setLogState(ReferenceTrackingClassVisitor.class, true);
		params.setLogState(ReferenceTrackingMethodVisitor.class, true);
		//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		/*
		params.setTests(Collections.singleton(
				new Tests4J_Selection(
						ReferenceTrackingClassVisitorTrial.class,
						"testReferenceCounting_10_MockWithMethodExceptionBlock")));
			*/			
		//params.setTests(Collections.singleton("testReferenceCounting_80_MockWithEverything"));
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		trials.add(ClassReferencesMutantTrial.class);
		
		
		/*
		 * trials.add(ClassRefernceDiscoveryTrial.class);
		trials.add(ClassRefernceDiscoveryTrial.class);
		trials.add(ReferenceTrackingClassVisitorTrial.class);
		*/
		trials.add(ReferenceTrackingClassVisitorTrial.class);
		trials.add(ReferenceTrackingMethodVisitorTrial.class);
		
		return trials;
	}
}
