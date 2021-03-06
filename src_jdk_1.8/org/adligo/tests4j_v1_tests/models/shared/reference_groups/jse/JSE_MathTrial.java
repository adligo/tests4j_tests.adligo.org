package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Lang;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_Math.class,minCoverage=84.0)
@AllowedReferences (groups=Tests4J_JSE_GwtReferenceGroup.class)
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
		
    assertEquals("BIG_DECIMAL",JSE_Math.INSTANCE.getConstantName("java.math.BigDecimal"));
    assertEquals("BIG_INTEGER",JSE_Math.INSTANCE.getConstantName("java.math.BigInteger"));
    assertEquals("MATH_CONTEXT",JSE_Math.INSTANCE.getConstantName("java.math.MathContext"));
    assertEquals("ROUNDING_MODE",JSE_Math.INSTANCE.getConstantName("java.math.RoundingMode"));

	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 10;
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
		int thisUniqueAsserts = 10;
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
