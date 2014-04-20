package org.adligo.tests4j_tests.models.shared.system;

import java.util.List;

import org.adligo.tests4j.models.shared.AbstractTrial;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;


@SourceFileScope(sourceClass=Tests4J_Params.class)
public class Tests4J_ParamsTrial extends SourceFileTrial {

	@Test
	public void testDefaultParams() {
		Tests4J_Params params = new Tests4J_Params();
		
		List<Class<? extends AbstractTrial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(0, trials.size());
		assertEquals(0, params.getThreadPoolSize());
		
		for (int i = 0; i < 32; i++) {
			params.addTrial(Tests4J_ParamsTrial.class);
		}
		assertEquals(32, params.getThreadPoolSize());
		
	}
	
	@Test
	public void testOneTrialRunParams() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Tests4J_ParamsTrial.class);
		
		List<Class<? extends AbstractTrial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(1, trials.size());
		assertEquals(Tests4J_ParamsTrial.class, trials.get(0));
		assertEquals(1, params.getThreadPoolSize());
	}
}
