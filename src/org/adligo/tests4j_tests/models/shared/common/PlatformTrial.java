package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.Platform;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Platform.class, minCoverage=95.0)
public class PlatformTrial extends SourceFileCountingTrial {

	@Test
	public void testEnums() {
		assertEquals(3, Platform.values().length);
		assertEquals("JSE", Platform.JSE.toString());
		assertEquals("GWTC", Platform.GWTC.toString());
		assertEquals("ADFM", Platform.ADFM.toString());
		
		assertSame(Platform.JSE, Platform.get(Platform.JSE));
		assertSame(Platform.GWTC, Platform.get(Platform.GWTC));
		assertSame(Platform.ADFM, Platform.get(Platform.ADFM));
	}
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 7;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}
}
