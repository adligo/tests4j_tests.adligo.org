package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.dependency_groups.jse.JSE_Util;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_UtilDelegates extends GWT_2_6_LangDelegates {

	public GWT_2_6_UtilDelegates(I_Trial p) {
		super(p);
	}

	public void delegateConcurrentModificationExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}

	public void delegateEmptyStackExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}

	public void delegateMissingResourceExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getClassName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getKey", 
			JSE_Lang.STRING));
	}

	public void delegateNoSuchElementExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}

	public void delegateTooManyListenersExceptionMemberAsserts(I_ClassAttributes result) {
		delegateExceptionMemberAsserts(result);
	}
	
	public void delegateDateMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("after", 
			new String[] {JSE_Util.DATE}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("before", 
			new String[] {JSE_Util.DATE}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Util.DATE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getDate", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getDay", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getHours", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getMinutes", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getMonth", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getSeconds", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getTimezoneOffset", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getYear", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("toGMTString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toLocaleString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("UTC", 
			new String[] {ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("getTime", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("parse", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("setDate", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setHours", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setMinutes", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setMonth", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setSeconds", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setTime", 
			new String[] {ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("setYear", 
			new String[] {ClassMethods.INT}));
	}
	
	public void delegateAbstractCollectionMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("toArray", 
			"[" + JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("toArray", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			"[" + JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("contains", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("containsAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEmpty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("removeAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("retainAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("size", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("iterator", 
			"java.util.Iterator"));
		assertContains(ms, new MethodSignature("clear"));
	}
	
	public void delegateAbstractListMemberAsserts(I_ClassAttributes result) {
		delegateAbstractCollectionMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();

		assertContains(ms, new MethodSignature("addAll", 
			new String[] {ClassMethods.INT, JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("get", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("set", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("subList", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			"java.util.List"));
		assertContains(ms, new MethodSignature("listIterator", 
			"java.util.ListIterator"));
		assertContains(ms, new MethodSignature("listIterator", 
			new String[] {ClassMethods.INT}, 
			"java.util.ListIterator"));
	}
	
	public void delegateAbstractMapMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("containsKey", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("containsValue", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEmpty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("size", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("get", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("put", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("values", 
			JSE_Util.COLLECTION));
		assertContains(ms, new MethodSignature("entrySet", 
			"java.util.Set"));
		assertContains(ms, new MethodSignature("keySet", 
			"java.util.Set"));
		assertContains(ms, new MethodSignature("clear"));
		assertContains(ms, new MethodSignature("putAll", 
			new String[] {"java.util.Map"}));
	}
	
	
	public void delegateAbstractQueueMemberAsserts(I_ClassAttributes result) {
		delegateAbstractCollectionMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();

		assertContains(ms, new MethodSignature("element", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("offer", 
				new String[] {JSE_Lang.OBJECT},
				ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("peek",
				JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("poll",
				JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove",
				JSE_Lang.OBJECT));
	}
	
	public void delegateAbstractSequentialListMemberAsserts(I_ClassAttributes result) {
		delegateAbstractListMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {ClassMethods.INT, JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("get", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("set", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("iterator", 
			"java.util.Iterator"));
		assertContains(ms, new MethodSignature("listIterator", 
			new String[] {ClassMethods.INT}, 
			"java.util.ListIterator"));
		assertContains(ms, new MethodSignature("add", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}));
	}
	
	public void delegateAbstractSetMemberAsserts(I_ClassAttributes result) {
		delegateAbstractCollectionMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("removeAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("hashCode", 
			ClassMethods.INT));
	}
	
	public void delegateArrayListMemberAsserts(I_ClassAttributes result) {
		delegateAbstractListMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("toArray", 
			"[" + JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("toArray", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			"[" + JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {ClassMethods.INT, JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("contains", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEmpty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("removeAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("retainAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("size", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("get", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("set", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("iterator", 
			"java.util.Iterator"));
		assertContains(ms, new MethodSignature("subList", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			"java.util.List"));
		assertContains(ms, new MethodSignature("listIterator", 
			"java.util.ListIterator"));
		assertContains(ms, new MethodSignature("listIterator", 
			new String[] {ClassMethods.INT}, 
			"java.util.ListIterator"));
		assertContains(ms, new MethodSignature("add", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("clear"));
		assertContains(ms, new MethodSignature("ensureCapacity", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("trimToSize"));
	}
	
	public void delegateArraysMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("deepEquals", 
			new String[] {"[" + JSE_Lang.OBJECT, "[" + JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.BYTE, "[" + ClassMethods.BYTE}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.CHAR, "[" + ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.DOUBLE, "[" + ClassMethods.DOUBLE}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.FLOAT, "[" + ClassMethods.FLOAT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.INT, "[" + ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.LONG, "[" + ClassMethods.LONG}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + JSE_Lang.OBJECT, "[" + JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.SHORT, "[" + ClassMethods.SHORT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {"[" + ClassMethods.BOOLEAN, "[" + ClassMethods.BOOLEAN}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + ClassMethods.BYTE, ClassMethods.BYTE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.CHAR}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + ClassMethods.FLOAT, ClassMethods.FLOAT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + ClassMethods.LONG, ClassMethods.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + JSE_Lang.OBJECT, JSE_Lang.OBJECT, JSE_Util.COMPARATOR}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {"[" + ClassMethods.SHORT, ClassMethods.SHORT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("deepHashCode", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.BYTE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.CHAR}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.DOUBLE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.FLOAT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.SHORT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {"[" + ClassMethods.BOOLEAN}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("deepToString", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.BYTE}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.CHAR}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.DOUBLE}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.FLOAT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.LONG}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.SHORT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {"[" + ClassMethods.BOOLEAN}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("asList", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			JSE_Util.LIST));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.BYTE, ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.BYTE, ClassMethods.INT, 
				ClassMethods.INT, ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, 
				ClassMethods.INT, ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.DOUBLE, ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.DOUBLE, ClassMethods.INT, 
				ClassMethods.INT, ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.FLOAT, ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.FLOAT, ClassMethods.INT, 
				ClassMethods.INT, ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.INT, ClassMethods.INT, 
				ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.LONG, ClassMethods.INT, 
				ClassMethods.INT, ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.LONG, ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + JSE_Lang.OBJECT, ClassMethods.INT, 
				ClassMethods.INT, JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + JSE_Lang.OBJECT, JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.SHORT, ClassMethods.INT, 
				ClassMethods.INT, ClassMethods.SHORT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.SHORT, ClassMethods.SHORT}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.BOOLEAN, ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {"[" + ClassMethods.BOOLEAN, ClassMethods.INT, ClassMethods.INT, ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.BYTE, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.DOUBLE, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.FLOAT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.LONG, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + JSE_Lang.OBJECT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + JSE_Lang.OBJECT, ClassMethods.INT, ClassMethods.INT, JSE_Util.COMPARATOR}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + JSE_Lang.OBJECT, JSE_Util.COMPARATOR}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.SHORT}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {"[" + ClassMethods.SHORT, ClassMethods.INT, ClassMethods.INT}));
	}
	
	public void delegateCollectionsMemberAsserts(I_ClassAttributes result) {
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("EMPTY_LIST", JSE_Util.LIST));
		assertContains(fs, new FieldSignature("EMPTY_MAP", JSE_Util.MAP));
		assertContains(fs, new FieldSignature("EMPTY_SET", JSE_Util.SET));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {JSE_Util.COLLECTION, "[" + JSE_Lang.OBJECT }, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("disjoint", 
			new String[] {JSE_Util.COLLECTION, JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("replaceAll", 
			new String[] {JSE_Util.LIST, JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {JSE_Util.LIST, JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("binarySearch", 
			new String[] {JSE_Util.LIST, JSE_Lang.OBJECT, JSE_Util.COMPARATOR}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("frequency", 
			new String[] {JSE_Util.COLLECTION, JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("max", 
			new String[] {JSE_Util.COLLECTION}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("max", 
			new String[] {JSE_Util.COLLECTION, JSE_Util.COMPARATOR}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("min", 
			new String[] {JSE_Util.COLLECTION}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("min", 
			new String[] {JSE_Util.COLLECTION, JSE_Util.COMPARATOR}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("list", 
			new String[] {JSE_Util.ENUMERATION}, 
			JSE_Util.ARRAY_LIST));
		assertContains(ms, new MethodSignature("unmodifiableCollection", 
			new String[] {JSE_Util.COLLECTION}, 
			JSE_Util.COLLECTION));
		assertContains(ms, new MethodSignature("reverseOrder", 
			JSE_Util.COMPARATOR));
		assertContains(ms, new MethodSignature("reverseOrder", 
			new String[] {JSE_Util.COMPARATOR}, 
			JSE_Util.COMPARATOR));
		assertContains(ms, new MethodSignature("enumeration", 
			new String[] {JSE_Util.COLLECTION}, 
			JSE_Util.ENUMERATION));
		assertContains(ms, new MethodSignature("emptyList", 
			JSE_Util.LIST));
		assertContains(ms, new MethodSignature("nCopies", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Util.LIST));
		assertContains(ms, new MethodSignature("singletonList", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.LIST));
		assertContains(ms, new MethodSignature("unmodifiableList", 
			new String[] {JSE_Util.LIST}, 
			JSE_Util.LIST));
		assertContains(ms, new MethodSignature("emptyMap", 
			JSE_Util.MAP));
		assertContains(ms, new MethodSignature("singletonMap", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			JSE_Util.MAP));
		assertContains(ms, new MethodSignature("unmodifiableMap", 
			new String[] {JSE_Util.MAP}, 
			JSE_Util.MAP));
		assertContains(ms, new MethodSignature("emptySet", 
			JSE_Util.SET));
		assertContains(ms, new MethodSignature("emptySet", 
				JSE_Util.SET));
		assertContains(ms, new MethodSignature("singleton", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SET));
		assertContains(ms, new MethodSignature("unmodifiableSet", 
			new String[] {JSE_Util.SET}, 
			JSE_Util.SET));
		assertContains(ms, new MethodSignature("unmodifiableSortedMap", 
			new String[] {JSE_Util.SORTED_MAP}, 
			JSE_Util.SORTED_MAP));
		assertContains(ms, new MethodSignature("unmodifiableSortedSet", 
			new String[] {JSE_Util.SORTED_SET}, 
			JSE_Util.SORTED_SET));
		assertContains(ms, new MethodSignature("copy", 
			new String[] {JSE_Util.LIST, JSE_Util.LIST}));
		assertContains(ms, new MethodSignature("fill", 
			new String[] {JSE_Util.LIST, JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("reverse", 
			new String[] {JSE_Util.LIST}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {JSE_Util.LIST}));
		assertContains(ms, new MethodSignature("sort", 
			new String[] {JSE_Util.LIST, JSE_Util.COMPARATOR}));
		assertContains(ms, new MethodSignature("swap", 
			new String[] {JSE_Util.LIST, ClassMethods.INT, ClassMethods.INT}));
	}
	
	public void delegateCollectionMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("toArray", 
			"[" + JSE_Lang.OBJECT ));
		assertContains(ms, new MethodSignature("toArray", 
			new String[] {"[" + JSE_Lang.OBJECT }, 
			"[" + JSE_Lang.OBJECT ));
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("contains", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("containsAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEmpty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("removeAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("retainAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("size", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("iterator", 
			JSE_Util.ITERATOR));
		assertContains(ms, new MethodSignature("clear"));
	}
	
	public void delegateComparatorMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			ClassMethods.INT));
	}
	
	public void delegateEnumMapMemberAsserts(I_ClassAttributes result) {
		delegateAbstractMapMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("clone", 
			JSE_Util.ENUM_MAP));
	}
	public void delegateEnumSetMemberAsserts(I_ClassAttributes result) {
		delegateAbstractSetMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("allOf", 
			new String[] {JSE_Lang.CLASS}, 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("clone", 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("complementOf", 
			new String[] {JSE_Util.ENUM_SET}, 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("copyOf", 
			new String[] {JSE_Util.COLLECTION}, 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("copyOf", 
			new String[] {JSE_Util.ENUM_SET}, 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("noneOf", 
			new String[] {JSE_Lang.CLASS}, 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("of", 
			new String[] {JSE_Lang.ENUM}, 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("of", 
			new String[] {JSE_Lang.ENUM, "[" + JSE_Lang.ENUM}, 
			JSE_Util.ENUM_SET));
		assertContains(ms, new MethodSignature("range", 
			new String[] {JSE_Lang.ENUM, JSE_Lang.ENUM}, 
			JSE_Util.ENUM_SET));
	}
	
	public void delegateEnumerationMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("hasMoreElements", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("nextElement", 
			JSE_Lang.OBJECT));
	}
	
	public void delegateEventObjectMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getSource", 
			JSE_Lang.OBJECT));
	}
	
	public void delegateHashMapMemberAsserts(I_ClassAttributes result) {
		delegateAbstractMapMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
	}
	
	public void delegateHashSetMemberAsserts(I_ClassAttributes result) {
		delegateAbstractSetMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
	}
	
	public void delegateIdentityHashMapMemberAsserts(I_ClassAttributes result) {
		delegateAbstractMapMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
	}
	
	public void delegateIteratorMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("hasNext", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("next", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove"));
	}
	
	public void delegateLinkedHashMapMemberAsserts(I_ClassAttributes result) {
		delegateHashMapMemberAsserts(result);
	}
	
	public void delegateLinkedHashSetMemberAsserts(I_ClassAttributes result) {
		delegateHashSetMemberAsserts(result);
	}
	
	public void delegateLinkedListMemberAsserts(I_ClassAttributes result) {
		delegateAbstractSequentialListMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {ClassMethods.INT, JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("get", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("getFirst", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("getLast", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("peek", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("poll", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("removeFirst", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("removeLast", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("listIterator", 
			new String[] {ClassMethods.INT}, 
			JSE_Util.LIST_ITERATOR));
		assertContains(ms, new MethodSignature("addFirst", 
			new String[] {JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("addLast", 
			new String[] {JSE_Lang.OBJECT}));
	}
	
	public void delegateListMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		delegateCollectionMemberAsserts(result);
		delegateIterableMemberAsserts(result);
		
	
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {ClassMethods.INT, JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("get", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("set", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("listIterator", 
			JSE_Util.LIST_ITERATOR));
		assertContains(ms, new MethodSignature("listIterator", 
			new String[] {ClassMethods.INT}, 
			JSE_Util.LIST_ITERATOR));
		assertContains(ms, new MethodSignature("add", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("clear"));
	}
	
	public void delegateListIteratorMemberAsserts(I_ClassAttributes result) {
		delegateIteratorMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("hasPrevious", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("nextIndex", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("previousIndex", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("previous", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("set", 
			new String[] {JSE_Lang.OBJECT}));
	}
	
	public void delegateMapMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("containsKey", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("containsValue", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEmpty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("hashCode", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("size", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("get", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("put", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("values", 
			JSE_Util.COLLECTION));
		assertContains(ms, new MethodSignature("entrySet", 
			JSE_Util.SET));
		assertContains(ms, new MethodSignature("keySet", 
			JSE_Util.SET));
		assertContains(ms, new MethodSignature("clear"));
		assertContains(ms, new MethodSignature("putAll", 
			new String[] {JSE_Util.MAP}));
	}
	
	public void delegateEntryMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("hashCode", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getKey", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("getValue", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("setValue", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
	}
	
	public void delegateObjectsMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("deepEquals", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT, JSE_Util.COMPARATOR}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hash", 
			new String[] {"[" + JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("requireNonNull", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("requireNonNull", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.STRING}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.STRING}, 
			JSE_Lang.STRING));
	}
	
	public void delegatePriorityQueueMemberAsserts(I_ClassAttributes result) {
		delegateAbstractQueueMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("offer", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("peek", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("poll", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("comparator", 
			JSE_Util.COMPARATOR));
	}
	
	public void delegateQueueMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("offer", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("element", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("peek", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("poll", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("remove", 
			JSE_Lang.OBJECT));
	}
	
	public void delegateRandomMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("nextBoolean", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("nextDouble", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("nextGaussian", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("nextFloat", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("nextInt", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("nextInt", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("nextLong", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("nextBytes", 
			new String[] {"[" + ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("setSeed", 
			new String[] {ClassMethods.LONG}));
	}
	
	public void delegateRandomAccessMemberAsserts(I_ClassAttributes result) {
	}
	
	public void delegateSetMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		delegateCollectionMemberAsserts(result);
	}
	
	public void delegateSortedMapMemberAsserts(I_ClassAttributes result) {
		delegateMapMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("firstKey", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("lastKey", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("headMap", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_MAP));
		assertContains(ms, new MethodSignature("subMap", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_MAP));
		assertContains(ms, new MethodSignature("tailMap", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_MAP));
	}
	
	public void delegateVectorMemberAsserts(I_ClassAttributes result) {
		delegateAbstractListMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();

		assertContains(ms, new MethodSignature("removeElement", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));

		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.OBJECT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.OBJECT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("elementAt", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("firstElement", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("lastElement", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("set", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("elements", 
			JSE_Util.ENUMERATION));
		assertContains(ms, new MethodSignature("subList", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Util.LIST));
		assertContains(ms, new MethodSignature("addElement", 
			new String[] {JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("copyInto", 
			new String[] {"[" + JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("ensureCapacity", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("insertElementAt", 
			new String[] {JSE_Lang.OBJECT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("removeAllElements"));
		assertContains(ms, new MethodSignature("removeElementAt", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setElementAt", 
			new String[] {JSE_Lang.OBJECT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setSize", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("trimToSize"));
	}
	
	public void delegateTreeMapMemberAsserts(I_ClassAttributes result) {
		delegateAbstractMapMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("clone", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("firstKey", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("lastKey", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("comparator", 
			JSE_Util.COMPARATOR));
		assertContains(ms, new MethodSignature("headMap", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_MAP));
		assertContains(ms, new MethodSignature("subMap", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_MAP));
		assertContains(ms, new MethodSignature("tailMap", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_MAP));
	}
	
	public void delegateStackMemberAsserts(I_ClassAttributes result) {
		delegateVectorMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("empty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("search", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("peek", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("pop", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("push", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.OBJECT));
	}
	
	public void delegateSortedSetMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("first", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("last", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("comparator", 
			JSE_Util.COMPARATOR));
		assertContains(ms, new MethodSignature("headSet", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_SET));
		assertContains(ms, new MethodSignature("subSet", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_SET));
		assertContains(ms, new MethodSignature("tailSet", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_SET));
	}
	
	public void delegateTreeSetMemberAsserts(I_ClassAttributes result) {
		delegateAbstractSetMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("addAll", 
			new String[] {JSE_Util.COLLECTION}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("contains", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEmpty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("remove", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("size", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("first", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("last", 
			JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("comparator", 
			JSE_Util.COMPARATOR));
		assertContains(ms, new MethodSignature("iterator", 
			JSE_Util.ITERATOR));
		assertContains(ms, new MethodSignature("headSet", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_SET));
		assertContains(ms, new MethodSignature("subSet", 
			new String[] {JSE_Lang.OBJECT, JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_SET));
		assertContains(ms, new MethodSignature("tailSet", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Util.SORTED_SET));
	}
}
