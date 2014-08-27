package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.dependency.ClassParentsLocalMutant;
import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.Tests4J_Selection;
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
		
		trials.add(ClassAliasTrial.class);
		trials.add(ClassAttributesMutantTrial.class);
		trials.add(ClassAttributesTrial.class);
		
		trials.add(ClassDependenciesLocalMutantTrial.class);
		trials.add(ClassDependenciesLocalTrial.class);
		
		trials.add(ClassParentsLocalMutantTrial.class);
		trials.add(ClassParentsLocalTrial.class);
		
		trials.add(DependencyMutantTrial.class);
		trials.add(DependencyTrial.class);
		
		trials.add(MethodSignatureTrial.class);
		
		return trials;
	}
}