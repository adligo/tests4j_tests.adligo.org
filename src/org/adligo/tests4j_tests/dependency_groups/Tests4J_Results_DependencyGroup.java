package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.results.ApiTrialResult;
import org.adligo.tests4j.models.shared.results.ApiTrialResultMutant;
import org.adligo.tests4j.models.shared.results.BaseTrialResult;
import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.results.I_Duration;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.results.I_TestResult;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.results.I_UseCaseTrialResult;
import org.adligo.tests4j.models.shared.results.SourceFileTrialResult;
import org.adligo.tests4j.models.shared.results.SourceFileTrialResultMutant;
import org.adligo.tests4j.models.shared.results.TestResult;
import org.adligo.tests4j.models.shared.results.TestResultMutant;
import org.adligo.tests4j.models.shared.results.TrialFailure;
import org.adligo.tests4j.models.shared.results.TrialRunResult;
import org.adligo.tests4j.models.shared.results.TrialRunResultMutant;
import org.adligo.tests4j.models.shared.results.UseCaseTrialResult;
import org.adligo.tests4j.models.shared.results.UseCaseTrialResultMutant;

public class Tests4J_Results_DependencyGroup extends Tests4J_DependencyGroup {

	public Tests4J_Results_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, ApiTrialResult.class);
		add(names, ApiTrialResultMutant.class);
		add(names, BaseTrialResult.class);
		add(names, BaseTrialResultMutant.class);
		
		add(names, I_ApiTrialResult.class);
		add(names, I_Duration.class);
		add(names, I_SourceFileTrialResult.class);
		add(names, I_TestResult.class);
		add(names, I_TrialFailure.class);
		add(names, I_TrialResult.class);
		add(names, I_TrialRunResult.class);
		add(names, I_UseCaseTrialResult.class);
		
		add(names, SourceFileTrialResult.class);
		add(names, SourceFileTrialResultMutant.class);
		
		add(names, TestResult.class);
		add(names, TestResultMutant.class);
		
		add(names, TrialFailure.class);
		add(names, TrialRunResult.class);
		add(names, TrialRunResultMutant.class);
		
		add(names, UseCaseTrialResult.class);
		add(names, UseCaseTrialResultMutant.class);
		
		Tests4J_Coverage_DependencyGroup dg = new Tests4J_Coverage_DependencyGroup();
		names.addAll(dg.getClassNames());
		
		Tests4J_Dependency_DependencyGroup dg2 = new Tests4J_Dependency_DependencyGroup();
		names.addAll(dg2.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
