package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class LinkedHashSet_2_6_MockUse {

	public LinkedHashSet obj = null;
	public LinkedHashSet_2_6_MockUse() {
		obj = new LinkedHashSet();
		obj = new LinkedHashSet(
			2);
		obj = new LinkedHashSet(
			2, (float) 0.2);
		obj = new LinkedHashSet(
			new HashSet());
		callObjectMethods();
		callAbstractCollectionMethods();
		callAbstractSetMethods();
		callHashSetMethods();
	}


	public void callAbstractSetMethods() {
		obj.equals(new Object());
		obj.removeAll(new ArrayList());
		obj.hashCode();
	}
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
	public void callAbstractCollectionMethods() {
		obj.toArray();
		obj.toArray(new Object[] {});
		obj.add(new Object());
		obj.addAll(new ArrayList());
		obj.contains(new Object());
		obj.containsAll(new ArrayList());
		obj.isEmpty();
		obj.remove(new Object());
		obj.removeAll(new ArrayList());
		obj.retainAll(new ArrayList());
		obj.size();
		obj.toString();
		obj.iterator();
		obj.clear();
	}
	
	public void callHashSetMethods() {
		obj.clone();
	}
}
