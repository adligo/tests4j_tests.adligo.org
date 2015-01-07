package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_UtilConcurrent;
import org.adligo.tests4j.run.common.ClassesDelegate;
import org.adligo.tests4j.run.common.ConcurrentQualifiedMap;
import org.adligo.tests4j.run.common.Holder;
import org.adligo.tests4j.run.common.I_Classes;
import org.adligo.tests4j.run.common.I_InitalValueFactory;
import org.adligo.tests4j.run.common.I_JavaPackageNode;
import org.adligo.tests4j.run.common.I_Memory;
import org.adligo.tests4j.run.common.I_Notifier;
import org.adligo.tests4j.run.common.I_RemoteRunner;
import org.adligo.tests4j.run.common.I_RemoteRunnerFactory;
import org.adligo.tests4j.run.common.I_ThreadGroupFilter;
import org.adligo.tests4j.run.common.I_ThreadGroupLocal;
import org.adligo.tests4j.run.common.I_ThreadManager;
import org.adligo.tests4j.run.common.I_ThreadingFactory;
import org.adligo.tests4j.run.common.I_Threads;
import org.adligo.tests4j.run.common.JavaPackageNodeMutant;
import org.adligo.tests4j.run.common.JavaTree;
import org.adligo.tests4j.run.common.NotifierDelegate;
import org.adligo.tests4j.run.common.ThreadGroupFilter;
import org.adligo.tests4j.run.common.ThreadGroupLocal;
import org.adligo.tests4j.run.common.ThreadingFactory;
import org.adligo.tests4j.run.common.ThreadsDelegate;

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
		
		add(names, ClassesDelegate.class);
		add(names, ConcurrentQualifiedMap.class);
		add(names, Holder.class);
		
		add(names, I_Classes.class);
		add(names, I_InitalValueFactory.class);
		add(names, I_JavaPackageNode.class);
		add(names, I_Notifier.class);
		add(names, I_Memory.class);
		add(names, I_RemoteRunner.class);
		add(names, I_RemoteRunnerFactory.class);
		
		add(names, I_ThreadGroupFilter.class);
		add(names, I_ThreadGroupLocal.class);
		add(names, I_ThreadingFactory.class);
		
		add(names, I_ThreadManager.class);
		add(names, I_Threads.class);
		
		add(names, JavaPackageNodeMutant.class);
		add(names, JavaTree.class);
		
		add(names, NotifierDelegate.class);
		add(names, ThreadGroupFilter.class);
		add(names, ThreadGroupLocal.class);
		add(names, ThreadingFactory.class);
		add(names, ThreadsDelegate.class);
		
		names.addAll(JSE_UtilConcurrent.INSTANCE.getClassNames());
		names.addAll(Tests4J_Summary_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
