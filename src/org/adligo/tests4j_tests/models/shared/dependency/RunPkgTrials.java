package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_tests.models.shared.dependency.ClassDependenciesMutantTrial;
import org.adligo.tests4j_tests.models.shared.dependency.ClassDependenciesTrial;
import org.adligo.tests4j_tests.models.shared.dependency.ClassReferencesMutantTrial;
import org.adligo.tests4j_tests.models.shared.dependency.DependencyMutantTrial;
import org.adligo.tests4j_tests.models.shared.dependency.DependencyTrial;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		//params.setLogState(ClassDiscovery.class, true);
		
		//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(ClassDependenciesMutantTrial.class);
		trials.add(ClassDependenciesTrial.class);
		
		trials.add(ClassReferencesMutantTrial.class);
		trials.add(ClassReferencesTrial.class);
		
		trials.add(DependencyMutantTrial.class);
		trials.add(DependencyTrial.class);
		
		
		return trials;
	}
}
