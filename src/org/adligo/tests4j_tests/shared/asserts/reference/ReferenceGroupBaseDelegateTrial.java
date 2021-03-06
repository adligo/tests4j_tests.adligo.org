package org.adligo.tests4j_tests.shared.asserts.reference;

import java.util.List;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupBaseDelegate;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;

@SourceFileScope (sourceClass=ReferenceGroupBaseDelegate.class, minCoverage=91.0)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class ReferenceGroupBaseDelegateTrial extends SourceFileCountingTrial 
	implements I_ReferenceGroup {
	ReferenceGroupBaseDelegateExtension ex;
	private boolean getClassNamesCalled_ = false;
	private boolean getClassMethodsCalled_ = false;
	private boolean getFieldsCalled_ = false;
	private boolean getMethodsCalled_ = false;
	private boolean isInGroupFieldCalled_ = false;
	private boolean isInGroupMethodCalled_ = false;
	private boolean isInGroupCalled_ = false;
	private boolean getSubGroupNames_ = false;
	public ReferenceGroupBaseDelegateTrial() {
		 ex = new ReferenceGroupBaseDelegateExtension();
		 ex.setParentDelegate(this);
	}

	@Test
	public void testCallThroughs() {
		assertFalse(getClassNamesCalled_);
		assertFalse(getClassMethodsCalled_);
		assertFalse(getClassNamesCalled_);
		assertFalse(getMethodsCalled_);
		assertFalse(isInGroupFieldCalled_);
		assertFalse(isInGroupMethodCalled_);
		assertFalse(getSubGroupNames_);
		
		ex.getClassNames();
		assertTrue(getClassNamesCalled_);
		ex.getClassAttributes();
		assertTrue(getClassMethodsCalled_);
		ex.getFields("className");
		assertTrue(getFieldsCalled_);
		ex.getMethods("ms");
		assertTrue(getMethodsCalled_);
		assertTrue(getClassNamesCalled_);
		ex.isInGroup("hey");
		assertTrue(isInGroupCalled_);
		ex.isInGroup("hey", (I_FieldSignature) null);
		assertTrue(isInGroupFieldCalled_);
		ex.isInGroup("hey", (I_MethodSignature) null);
		assertTrue(isInGroupMethodCalled_);
		ex.getSubGroupNames();
		assertTrue(getSubGroupNames_);
	}
	

	@Override
	public Set<String> getClassNames() {
		getClassNamesCalled_ = true;
		return null;
	}

	@Override
	public List<I_ClassAttributes> getClassAttributes() {
		getClassMethodsCalled_ = true;
		return null;
	}

	@Override
	public Set<I_MethodSignature> getMethods(String className) {
		getMethodsCalled_ = true;
		return null;
	}

	@Override
	public Set<I_FieldSignature> getFields(String className) {
		getFieldsCalled_ = true;
		return null;
	}

	@Override
	public boolean isInGroup(String className, I_MethodSignature method) {
		isInGroupMethodCalled_ = true;
		return false;
	}

	@Override
	public boolean isInGroup(String className, I_FieldSignature method) {
		isInGroupFieldCalled_ = true;
		return false;
	}
	@Override
	public boolean isInGroup(String className) {
		isInGroupCalled_ = true;
		return false;
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 16;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 2;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

	@Override
	public Set<String> getSubGroupNames() {
		getSubGroupNames_ = true;
		return null;
	}

	
}
