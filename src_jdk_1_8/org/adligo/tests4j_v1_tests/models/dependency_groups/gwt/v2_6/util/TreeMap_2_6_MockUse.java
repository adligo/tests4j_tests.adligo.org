package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class TreeMap_2_6_MockUse {

	
	public TreeMap obj = null;
	public TreeMap_2_6_MockUse() {
		obj = new TreeMap();
		obj = new TreeMap(
			new TreeMap());
		obj = new TreeMap(
			new HashMap());
		obj = new TreeMap(
			new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return 0;
				}
			});
		callTreeMapMethods();
		callObjectMethods();
		callAbstractMapMethods();
	}

	public void callTreeMapMethods() {
		obj.containsKey(new Object());
		obj.containsValue(new Object());
		obj.size();
		obj.clone();
		obj.put(new Object(), new Object());
		obj.firstKey();
		obj.get(new Object());
		obj.lastKey();
		obj.put(new Object(), new Object());
		obj.remove(new Object());
		obj.comparator();
		obj.headMap(new Object());
		obj.subMap(new Object(), new Object());
		obj.tailMap(new Object());
		obj.putAll(new HashMap());
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
