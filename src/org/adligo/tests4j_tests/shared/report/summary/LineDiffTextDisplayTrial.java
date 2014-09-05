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
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.shared.report.summary.LineDiffTextDisplay;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

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
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingActualLineOfTextIsMissing() + 2, output.get(0));
		assertEquals("c", output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testSingleActualLineMissing_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testSinglePartialMatch_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.MissingActualLine);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(0);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testSinglePartialMatch_NullExpectedLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testSingleExpectedLineMissing_MissingExampleLine() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a\nb\nc", "a\nb", true);
		dislay.display(this,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingExpectedLineOfTextIsMissing() + 2, output.get(0));
		assertEquals("c", output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testDoubleActualLineMissing_ExpectedLinesEmpty() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("", "a\nb", true);
		dislay.display(this,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingActualLineOfTextIsMissing() + 0, output.get(0));
		assertEquals("a", output.get(1));
		assertEquals(messages.getTheFollowingActualLineOfTextIsMissing() + 1, output.get(2));
		assertEquals("b", output.get(3));
		assertEquals(4, output.size());
	}
	
	@Test
	public void testSingleExpectedLineMissing() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a", "", true);
		dislay.display(this,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingExpectedLineOfTextIsMissing() + 0, output.get(0));
		assertEquals("a", output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testSingleExpecteLineMissing_NullExpectedLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError() , output.get(0));
		assertEquals(1, output.size());
	}


	@Test
	public void testDisplaySingleDiffSafeNullType_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setExpectedLineNbr(0);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), output.get(0));
		assertEquals(1, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_ActualDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), output.get(0));
		assertEquals(messages.getExpected()+ " " + 0, output.get(1));
		assertEquals("hey", output.get(2));
		assertEquals(messages.getActual() + " " + 0, output.get(3));
		assertEquals("hey2", output.get(4));
		assertEquals(messages.getDifferences(), output.get(5));
		assertEquals("'2'", output.get(6));
		assertEquals(7, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_ExpectedDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(3, 3, 0, 2), new DiffIndexes(null, null , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), output.get(0));
		assertEquals(messages.getExpected() + " " + 0, output.get(1));
		assertEquals("hey2", output.get(2));
		assertEquals(messages.getDifferences(), output.get(3));
		assertEquals("'2'", output.get(4));
		assertEquals(messages.getActual() + " " + 0, output.get(5));
		assertEquals("hey", output.get(6));

		assertEquals(7, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_BadExpectedIndexes() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(0, 7, null, null), new DiffIndexes(0,0 , null, null)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), output.get(0));
		assertEquals(messages.getError(), output.get(1));
		assertEquals(2, output.size());
	}
	
	@Test
	public void testDisplaySingleDiffComplex_BadActualIndexes() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(0, 7, null, null), new DiffIndexes(0,0 , null, null)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), output.get(0));
		assertEquals(messages.getError(), output.get(1));
		assertEquals(2, output.size());
	}
	@Test
	public void testDisplaySingleDiffComplex_BothDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(3, 3, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey3", true),false,Collections.singletonList(ldm));
		
		dislay.display(this,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), output.get(0));
		assertEquals(messages.getExpected() + " " + 0, output.get(1));
		assertEquals("hey2", output.get(2));
		assertEquals(messages.getDifferences(), output.get(3));
		assertEquals("'2'", output.get(4));
		assertEquals(messages.getActual() + " " + 0, output.get(5));
		assertEquals("hey3", output.get(6));
		assertEquals(messages.getDifferences(), output.get(7));
		assertEquals("'3'", output.get(8));
		assertEquals(9, output.size());
	}
	
	@Test
	public void testDisplayFourLinesLimitToThree() {
		
	}


	@Override
	public void onThrowable(Throwable p) {
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

	@Override
	public String getLineSeperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLogEnabled(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 15);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 56;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 55;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

	@Override
	public String getCurrentThreadName() {
		// TODO Auto-generated method stub
		return null;
	}
}
