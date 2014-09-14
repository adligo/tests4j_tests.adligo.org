package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Sql;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Util;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_SqlDelegates extends GWT_2_6_UtilDelegates {

	public GWT_2_6_SqlDelegates(I_Trial p) {
		super(p);
	}

	public void delegateDateMemberAsserts(I_ClassAttributes result) {
		super.delegateDateMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("setTime", 
			new String[] {ClassMethods.LONG}));
	}
	
	public void delegateTimeMemberAsserts(I_ClassAttributes result) {
		delegateDateMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getDate", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getDay", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getMonth", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getYear", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Sql.TIME));
		assertContains(ms, new MethodSignature("setDate", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setMonth", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setTime", 
			new String[] {ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("setYear", 
			new String[] {ClassMethods.INT}));
	}
	
	public void delegateTimestampMemberAsserts(I_ClassAttributes result) {
		delegateDateMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("after", 
			new String[] {JSE_Sql.TIMESTAMP}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("before", 
			new String[] {JSE_Sql.TIMESTAMP}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Sql.TIMESTAMP}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Sql.TIMESTAMP}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Util.DATE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getNanos", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Sql.TIMESTAMP));
		assertContains(ms, new MethodSignature("getTime", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("setNanos", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setTime", 
			new String[] {ClassMethods.LONG}));
	}
}
