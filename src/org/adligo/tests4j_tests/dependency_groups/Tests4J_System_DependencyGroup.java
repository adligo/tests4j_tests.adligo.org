package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.system.shared.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.I_Tests4J_CoveragePlugin;
import org.adligo.tests4j.system.shared.I_Tests4J_CoveragePluginFactory;
import org.adligo.tests4j.system.shared.I_Tests4J_CoveragePluginParams;
import org.adligo.tests4j.system.shared.I_Tests4J_CoverageRecorder;
import org.adligo.tests4j.system.shared.I_Tests4J_CoverageTrialInstrumentation;
import org.adligo.tests4j.system.shared.I_Tests4J_Delegate;
import org.adligo.tests4j.system.shared.I_Tests4J_DelegateFactory;
import org.adligo.tests4j.system.shared.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.I_Tests4J_Params;
import org.adligo.tests4j.system.shared.I_Tests4J_ProcessInfo;
import org.adligo.tests4j.system.shared.I_Tests4J_ProgressMonitor;
import org.adligo.tests4j.system.shared.I_Tests4J_RemoteInfo;
import org.adligo.tests4j.system.shared.I_Tests4J_Runnable;
import org.adligo.tests4j.system.shared.I_Tests4J_Selection;
import org.adligo.tests4j.system.shared.I_Tests4J_SourceInfoParams;
import org.adligo.tests4j.system.shared.I_Tests4J_TestFinishedListener;
import org.adligo.tests4j.system.shared.I_Tests4J_TrialList;
import org.adligo.tests4j.system.shared.I_Tests4J_TrialProgress;
import org.adligo.tests4j.system.shared.Tests4J_CoveragePluginParams;
import org.adligo.tests4j.system.shared.Tests4J_CoverageTrialInstrumentation;
import org.adligo.tests4j.system.shared.Tests4J_DefaultProgressMonitor;
import org.adligo.tests4j.system.shared.Tests4J_DelegateCoveragePlugin;
import org.adligo.tests4j.system.shared.Tests4J_DelegateProgressMonitor;
import org.adligo.tests4j.system.shared.Tests4J_ListenerDelegator;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.Tests4J_RemoteInfo;
import org.adligo.tests4j.system.shared.Tests4J_Selection;
import org.adligo.tests4j.system.shared.Tests4J_SourceInfoParams;
import org.adligo.tests4j.system.shared.Tests4J_SourceInfoParamsDelegate;
import org.adligo.tests4j.system.shared.Tests4J_TrialProgress;

public class Tests4J_System_DependencyGroup extends Tests4J_DependencyGroup {

	public Tests4J_System_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
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
		add(names, I_Tests4J_ProcessInfo.class);
		add(names, I_Tests4J_ProgressMonitor.class);
		
		add(names, I_Tests4J_RemoteInfo.class);
		add(names, I_Tests4J_Runnable.class);
		
		add(names, I_Tests4J_Selection.class);
		add(names, I_Tests4J_SourceInfoParams.class);
		
		add(names, I_Tests4J_TestFinishedListener.class);
		add(names, I_Tests4J_TrialList.class);
		add(names, I_Tests4J_TrialProgress.class);
		
		add(names, Tests4J_CoveragePluginParams.class);
		add(names, Tests4J_CoverageTrialInstrumentation.class);
		add(names, Tests4J_DefaultProgressMonitor.class);
		add(names, Tests4J_DelegateCoveragePlugin.class);
		
		add(names, Tests4J_DelegateProgressMonitor.class);
		add(names, Tests4J_ListenerDelegator.class);
		
		add(names, Tests4J_Params.class);
		add(names, Tests4J_RemoteInfo.class);
		add(names, Tests4J_Selection.class);
		add(names, Tests4J_SourceInfoParams.class);
		add(names, Tests4J_SourceInfoParamsDelegate.class);
		add(names, Tests4J_TrialProgress.class);
		
		Tests4J_Results_DependencyGroup dg = new Tests4J_Results_DependencyGroup();
		names.addAll(dg.getClassNames());
		
		Tests4J_Metadata_DependencyGroup dgm = new Tests4J_Metadata_DependencyGroup();
		names.addAll(dgm.getClassNames());
		
		Tests4J_Asserts_DependencyGroup adg = new Tests4J_Asserts_DependencyGroup();
		names.addAll(adg.getClassNames());
		
		Tests4J_Output_DependencyGroup odg = new Tests4J_Output_DependencyGroup();
		names.addAll(odg.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
