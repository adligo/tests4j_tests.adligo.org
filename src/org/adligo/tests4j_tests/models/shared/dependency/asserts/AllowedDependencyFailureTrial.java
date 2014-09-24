package org.adligo.tests4j_tests.models.shared.dependency.asserts;

import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency.asserts.AllowedDependencyFailure;
import org.adligo.tests4j.models.shared.dependency.asserts.AllowedDependencyFailureMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=AllowedDependencyFailure.class, minCoverage=83.0)
public class AllowedDependencyFailureTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyConstructor() {
		AllowedDependencyFailure failure = new AllowedDependencyFailure();
	
		assertEquals(AssertType.AssertDependency ,failure.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,failure.getType());
		//no set type
		assertNull(failure.getCalledClass());
		assertNull(failure.getFailureDetail());
		I_Tests4J_ResultMessages messages = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messages.getCalledMethodOrFieldsOutsideOfAllowedDepenencies(),
				failure.getFailureMessage());
		List<String> gns = failure.getGroupNames();
		assertNotNull(gns);
		assertEquals("java.util.Collections$EmptyList",  gns.getClass().getName());
		assertTrue(gns.isEmpty());
		assertNull(failure.getMethod());
		assertNull(failure.getSourceClass());
		assertNull(failure.getField());
		
		//...
		AllowedDependencyFailureMutant mutant = new AllowedDependencyFailureMutant();
		failure = new AllowedDependencyFailure(mutant);
		gns = failure.getGroupNames();
		assertNotNull(gns);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList",  gns.getClass().getName());
		
		//assertDefaults
		assertEquals(AssertType.AssertDependency ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,mutant.getType());
		mutant.setCalledClass("foo");
		mutant.setFailureDetail("failureDetail");
		mutant.setFailureMessage("failureMessage");
		mutant.setGroupNames(Collections.singletonList("Nane"));
		MethodSignature ms = new MethodSignature("methodNameIn");
		mutant.setMethod(ms);
		mutant.setSourceClass(AllowedDependencyFailureMutant.class);
		FieldSignature fs = new FieldSignature("nameIn", "classNameIn");
		mutant.setField(fs);
		
		failure = new AllowedDependencyFailure(mutant);
		//assertDefaults
		assertEquals(AssertType.AssertDependency ,failure.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,failure.getType());
		//no set type
		assertEquals("foo", failure.getCalledClass());
		assertEquals("failureDetail", failure.getFailureDetail());
		
		assertEquals(messages.getCalledMethodOrFieldsOutsideOfAllowedDepenencies(),
				mutant.getFailureMessage());
		gns = failure.getGroupNames();
		assertNotNull(gns);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList",  gns.getClass().getName());
		assertContains(gns,"Nane");
		
		assertSame(ms, failure.getMethod());
		mutant.setSourceClass(AllowedDependencyFailureMutant.class);
		assertEquals(AllowedDependencyFailureMutant.class.getName(),
				mutant.getSourceClass().getName());
		assertSame(fs, failure.getField());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 26;
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
		int thisUniqueAsserts = 15;
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

