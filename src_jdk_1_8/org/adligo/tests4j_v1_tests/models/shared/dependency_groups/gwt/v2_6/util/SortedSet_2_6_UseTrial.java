package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Util;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=SortedSet_2_6_MockUse.class)
public class SortedSet_2_6_UseTrial extends SourceFileCountingTrial 
  implements SortedSet<Object> {

	private int methodsCalled = 0;

	public java.lang.Object first() {
		methodsCalled++;
		return null;
	}
	
	public java.lang.Object last() {
		methodsCalled++;
		return null;
	}
	public java.util.Comparator<Object> comparator() {
		methodsCalled++;
		return null;
	}
	public java.util.SortedSet<Object> headSet(java.lang.Object p0) {
		methodsCalled++;
		return null;
	}
	public java.util.SortedSet<Object> subSet(java.lang.Object p0, java.lang.Object p1) {
		methodsCalled++;
		return null;
	}
	public java.util.SortedSet<Object> tailSet(java.lang.Object p0) {
		methodsCalled++;
		return null;
	}

	@Test
	public void testMethods() throws Exception {
		new SortedSet_2_6_MockUse(this);
		assertEquals(6, methodsCalled);
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(SortedSet_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAttributes result = p.getAttributes("java.util.SortedSet");
		assertNotNull(result);
		Set<I_FieldSignature> fields = new TreeSet<I_FieldSignature>();
		fields.addAll(result.getFields());
		Set<I_MethodSignature> methods = new TreeSet<I_MethodSignature>();
		methods.addAll(result.getMethods());

		I_ClassAttributes example = GWT_2_6_Util.getSortedSet();
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
	public Iterator iterator() {
		methodsCalled++;
		return null;
	}

	@Override
	public Object[] toArray() {
		methodsCalled++;
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		methodsCalled++;
		return null;
	}

	@Override
	public boolean add(Object e) {
		methodsCalled++;
		return false;
	}

	@Override
	public boolean remove(Object o) {
		methodsCalled++;
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		methodsCalled++;
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		methodsCalled++;
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		methodsCalled++;
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		methodsCalled++;
		return false;
	}

	@Override
	public void clear() {
		methodsCalled++;
		
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
}