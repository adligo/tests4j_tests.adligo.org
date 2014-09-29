package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.util;

import java.util.ArrayList;
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

@SourceFileScope (sourceClass=AbstractCollection_2_6_MockUse.class)
public class AbstractCollection_2_6_UseTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() throws Exception {
		new AbstractCollection_2_6_MockUse(new ArrayList());
		assertTrue("The trial should be able to create aAbstractCollection_MockUse.",true);
	}


@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(AbstractCollection_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAttributes result = p.getAttributes("java.util.AbstractCollection");
		assertNotNull(result);
		Set<I_FieldSignature> fields = new TreeSet<I_FieldSignature>();
		fields.addAll(result.getFields());
		Set<I_MethodSignature> methods = new TreeSet<I_MethodSignature>();
		methods.addAll(result.getMethods());

		java.util.List<String> parents = new ArrayList<String>();
		parents.add("java.lang.Object");
		for (String pt: parents) {
			I_ClassAttributes parentResult = p.getAttributes(pt);
			if (parentResult != null) {
				fields.addAll(parentResult.getFields());
				//keep parent initilization out
				for (I_MethodSignature ms: parentResult.getMethods()) {
					if ( !"<init>".equals(ms.getMethodName())) {
						methods.add(ms);
					}
				}
			}
		}
		I_ClassAttributes example = GWT_2_6_Util.getAbstractCollection();
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
		int thisAfterAsserts = 24;
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
		int uAfterAsserts = 24;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, uAsserts + uAfterAsserts);
		} else {
			return super.getAsserts(type, uAsserts);
		}
	}
}