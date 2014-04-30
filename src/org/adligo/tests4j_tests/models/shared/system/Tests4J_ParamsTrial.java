package org.adligo.tests4j_tests.models.shared.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.I_AbstractTrial;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;


@SourceFileScope(sourceClass=Tests4J_Params.class)
public class Tests4J_ParamsTrial extends SourceFileTrial {

	public Tests4J_ParamsTrial() {
		Map<Integer,Boolean> foo = getFoo();
		foo.put(1, true);
		for (int i = 0; i < 10; i++) {
			System.out.println(" hey " + i);
			foo.put(i, true);
		}
		foo.put(11, false);
	}
	@Test
	public void testDefaultParams() {
		Tests4J_Params params = new Tests4J_Params();
		List<Class<? extends I_AbstractTrial>> trials = params.getTrials();
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
		List<Class<? extends I_AbstractTrial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(1, trials.size());
		assertEquals(Tests4J_ParamsTrial.class, trials.get(0));
		assertEquals(1, params.getThreadPoolSize());
		Long random = System.currentTimeMillis();
		
	}
	
	private static Map<Integer,Boolean> getFoo() {
		return new HashMap<Integer,Boolean>();
	}
}
