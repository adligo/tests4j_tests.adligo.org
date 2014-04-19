package org.adligo.tests4j_tests.models.shared.system;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.I_AbstractTrial;
import org.adligo.tests4j.models.shared.system.I_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPlugin;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		params.setCheckMins(false);
		params.setCoveragePlugin(new SimpleJacocoPlugin());
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
	public List<Class<? extends I_AbstractTrial>> getTrials() {
		List<Class<? extends I_AbstractTrial>> trials = new ArrayList<Class<? extends I_AbstractTrial>>();
		
		trials.add(ByteListOutputStreamTrial.class);
		return trials;
	}
}
