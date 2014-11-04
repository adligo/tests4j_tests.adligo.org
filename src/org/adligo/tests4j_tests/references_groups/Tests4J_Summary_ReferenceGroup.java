package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.system.shared.report.summary.AbstractProcessDisplay;
import org.adligo.tests4j.system.shared.report.summary.DefaultReporterStates;
import org.adligo.tests4j.system.shared.report.summary.DependencyFailureException;
import org.adligo.tests4j.system.shared.report.summary.LineDiffTextDisplay;
import org.adligo.tests4j.system.shared.report.summary.PercentFormat;
import org.adligo.tests4j.system.shared.report.summary.RemoteProcessDisplay;
import org.adligo.tests4j.system.shared.report.summary.RemoteProgressDisplay;
import org.adligo.tests4j.system.shared.report.summary.SetupProcessDisplay;
import org.adligo.tests4j.system.shared.report.summary.SetupProgressDisplay;
import org.adligo.tests4j.system.shared.report.summary.SummaryReporter;
import org.adligo.tests4j.system.shared.report.summary.TestDisplay;
import org.adligo.tests4j.system.shared.report.summary.TestFailedDisplay;
import org.adligo.tests4j.system.shared.report.summary.TestsProgressDisplay;
import org.adligo.tests4j.system.shared.report.summary.ThreadDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialFailedDetailDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialFailedDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialsProcessDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialsProgressDisplay;

/**
 *  @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_Summary_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_Summary_ReferenceGroup INSTANCE = new Tests4J_Summary_ReferenceGroup();
	
	private Tests4J_Summary_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, AbstractProcessDisplay.class);
		add(names, DefaultReporterStates.class);
		add(names, DependencyFailureException.class);
		add(names, LineDiffTextDisplay.class);
		add(names, PercentFormat.class);
		add(names, RemoteProcessDisplay.class);
		add(names, RemoteProgressDisplay.class);
		add(names, SetupProcessDisplay.class);
		add(names, SetupProgressDisplay.class);
		add(names, SummaryReporter.class);
		add(names, TestDisplay.class);
		add(names, TestFailedDisplay.class);
		add(names, TestsProgressDisplay.class);
		add(names, ThreadDisplay.class);
		add(names, TrialDisplay.class);
		add(names, TrialFailedDetailDisplay.class);
		add(names, TrialFailedDisplay.class);
		add(names, TrialsProcessDisplay.class);
		add(names, TrialsProgressDisplay.class);
		
		names.addAll(Tests4J_SystemApi_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
