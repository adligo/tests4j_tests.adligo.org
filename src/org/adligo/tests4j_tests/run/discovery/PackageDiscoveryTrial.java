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
import org.adligo.tests4j.run.discovery.AfterTrialAuditor;
import org.adligo.tests4j.run.discovery.AllowedDependenciesAuditor;
import org.adligo.tests4j.run.discovery.BeforeTrialAuditor;
import org.adligo.tests4j.run.discovery.ClassesWithSourceFileTrialsCalculator;
import org.adligo.tests4j.run.discovery.I_TrialDescription;
import org.adligo.tests4j.run.discovery.I_TrialStateNameIdKey;
import org.adligo.tests4j.run.discovery.MemoryWarning;
import org.adligo.tests4j.run.discovery.NonTests4jMethodDiscovery;
import org.adligo.tests4j.run.discovery.PackageDiscovery;
import org.adligo.tests4j.run.discovery.TestAuditor;
import org.adligo.tests4j.run.discovery.TestDescription;
import org.adligo.tests4j.run.discovery.Tests4J_ParamsReader;
import org.adligo.tests4j.run.discovery.TrialDescription;
import org.adligo.tests4j.run.discovery.TrialDescriptionProcessor;
import org.adligo.tests4j.run.discovery.TrialQueueDecisionTree;
import org.adligo.tests4j.run.discovery.TrialState;
import org.adligo.tests4j.run.discovery.TrialStateNameIdKey;
import org.adligo.tests4j.run.discovery.TrialTypeFinder;
import org.adligo.tests4j.system.shared.trials.AbstractTrial;
import org.adligo.tests4j.system.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.system.shared.trials.AfterTrial;
import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.BeforeTrial;
import org.adligo.tests4j.system.shared.trials.I_AbstractTrial;
import org.adligo.tests4j.system.shared.trials.I_ApiTrial;
import org.adligo.tests4j.system.shared.trials.I_MetaTrial;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialInputData;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParamsAware;
import org.adligo.tests4j.system.shared.trials.I_Progress;
import org.adligo.tests4j.system.shared.trials.I_SourceFileTrial;
import org.adligo.tests4j.system.shared.trials.I_SubProgress;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j.system.shared.trials.I_TrialBindings;
import org.adligo.tests4j.system.shared.trials.I_TrialParamValue;
import org.adligo.tests4j.system.shared.trials.I_TrialParams;
import org.adligo.tests4j.system.shared.trials.I_TrialParamsAware;
import org.adligo.tests4j.system.shared.trials.I_TrialParamsFactory;
import org.adligo.tests4j.system.shared.trials.I_UseCaseTrial;
import org.adligo.tests4j.system.shared.trials.IgnoreTest;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.PlatformType;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.SourceFileTrial;
import org.adligo.tests4j.system.shared.trials.SubProgress;
import org.adligo.tests4j.system.shared.trials.SuppressOutput;
import org.adligo.tests4j.system.shared.trials.TargetedPlatform;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialBindings;
import org.adligo.tests4j.system.shared.trials.TrialDelegate;
import org.adligo.tests4j.system.shared.trials.TrialParamValue;
import org.adligo.tests4j.system.shared.trials.TrialParamValue_XML_Consumer;
import org.adligo.tests4j.system.shared.trials.TrialParams;
import org.adligo.tests4j.system.shared.trials.TrialParamsMutant;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;
import org.adligo.tests4j.system.shared.trials.TrialTimeout;
import org.adligo.tests4j.system.shared.trials.TrialTypeAnnotation;
import org.adligo.tests4j.system.shared.trials.UseCaseScope;
import org.adligo.tests4j.system.shared.trials.UseCaseTrial;
import org.adligo.tests4j_4jacoco.plugin.CoveragePlugin;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginMemory;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.SharedClassList;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.discovery.package_discovery_inner_mocks.TwoNestedRunnables;

@SourceFileScope (sourceClass=PackageDiscovery.class, minCoverage=50.0)
public class PackageDiscoveryTrial extends SourceFileCountingTrial {

	private static final int ASSERT_COUNT = 109;

	@Test
	public void testDiscoveryPackage() throws Exception {
		PackageDiscovery cd = new PackageDiscovery("org.adligo.tests4j.run.discovery");
		List<String> clazzNames = cd.getClassNames();
		assertNotNull(clazzNames);
		assertEquals(18, clazzNames.size());
		assertContains(clazzNames, AfterTrialAuditor.class.getName());
		assertContains(clazzNames, AllowedDependenciesAuditor.class.getName());
		
		assertContains(clazzNames, BeforeTrialAuditor.class.getName());
		
		assertContains(clazzNames, I_TrialDescription.class.getName());
		assertContains(clazzNames, I_TrialStateNameIdKey.class.getName());
		
		assertContains(clazzNames, MemoryWarning.class.getName());
		assertContains(clazzNames, NonTests4jMethodDiscovery.class.getName());
		assertContains(clazzNames, PackageDiscovery.class.getName());

		assertContains(clazzNames, ClassesWithSourceFileTrialsCalculator.class.getName());
		
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
	public void testModelsSharedTrials() throws Exception {
		PackageDiscovery cd = new PackageDiscovery("org.adligo.tests4j.system.shared.trials");
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
		
		assertContains(classNames, I_MetaTrialInputData.class.getName());
		assertContains(classNames, I_MetaTrialParams.class.getName());
		assertContains(classNames, I_MetaTrialParamsAware.class.getName());
		
		assertContains(classNames, I_TrialParams.class.getName());
		assertContains(classNames, I_TrialParamValue.class.getName());
		assertContains(classNames, I_TrialParamsAware.class.getName());
		assertContains(classNames, I_TrialParamsFactory.class.getName());
		
		assertContains(classNames, I_MetaTrial.class.getName());
		assertContains(classNames, I_Progress.class.getName());
		assertContains(classNames, I_SourceFileTrial.class.getName());
		assertContains(classNames, I_SubProgress.class.getName());
		assertContains(classNames, I_UseCaseTrial.class.getName());
		
		assertContains(classNames, IgnoreTest.class.getName());
		
		assertContains(classNames, PlatformType.class.getName());
		
		assertContains(classNames, PackageScope.class.getName());
		assertContains(classNames, SourceFileScope.class.getName());
		assertContains(classNames, SourceFileTrial.class.getName());
		assertContains(classNames, SubProgress.class.getName());
		assertContains(classNames, SuppressOutput.class.getName());
		assertContains(classNames, TargetedPlatform.class.getName());
		assertContains(classNames, Test.class.getName());
		
		assertContains(classNames, TrialBindings.class.getName());
		assertContains(classNames, TrialDelegate.class.getName());
		
		assertContains(classNames, TrialTimeout.class.getName());
		assertContains(classNames, TrialTypeAnnotation.class.getName());
		
		assertContains(classNames, TrialParams.class.getName());
		assertContains(classNames, TrialParamsMutant.class.getName());
		assertContains(classNames, TrialParamValue.class.getName());
		assertContains(classNames, TrialParamValue_XML_Consumer.class.getName());
		assertContains(classNames, TrialRecursion.class.getName());
		
		assertContains(classNames, UseCaseScope.class.getName());
		assertContains(classNames, UseCaseTrial.class.getName());
		
		assertEquals(43, classNames.size());
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
		assertContains(childNames, "org.adligo.tests4j.system");
		
		assertEquals(4, children.size());
	}
	
	
	@Test
	public void testCoco() throws Exception {
		PackageDiscovery cd = new PackageDiscovery("org.adligo.tests4j_4jacoco.plugin");
		
		List<String> classNames = cd.getClassNames();
		assertContains(classNames, CoveragePlugin.class.getName());
		assertContains(classNames, CoveragePluginFactory.class.getName());
		assertContains(classNames, CoveragePluginMemory.class.getName());
		assertContains(classNames, Recorder.class.getName());
		assertContains(classNames, SharedClassList.class.getName());
		assertEquals(5, classNames.size());
		
		
		List<PackageDiscovery> children =  cd.getSubPackages();
		List<String> childNames = new ArrayList<String>();
		for(PackageDiscovery i: children) {
			childNames.add(i.getPackageName());
		}
		assertContains(childNames, "org.adligo.tests4j_4jacoco.plugin.analysis");
		assertContains(childNames, "org.adligo.tests4j_4jacoco.plugin.asm");
		assertContains(childNames, "org.adligo.tests4j_4jacoco.plugin.common");
		assertContains(childNames, "org.adligo.tests4j_4jacoco.plugin.data");
		assertContains(childNames, "org.adligo.tests4j_4jacoco.plugin.discovery");
		assertContains(childNames, "org.adligo.tests4j_4jacoco.plugin.instrumentation");
		assertContains(childNames, "org.adligo.tests4j_4jacoco.plugin.runtime");
		assertEquals(7, children.size());
		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = ASSERT_COUNT;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = ASSERT_COUNT;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
