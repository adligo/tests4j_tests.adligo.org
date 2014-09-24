package org.adligo.tests4j_tests.models.shared.dependency.asserts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency.asserts.AllowedDependencyFailureMutant;
import org.adligo.tests4j.models.shared.dependency.asserts.CircularDependencyFailureMutant;
import org.adligo.tests4j.models.shared.dependency.asserts.I_AllowedDependencyFailure;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.trials.CircularDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=CircularDependencyFailureMutant.class, minCoverage=90.0)
public class CircularDependencyFailureMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testDefaultsGettersAndSetters() {
		
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
	}
	
	@Test
	public void testCopyConstructor() {
		
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
		
		mutant = new CircularDependencyFailureMutant(mutant);
		assertEquals(AssertType.AssertCircularDependency ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,mutant.getType());
		//no set type
		
		assertEquals(CircularDependencies.None, mutant.getAllowedType());
		assertNotNull(cob);
		assertContains(cob, "hey");
		assertEquals(1, cob.size());
		
		mutant = new CircularDependencyFailureMutant(mutant, new ArrayList<String>());
		assertEquals(AssertType.AssertCircularDependency ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,mutant.getType());
		//no set type
		
		assertEquals(CircularDependencies.None, mutant.getAllowedType());
		cob =  mutant.getClassesOutOfBounds();
		assertNotNull(cob);
		assertEquals(0, cob.size());
		
		mutant = new CircularDependencyFailureMutant(mutant, null);
		assertEquals(AssertType.AssertCircularDependency ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,mutant.getType());
		//no set type
		
		assertEquals(CircularDependencies.None, mutant.getAllowedType());
		cob =  mutant.getClassesOutOfBounds();
		assertNotNull(cob);
		assertEquals(0, cob.size());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 34;
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
		int thisUniqueAsserts = 16;
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

