package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang;

import java.lang.Character;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class Character_2_6_MockUse {

	public Character obj = null;
	public java.lang.Class<?> obj62 = Character.TYPE;
	public Character_2_6_MockUse() {
		obj = new Character(
			'c');
		callCharacterMethods();
		callObjectMethods();
	}

	@SuppressWarnings("static-access")
	public void callCharacterMethods() {
		obj.toChars(2);
		obj.equals(new Object());
		obj.digit('c',1);
		obj.forDigit(1,1);
		obj.isDigit('c');
		
		obj.isLetter('c');
		obj.isLetterOrDigit('c');
		obj.isLowSurrogate('c');
		obj.isLowerCase('c');
		obj.isSpace('c');
		obj.isSupplementaryCodePoint(2);
		obj.isSurrogate('c');
		obj.isSurrogatePair('c', 'c');
		obj.isHighSurrogate('c');
		obj.isUpperCase('c');
		obj.isValidCodePoint(2);
		obj.charValue();
		obj.toLowerCase('c');
		obj.toUpperCase('c');
		obj.charCount(2);
		obj.codePointAt(new char[] {'c','c'}, 1);
		obj.codePointAt(new char[] {'a','b','c'}, 0, 1);
		obj.codePointAt("charSequence", 2);
		obj.codePointBefore(new char[] {'c','c'}, 1);
		obj.codePointBefore(new char[] {'c','c'}, 1, 0);
		obj.codePointBefore("charSequence", 2);
		obj.codePointCount(new char[] {'c','c'}, 0, 1);
		obj.codePointCount("charSequence", 2, 2);
		obj.compare('c', 'c');
		obj.compareTo('c');
		obj.offsetByCodePoints(new char[] {'c','c'}, 0, 1, 0, 1);
		obj.offsetByCodePoints("charSequence", 0, 1);
		obj.toChars(2, new char[] {'c','c'}, 1);
		obj.toCodePoint('c', 'c');
		obj.valueOf('c');
	}
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
}