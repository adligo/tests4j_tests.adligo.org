package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.gwt_refs.v2_6.GWT_2_6_Util;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Queue_2_6_MockUse.class)
public class Queue_2_6_UseTrial extends SourceFileCountingTrial 
  implements Queue<Object> {

	private int methodsCalled = 0;

	public boolean add(java.lang.Object p0) {
		methodsCalled++;
		return false;
	}
	public boolean offer(java.lang.Object p0) {
		methodsCalled++;
		return false;
	}
	public java.lang.Object element() {
		methodsCalled++;
		return null;
	}
	public java.lang.Object peek() {
		methodsCalled++;
		return null;
	}
	public java.lang.Object poll() {
		methodsCalled++;
		return null;
	}
	public java.lang.Object remove() {
		methodsCalled++;
		return null;
	}

	@Test
	public void testMethods() throws Exception {
		new Queue_2_6_MockUse(this);
		assertEquals(6, methodsCalled);
	}

@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(Queue_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAttributes result = p.getReferences("java.util.Queue");
		assertNotNull(result);
		Set<I_FieldSignature> fields = new TreeSet<I_FieldSignature>();
		fields.addAll(result.getFields());
		Set<I_MethodSignature> methods = new TreeSet<I_MethodSignature>();
		methods.addAll(result.getMethods());

		I_ClassAttributes example = GWT_2_6_Util.getQueue();
		assertEquals(example.getName(), result.getName());
		Set<I_FieldSignature> exampleFields = example.getFields();
		for (I_FieldSignature sig: exampleFields) {
			assertContains(fields, sig);
		}
		assertEquals(exampleFields.size(), fields.size());
		Set<I_MethodSignature> exampleMethods = example.getMethods();
		for (I_MethodSignature method: exampleMethods) {
			assertContains(methods, method);
		}
		assertEquals(exampleMethods.size(), methods.size());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override 
	public int getAsserts(I_CountType type) { 
		int thisAsserts = 1;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 13;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uAsserts = 1;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int uAfterAsserts = 13;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, uAsserts + uAfterAsserts);
		} else {
			return super.getAsserts(type, uAsserts);
		}
	}
	@Override
	public int size() {
		methodsCalled++;
		return 0;
	}
	@Override
	public boolean isEmpty() {
		methodsCalled++;
		return false;
	}
	@Override
	public boolean contains(Object o) {
		methodsCalled++;
		return false;
	}
	@Override
	public Iterator<Object> iterator() {
		methodsCalled++;
		return null;
	}
	@Override
	public Object[] toArray() {
		methodsCalled++;
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		methodsCalled++;
		return null;
	}
	@Override
	public boolean remove(Object o) {
		methodsCalled++;
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		methodsCalled++;
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends Object> c) {
		methodsCalled++;
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		methodsCalled++;
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		methodsCalled++;
		return false;
	}
	@Override
	public void clear() {
		methodsCalled++;
		
	}
}
