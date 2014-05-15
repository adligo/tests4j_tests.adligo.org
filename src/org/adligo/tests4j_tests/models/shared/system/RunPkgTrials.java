package org.adligo.tests4j_tests.models.shared.system;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.AbstractTrial;
import org.adligo.tests4j.models.shared.system.I_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPlugin;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		plugin.setWriteOutInstrumentedClassFiles(true);
		
		//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
		params.setCoveragePlugin(plugin);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends AbstractTrial>> getTrials() {
		List<Class<? extends AbstractTrial>> trials = new ArrayList<Class<? extends AbstractTrial>>();
		
		trials.add(ByteListOutputStreamTrial.class);
		trials.add(Tests4J_ParamsTrial.class);
		return trials;
	}
}
