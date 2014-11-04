package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.run.common.I_Notifier;
import org.adligo.tests4j.run.common.I_Memory;
import org.adligo.tests4j.run.common.I_RemoteRunner;
import org.adligo.tests4j.run.common.I_RemoteRunnerFactory;
import org.adligo.tests4j.run.common.I_ThreadManager;
import org.adligo.tests4j.run.common.NotifierDelegate;

import java.util.HashSet;
import java.util.Set;

/**
 *  @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_RunCommon_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_RunCommon_ReferenceGroup INSTANCE = new Tests4J_RunCommon_ReferenceGroup();
	
	private Tests4J_RunCommon_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_Notifier.class);
		add(names, I_Memory.class);
		add(names, I_RemoteRunner.class);
		add(names, I_RemoteRunnerFactory.class);
		add(names, I_ThreadManager.class);
		add(names, NotifierDelegate.class);
		
		names.addAll(Tests4J_Summary_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
