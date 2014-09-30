package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Math;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.I_DependencyGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_JSE_v1_6_DependencyGroup;

@SourceFileScope (sourceClass=JSE_1_6_Math.class,minCoverage=80.0)
@AllowedDependencies (groups={Tests4J_JSE_v1_6_DependencyGroup.class})
public class JSE_1_6_MathTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Math.INSTANCE);
	}
		
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_DependencyGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.math.BigDecimal"));
		asserts.assertTrue(dg.isInGroup("java.math.BigInteger"));
		asserts.assertTrue(dg.isInGroup("java.math.RoundingMode"));
		asserts.assertTrue(dg.isInGroup("java.math.MathContext"));

	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 4;
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
		int thisUniqueAsserts = 1;
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
