package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

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
import org.adligo.tests4j.system.shared.trials.IgnoreTrial;
import org.adligo.tests4j.system.shared.trials.MetaTrial;
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

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_SystemTrials_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_SystemTrials_ReferenceGroup INSTANCE = new Tests4J_SystemTrials_ReferenceGroup();
	
	private Tests4J_SystemTrials_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, AbstractTrial.class);
		add(names, AbstractTrial.class);
		add(names, AdditionalInstrumentation.class);
		add(names, AfterTrial.class);
		add(names, ApiTrial.class);
		add(names, BeforeTrial.class);
		add(names, I_AbstractTrial.class);
		add(names, I_ApiTrial.class);
		add(names, I_MetaTrial.class);
		add(names, I_MetaTrialInputData.class);
		add(names, I_MetaTrialParams.class);
		add(names, I_MetaTrialParamsAware.class);
		add(names, I_Progress.class);
		add(names, I_SourceFileTrial.class);
		add(names, I_SubProgress.class);
		add(names, I_Trial.class);
		add(names, I_TrialBindings.class);
		add(names, I_TrialParamValue.class);
		add(names, I_TrialParams.class);
		add(names, I_TrialParamsAware.class);
		add(names, I_TrialParamsFactory.class);
		add(names, I_UseCaseTrial.class);
		add(names, IgnoreTest.class);
		add(names, IgnoreTrial.class);
		add(names, MetaTrial.class);
		add(names, PackageScope.class);
		add(names, PlatformType.class);
		add(names, SourceFileScope.class);
		add(names, SourceFileTrial.class);
		add(names, SubProgress.class);
		add(names, SuppressOutput.class);
		add(names, TargetedPlatform.class);
		add(names, Test.class);
		add(names, TrialBindings.class);
		add(names, TrialDelegate.class);
		add(names, TrialParamValue.class);
		add(names, TrialParamValue_XML_Consumer.class);
		add(names, TrialParams.class);
		add(names, TrialParamsMutant.class);
		add(names, TrialRecursion.class);
		add(names, TrialTimeout.class);
		add(names, TrialTypeAnnotation.class);
		add(names, UseCaseScope.class);
		add(names, UseCaseTrial.class);
		
		names.addAll(Tests4J_Results_ReferenceGroup.INSTANCE.getClassNames());
		
		names.addAll(Tests4J_Metadata_ReferenceGroup.INSTANCE.getClassNames());
		
		names.addAll(Tests4J_Asserts_ReferenceGroup.INSTANCE.getClassNames());
		
		names.addAll(Tests4J_Output_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
