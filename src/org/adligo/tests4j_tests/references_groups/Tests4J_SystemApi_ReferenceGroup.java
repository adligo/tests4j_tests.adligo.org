package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.results.I_PhaseState;
import org.adligo.tests4j.system.shared.api.AbstractParamsFactory;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePlugin;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePluginFactory;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePluginParams;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoverageRecorder;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoverageTrialInstrumentation;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Delegate;
import org.adligo.tests4j.system.shared.api.I_Tests4J_DelegateFactory;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;
import org.adligo.tests4j.system.shared.api.I_Tests4J_ProgressParams;
import org.adligo.tests4j.system.shared.api.I_Tests4J_RemoteInfo;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Runnable;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Selection;
import org.adligo.tests4j.system.shared.api.I_Tests4J_SourceInfoParams;
import org.adligo.tests4j.system.shared.api.I_Tests4J_TestFinishedListener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_TrialList;
import org.adligo.tests4j.system.shared.api.I_Tests4J_TrialProgress;
import org.adligo.tests4j.system.shared.api.Tests4J_CoveragePluginParams;
import org.adligo.tests4j.system.shared.api.Tests4J_CoverageTrialInstrumentation;
import org.adligo.tests4j.system.shared.api.Tests4J_DefaultProgressParams;
import org.adligo.tests4j.system.shared.api.Tests4J_DelegateCoveragePlugin;
import org.adligo.tests4j.system.shared.api.Tests4J_DelegateProgressMonitor;
import org.adligo.tests4j.system.shared.api.Tests4J_ListenerDelegator;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.api.Tests4J_RemoteInfo;
import org.adligo.tests4j.system.shared.api.Tests4J_Selection;
import org.adligo.tests4j.system.shared.api.Tests4J_SourceInfoParams;
import org.adligo.tests4j.system.shared.api.Tests4J_SourceInfoParamsDelegate;
import org.adligo.tests4j.system.shared.api.Tests4J_TrialProgress;

import java.util.HashSet;
import java.util.Set;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_SystemApi_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_SystemApi_ReferenceGroup INSTANCE = new Tests4J_SystemApi_ReferenceGroup();
	
	private Tests4J_SystemApi_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		add(names, AbstractParamsFactory.class);
		
		add(names, I_Tests4J_Controls.class);
		add(names, I_Tests4J_CoveragePlugin.class);
		add(names, I_Tests4J_CoveragePluginFactory.class);
		add(names, I_Tests4J_CoveragePluginParams.class);
		add(names, I_Tests4J_CoverageRecorder.class);
		add(names, I_Tests4J_CoverageTrialInstrumentation.class);
		add(names, I_Tests4J_Delegate.class);
		add(names, I_Tests4J_DelegateFactory.class);
		
		add(names, I_Tests4J_Listener.class);
		add(names, I_Tests4J_Params.class);
		add(names, I_PhaseState.class);
		add(names, I_Tests4J_ProgressParams.class);
		
		add(names, I_Tests4J_RemoteInfo.class);
		add(names, I_Tests4J_Runnable.class);
		
		add(names, I_Tests4J_Selection.class);
		add(names, I_Tests4J_SourceInfoParams.class);
		
		add(names, I_Tests4J_TestFinishedListener.class);
		add(names, I_Tests4J_TrialList.class);
		add(names, I_Tests4J_TrialProgress.class);
		
		add(names, Tests4J_CoveragePluginParams.class);
		add(names, Tests4J_CoverageTrialInstrumentation.class);
		add(names, Tests4J_DefaultProgressParams.class);
		add(names, Tests4J_DelegateCoveragePlugin.class);
		
		add(names, Tests4J_DelegateProgressMonitor.class);
		add(names, Tests4J_ListenerDelegator.class);
		
		add(names, Tests4J_Params.class);
		add(names, Tests4J_RemoteInfo.class);
		add(names, Tests4J_Selection.class);
		add(names, Tests4J_SourceInfoParams.class);
		add(names, Tests4J_SourceInfoParamsDelegate.class);
		add(names, Tests4J_TrialProgress.class);
		
		names.addAll(Tests4J_SystemTrials_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
