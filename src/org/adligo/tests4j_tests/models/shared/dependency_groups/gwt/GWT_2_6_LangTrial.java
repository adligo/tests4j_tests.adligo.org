package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt;

import org.adligo.tests4j.models.shared.dependency.ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.ClassAttributesMutant;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Lang.class, minCoverage=50.0)
public class GWT_2_6_LangTrial extends SourceFileCountingTrial {
	private GWT_2_6_LangDelegates delegates;
	
	public GWT_2_6_LangTrial() {
		delegates = new GWT_2_6_LangDelegates(this);
	}
	@Test
	public void testAppendable() {
		ClassAttributes cam = GWT_2_6_Lang.getAppendable();
		delegates.delegateAppendable(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateAppendable(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testArithmeticException() {
		ClassAttributes cam = GWT_2_6_Lang.getArithmeticException();
		delegates.delegateArithmeticException(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateArithmeticException(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testArrayIndexOutOfBoundsException() {
		ClassAttributes cam = GWT_2_6_Lang.getArrayIndexOutOfBoundsException();
		delegates.delegateArrayIndexOutOfBoundsException(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateArrayIndexOutOfBoundsException(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testArrayStoreException() {
		ClassAttributes cam = GWT_2_6_Lang.getArrayStoreException();
		delegates.delegateArrayStoreException(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateArrayStoreException(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testAssertionError() {
		ClassAttributes cam = GWT_2_6_Lang.getAssertionError();
		delegates.delegateAssertionError(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateAssertionError(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testAutoCloseable() {
		ClassAttributes cam = GWT_2_6_Lang.getAutoCloseable();
		delegates.delegateAutoCloseable(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateAutoCloseable(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testBoolean() {
		ClassAttributes cam = GWT_2_6_Lang.getBoolean();
		delegates.delegateBoolean(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateBoolean(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testByte() {
		
	}
	@Override
	public int getTests() {
		return 8;
	}

	@Override
	public int getAsserts() {
		return 124;
	}

	@Override
	public int getUniqueAsserts() {
		return 69;
	}

}
