package org.adligo.tests4j_tests.shared.asserts.dependency;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_AssertsDependency_DependencyGroup;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Dependency_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.NameOnlyDependencyGroup;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=NameOnlyDependencyGroup.class)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
public class NameOnlyDependencyGroupTrial extends SourceFileCountingTrial 
	 {

	@Test
	public void testConstructorAndMethods() {
		Set<String> names = new HashSet<String>();
		names.add("foo");
		NameOnlyDependencyGroup nodg = new NameOnlyDependencyGroup(names);
		Set<String> cns = nodg.getClassNames();
		assertNotNull(cns);
		assertContains(cns,"foo");
		assertEquals(1, cns.size());
		
		assertTrue(nodg.isInGroup("foo"));
		assertFalse(nodg.isInGroup("bar"));
		assertTrue(nodg.isInGroup("foo",new MethodSignature("hmm")));
		assertTrue(nodg.isInGroup("foo",new FieldSignature("hmm","hmm")));
		assertFalse(nodg.isInGroup("bar",new MethodSignature("hmm")));
		assertFalse(nodg.isInGroup("bar",new FieldSignature("hmm","hmm")));
		
		Collection<I_ClassAttributes> cas = nodg.getClassAttributes();
		assertEquals(0,cas.size());
		
		Set<I_FieldSignature> fs =  nodg.getFields("foo");
		assertEquals(0, fs.size());
		assertNull(nodg.getFields("bar"));
		
		Set<I_MethodSignature> ms =  nodg.getMethods("foo");
		assertEquals(0, ms.size());
		assertNull(nodg.getMethods("bar"));
		
		Set<String> sgns = nodg.getSubGroupNames();
		assertEquals(0, sgns.size());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 15;
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
		int thisUniqueAsserts = 7;
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
