package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang;

import java.lang.Short;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class Short_2_6_MockUse {

	public Short obj = null;
	public short obj0 = Short.MAX_VALUE;
	public short obj1 = Short.MIN_VALUE;
	public int obj2 = Short.SIZE;
	public java.lang.Class obj3 = Short.TYPE;
	public Short_2_6_MockUse() {
		obj = new Short(
			"1");
		obj = new Short(
			(short) 1);
		callShortMethods();
		callObjectMethods();
		callNumberMethods();
	}

	public void callShortMethods() {
		obj.byteValue();
		obj.doubleValue();
		obj.floatValue();
		obj.compare((short) 1, (short) 1);
		obj.compareTo(new Short((short) 12));
		obj.intValue();
		obj.decode("12");
		obj.valueOf("12");
		obj.valueOf("1", 2);
		obj.valueOf((short) 1);
		obj.toString((short) 1);
		obj.longValue();
		obj.parseShort("12");
		obj.parseShort("1", 2);
		obj.reverseBytes((short) 1);
		obj.shortValue();
	}
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
	public void callNumberMethods() {
		obj.byteValue();
		obj.doubleValue();
		obj.floatValue();
		obj.intValue();
		obj.longValue();
		obj.shortValue();
	}
}