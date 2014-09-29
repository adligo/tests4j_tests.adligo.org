package org.adligo.tests4j_tests.shared.asserts.dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_DependencyGroup;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_IO;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.DependencyGroupAggregate;
import org.adligo.tests4j.shared.asserts.dependency.FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_DependencyGroup;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.NameOnlyDependencyGroup;
import org.adligo.tests4j.shared.common.ClassMethods;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_AssertsDependency_DependencyGroup;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_Dependency_DependencyGroup;

@SourceFileScope (sourceClass=DependencyGroupAggregate.class, minCoverage=96.0)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
public class DependencyGroupAggregateTrial extends SourceFileCountingTrial {

	@Test
	public void testDefaultConstructorMutators() {
		
		List<String> classNames = new ArrayList<String>();
		classNames.add("foo");
		NameOnlyDependencyGroup nodg = new NameOnlyDependencyGroup(classNames);
		
		List<I_DependencyGroup> groups = new ArrayList<I_DependencyGroup>();
		groups.add(nodg);
		groups.add(new GWT_DependencyGroup());
		DependencyGroupAggregate dgm = new DependencyGroupAggregate(groups);
		
		Set<String> names = dgm.getClassNames();
		assertEquals(122, names.size());
		
		
		List<I_ClassAttributes> cas = dgm.getClassAttributes();
		//doesn't include the name only classes
		assertEquals(121, cas.size());
		
		Set<I_FieldSignature> fields = dgm.getFields(JSE_Lang.SYSTEM);
		assertEquals(2, fields.size());
		
		Set<I_MethodSignature> methods = dgm.getMethods(JSE_Lang.SYSTEM);
		assertEquals(7, methods.size());
		
		assertTrue(dgm.isInGroup("foo"));
		assertFalse(dgm.isInGroup(JSE_Lang.SYSTEM));
		
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
		assertContains(gns, "GWT_DependencyGroup");
		assertContains(gns, "NameOnlyDependencyGroup");
		assertEquals(2, gns.size());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
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
