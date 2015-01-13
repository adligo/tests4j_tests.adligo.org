package org.adligo.tests4j_tests.shared.asserts.reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferencesFailureMutant;
import org.adligo.tests4j.shared.asserts.reference.FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;

@SourceFileScope (sourceClass=AllowedReferencesFailureMutant.class, minCoverage=91.0)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class AllowedReferencesFailureMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testDefaultsGettersAndSetters() {
		
		AllowedReferencesFailureMutant mutant = new AllowedReferencesFailureMutant(Tests4J_EnglishConstants.ENGLISH);
		//assertDefaults
		assertEquals(AssertType.AssertReferences ,mutant.getAssertType());
		mutant.setAssertType(AssertType.AssertContains);
		assertEquals(AssertType.AssertReferences ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertReferencesFailure ,mutant.getType());
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
		mutant.setSourceClass(AllowedReferencesFailureMutant.class);
		assertEquals(AllowedReferencesFailureMutant.class.getName(),
				mutant.getSourceClass().getName());
		
		assertNull(mutant.getField());
		FieldSignature fs = new FieldSignature("nameIn", "classNameIn");
		mutant.setField(fs);
		assertSame(fs, mutant.getField());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testCopyConstructor() {
		
		AllowedReferencesFailureMutant mutant = new AllowedReferencesFailureMutant(Tests4J_EnglishConstants.ENGLISH);
		I_Tests4J_ResultMessages messages = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
    
	  //assertDefaults
    assertEquals(messages.getCalledMethodOrFieldsOutsideOfAllowedDepenencies(),
        mutant.getFailureMessage());
		assertEquals(AssertType.AssertReferences ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertReferencesFailure ,mutant.getType());
		mutant.setCalledClass("foo");
		assertEquals("foo", mutant.getCalledClass());
		mutant.setFailureDetail("failureDetail");
		assertEquals("failureDetail", mutant.getFailureDetail());
		mutant.setGroupNames(Collections.singletonList("Nane"));
		List<String> gnames = mutant.getGroupNames();
		assertContains(gnames, "Nane");
		assertEquals(1, gnames.size());
		
		MethodSignature ms = new MethodSignature("methodNameIn");
		mutant.setMethod(ms);
		assertSame(ms, mutant.getMethod());
		mutant.setSourceClass(AllowedReferencesFailureMutant.class);
		assertSame(AllowedReferencesFailureMutant.class, mutant.getSourceClass());
		FieldSignature fs = new FieldSignature("nameIn", "classNameIn");
		mutant.setField(fs);
		assertSame(fs, mutant.getField());
		
		mutant = new AllowedReferencesFailureMutant(mutant);
		//assertDefaults
		assertEquals(AssertType.AssertReferences ,mutant.getAssertType());
		assertEquals(TestFailureType.AssertReferencesFailure ,mutant.getType());
		//no set type
		assertEquals("foo", mutant.getCalledClass());
		assertEquals("failureDetail", mutant.getFailureDetail());
		
		assertEquals(messages.getCalledMethodOrFieldsOutsideOfAllowedDepenencies(),
				mutant.getFailureMessage());
		List<String> gns = mutant.getGroupNames();
		assertNotNull(gns);
		assertEquals(ArrayList.class.getName(),  gns.getClass().getName());
		assertContains(gns,"Nane");
		
		assertSame(ms, mutant.getMethod());
		mutant.setSourceClass(AllowedReferencesFailureMutant.class);
		assertEquals(AllowedReferencesFailureMutant.class.getName(),
				mutant.getSourceClass().getName());
		assertSame(fs, mutant.getField());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 41;
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
		int thisUniqueAsserts = 26;
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

