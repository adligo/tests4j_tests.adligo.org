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
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TextLinesCompareResult.class, minCoverage=60.0)
public class TextLinesCompareResultTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorAndGetters() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.MissingExpectedLine);
		ldm.setExpectedLineNbr(0);
		
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
		ldm.setType(LineDiffType.MissingExpectedLine);
		ldm.setExpectedLineNbr(0);
		
		List<I_LineDiff> lineDiffs = new ArrayList<I_LineDiff>();
		lineDiffs.add(ldm);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("a", true), 
				new TextLines("b", true), false, lineDiffs);
		assertEquals("TextLinesCompareResult [example=TextLines [lines=[a]], "
				+ "actual=TextLines [lines=[b]], matched=false, "
				+ "lineDiffs=[LineDiff [type=MissingExpectedLine, "
				+ "exampleLineNbr=0, actualLineNbr=null]]]",result.toString());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}
	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,14);
		} else {
			return super.getAsserts(type, 12);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 12);
		} else {
			return super.getUniqueAsserts(type, 10);
		}
	}
}
