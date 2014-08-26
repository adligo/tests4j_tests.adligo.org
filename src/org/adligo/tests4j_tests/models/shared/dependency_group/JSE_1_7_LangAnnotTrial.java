package org.adligo.tests4j_tests.models.shared.dependency_group;

import org.adligo.tests4j.models.shared.dependency_groups.JSE_1_7_LangAnnot;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=JSE_1_7_LangAnnot.class)
public class JSE_1_7_LangAnnotTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.lang.annotation.Annotation",JSE_1_7_LangAnnot.ANNOTATION);
		assertEquals("java.lang.annotation.ElementType",JSE_1_7_LangAnnot.ELEMENT_TYPE);
		assertEquals("java.lang.annotation.RetentionPolicy",JSE_1_7_LangAnnot.RETENTION_POLICY);
		assertEquals("java.lang.annotation.AnnotationTypeMismatchException",JSE_1_7_LangAnnot.ANNOTATION_TYPE_MISMATCH_EXCEPTION);
		assertEquals("java.lang.annotation.IncompleteAnnotationException",JSE_1_7_LangAnnot.INCOMPLETE_ANNOTATION_EXCEPTION);
		assertEquals("java.lang.annotation.AnnotationFormatError",JSE_1_7_LangAnnot.ANNOTATION_FORMAT_ERROR);
		assertEquals("java.lang.annotation.Documented",JSE_1_7_LangAnnot.DOCUMENTED);
		assertEquals("java.lang.annotation.Inherited",JSE_1_7_LangAnnot.INHERITED);
		assertEquals("java.lang.annotation.Retention",JSE_1_7_LangAnnot.RETENTION);
		assertEquals("java.lang.annotation.Target",JSE_1_7_LangAnnot.TARGET);
		assertEquals(JSE_1_7_LangAnnot.class.getName(), JSE_1_7_LangAnnot.INSTANCE.getClass().getName());
	}
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 11;
	}

	@Override
	public int getUniqueAsserts() {
		return 11;
	}

}
