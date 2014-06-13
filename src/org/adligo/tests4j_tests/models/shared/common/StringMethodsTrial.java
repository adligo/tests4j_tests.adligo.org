package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.I_Thrower;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;

@SourceFileScope (sourceClass=StringMethods.class)
public class StringMethodsTrial extends SourceFileTrial {

	@Test
	public void testMethods() {
		assertTrue(StringMethods.isEmpty(null));
		assertTrue(StringMethods.isEmpty(""));
		assertTrue(StringMethods.isEmpty("\t"));
		assertTrue(StringMethods.isEmpty("\n"));
		assertFalse(StringMethods.isEmpty("hey"));
		
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class,"null message."), new I_Thrower() {
			
			@Override
			public void run() {
				StringMethods.isEmpty(null, "null message.");
			}
		});
		
	}
	

	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(6.0, p.getAssertions());
		assertGreaterThanOrEquals(3.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
