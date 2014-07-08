package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.asserts.line_text.LineSplitter;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineSplitter.class)
public class LineSplitterTrial extends SourceFileCountingTrial {

	
	@Test
	public void testTypes() {
		LineSplitter split = new LineSplitter();
		assertFalse(split.isLastCharLineFeedChar());
		assertFalse(split.isLineFeedChar('c'));
		assertFalse(split.isLastCharLineFeedChar());
		
		assertTrue(split.isLineFeedChar('\n'));
		assertTrue(split.isLastCharLineFeedChar());
		
		assertTrue(split.isLineFeedChar('\r'));
		assertTrue(split.isLastCharLineFeedChar());
		
		assertFalse(split.isLineFeedChar('a'));
		assertFalse(split.isLastCharLineFeedChar());
		
		assertTrue(split.isLineFeedChar('\r'));
		assertTrue(split.isLastCharLineFeedChar());
		
		assertFalse(split.isLineFeedChar('b'));
		assertFalse(split.isLastCharLineFeedChar());
		
		assertTrue(split.isLineFeedChar('\n'));
		assertTrue(split.isLastCharLineFeedChar());
		split.setLastCharLineFeedChar(false);
		assertFalse(split.isLastCharLineFeedChar());
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
