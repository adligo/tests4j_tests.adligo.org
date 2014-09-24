package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.io.UnsupportedEncodingException;
import java.lang.String;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class String_2_6_MockUse {

	public String obj = null;
	public java.util.Comparator obj0 = String.CASE_INSENSITIVE_ORDER;
	public String_2_6_MockUse() throws UnsupportedEncodingException {
		obj = new String();
		obj = new String(
			"abc".getBytes());
		obj = new String(
				"abc".getBytes(), "UTF-16");
		obj = new String(
				"abc".getBytes(), 0, 1);
		obj = new String(
				"abc".getBytes(), 0, 1, "UTF-16");
		obj = new String(
				"abc".toCharArray());
		obj = new String(
				"abc".toCharArray(), 0, 1);
		
		obj = new String(
			new int [] {1,2, 3}, 0, 1);
		obj = new String(
			"string");
		obj = new String(
			new StringBuffer());
		obj = new String(
				new StringBuilder("mama"));
		callStringMethods();
		callObjectMethods();
	}

	public void callStringMethods() throws UnsupportedEncodingException {
		obj.getBytes();
		obj.getBytes("UTF-16");
		obj.toCharArray();
		obj.split("string");
		obj.split("string", 2);
		obj.contains("charSequence");
		obj.contentEquals("charSequence");
		obj.contentEquals(new StringBuffer());
		obj.endsWith("string");
		obj.equalsIgnoreCase("string");
		obj.isEmpty();
		obj.matches("string");
		obj.regionMatches(true, 2, "string", 2, 2);
		obj.regionMatches(2, "string", 2, 2);
		obj.startsWith("string");
		obj.startsWith("string", 2);
		obj.charAt(0);
		obj.codePointAt(2);
		obj.codePointBefore(2);
		obj.codePointCount(2, 2);
		obj.compareTo("string");
		obj.compareToIgnoreCase("string");
		obj.indexOf(2);
		obj.indexOf(2, 2);
		obj.indexOf("string");
		obj.indexOf("string", 2);
		obj.lastIndexOf(2);
		obj.lastIndexOf(2, 2);
		obj.lastIndexOf("string");
		obj.lastIndexOf("string", 2);
		obj.length();
		obj.offsetByCodePoints(2, 2);
		obj.subSequence(2, 2);
		obj.concat("string");
		obj.copyValueOf( new char[] {'a','b','c'});
		obj.copyValueOf( new char[] {'a','b','c'}, 0, 1);
		obj.intern();
		obj.replace('c', 'c');
		obj.replace("charSequence", "charSequence");
		obj.replaceAll("string", "string");
		obj.replaceFirst("string", "string");
		obj.substring(2);
		obj.substring(2, 2);
		obj.toLowerCase();
		obj.toString();
		obj.toUpperCase();
		obj.trim();
		obj.valueOf(new char[] {'a','b','c'});
		obj.valueOf(new char[] {'a','b','c'}, 0,1);
		obj.valueOf(true);
		obj.valueOf('c');
		obj.valueOf(0.1);
		obj.valueOf((float) 0.2);
		obj.valueOf(2);
		obj.valueOf(new Object());
		obj.valueOf(3L);
		obj.getChars(2, 2, new char[] {'a','b','c'}, 2);
	}
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
}