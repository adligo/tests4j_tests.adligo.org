package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.dependency.ClassParentsLocalMutant;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.Tests4J_Selection;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.models.shared.dependency_groups.jse.JSE_IOTrial;
import org.adligo.tests4j_tests.models.shared.dependency_groups.jse.JSE_LangAnnotTrial;
import org.adligo.tests4j_tests.models.shared.dependency_groups.jse.JSE_LangTrial;
import org.adligo.tests4j_tests.models.shared.dependency_groups.jse.JSE_LogTrial;
import org.adligo.tests4j_tests.models.shared.dependency_groups.jse.JSE_MathTrial;
import org.adligo.tests4j_tests.models.shared.dependency_groups.jse.JSE_SqlTrial;
import org.adligo.tests4j_tests.models.shared.dependency_groups.jse.JSE_UtilTrial;

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
		
		
		trials.add(Appendable_2_6_ClassAttributeUseTrial.class);
		
		trials.add(GWT_2_6_LangTrial.class);
		
		return trials;
	}
}