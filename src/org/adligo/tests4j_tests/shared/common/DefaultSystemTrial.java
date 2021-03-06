package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.DefaultSystem;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;

//TODO look into minCoverage it should be 53.0+
@SourceFileScope (sourceClass=DefaultSystem.class, minCoverage=30.0)
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
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
		
		assertEquals(System.getProperty("line.seperator","\n"), ds.lineSeperator());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,6);
		} else {
			return super.getAsserts(type, 3);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 6);
		} else {
			return super.getUniqueAsserts(type, 3);
		}
	}
}
