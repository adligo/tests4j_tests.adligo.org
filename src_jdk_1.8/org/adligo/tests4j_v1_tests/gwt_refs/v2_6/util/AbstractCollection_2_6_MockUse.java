package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.util;

import java.util.AbstractCollection;
import java.util.ArrayList;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class AbstractCollection_2_6_MockUse {

	public AbstractCollection obj = null;
	public AbstractCollection_2_6_MockUse(AbstractCollection p) {
		obj = p;
		callAbstractCollectionMethods();
		callObjectMethods();
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
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
}