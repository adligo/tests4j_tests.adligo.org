package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.Tests4J_Selection;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		//params.setLogState(ReferenceTrackingClassVisitor.class, true);
		//params.setLogState(ReferenceTrackingMethodVisitor.class, true);
		//params.setLogState(ClassDependenciesDiscovery.class, true);
		//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
		//params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		
		params.setLogState(OrderedClassDiscovery.class, true);
		params.setLogState(ClassInstrumenter.class, true);
		/*
		params.setTests(Collections.singleton(
				new Tests4J_Selection(
						ClassDependenciesDiscoveryTrial.class,
						"test01_MockWithNothing")));
		*/
		/*
		params.setTests(Collections.singleton(
				new Tests4J_Selection(
						ReferenceTrackingClassVisitorTrial.class,
						"testFindReferences_80_MockWithEverything")));
		
		params.setTests(Collections.singleton(
				new Tests4J_Selection(
						ClassDependenciesDiscoveryTrial.class,
						"test03_RefToMockWithEverything")));
		
		params.setTests(Collections.singleton(
				new Tests4J_Selection(
						ClassDependenciesDiscoveryTrial.class,
						"test03_RefToMockWithEverything")));
						test01_MockWithNothing
		//test03_RefToMockWithEverything, test02_MockWithEverything
		*/
		/*
		params.setTests(Collections.singleton(
				new Tests4J_Selection(
						DiscoveryApiTrial.class,
						"test3001_MockWithEverything")));
		*/
		//params.setTests(Collections.singleton("testReferenceCounting_80_MockWithEverything"));
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(ReferenceTrackingMethodVisitorTrial.class);
		trials.add(ReferenceTrackingClassVisitorTrial.class);
		trials.add(ClassParentsDiscoveryTrial.class);
		trials.add(DiscoveryApiTrial.class);
		
		return trials;
	}
}
