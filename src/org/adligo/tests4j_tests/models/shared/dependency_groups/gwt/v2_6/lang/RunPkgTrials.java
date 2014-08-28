package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		//params.setLogState(ClassDiscovery.class, true);
		
		//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
		params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		
		//params.addTest(new Tests4J_Selection(ClassReferencesTrial.class, "testGetsSetsAndConstructor"));
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		//in alpha dependency order
		trials.add(Appendable_2_6_UseTrial.class);
		
		trials.add(Object_2_6_UseTrial.class);
		trials.add(Throwable_2_6_UseTrial.class);
		trials.add(Exception_2_6_UseTrial.class);
		trials.add(RuntimeException_2_6_UseTrial.class);
		trials.add(ArithmeticException_2_6_UseTrial.class);
		
		trials.add(IndexOutOfBoundsException_2_6_UseTrial.class);
		trials.add(ArrayIndexOutOfBoundsException_2_6_UseTrial.class);
		trials.add(ArrayStoreException_2_6_UseTrial.class);
		trials.add(Error_2_6_UseTrial.class);
		trials.add(AssertionError_2_6_UseTrial.class);
		
		return trials;
	}
}
