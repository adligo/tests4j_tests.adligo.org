package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.util;

import java.util.Set;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Util;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Set_2_6_MockUse.class)
public class Set_2_6_UseTrial extends SourceFileCountingTrial 
  implements Set<Object> {

	private int methodsCalled = 0;

	public Object[] toArray() {
		methodsCalled++;
		return null;
	}
	@SuppressWarnings("unchecked")
	public Object[] toArray(Object [] p0) {
		methodsCalled++;
		return null;
	}
	public boolean add(java.lang.Object p0) {
		methodsCalled++;
		return true;
	}
	@SuppressWarnings("rawtypes")
	public boolean addAll(java.util.Collection p0) {
		methodsCalled++;
		return true;
	}
	public boolean contains(java.lang.Object p0) {
		methodsCalled++;
		return false;
	}
	@SuppressWarnings("rawtypes")
	public boolean containsAll(java.util.Collection p0) {
		methodsCalled++;
		return false;
	}
	public boolean equals(java.lang.Object p0) {
		methodsCalled++;
		return false;
	}
	public boolean isEmpty() {
		methodsCalled++;
		return false;
	}
	public boolean remove(java.lang.Object p0) {
		methodsCalled++;
		return false;
	}
	@SuppressWarnings("rawtypes")
	public boolean removeAll(java.util.Collection p0) {
		methodsCalled++;
		return false;
	}
	@SuppressWarnings("rawtypes")
	public boolean retainAll(java.util.Collection p0) {
		methodsCalled++;
		return false;
	}
	public int hashCode() {
		methodsCalled++;
		return 0;
	}
	public int size() {
		methodsCalled++;
		return 0;
	}
	
	public java.util.Iterator<Object> iterator() {
		methodsCalled++;
		return null;
	}
	public void clear() {
		methodsCalled++;
	}

	@Test
	public void testMethods() throws Exception {
		new Set_2_6_MockUse(this);
		assertEquals(15, methodsCalled);
	}

@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(Set_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAttributes result = p.getAttributes("java.util.Set");
		assertNotNull(result);
		Set<I_FieldSignature> fields = new TreeSet<I_FieldSignature>();
		fields.addAll(result.getFields());
		Set<I_MethodSignature> methods = new TreeSet<I_MethodSignature>();
		methods.addAll(result.getMethods());

		I_ClassAttributes example = GWT_2_6_Util.getSet();
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
		int thisAfterAsserts = 22;
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
		int uAfterAsserts = 22;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, uAsserts + uAfterAsserts);
		} else {
			return super.getAsserts(type, uAsserts);
		}
	}
}