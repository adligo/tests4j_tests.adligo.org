package org.adligo.tests4j_v1_tests.models.shared.reference_groups.gwt.v2_6.util;

import java.util.Stack;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
@SuppressWarnings({"unchecked","rawtypes"})
public class Stack_2_6_MockUse {

	public Stack obj = null;
	public Stack_2_6_MockUse() {
		obj = new Stack();
		callStackMethods();
		callObjectMethods();
		callAbstractCollectionMethods();
		callAbstractListMethods();
		callVectorMethods();
	}

	
	public void callStackMethods() {
		obj.empty();
		obj.search(new Object());
		obj.push(new Object());
		obj.peek();
		obj.push(new Object());
		obj.pop();
		obj.push(new Object());
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
		obj.addAll(new Stack());
		obj.contains(new Object());
		obj.containsAll(new Stack());
		obj.isEmpty();
		obj.remove(new Object());
		obj.removeAll(new Stack());
		obj.retainAll(new Stack());
		obj.size();
		obj.toString();
		obj.iterator();
		obj.clear();
	}
	public void callAbstractListMethods() {
		obj.add(new Object());
		obj.add(new Object());
		obj.add(new Object());
		obj.addAll(2, new Stack());
		obj.equals(new Object());
		obj.hashCode();
		obj.indexOf(new Object());
		obj.lastIndexOf(new Object());
		obj.get(2);
		obj.remove(2);
		obj.add(new Object());
		obj.add(new Object());
		obj.add(new Object());
		obj.set(2, new Object());
		obj.iterator();
		obj.subList(2, 2);
		obj.listIterator();
		obj.listIterator(2);
		obj.add(2, new Object());
		obj.clear();
	}
	public void callVectorMethods() {
		
		obj.removeElement(new Object());
		
		obj.capacity();
		obj.indexOf(new Object());
		obj.add(new Object());
		obj.add(new Object());
		obj.add(new Object());
		obj.indexOf(new Object(), 2);
		obj.lastIndexOf(new Object());
		obj.add(new Object());
		obj.add(new Object());
		obj.add(new Object());
		obj.lastIndexOf(new Object(), 2);
		
		obj.clone();
		obj.elementAt(2);
		obj.firstElement();
		obj.get(2);
		obj.lastElement();
		obj.remove(2);
		obj.set(2, new Object());
		obj.toString();
		obj.elements();
		obj.iterator();
		obj.subList(2, 2);
		obj.listIterator();
		obj.listIterator(2);
		obj.add(2, new Object());
		obj.addElement(new Object());
		obj.copyInto(new Object[10]);
		obj.ensureCapacity(2);
		obj.insertElementAt(new Object(), 2);
		
		obj.setElementAt(new Object(), 2);
		obj.removeElementAt(2);
		obj.removeAllElements();
		
		obj.setSize(2);
		obj.trimToSize();
	}
}