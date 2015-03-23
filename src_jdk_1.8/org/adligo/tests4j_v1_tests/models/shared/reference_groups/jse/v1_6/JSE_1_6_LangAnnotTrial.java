package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_LangAnnot;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_1_6_LangAnnot.class,minCoverage=88.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_LangAnnotTrial extends SourceFileCountingTrial {
	public static final int ASSERTS = 22;
	public static final int UASSERTS = 11;
	
	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_LangAnnot.INSTANCE);
    assertEquals("ANNOTATION",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.Annotation"));
    assertEquals("ELEMENT_TYPE",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.ElementType"));
    assertEquals("RETENTION_POLICY",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.RetentionPolicy"));
    assertEquals("ANNOTATION_TYPE_MISMATCH_EXCEPTION",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.AnnotationTypeMismatchException"));
    assertEquals("INCOMPLETE_ANNOTATION_EXCEPTION",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.IncompleteAnnotationException"));
    assertEquals("ANNOTATION_FORMAT_ERROR",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.AnnotationFormatError"));
    assertEquals("DOCUMENTED",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.Documented"));
    assertEquals("INHERITED",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.Inherited"));
    assertEquals("RETENTION",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.Retention"));
    assertEquals("TARGET",JSE_1_6_LangAnnot.INSTANCE.getConstantName("java.lang.annotation.Target"));
	}
	
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.Annotation"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.ElementType"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.RetentionPolicy"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.AnnotationTypeMismatchException"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.IncompleteAnnotationException"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.AnnotationFormatError"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.Documented"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.Inherited"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.Native"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.Repeatable"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.Retention"));
		asserts.assertTrue(dg.isInGroup("java.lang.annotation.Target"));
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, ASSERTS + thisAfterAsserts);
		} else {
			return super.getAsserts(type, ASSERTS);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, UASSERTS + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, UASSERTS);
		}
	}

}
