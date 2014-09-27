package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse;

import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Log;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=JSE_Math.class)
public class JSE_MathTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.lang.Appendable",I_JSE_1_7_Lang.APPENDABLE);
		assertEquals("java.math.BigDecimal",JSE_Math.BIG_DECIMAL);
		assertEquals("java.math.BigInteger",JSE_Math.BIG_INTEGER);
		assertEquals("java.math.MathContext",JSE_Math.MATH_CONTEXT);
		assertEquals("java.math.RoundingMode",JSE_Math.ROUNDING_MODE);
		assertEquals(JSE_Math.class.getName(), JSE_Math.INSTANCE.getClass().getName());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 6;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 6;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
