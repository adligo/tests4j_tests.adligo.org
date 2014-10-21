package org.adligo.tests4j_tests.shared.asserts.reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencyFailure;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencyFailureMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_ReferenceGroup;

@SourceFileScope (sourceClass=CircularDependencyFailure.class, minCoverage=64.0)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class CircularDependencyFailureTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyConstructor() {
		CircularDependencyFailure failure = new CircularDependencyFailure();
		assertEquals(AssertType.AssertCircularDependency ,failure.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,failure.getType());
		
		CircularDependencyFailureMutant mutant = new CircularDependencyFailureMutant();
		//assertDefaults
		assertEquals(AssertType.AssertCircularDependency ,mutant.getAssertType());
		mutant.setAssertType(AssertType.AssertContains);
		assertEquals(AssertType.AssertCircularDependency,mutant.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,mutant.getType());
		//no set type
		
		mutant.setAllowedType(CircularDependencies.None);
		assertEquals(CircularDependencies.None, mutant.getAllowedType());
		
		List<String> cob =  mutant.getClassesOutOfBounds();
		assertNotNull(cob);
		assertEquals(0, cob.size());
		mutant.setClassesOutOfBounds(Collections.singletonList("hey"));
		cob =  mutant.getClassesOutOfBounds();
		assertNotNull(cob);
		assertContains(cob, "hey");
		assertEquals(1, cob.size());
		
		failure = new CircularDependencyFailure(mutant);
		assertEquals(AssertType.AssertCircularDependency ,failure.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,failure.getType());
		//no set type
		
		assertEquals(CircularDependencies.None, failure.getAllowedType());
		cob = failure.getClassesOutOfBounds();
		assertNotNull(cob);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", cob.getClass().getName());
		assertContains(cob, "hey");
		assertEquals(1, cob.size());
		
		mutant = new CircularDependencyFailureMutant(failure, new ArrayList<String>());
		assertEquals(AssertType.AssertCircularDependency ,failure.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,failure.getType());
		//no set type
		
		assertEquals(CircularDependencies.None, failure.getAllowedType());
		cob =  failure.getClassesOutOfBounds();
		assertNotNull(cob);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", cob.getClass().getName());
		assertContains(cob, "hey");
		assertEquals(1, cob.size());
		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 25;
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
		int thisUniqueAsserts = 9;
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

