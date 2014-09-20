package org.adligo.tests4j_tests.models.shared.dependency.asserts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.models.shared.dependency.asserts.CircularDependencyFailure;
import org.adligo.tests4j.models.shared.dependency.asserts.CircularDependencyFailureMutant;
import org.adligo.tests4j.models.shared.trials.CircularDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=CircularDependencyFailureMutant.class, minCoverage=65.0)
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
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 25;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
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
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

