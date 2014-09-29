package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_Math;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_JSE_v1_7_DependencyGroup;

@SourceFileScope (sourceClass=I_JSE_1_7_Math.class)
@AllowedDependencies (groups=Tests4J_JSE_v1_7_DependencyGroup.class)
public class I_JSE_1_7_MathTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.lang.Appendable",I_JSE_1_7_Lang.APPENDABLE);
		assertEquals("java.math.BigDecimal",I_JSE_1_7_Math.BIG_DECIMAL);
		assertEquals("java.math.BigInteger",I_JSE_1_7_Math.BIG_INTEGER);
		assertEquals("java.math.MathContext",I_JSE_1_7_Math.MATH_CONTEXT);
		assertEquals("java.math.RoundingMode",I_JSE_1_7_Math.ROUNDING_MODE);
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 5;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 5;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}
