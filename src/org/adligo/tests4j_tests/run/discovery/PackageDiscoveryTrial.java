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
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
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
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.PlatformType;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.TargetedPlatform;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialBindings;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j.models.shared.trials.TrialTimeout;
import org.adligo.tests4j.models.shared.trials.TrialTypeAnnotation;
import org.adligo.tests4j.models.shared.trials.UseCaseScope;
import org.adligo.tests4j.models.shared.trials.UseCaseTrial;
import org.adligo.tests4j.run.discovery.AfterTrialAuditor;
import org.adligo.tests4j.run.discovery.BeforeTrialAuditor;
import org.adligo.tests4j.run.discovery.I_TrialDescription;
import org.adligo.tests4j.run.discovery.I_TrialStateNameIdKey;
import org.adligo.tests4j.run.discovery.PackageDiscovery;
import org.adligo.tests4j.run.discovery.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.run.discovery.TestAuditor;
import org.adligo.tests4j.run.discovery.TestDescription;
import org.adligo.tests4j.run.discovery.Tests4J_ParamsReader;
import org.adligo.tests4j.run.discovery.TrialDescription;
import org.adligo.tests4j.run.discovery.TrialDescriptionProcessor;
import org.adligo.tests4j.run.discovery.TrialQueueDecisionTree;
import org.adligo.tests4j.run.discovery.TrialState;
import org.adligo.tests4j.run.discovery.TrialStateNameIdKey;
import org.adligo.tests4j.run.discovery.TrialTypeFinder;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.discovery.package_discovery_inner_mocks.TwoNestedRunnables;

@SourceFileScope (sourceClass=PackageDiscovery.class, minCoverage=51.0)
public class PackageDiscoveryTrial extends SourceFileCountingTrial {

	@Test
	public void testDiscoveryPackage() throws Exception {
		PackageDiscovery cd = new PackageDiscovery("org.adligo.tests4j.run.discovery");
		List<String> clazzNames = cd.getClassNames();
		assertNotNull(clazzNames);
		assertEquals(15, clazzNames.size());
		assertContains(clazzNames, AfterTrialAuditor.class.getName());
		assertContains(clazzNames, BeforeTrialAuditor.class.getName());
		
		assertContains(clazzNames, I_TrialDescription.class.getName());
		assertContains(clazzNames, I_TrialStateNameIdKey.class.getName());
		
		assertContains(clazzNames, PackageDiscovery.class.getName());

		assertContains(clazzNames, RelevantClassesWithTrialsCalculator.class.getName());
		
		assertContains(clazzNames, TestAuditor.class.getName());
		assertContains(clazzNames, TestDescription.class.getName());
		
		assertContains(clazzNames, Tests4J_ParamsReader.class.getName());
		
		
		assertContains(clazzNames, TrialDescription.class.getName());
		assertContains(clazzNames, TrialDescriptionProcessor.class.getName());
		
		assertContains(clazzNames, TrialQueueDecisionTree.class.getName());
		assertContains(clazzNames, TrialState.class.getName());
		assertContains(clazzNames, TrialStateNameIdKey.class.getName());
		
		assertContains(clazzNames, TrialTypeFinder.class.getName());
		
		List<PackageDiscovery>  subs = cd.getSubPackages();
		assertNotNull(subs);
		assertEquals(0, subs.size());
	}
	
	

	@Test
	public void testMetadataPackage() throws Exception {
		assertMetadataPackage();
	}

	private PackageDiscovery assertMetadataPackage() throws IOException {
		PackageDiscovery cd = new PackageDiscovery("org.adligo.tests4j.models.shared.metadata");
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, I_MachineMetadata.class.getName());
		assertContains(classNames, I_SourceInfoMetadata.class.getName());
		assertContains(classNames, I_TestMetadata.class.getName());
		assertContains(classNames, I_TrialMetadata.class.getName());
		assertContains(classNames, I_TrialRunMetadata.class.getName());
		assertContains(classNames, I_UseCaseMetadata.class.getName());
		
		assertContains(classNames, MachineMetadata.class.getName());
		assertContains(classNames, MachineMetadataMutant.class.getName());
		
		assertContains(classNames, SourceInfoMetadata.class.getName());
		assertContains(classNames, SourceInfoMetadataMutant.class.getName());
		
		assertContains(classNames, TestMetadata.class.getName());
		assertContains(classNames, TestMetadataMutant.class.getName());
		
		assertContains(classNames, TrialMetadata.class.getName());
		assertContains(classNames, TrialMetadataMutant.class.getName());
		assertContains(classNames, TrialRunMetadata.class.getName());
		assertContains(classNames, TrialRunMetadataMutant.class.getName());
		assertContains(classNames, UseCaseMetadata.class.getName());
		
		assertEquals(17, classNames.size());
		List<PackageDiscovery> children =  cd.getSubPackages();
		assertEquals(0, children.size());
		return cd;
	}
	
	@Test
	public void testModelsShared() throws Exception {
		PackageDiscovery cd = new PackageDiscovery("org.adligo.tests4j.models.shared.trials");
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, AllowedDependencies.class.getName());
		assertContains(classNames, AdditionalInstrumentation.class.getName());
		assertContains(classNames, AbstractTrial.class.getName());
		assertContains(classNames, AfterTrial.class.getName());
		assertContains(classNames, ApiTrial.class.getName());
		
		assertContains(classNames, BeforeTrial.class.getName());
		
		assertContains(classNames, TrialDelegate.class.getName());
		
		assertContains(classNames, I_AbstractTrial.class.getName());
		assertContains(classNames, I_ApiTrial.class.getName());
		assertContains(classNames, I_Trial.class.getName());
		assertContains(classNames, I_TrialBindings.class.getName());
		assertContains(classNames, I_MetaTrial.class.getName());
		assertContains(classNames, I_SourceFileTrial.class.getName());
		assertContains(classNames, I_UseCaseTrial.class.getName());
		
		assertContains(classNames, IgnoreTest.class.getName());
		
		assertContains(classNames, PlatformType.class.getName());
		
		assertContains(classNames, PackageScope.class.getName());
		assertContains(classNames, SourceFileScope.class.getName());
		assertContains(classNames, SourceFileTrial.class.getName());
		assertContains(classNames, TargetedPlatform.class.getName());
		assertContains(classNames, Test.class.getName());
		
		assertContains(classNames, TrialBindings.class.getName());
		assertContains(classNames, TrialTimeout.class.getName());
		assertContains(classNames, TrialTypeAnnotation.class.getName());
		assertContains(classNames, TrialRecursion.class.getName());
		
		assertContains(classNames, UseCaseScope.class.getName());
		assertContains(classNames, UseCaseTrial.class.getName());
		
		assertEquals(28, classNames.size());
		List<PackageDiscovery> children =  cd.getSubPackages();
		
		
		assertEquals(0, children.size());
	}
	
	@Test
	public void testInnerClasses() throws Exception {
		PackageDiscovery cd = new PackageDiscovery(
				"org.adligo.tests4j_tests.run.discovery.package_discovery_inner_mocks");
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, TwoNestedRunnables.class.getName());
		assertContains(classNames, "org.adligo.tests4j_tests.run.discovery.package_discovery_inner_mocks.TwoNestedRunnables$1");
		assertContains(classNames, "org.adligo.tests4j_tests.run.discovery.package_discovery_inner_mocks.TwoNestedRunnables$2");
		
		
		assertEquals(3, classNames.size());
		List<PackageDiscovery> children =  cd.getSubPackages();
		assertEquals(0, children.size());
	}
	
	@Test
	public void testTestForJ() throws Exception {
		PackageDiscovery cd = new PackageDiscovery("org.adligo.tests4j");
		List<String> classNames = cd.getClassNames();
		
		assertEquals(0, classNames.size());
		List<PackageDiscovery> children =  cd.getSubPackages();
		List<String> childNames = new ArrayList<String>();
		for(PackageDiscovery i: children) {
			childNames.add(i.getPackageName());
		}
		assertContains(childNames, "org.adligo.tests4j.models");
		assertContains(childNames, "org.adligo.tests4j.run");
		assertContains(childNames, "org.adligo.tests4j.shared");
		
		assertEquals(3, children.size());
	}
	
	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 77;
	}

	@Override
	public int getUniqueAsserts() {
		return 77;
	}
}
