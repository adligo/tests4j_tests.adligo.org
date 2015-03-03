package org.adligo.tests4j_tests.shared.i18n;

import org.adligo.tests4j.shared.asserts.common.I_Asserts;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class I18N_Asserter {
	public static final String JACOCO_DATA = "$jacocoData";
	public static final String INSTANCE = "INSTANCE";
	private static final List<String> IGNORED_FIELD_NAMES = getIgnoredFieldNames();
	private Set<String> expecteds = new HashSet<String>();
	private I_Asserts asserts;
	private int constantCount;
	
	private static List<String> getIgnoredFieldNames() {
		List<String> toRet = new ArrayList<String>();
		toRet.add(JACOCO_DATA);
		toRet.add(INSTANCE);
		return Collections.unmodifiableList(toRet);
	}
	
	public I18N_Asserter(I_Asserts p) {
		asserts = p;
		if (p == null) {
			throw new NullPointerException("I18N_Asserter requires I_Asserts");
		}
	}
	
	public void assertConstant(String expected, String actual) {
	  if (expecteds.contains(expected)) {
	    throw new IllegalStateException("Already asserted " + System.lineSeparator() + 
	        expected);
	  }
	  expecteds.add(expected);
		asserts.assertEquals(expected, actual);
		constantCount++;
	}
	
	public void assertConstantsMatchMethods(Class<?> testedClass) {
		assertConstantsMatchMethods(testedClass, IGNORED_FIELD_NAMES);
	}
	
	public void assertConstantsMatchMethods(Class<?> testedClass, Collection<String> ignoredFieldNames) {
		Field[] fields = testedClass.getDeclaredFields();
		
		Set<String> fieldNames = new HashSet<String>();
		int localCount = 0;
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			fieldNames.add(fieldName);
			if ( !ignoredFieldNames.contains(fieldName) && Modifier.isStatic(field.getModifiers())) {
				asserts.assertTrue("field " + fieldName + " should be private",Modifier.isPrivate(field.getModifiers()));
				asserts.assertTrue("field " + fieldName + " should be final",Modifier.isFinal(field.getModifiers()));
				localCount++;
			}
		}
		
		asserts.assertEquals(localCount, constantCount);
	}
}
