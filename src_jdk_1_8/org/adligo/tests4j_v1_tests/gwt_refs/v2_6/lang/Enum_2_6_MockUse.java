package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang;

public enum Enum_2_6_MockUse {
	HEY("HEY",0);
	
	private int id;
	
	private Enum_2_6_MockUse(String name, int p) {
		id = p;
	}

	public int getId() {
		return id;
	}
	
	@SuppressWarnings({ "static-access"})
	public static void callEnumMethods(Enum<Enum_2_6_MockUse> obj) {
		obj.compareTo(Enum_2_6_MockUse.HEY);
		obj.ordinal();
		obj.getDeclaringClass();
		obj.valueOf(Enum_2_6_MockUse.class, "HEY");
		obj.name();
	}
	public static void callObjectMethods(Object obj) {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
}
