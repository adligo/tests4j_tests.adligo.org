package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.dependency_groups.gwt.GWT_2_6_IO;
import org.adligo.tests4j.models.dependency_groups.jse.JSE_IO;
import org.adligo.tests4j.models.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_IO.class, minCoverage=97.0)
public class GWT_2_6_IOTrial extends SourceFileCountingTrial {
	private GWT_2_6_IODelegates delegates;
	
	public GWT_2_6_IOTrial() {
		delegates = new GWT_2_6_IODelegates(this);
	}
	
	@Test
	public void testIOException() {
		I_ClassAttributes result = GWT_2_6_IO.getIOException();
		assertEquals("java.io.IOException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateIOExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}
	@Test
	public void testUnsupportedEncodingException() {
		I_ClassAttributes result = GWT_2_6_IO.getUnsupportedEncodingException();
		assertEquals("java.io.UnsupportedEncodingException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateUnsupportedEncodingExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testFilterOutputStream() {
		I_ClassAttributes result = GWT_2_6_IO.getFilterOutputStream();
		assertEquals(JSE_IO.FILTER_OUTPUT_STREAM, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_IO.OUTPUT_STREAM}));
		delegates.delegateFilterOutputStreamMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(5, ms.size());
	}

	@Test
	public void testOutputStream() {
		I_ClassAttributes result = GWT_2_6_IO.getOutputStream();
		assertEquals(JSE_IO.OUTPUT_STREAM, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateOutputStreamMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(4, ms.size());
	}

	@Test
	public void testPrintStream() {
		I_ClassAttributes result = GWT_2_6_IO.getPrintStream();
		assertEquals(JSE_IO.PRINT_STREAM, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_IO.OUTPUT_STREAM}));
		delegates.delegatePrintStreamMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(24, ms.size());
	}

	@Test
	public void testSerializable() {
		I_ClassAttributes result = GWT_2_6_IO.getSerializable();
		assertEquals("java.io.Serializable", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 99;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 2);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 96;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
