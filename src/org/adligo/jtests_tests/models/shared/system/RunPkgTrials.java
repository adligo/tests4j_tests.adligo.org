package org.adligo.jtests_tests.models.shared.system;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.models.shared.I_AbstractTrial;
import org.adligo.jtests.models.shared.system.I_TrialList;
import org.adligo.jtests.models.shared.system.JTestParameters;
import org.adligo.jtests.reports.console.ConsoleTestRunner;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		JTestParameters params = new JTestParameters();
		params.addTrials(new RunPkgTrials());
		ConsoleTestRunner.run(params);
		
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
