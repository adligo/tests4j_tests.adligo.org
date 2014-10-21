package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_GwtReferenceGroup;

@SourceFileScope (sourceClass=CompareAssertionData.class, minCoverage=77.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class CompareAssertionDataTrial extends SourceFileCountingTrial {

	@Test
	public void testEqualsHashCode() {
		CompareAssertionData<String> a = new CompareAssertionData<String>("a","a", AssertType.AssertTrue);
		CompareAssertionData<String> b = new CompareAssertionData<String>("a","b", AssertType.AssertTrue);
		CompareAssertionData<String> c = new CompareAssertionData<String>("a","a", AssertType.AssertTrue);
		CompareAssertionData<String> d = new CompareAssertionData<String>("b","b", AssertType.AssertTrue);
		CompareAssertionData<String> e = new CompareAssertionData<String>("b","a", AssertType.AssertTrue);
		CompareAssertionData<String> f = new CompareAssertionData<String>("a","a", AssertType.AssertFalse);
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
		
		assertNotEquals(a, new Object());
	}
	
	@Test
	public void testGettersAndCopyConstructor() {
		CompareAssertionData<String> a = new CompareAssertionData<String>("a","b", AssertType.AssertTrue);

	
		assertEquals("a", a.getExpected());
		assertEquals("b", a.getActual());
		assertEquals(AssertType.AssertTrue, a.getType());
		
		CompareAssertionData<String> b = new CompareAssertionData<String>(a);
		
		assertEquals("a", b.getExpected());
		assertEquals("b", b.getActual());
		assertEquals(AssertType.AssertTrue, b.getType());
	}
	
	@Test
	public void testToString() {
		CompareAssertionData<String> a = new CompareAssertionData<String>("a","b", AssertType.AssertTrue);
		assertEquals("CompareAssertionData [expected=a, actual=b, type=AssertTrue]", a.toString());
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 18;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 9;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
