package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.TieredJacocoPlugin;
import org.adligo.tests4j_tests.models.shared.system.Tests4J_ParamsTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		//params.addTrial(ByteListOutputStreamTrial.class);
		params.addTrial(Tests4J_ParamsTrial.class);
		params.setCheckMins(false);
		//params.setCoveragePlugin(new SimpleJacocoPlugin());
		TieredJacocoPlugin plugin = new TieredJacocoPlugin();
		plugin.setWriteOutInstrumentedClassFiles(true);
		params.setCoveragePlugin(plugin);
		Tests4J.run(params);
	}

}
