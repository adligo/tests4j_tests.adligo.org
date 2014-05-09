package org.adligo.tests4j_tests.jacoco.api_trials;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.AbstractTrial;
import org.adligo.tests4j.models.shared.system.I_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.OldScopedJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassDiscovery;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		params.setCheckMins(false);
		
		OldScopedJacocoPlugin covargePlugin =new OldScopedJacocoPlugin();
		params.setCoveragePlugin(covargePlugin);
		Tests4J.run(params);
	}


	public int getMinAsserts() {
		return 4;
	}
	
	public int getMinUniqueAssertions() {
		return 4;
	}
	
	public int getMinTests(){
		return 2;
	}

	@Override
	public List<Class<? extends AbstractTrial>> getTrials() {
		List<Class<? extends AbstractTrial>> trials = new ArrayList<Class<? extends AbstractTrial>>();
		
		trials.add(MultiRecordingTrial.class);
		return trials;
	}
}
