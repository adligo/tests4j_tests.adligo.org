package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Common_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.common.Platform;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Platform.class, minCoverage=95.0)
@AllowedDependencies (groups=Tests4J_Common_DependencyGroup.class)
public class PlatformTrial extends SourceFileCountingTrial {

	@Test
	public void testEnums() {
		assertEquals(3, Platform.values().length);
		assertEquals("JSE", Platform.JSE.toString());
		assertEquals("GWTC", Platform.GWTC.toString());
		assertEquals("MOBILE", Platform.MOBILE.toString());
		
		assertSame(Platform.JSE, Platform.get(Platform.JSE));
		assertSame(Platform.GWTC, Platform.get(Platform.GWTC));
		assertSame(Platform.MOBILE, Platform.get(Platform.MOBILE));
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	
	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,10);
		} else {
			return super.getAsserts(type, 7);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 10);
		} else {
			return super.getUniqueAsserts(type, 7);
		}
	}
}
