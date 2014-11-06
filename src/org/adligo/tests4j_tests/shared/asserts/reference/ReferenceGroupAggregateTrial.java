package org.adligo.tests4j_tests.shared.asserts.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.gwt_refs.GWT_ReferenceGroup;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.NameOnlyReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupAggregate;
import org.adligo.tests4j.shared.common.ClassMethods;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;

@SourceFileScope (sourceClass=ReferenceGroupAggregate.class, minCoverage=94.0)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class ReferenceGroupAggregateTrial extends SourceFileCountingTrial {

	@Test
	public void testDefaultConstructorMutators() {
		
		List<String> classNames = new ArrayList<String>();
		classNames.add("foo");
		NameOnlyReferenceGroup nodg = new NameOnlyReferenceGroup(classNames);
		
		List<I_ReferenceGroup> groups = new ArrayList<I_ReferenceGroup>();
		groups.add(nodg);
		groups.add(GWT_ReferenceGroup.INSTANCE);
		ReferenceGroupAggregate dgm = new ReferenceGroupAggregate(groups);
		
		Set<String> names = dgm.getClassNames();
		assertEquals(125, names.size());
		
		
		List<I_ClassAttributes> cas = dgm.getClassAttributes();
		//doesn't include the name only classes
		assertEquals(124, cas.size());
		
		Set<I_FieldSignature> fields = dgm.getFields(JSE_Lang.SYSTEM);
		assertEquals(2, fields.size());
		
		Set<I_MethodSignature> methods = dgm.getMethods(JSE_Lang.SYSTEM);
		assertEquals(7, methods.size());
		
		assertTrue(dgm.isInGroup("foo"));
		assertTrue(dgm.isInGroup(JSE_Lang.SYSTEM));
		
		assertTrue(dgm.isInGroup(JSE_Lang.SYSTEM,
				new FieldSignature("out", JSE_IO.INPUT_STREAM)));
		assertFalse(dgm.isInGroup(JSE_Lang.SYSTEM,
				new FieldSignature("in", JSE_IO.INPUT_STREAM)));
		
		assertTrue(dgm.isInGroup(JSE_Lang.SYSTEM,
				new MethodSignature("gc")));
		assertFalse(dgm.isInGroup(JSE_Lang.SYSTEM,
				new MethodSignature("exit", 
				new String[] {ClassMethods.INT})));
		
		Set<String> gns = dgm.getSubGroupNames();
		assertContains(gns, "GWT_ReferenceGroup");
		assertContains(gns, "NameOnlyReferenceGroup");
		assertEquals(2, gns.size());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 13;
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
		int thisUniqueAsserts = 8;
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
}
