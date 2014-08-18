package org.adligo.tests4j_tests.jacoco.plugin.data.coverage;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;

/**
 * TODO 
 * from 6/24/2014- 7/16/2014 I was experiencing a random failure
 * with code coverage, I reduced it to about a 3% all run failure
 * using a ThreadLocal and then a ThreadLocalGroup
 * and then added tons of logging;
 * 
 * The following is a filtered log;
 * 
 * Tests4J: Thread tests4j-trial-18 is running trial;
 * org.adligo.tests4j_tests.models.shared.asserts.common.AssertTypeTrial
 * Tests4J: org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap@12c50438 Thread/Group: tests4j-trial-18~~~tests4j-trial-18 is clearing probes 
 * MultiProbesMap [classCovered=org/adligo/tests4j/models/shared/asserts/common/AssertType, probes=[t,t,t,t,t,t,t,t,f],threadGroupLocalProbes=[t,t,t,t,t,t,t,t,f]]
 * and then 
 * Tests4J: 	org.adligo.tests4j_tests.models.shared.asserts.common.AssertTypeTrial[0].testMinCoverage failed!
 * Tests4J: 	The actual Value should be greater than OR equal to the expected Value.
 * Tests4J: 	Expected;
 * Tests4J: 		Class: class java.lang.Double
 * Tests4J: 		'95.0'
 * Tests4J: 	Actual;
 * Tests4J: 		Class: class java.lang.Double
 * Tests4J: 		'7.8'
 * 
 * Since the probes seem to be getting recorded correctly,
 * I think my issue has something to do with ThreadSafty and
 * the conversion of probes to coverage units (instructions and branches).
 * So this test is a attempt to isolate that problem at the top level.
 *  
 * @author scott
 *
 */
@PackageScope (packageName="org.adligo.tests4j_4jacoco.plugin.data.coverage")
public class LazySourceFileCoverageThreadSaftyTrial extends ApiCountingTrial {

	@BeforeTrial
	public static void beforeTrial() {
		Executor exetutor = Executors.newFixedThreadPool(4);
				
	}
	
	@Test
	public void testThreadSafty() throws Exception {
		/*
		for (int i = 0; i < threadCount; i++) {
			exetutor.submit(new UTF8_CharacterBuilder_ChuckTester(charGroups,this));
		}
		while (charGroupCount > finishedCharGroups.get()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException x) {
				x.printStackTrace();
				return;
			}
		}
		System.out.print("hey");
		*/
	}

	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 31;
	}

	@Override
	public int getUniqueAsserts() {
		return 31;
	}


}
