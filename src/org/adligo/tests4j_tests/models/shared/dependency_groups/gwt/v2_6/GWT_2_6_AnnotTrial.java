package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Annot;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Lang.class, minCoverage=50.0)
public class GWT_2_6_AnnotTrial extends SourceFileCountingTrial {
	private GWT_2_6_AnnotDelegates delegates;
	
	public GWT_2_6_AnnotTrial() {
		delegates = new GWT_2_6_AnnotDelegates(this);
	}
	
	@Test
	public void testIncompleteAnnotationException() {
		I_ClassAttributes result = GWT_2_6_Annot.getIncompleteAnnotationException();
		assertEquals("java.lang.annotation.IncompleteAnnotationException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.CLASS, JSE_Lang.STRING}));
		delegates.delegateIncompleteAnnotationExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 24;
	}

	@Override
	public int getUniqueAsserts() {
		return 23;
	}

}
