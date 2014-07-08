package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.LineSplitter;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TextLines.class)
public class TextLinesTrial extends SourceFileCountingTrial {

	
	@Test
	public void testTypes() {
		TextLines lines = new TextLines("a\n" +
				"b");
		assertEquals(2, lines.getLines());
		assertEquals("a", lines.getLine(0));
		assertEquals("b", lines.getLine(1));
		
		
		lines = new TextLines("a\n\r" +
				"\n\r" +
				"b");
		assertEquals(3, lines.getLines());
		assertEquals("a", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("b", lines.getLine(2));
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
		return 7;
	}

	@Override
	public int getUniqueAsserts() {
		return 5;
	}
}
