package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_IO;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_IODelegates extends GWT_2_6_LangDelegates {

	public GWT_2_6_IODelegates(I_Trial p) {
		super(p);
	}


	public void delegateIOExceptionMemberAsserts(I_ClassAttributes result) {
		delegateExceptionMemberAsserts(result);
	}

	public void delegateUnsupportedEncodingExceptionMemberAsserts(I_ClassAttributes result) {
		delegateIOExceptionMemberAsserts(result);
	}
	
	public void delegateFilterOutputStreamMemberAsserts(I_ClassAttributes result) {
		delegateOutputStreamMemberAsserts(result);
	}
	
	public void delegateOutputStreamMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
	}
	
	public void delegatePrintStreamMemberAsserts(I_ClassAttributes result) {
		delegateFilterOutputStreamMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("print", 
			new String[] {"[" + ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("print", 
			new String[] {ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("println"));
		assertContains(ms, new MethodSignature("println", 
			new String[] {"[" + ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("println", 
			new String[] {ClassMethods.LONG}));
	}
}
