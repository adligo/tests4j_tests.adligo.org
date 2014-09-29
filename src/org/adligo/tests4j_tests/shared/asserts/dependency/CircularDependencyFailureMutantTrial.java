package org.adligo.tests4j_tests.shared.asserts.dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.CircularDependencies;
import org.adligo.tests4j.shared.asserts.dependency.CircularDependencyFailureMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_AssertsDependency_DependencyGroup;

@SourceFileScope (sourceClass=CircularDependencyFailureMutant.class, minCoverage=90.0)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
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
		int thisAfterAsserts = 3;
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

