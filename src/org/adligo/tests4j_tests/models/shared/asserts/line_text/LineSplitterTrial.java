package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.LineSplitter;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineSplitter.class)
public class LineSplitterTrial extends SourceFileCountingTrial {

	
	@Test
	public void testMethods() {
		LineSplitter split = new LineSplitter();
		assertFalse(split.isNewLineChar('c'));
		
		assertTrue(split.isNewLineChar('\n'));
		
		assertTrue(split.isNewLineChar('\r'));
		
		assertFalse(split.isNewLineChar('a'));
		
		assertTrue(split.isNewLineChar('\r'));
		
		assertFalse(split.isNewLineChar('b'));
		
		assertTrue(split.isNewLineChar('\n'));
		
		split.setLastNewLineChar('\n');
		assertTrue(split.isLastCharNewLine());
		assertFalse(split.isMultiCharNewLine('\r'));
		assertFalse(split.isMultiCharNewLine('\n'));
		
		split.setLastNewLineChar('\r');
		assertTrue(split.isLastCharNewLine());
		assertTrue(split.isMultiCharNewLine('\n'));
		assertFalse(split.isMultiCharNewLine('\r'));
		
		split.setLastNewLineChar(null);
		assertFalse(split.isLastCharNewLine());
		assertFalse(split.isMultiCharNewLine('\n'));
		assertFalse(split.isMultiCharNewLine('\n'));
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}

	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 16;
	}

	@Override
	public int getUniqueAsserts() {
		return 2;
	}
}
