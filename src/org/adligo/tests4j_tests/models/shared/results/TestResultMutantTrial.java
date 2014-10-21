package org.adligo.tests4j_tests.models.shared.results;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.results.TestResultMutant;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.TestFailureMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Results_GwtReferenceGroup;

@SourceFileScope (sourceClass=TestResultMutant.class, minCoverage=98.0)
@AllowedReferences (groups=Tests4J_Results_GwtReferenceGroup.class)
public class TestResultMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testGetsAndSets() {
		TestResultMutant trm = new TestResultMutant();
		trm.setAfterOutput("afterOutput");
		assertEquals("afterOutput", trm.getAfterOutput());
		
		trm.setAssertionCount(11);
		assertEquals(11, trm.getAssertionCount());
		
		trm.setBeforeOutput("beforeOutput");
		assertEquals("beforeOutput", trm.getBeforeOutput());
		
		TestFailureMutant tfm = new TestFailureMutant();
		tfm.setAssertType(AssertType.AssertContains);
		tfm.setFailureDetail("failureDetail");
		tfm.setFailureMessage("failureMessage");
		trm.setFailure(tfm);
		assertEquals(tfm, trm.getFailure());
		
		trm.setIgnored(true);
		assertTrue(trm.isIgnored());
		trm.setIgnored(false);
		assertFalse(trm.isIgnored());
		
		trm.setName("name");
		assertEquals("name", trm.getName());
		
		trm.setOutput("output");
		assertEquals("output", trm.getOutput());
		
		trm.setPassed(false);
		assertFalse(trm.isPassed());
		trm.setPassed(true);
		assertTrue(trm.isPassed());
		
		trm.incrementAssertionCount(1);
		trm.incrementAssertionCount(2);
		trm.incrementAssertionCount(3);
		trm.incrementAssertionCount(4);
		trm.incrementAssertionCount(5);
		
		Set<Integer> ex = new HashSet<Integer>();
		ex.add(1);
		ex.add(2);
		ex.add(3);
		ex.add(4);
		ex.add(5);
		
		assertEquals(ex,
				trm.getUniqueAsserts());
		assertEquals(5, trm.getUniqueAsserts().size());
	}

	
	@Test
	public void testCopyConstructorAndToString() {
		TestResultMutant trm = new TestResultMutant();
		trm.setAfterOutput("afterOutput");
		
		trm.setAssertionCount(11);
		
		TestFailureMutant tfm = new TestFailureMutant();
		tfm.setAssertType(AssertType.AssertContains);
		tfm.setFailureDetail("failureDetail");
		tfm.setFailureMessage("failureMessage");
		trm.setFailure(tfm);
		
		trm.setIgnored(true);
		
		trm.setBeforeOutput("beforeOutput");
		
		
		trm.setName("name");
		trm.setOutput("output");
		trm.setPassed(false);
		assertFalse(trm.isPassed());
		
		TestResultMutant trm2 = new TestResultMutant(trm);
		assertEquals("TestResultMutant [name=name, passed=false, ignored=true]", trm2.toString());
		assertEquals(tfm, trm2.getFailure());
		assertTrue(trm2.isIgnored());
		assertEquals("name", trm2.getName());
		assertEquals("output", trm2.getOutput());
		assertEquals("afterOutput", trm2.getAfterOutput());
		assertEquals(11, trm2.getAssertionCount());
		assertEquals("beforeOutput", trm2.getBeforeOutput());
		assertFalse(trm2.isPassed());
		
		trm.setIgnored(false);
		assertFalse(trm.isIgnored());
		trm.setPassed(true);
		assertTrue(trm.isPassed());
		
		trm2 = new TestResultMutant(trm);
		assertEquals(tfm, trm2.getFailure());
		assertFalse(trm2.isIgnored());
		assertEquals("name", trm2.getName());
		assertEquals("output", trm2.getOutput());
		assertEquals("afterOutput", trm2.getAfterOutput());
		assertEquals(11, trm2.getAssertionCount());
		assertEquals("beforeOutput", trm2.getBeforeOutput());
		assertTrue(trm2.isPassed());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 32;
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
		int thisUniqueAsserts = 19;
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
