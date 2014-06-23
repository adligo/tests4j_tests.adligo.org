package org.adligo.tests4j_tests.models.shared.common;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.AbstractTrial;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.system.I_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		params.setMetaTrialClass(CommonPackageMetaTrial.class);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends AbstractTrial>> getTrials() {
		List<Class<? extends AbstractTrial>> trials = new ArrayList<Class<? extends AbstractTrial>>();
		
		trials.add(ClassUtilsTrial.class);
		trials.add(MethodBlockerTrial.class);
		trials.add(PlatformEnumTrial.class);
		trials.add(StringMethodsTrial.class);
		trials.add(LineSeperatorTrial.class);
		trials.add(TrialTypeEnumTrial.class);
		
		return trials;
	}
}