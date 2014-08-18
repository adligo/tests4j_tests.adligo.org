package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.DefaultSystem;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=DefaultSystem.class, minCoverage=75.0)
public class DefaultSystemTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() {
		DefaultSystem ds = new DefaultSystem();
		//note this is actually for a visual check
		//on the log a run of tests4j_tests
		//so that I can make sure I don't break System.out.println() 
		// for test developers.
		ds.println("Tests4J: DefaultSystemTrial println1");
		System.out.println("Tests4J: DefaultSystemTrial println2");
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(100);
		} catch (InterruptedException x) {
			//do nothing, this makes the time assertions unique
		}
		long time = ds.getTime();
		try {
			Thread.sleep(100);
		} catch (InterruptedException x) {
			//do nothing, this makes the time assertions unique
		}
		long end = System.currentTimeMillis();
		assertGreaterThanOrEquals(start, time);
		assertGreaterThanOrEquals(time, end);
		
		assertEquals(System.lineSeparator(), ds.getLineSeperator());
	}

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 3;
	}

	@Override
	public int getUniqueAsserts() {
		return 3;
	}
}
