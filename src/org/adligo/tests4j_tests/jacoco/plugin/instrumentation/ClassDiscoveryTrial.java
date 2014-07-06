package org.adligo.tests4j_tests.jacoco.plugin.instrumentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.metadata.I_SourceInfo;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.I_UseCase;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.metadata.SourceInfo;
import org.adligo.tests4j.models.shared.metadata.SourceInfoMutant;
import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.UseCase;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.AfterTrial;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.I_AbstractTrial;
import org.adligo.tests4j.models.shared.trials.I_ApiTrial;
import org.adligo.tests4j.models.shared.trials.I_MetaTrial;
import org.adligo.tests4j.models.shared.trials.I_SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.models.shared.trials.I_TrialBindings;
import org.adligo.tests4j.models.shared.trials.I_UseCaseTrial;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.MetaTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialBindings;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j.models.shared.trials.TrialTimeout;
import org.adligo.tests4j.models.shared.trials.TrialTypeAnnotation;
import org.adligo.tests4j.models.shared.trials.UseCaseScope;
import org.adligo.tests4j.models.shared.trials.UseCaseTrial;
import org.adligo.tests4j.run.discovery.ClassDiscovery;

@SourceFileScope (sourceClass=ClassDiscovery.class)
public class ClassDiscoveryTrial extends SourceFileTrial {

	@Test
	public void testMetadataPackage() throws Exception {
		assertMetadataPackage();
	}

	private ClassDiscovery assertMetadataPackage() throws IOException {
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j.models.shared.metadata");
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, I_SourceInfo.class.getName());
		assertContains(classNames, I_TestMetadata.class.getName());
		assertContains(classNames, I_TrialMetadata.class.getName());
		assertContains(classNames, I_TrialRunMetadata.class.getName());
		assertContains(classNames, I_UseCase.class.getName());
		
		assertContains(classNames, RelevantClassesWithTrialsCalculator.class.getName());
		
		assertContains(classNames, SourceInfo.class.getName());
		assertContains(classNames, SourceInfoMutant.class.getName());
		
		assertContains(classNames, TestMetadata.class.getName());
		assertContains(classNames, TestMetadataMutant.class.getName());
		
		assertContains(classNames, TrialMetadata.class.getName());
		assertContains(classNames, TrialMetadataMutant.class.getName());
		assertContains(classNames, TrialRunMetadata.class.getName());
		assertContains(classNames, TrialRunMetadataMutant.class.getName());
		assertContains(classNames, UseCase.class.getName());
		
		assertEquals(15, classNames.size());
		List<ClassDiscovery> children =  cd.getSubPackages();
		assertEquals(0, children.size());
		return cd;
	}
	
	@Test
	public void testModelsShared() throws Exception {
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j.models.shared.trials");
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, AdditionalInstrumentation.class.getName());
		assertContains(classNames, AbstractTrial.class.getName());
		assertContains(classNames, AfterTrial.class.getName());
		assertContains(classNames, ApiTrial.class.getName());
		
		assertContains(classNames, BeforeTrial.class.getName());
		
		assertContains(classNames, I_AbstractTrial.class.getName());
		assertContains(classNames, I_ApiTrial.class.getName());
		assertContains(classNames, I_Trial.class.getName());
		assertContains(classNames, I_TrialBindings.class.getName());
		assertContains(classNames, I_MetaTrial.class.getName());
		assertContains(classNames, I_SourceFileTrial.class.getName());
		assertContains(classNames, I_UseCaseTrial.class.getName());
		
		assertContains(classNames, MetaTrial.class.getName());
		
		assertContains(classNames, IgnoreTest.class.getName());
		
		assertContains(classNames, PackageScope.class.getName());
		assertContains(classNames, SourceFileScope.class.getName());
		assertContains(classNames, SourceFileTrial.class.getName());
		assertContains(classNames, Test.class.getName());
		
		assertContains(classNames, TrialBindings.class.getName());
		assertContains(classNames, TrialTimeout.class.getName());
		assertContains(classNames, TrialTypeAnnotation.class.getName());
		assertContains(classNames, TrialRecursion.class.getName());
		
		assertContains(classNames, UseCaseScope.class.getName());
		assertContains(classNames, UseCaseTrial.class.getName());
		
		assertEquals(25, classNames.size());
		List<ClassDiscovery> children =  cd.getSubPackages();
		
		
		assertEquals(0, children.size());
	}
	
	
	@Test
	public void testTestForJ() throws Exception {
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j");
		List<String> classNames = cd.getClassNames();
		
		assertEquals(0, classNames.size());
		List<ClassDiscovery> children =  cd.getSubPackages();
		List<String> childNames = new ArrayList<String>();
		for(ClassDiscovery i: children) {
			childNames.add(i.getPackageName());
		}
		assertContains(childNames, "org.adligo.tests4j.models");
		assertContains(childNames, "org.adligo.tests4j.run");
		assertContains(childNames, "org.adligo.tests4j.shared");
		
		assertEquals(3, children.size());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(3, p.getTestCount());
		assertGreaterThanOrEquals(45.0, p.getAssertionCount());
		assertGreaterThanOrEquals(30.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(50.0, coverage.getPercentageCoveredDouble());
		}
	}
}
