package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.asserts.line_text.I_LineDiff;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLines;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffMutant;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLinesCompareResult;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TextLinesCompareResult.class)
public class TextLinesCompareResultTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorAndGetters() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.MISSING_EXAMPLE_LINE);
		ldm.setExampleLineNbr(0);
		
		List<I_LineDiff> lineDiffs = new ArrayList<I_LineDiff>();
		lineDiffs.add(ldm);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("a", true), 
				new TextLines("b", true), false, lineDiffs);
		assertFalse(result.isMatched());
		I_TextLines example = result.getExpectedLines();
		assertNotNull(example);
		assertEquals(1, example.getLines());
		assertEquals("a", example.getLine(0));
		
		I_TextLines actual = result.getActualLines();
		assertNotNull(actual);
		assertEquals(1, actual.getLines());
		assertEquals("b", actual.getLine(0));
		
		List<I_LineDiff> diffs =  result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", diffs.getClass().getName());
		assertEquals(1, diffs.size());
		assertEquals(ldm, diffs.get(0));
	}
	
	@Test
	public void testToString() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.MISSING_EXAMPLE_LINE);
		ldm.setExampleLineNbr(0);
		
		List<I_LineDiff> lineDiffs = new ArrayList<I_LineDiff>();
		lineDiffs.add(ldm);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("a", true), 
				new TextLines("b", true), false, lineDiffs);
		assertEquals("TextLinesCompareResult [example=TextLines [lines=[a]], "
				+ "actual=TextLines [lines=[b]], matched=false, "
				+ "lineDiffs=[LineDiffMutant [type=MISSING_EXAMPLE_LINE, "
				+ "exampleLineNbr=0, actualLineNbr=null]]]",result.toString());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(96.0, coverage.getPercentageCoveredDouble());
		}
	}

	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 12;
	}

	@Override
	public int getUniqueAsserts() {
		return 10;
	}
}
