package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.dependency_groups.gwt.GWT_2_6_Util;
import org.adligo.tests4j.models.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Util.class, minCoverage=99.0)
public class GWT_2_6_UtilTrial extends SourceFileCountingTrial {
	private GWT_2_6_UtilDelegates delegates;
	
	public GWT_2_6_UtilTrial() {
		delegates = new GWT_2_6_UtilDelegates(this);
	}
	
	@Test
	public void testConcurrentModificationException() {
		I_ClassAttributes result = GWT_2_6_Util.getConcurrentModificationException();
		assertEquals("java.util.ConcurrentModificationException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateConcurrentModificationExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	@Test
	public void testEmptyStackException() {
		I_ClassAttributes result = GWT_2_6_Util.getEmptyStackException();
		assertEquals("java.util.EmptyStackException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		delegates.delegateEmptyStackExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(16, ms.size());
	}

	@Test
	public void testMissingResourceException() {
		I_ClassAttributes result = GWT_2_6_Util.getMissingResourceException();
		assertEquals("java.util.MissingResourceException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.STRING, JSE_Lang.STRING}));
		delegates.delegateMissingResourceExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	@Test
	public void testNoSuchElementException() {
		I_ClassAttributes result = GWT_2_6_Util.getNoSuchElementException();
		assertEquals("java.util.NoSuchElementException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateNoSuchElementExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testTooManyListenersException() {
		I_ClassAttributes result = GWT_2_6_Util.getTooManyListenersException();
		assertEquals("java.util.TooManyListenersException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateTooManyListenersExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 117;
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
		int thisUniqueAsserts = 112;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}
