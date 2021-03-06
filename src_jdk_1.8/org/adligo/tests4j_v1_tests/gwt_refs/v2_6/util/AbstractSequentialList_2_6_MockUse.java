package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.util;

import java.util.AbstractSequentialList;
import java.util.ArrayList;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class AbstractSequentialList_2_6_MockUse {

	public AbstractSequentialList obj = null;
	public AbstractSequentialList_2_6_MockUse(AbstractSequentialList l) {
		obj = l;
	
		callObjectMethods();
		callAbstractCollectionMethods();
		callAbstractListMethods();
		callAbstractSequentialListMethods();
	}

	public void callAbstractSequentialListMethods() {
		obj.addAll(0, new ArrayList());
		obj.add(new Object());
		obj.get(0);

		obj.add(new Object());
		obj.remove(0);
		obj.set(0, new Object());
		obj.iterator();
		obj.listIterator(1);
		obj.add(0, new Object());
	}
	public void callAbstractListMethods() {
		obj.add(new Object());
		obj.addAll(0, new ArrayList());
		obj.equals(new Object());
		obj.hashCode();
		obj.indexOf(new Object());
		obj.lastIndexOf(new Object());
		obj.get(0);
		obj.remove(0);
		obj.add(new Object());
		obj.set(0, new Object());
		obj.iterator();
		obj.subList(0, 1);
		obj.listIterator();
		obj.listIterator(1);
		obj.add(1, new Object());
		obj.clear();
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
		obj.iterator();
		obj.clear();
	}
}