package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends AbstractTrial>> getTrials() {
		List<Class<? extends AbstractTrial>> trials = new ArrayList<Class<? extends AbstractTrial>>();
		
		trials.add(DiffIndexesTrial.class);
		trials.add(DiffIndexesPairTrial.class);
		
		trials.add(LineDiffMutantTrial.class);
		trials.add(LineDiffTrial.class);
		trials.add(LineDiffTypeTrial.class);
		trials.add(LineSplitterTrial.class);
		
		trials.add(TextLinesCompareResultTrial.class);
		trials.add(TextLinesCompareTrial.class);
		trials.add(TextLinesTrial.class);
		
		trials.addAll(new org.adligo.tests4j_tests.models.shared.asserts.common.RunPkgTrials().getTrials());
		return trials;
	}
}