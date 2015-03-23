package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Math;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_1_6_Math.class,minCoverage=80.0)
@AllowedReferences (groups=Tests4J_JSE_v1_6_GwtReferenceGroup.class)
public class JSE_1_6_MathTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Math.INSTANCE);
    assertEquals("BIG_DECIMAL",JSE_1_6_Math.INSTANCE.getConstantName("java.math.BigDecimal"));
    assertEquals("BIG_INTEGER",JSE_1_6_Math.INSTANCE.getConstantName("java.math.BigInteger"));
    assertEquals("MATH_CONTEXT",JSE_1_6_Math.INSTANCE.getConstantName("java.math.MathContext"));
    assertEquals("ROUNDING_MODE",JSE_1_6_Math.INSTANCE.getConstantName("java.math.RoundingMode"));
	}
		
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.math.BigDecimal"));
		asserts.assertTrue(dg.isInGroup("java.math.BigInteger"));
		asserts.assertTrue(dg.isInGroup("java.math.RoundingMode"));
		asserts.assertTrue(dg.isInGroup("java.math.MathContext"));

	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 8;
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
