package org.adligo.tests4j_tests.jacoco.plugin.instrumentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.AbstractTrial;
import org.adligo.tests4j.models.shared.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.AfterTrial;
import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.BeforeTrial;
import org.adligo.tests4j.models.shared.I_AbstractTrial;
import org.adligo.tests4j.models.shared.I_MetaTrial;
import org.adligo.tests4j.models.shared.I_Trial;
import org.adligo.tests4j.models.shared.I_TrialProcessorBindings;
import org.adligo.tests4j.models.shared.IgnoreTest;
import org.adligo.tests4j.models.shared.MetaTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;
import org.adligo.tests4j.models.shared.TrialTimeout;
import org.adligo.tests4j.models.shared.TrialType;
import org.adligo.tests4j.models.shared.UseCaseScope;
import org.adligo.tests4j.models.shared.UseCaseTrial;
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
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j.models.shared");
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, AdditionalInstrumentation.class.getName());
		assertContains(classNames, AbstractTrial.class.getName());
		assertContains(classNames, AfterTrial.class.getName());
		assertContains(classNames, ApiTrial.class.getName());
		assertContains(classNames, BeforeTrial.class.getName());
		assertContains(classNames, I_AbstractTrial.class.getName());
		assertContains(classNames, I_Trial.class.getName());
		assertContains(classNames, I_TrialProcessorBindings.class.getName());
		assertContains(classNames, I_MetaTrial.class.getName());
		assertContains(classNames, MetaTrial.class.getName());
		assertContains(classNames, IgnoreTest.class.getName());
		
		assertContains(classNames, PackageScope.class.getName());
		assertContains(classNames, SourceFileScope.class.getName());
		assertContains(classNames, SourceFileTrial.class.getName());
		assertContains(classNames, Test.class.getName());
		assertContains(classNames, TrialTimeout.class.getName());
		assertContains(classNames, TrialType.class.getName());
		assertContains(classNames, TrialRecursion.class.getName());
		assertContains(classNames, UseCaseScope.class.getName());
		assertContains(classNames, UseCaseTrial.class.getName());
		
		assertEquals(21, classNames.size());
		List<ClassDiscovery> children =  cd.getSubPackages();
		
		
		assertEquals(6, children.size());
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
		
		assertEquals(2, children.size());
	}
}
