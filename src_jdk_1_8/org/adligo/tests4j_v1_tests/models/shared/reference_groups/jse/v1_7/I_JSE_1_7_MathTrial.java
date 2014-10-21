package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_7;

import java.util.Arrays;
import java.util.List;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Math;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_7_GwtReferenceGroup;

@SourceFileScope (sourceClass=I_JSE_1_7_Math.class)
@AllowedReferences (groups=Tests4J_JSE_v1_7_GwtReferenceGroup.class)
public class I_JSE_1_7_MathTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		Class<?> [] classes = I_JSE_1_7_Math.class.getInterfaces();
		List<Class<?>> cs = Arrays.asList(classes);
		assertContains(cs, I_JSE_1_6_Math.class);
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 1;
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
