package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.util;

import java.util.HashMap;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HashMap_2_6_MockUse {

	
	public HashMap obj = null;
	public HashMap_2_6_MockUse() {
		obj = new HashMap();
		obj = new HashMap(
			2);
		obj = new HashMap(
			2, (float) 0.2);
		obj = new HashMap(
			new HashMap());
		callHashMapMethods();
		callObjectMethods();
		callAbstractMapMethods();
	}

	public void callHashMapMethods() {
		obj.clone();
	}
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
	public void callAbstractMapMethods() {
		obj.containsKey(new Object());
		obj.containsValue(new Object());
		obj.equals(new Object());
		obj.isEmpty();
		obj.hashCode();
		obj.size();
		obj.get(new Object());
		obj.put(new Object(), new Object());
		obj.remove(new Object());
		obj.toString();
		obj.values();
		obj.entrySet();
		obj.keySet();
		obj.clear();
		obj.putAll(new HashMap());
	}
}
