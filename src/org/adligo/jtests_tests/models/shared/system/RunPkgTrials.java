package org.adligo.jtests_tests.models.shared.system;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.models.shared.I_AbstractTrial;
import org.adligo.jtests.reports.console.ConsoleTestRunner;
import org.adligo.jtests.reports.console.I_RunList;
import org.adligo.jtests_tests.api_trials.Assert_PassConditions_Trial;
import org.adligo.jtests_tests.api_trials.Run_ApiTrial_Trial;
import org.adligo.jtests_tests.api_trials.Run_ClassTrial_Trial;
import org.adligo.jtests_tests.api_trials.Run_UseCaseTrial_Trial;

public class RunPkgTrials implements I_RunList {

	
	public static void main(String [] args) {
		ConsoleTestRunner.run(new RunPkgTrials(), true);
		
	}


	public int getMinAssertions() {
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
