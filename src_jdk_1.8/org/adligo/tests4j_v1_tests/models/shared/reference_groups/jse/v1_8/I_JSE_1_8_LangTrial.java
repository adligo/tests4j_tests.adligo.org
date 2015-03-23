package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_8;

import java.util.Arrays;
import java.util.List;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_Lang;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_8_GwtReferenceGroup;

@SourceFileScope (sourceClass=I_JSE_1_8_Lang.class)
@AllowedReferences (groups=Tests4J_JSE_v1_8_GwtReferenceGroup.class)
public class I_JSE_1_8_LangTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		Class<?> [] classes = I_JSE_1_8_Lang.class.getInterfaces();
		List<Class<?>> cs = Arrays.asList(classes);
		assertContains(cs, I_JSE_1_7_Lang.class);
		assertEquals("java.lang.FunctionalInterface", I_JSE_1_8_Lang.FUNCTIONAL_INTERFACE);
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 2;
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
		int thisUniqueAsserts = 2;
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
