package org.adligo.tests4j_tests.shared.report.summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffMutant;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLinesCompare;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLinesCompareResult;
import org.adligo.tests4j.models.shared.en.Tests4J_LineDiffTextDisplayConstants;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.report.summary.LineDiffTextDisplay;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineDiffTextDisplay.class, minCoverage=90.0)
public class LineDiffTextDisplayTrial extends SourceFileCountingTrial implements  I_Tests4J_Log {
	private List<String> output = new ArrayList<String>();
	private LineDiffTextDisplay dislay = new LineDiffTextDisplay();
	@Override
	public void beforeTests() {
		output.clear();
	}
	
	@Test
	public void testSingleActualLineMissing() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a\nb", "a\nb\nc", true);
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.THE_FOLLOWING_ACTUAL_LINE_IS_MISSING_IN_THE_EXPECTED_TEXT + 2, output.get(0));
		assertEquals("c", output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testSingleActualLineMissing_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.TESTS4J_ERROR, output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testSinglePartialMatch_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.MISSING_ACTUAL_LINE);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(0);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.TESTS4J_ERROR, output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testSinglePartialMatch_NullExpectedLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.TESTS4J_ERROR, output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testSingleExpectedLineMissing_MissingExampleLine() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a\nb\nc", "a\nb", true);
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.THE_FOLLOWING_EXPECTED_LINE_IS_MISSING_AFTER_THE_ACTUAL_TEXT + 2, output.get(0));
		assertEquals("c", output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testDoubleActualLineMissing_ExpectedLinesEmpty() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("", "a\nb", true);
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.THE_FOLLOWING_ACTUAL_LINE_IS_MISSING_IN_THE_EXPECTED_TEXT + 0, output.get(0));
		assertEquals("a", output.get(1));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.THE_FOLLOWING_ACTUAL_LINE_IS_MISSING_IN_THE_EXPECTED_TEXT + 1, output.get(2));
		assertEquals("b", output.get(3));
		assertEquals(4, output.size());
	}
	
	@Test
	public void testSingleExpectedLineMissing() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a", "", true);
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.THE_FOLLOWING_EXPECTED_LINE_IS_MISSING_AFTER_THE_ACTUAL_TEXT + 0, output.get(0));
		assertEquals("a", output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testSingleExpecteLineMissing_NullExpectedLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		
		assertEquals(Tests4J_LineDiffTextDisplayConstants.TESTS4J_ERROR , output.get(0));
		assertEquals(1, output.size());
	}


	@Test
	public void testDisplaySingleDiffSafeNullType_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setExpectedLineNbr(0);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		assertEquals(Tests4J_LineDiffTextDisplayConstants.TESTS4J_ERROR, output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_ActualDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		assertEquals(Tests4J_LineDiffTextDisplayConstants.LINES_ARE_DIFFERENT_FROM_THE_ACTUAL_LINE_AS_FOLLOWS, output.get(0));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.EXPECTED + " " + 0, output.get(1));
		assertEquals("hey", output.get(2));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.ACTUAL + " " + 0, output.get(3));
		assertEquals("hey2", output.get(4));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.DIFFERENCES, output.get(5));
		assertEquals("'2'", output.get(6));
		assertEquals(7, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_ExpectedDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(3, 3, 0, 2), new DiffIndexes(null, null , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		assertEquals(Tests4J_LineDiffTextDisplayConstants.LINES_ARE_DIFFERENT_FROM_THE_ACTUAL_LINE_AS_FOLLOWS, output.get(0));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.EXPECTED + " " + 0, output.get(1));
		assertEquals("hey2", output.get(2));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.DIFFERENCES, output.get(3));
		assertEquals("'2'", output.get(4));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.ACTUAL + " " + 0, output.get(5));
		assertEquals("hey", output.get(6));

		assertEquals(7, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_BadExpectedIndexes() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(0, 7, null, null), new DiffIndexes(0,0 , null, null)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		assertEquals(Tests4J_LineDiffTextDisplayConstants.LINES_ARE_DIFFERENT_FROM_THE_ACTUAL_LINE_AS_FOLLOWS, output.get(0));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.TESTS4J_ERROR, output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_BadActualIndexes() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(0, 7, null, null), new DiffIndexes(0,0 , null, null)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		assertEquals(Tests4J_LineDiffTextDisplayConstants.LINES_ARE_DIFFERENT_FROM_THE_ACTUAL_LINE_AS_FOLLOWS, output.get(0));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.TESTS4J_ERROR, output.get(1));
		assertEquals(2, output.size());
	}
	@Test
	public void testDisplaySingleDiffComplex_BothDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(3, 3, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey3", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		assertEquals(Tests4J_LineDiffTextDisplayConstants.LINES_ARE_DIFFERENT_FROM_THE_ACTUAL_LINE_AS_FOLLOWS, output.get(0));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.EXPECTED + " " + 0, output.get(1));
		assertEquals("hey2", output.get(2));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.DIFFERENCES, output.get(3));
		assertEquals("'2'", output.get(4));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.ACTUAL + " " + 0, output.get(5));
		assertEquals("hey3", output.get(6));
		assertEquals(Tests4J_LineDiffTextDisplayConstants.DIFFERENCES, output.get(7));
		assertEquals("'3'", output.get(8));
		assertEquals(9, output.size());
	}
	
	@Test
	public void testDisplayFourLinesLimitToThree() {
		
	}

	@Override
	public int getTests() {
		return 15;
	}

	@Override
	public int getAsserts() {
		return 56;
	}

	@Override
	public int getUniqueAsserts() {
		return 55;
	}

	@Override
	public void onException(Throwable p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMainLog() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void log(String p) {
		output.add(p);
	}
}
