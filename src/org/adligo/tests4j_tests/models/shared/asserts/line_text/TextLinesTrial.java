package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TextLines.class)
public class TextLinesTrial extends SourceFileCountingTrial {

	
	@Test
	public void testLinesWithNormalizedLineFeeds() {
		TextLines lines = new TextLines("a\n" +
				"b", true);
		assertEquals(2, lines.getLines());
		assertEquals("a", lines.getLine(0));
		assertEquals("b", lines.getLine(1));
		
		
		lines = new TextLines("a\r\n" +
				"\r\n" +
				"b", true);
		assertEquals(3, lines.getLines());
		assertEquals("a", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("b", lines.getLine(2));
	}
	
	@Test
	public void testLinesWithOutNormalizedLineFeeds() {
		TextLines lines = new TextLines("a\n" +
				"b", false);
		assertEquals(2, lines.getLines());
		assertEquals("a\n", lines.getLine(0));
		assertEquals("b", lines.getLine(1));
		
		
		lines = new TextLines("a\r\n" +
				"\r\n" +
				"b", false);
		assertEquals(3, lines.getLines());
		assertEquals("a\r\n", lines.getLine(0));
		assertEquals("\r\n", lines.getLine(1));
		assertEquals("b", lines.getLine(2));
	}
	
	@Test
	public void testEmptyLines() {
		TextLines lines = new TextLines("\n\n\n", true);
		assertEquals(3, lines.getLines());
		assertEquals("", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("", lines.getLine(3));
		
		
		lines = new TextLines("\r\r\r", true);
		assertEquals(3, lines.getLines());
		assertEquals("", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("", lines.getLine(3));
		
		lines = new TextLines("\r\n\r\n\r\n", true);
		assertEquals(3, lines.getLines());
		assertEquals("", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("", lines.getLine(3));
	}
	
	@Test
	public void testToString() {
		TextLines lines = new TextLines("a\n" +
				"b", false);
		
		String actual = lines.toString();
		TextLines fromString = new TextLines(actual, false);
		assertEquals(2, fromString.getLines());
		assertEquals("TextLines [lines=[a\n", fromString.getLine(0));
		assertEquals(", b]]", fromString.getLine(1));
		
		assertEquals("TextLines [lines=[a\n, b]]", actual);
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(97.0, coverage.getPercentageCoveredDouble());
		}
	}

	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 30;
	}

	@Override
	public int getUniqueAsserts() {
		return 17;
	}
}
