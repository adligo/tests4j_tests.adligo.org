package org.adligo.tests4j_tests.run.discovery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.metadata.I_MachineMetadata;
import org.adligo.tests4j.models.shared.metadata.I_SourceInfoMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.I_UseCaseMetadata;
import org.adligo.tests4j.models.shared.metadata.MachineMetadata;
import org.adligo.tests4j.models.shared.metadata.MachineMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.metadata.SourceInfoMetadata;
import org.adligo.tests4j.models.shared.metadata.SourceInfoMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.UseCaseMetadata;
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
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassDiscovery.class, minCoverage=51.0)
public class ClassDiscoveryTrial extends SourceFileCountingTrial {

	@Test
	public void testDiscoveryPackage() throws Exception {
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j.run.discovery");
		List<String> clazzNames = cd.getClassNames();
		assertNotNull(clazzNames);
		assertEquals(2, clazzNames.size());
		assertTrue(clazzNames.contains("org.adligo.tests4j.run.discovery.ClassDiscovery"));
		assertTrue(clazzNames.contains("org.adligo.tests4j.run.discovery.TopPackageSet"));
		List<ClassDiscovery>  subs = cd.getSubPackages();
		assertNotNull(subs);
		assertEquals(0, subs.size());
	}
	
	

	@Test
	public void testMetadataPackage() throws Exception {
		assertMetadataPackage();
	}

	private ClassDiscovery assertMetadataPackage() throws IOException {
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j.models.shared.metadata");
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, I_MachineMetadata.class.getName());
		assertContains(classNames, I_SourceInfoMetadata.class.getName());
		assertContains(classNames, I_TestMetadata.class.getName());
		assertContains(classNames, I_TrialMetadata.class.getName());
		assertContains(classNames, I_TrialRunMetadata.class.getName());
		assertContains(classNames, I_UseCaseMetadata.class.getName());
		
		assertContains(classNames, MachineMetadata.class.getName());
		assertContains(classNames, MachineMetadataMutant.class.getName());
		
		assertContains(classNames, RelevantClassesWithTrialsCalculator.class.getName());
		
		assertContains(classNames, SourceInfoMetadata.class.getName());
		assertContains(classNames, SourceInfoMetadataMutant.class.getName());
		
		assertContains(classNames, TestMetadata.class.getName());
		assertContains(classNames, TestMetadataMutant.class.getName());
		
		assertContains(classNames, TrialMetadata.class.getName());
		assertContains(classNames, TrialMetadataMutant.class.getName());
		assertContains(classNames, TrialRunMetadata.class.getName());
		assertContains(classNames, TrialRunMetadataMutant.class.getName());
		assertContains(classNames, UseCaseMetadata.class.getName());
		
		assertEquals(18, classNames.size());
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
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 57;
	}

	@Override
	public int getUniqueAsserts() {
		return 56;
	}
}
