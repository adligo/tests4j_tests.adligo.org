package org.adligo.tests4j_tests.shared.asserts.dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_AssertsDependency_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencyFailureMutant;
import org.adligo.tests4j.shared.asserts.dependency.FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.MethodSignature;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=AllowedDependencyFailureMutant.class, minCoverage=97.0)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
public class AllowedDependencyFailureMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testDefaultsGettersAndSetters() {
		
		AllowedDependencyFailureMutant mutant = new AllowedDependencyFailureMutant();
		//assertDefaults
		assertEquals(AssertType.AssertDependency ,mutant.getAssertType());
		mutant.setAssertType(AssertType.AssertContains);
		assertEquals(AssertType.AssertDependency ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,mutant.getType());
		//no set type
		assertNull(mutant.getCalledClass());
		mutant.setCalledClass("foo");
		assertEquals("foo", mutant.getCalledClass());
		assertNull(mutant.getFailureDetail());
		mutant.setFailureDetail("failureDetail");
		assertEquals("failureDetail", mutant.getFailureDetail());
		
		I_Tests4J_ResultMessages messages = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messages.getCalledMethodOrFieldsOutsideOfAllowedDepenencies(),
				mutant.getFailureMessage());
		mutant.setFailureMessage("failureMessage");
		assertEquals(messages.getCalledMethodOrFieldsOutsideOfAllowedDepenencies(),
				mutant.getFailureMessage());
		assertNull(mutant.getField());
		List<String> gns = mutant.getGroupNames();
		assertNotNull(gns);
		assertEquals(ArrayList.class.getName(),  gns.getClass().getName());
		assertTrue(gns.isEmpty());
		mutant.setGroupNames(Collections.singletonList("Nane"));
		gns = mutant.getGroupNames();
		assertContains(gns,"Nane");
		
		assertNull(mutant.getMethod());
		MethodSignature ms = new MethodSignature("methodNameIn");
		mutant.setMethod(ms);
		assertSame(ms, mutant.getMethod());
		assertNull(mutant.getSourceClass());
		mutant.setSourceClass(AllowedDependencyFailureMutant.class);
		assertEquals(AllowedDependencyFailureMutant.class.getName(),
				mutant.getSourceClass().getName());
		
		assertNull(mutant.getField());
		FieldSignature fs = new FieldSignature("nameIn", "classNameIn");
		mutant.setField(fs);
		assertSame(fs, mutant.getField());
	}
	
	@Test
	public void testCopyConstructor() {
		
		AllowedDependencyFailureMutant mutant = new AllowedDependencyFailureMutant();
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
		
		mutant = new AllowedDependencyFailureMutant(mutant);
		//assertDefaults
		assertEquals(AssertType.AssertDependency ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertDependencyFailure ,mutant.getType());
		//no set type
		assertEquals("foo", mutant.getCalledClass());
		assertEquals("failureDetail", mutant.getFailureDetail());
		
		I_Tests4J_ResultMessages messages = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messages.getCalledMethodOrFieldsOutsideOfAllowedDepenencies(),
				mutant.getFailureMessage());
		List<String> gns = mutant.getGroupNames();
		assertNotNull(gns);
		assertEquals(ArrayList.class.getName(),  gns.getClass().getName());
		assertContains(gns,"Nane");
		
		assertSame(ms, mutant.getMethod());
		mutant.setSourceClass(AllowedDependencyFailureMutant.class);
		assertEquals(AllowedDependencyFailureMutant.class.getName(),
				mutant.getSourceClass().getName());
		assertSame(fs, mutant.getField());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 33;
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
		int thisUniqueAsserts = 24;
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

