package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.shared.asserts.line_text.DiffIndexes;
import org.adligo.tests4j.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.shared.asserts.line_text.LineDiffMutant;
import org.adligo.tests4j.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.shared.asserts.line_text.TextLinesCompare;
import org.adligo.tests4j.shared.asserts.line_text.TextLinesCompareResult;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.LineDiffTextDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

import java.util.Collections;

@SourceFileScope (sourceClass=LineDiffTextDisplay.class, minCoverage=90.0)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class LineDiffTextDisplayTrial extends SourceFileCountingTrial  {
	private I_Tests4J_Log logMock_;
	private MockMethod<Void> logRecord_;
	private LineDiffTextDisplay dislay = new LineDiffTextDisplay();
	
	@Override
	public void beforeTests() {
	  logMock_ = mock(I_Tests4J_Log.class);
	  logRecord_ = new MockMethod<Void>();
	  doAnswer(logRecord_).when(logMock_).log(anyVararg());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testSingleActualLineMissing() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a\nb", "a\nb\nc", true);
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingActualLineOfTextIsMissing() + 2, logRecord_.getArg(0));
		assertEquals("c", logRecord_.getArg(1));
		assertEquals(2, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testSingleActualLineMissing_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), logRecord_.getArg(0));
		assertEquals(1, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testSinglePartialMatch_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.MissingActualLine);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(0);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), logRecord_.getArg(0));
		assertEquals(1, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testSinglePartialMatch_NullExpectedLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), logRecord_.getArg(0));
		assertEquals(1, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testSingleExpectedLineMissing_MissingExampleLine() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a\nb\nc", "a\nb", true);
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingExpectedLineOfTextIsMissing() + 2, logRecord_.getArg(0));
		assertEquals("c", logRecord_.getArg(1));
		assertEquals(2, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testDoubleActualLineMissing_ExpectedLinesEmpty() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("", "a\nb", true);
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingActualLineOfTextIsMissing() + 0, logRecord_.getArg(0));
		assertEquals("a", logRecord_.getArg(1));
		assertEquals(messages.getTheFollowingActualLineOfTextIsMissing() + 1, logRecord_.getArg(2));
		assertEquals("b", logRecord_.getArg(3));
		assertEquals(4, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testSingleExpectedLineMissing() {
		I_TextLinesCompareResult result = new TextLinesCompare().compare("a", "", true);
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheFollowingExpectedLineOfTextIsMissing() + 0, logRecord_.getArg(0));
		assertEquals("a", logRecord_.getArg(1));
		assertEquals(2, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testSingleExpecteLineMissing_NullExpectedLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setActualLineNbr(null);
		ldm.setExpectedLineNbr(-1);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError() , logRecord_.getArg(0));
		assertEquals(1, logRecord_.count());
	}

	@SuppressWarnings("boxing")
	@Test
	public void testDisplaySingleDiffSafeNullType_NullActualLine() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setExpectedLineNbr(0);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		
		I_TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getError(), logRecord_.getArg(0));
		assertEquals(1, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testDisplaySingleDiffComplex_ActualDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(null, null, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey", true),
				new TextLines("hey2", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), logRecord_.getArg(0));
		assertEquals(messages.getExpected()+ " " + 0, logRecord_.getArg(1));
		assertEquals("hey", logRecord_.getArg(2));
		assertEquals(messages.getActual() + " " + 0, logRecord_.getArg(3));
		assertEquals("hey2", logRecord_.getArg(4));
		assertEquals(messages.getDifferences(), logRecord_.getArg(5));
		assertEquals("'2'", logRecord_.getArg(6));
		assertEquals(7, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testDisplaySingleDiffComplex_ExpectedDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(3, 3, 0, 2), new DiffIndexes(null, null , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), logRecord_.getArg(0));
		assertEquals(messages.getExpected() + " " + 0, logRecord_.getArg(1));
		assertEquals("hey2", logRecord_.getArg(2));
		assertEquals(messages.getDifferences(), logRecord_.getArg(3));
		assertEquals("'2'", logRecord_.getArg(4));
		assertEquals(messages.getActual() + " " + 0, logRecord_.getArg(5));
		assertEquals("hey", logRecord_.getArg(6));

		assertEquals(7, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testDisplaySingleDiffComplex_BadExpectedIndexes() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(0, 7, null, null), new DiffIndexes(0,0 , null, null)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), logRecord_.getArg(0));
		assertEquals(messages.getError(), logRecord_.getArg(1));
		assertEquals(2, logRecord_.count());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testDisplaySingleDiffComplex_BadActualIndexes() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(0, 7, null, null), new DiffIndexes(0,0 , null, null)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), logRecord_.getArg(0));
		assertEquals(messages.getError(), logRecord_.getArg(1));
		assertEquals(2, logRecord_.count());
	}
	@SuppressWarnings("boxing")
  @Test
	public void testDisplaySingleDiffComplex_BothDifferent() {
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setIndexes(new DiffIndexesPair(new DiffIndexes(3, 3, 0, 2), new DiffIndexes(3,3 , 0, 2)));
		ldm.setExpectedLineNbr(0);
		ldm.setActualLineNbr(0);
		TextLinesCompareResult result = new TextLinesCompareResult(new TextLines("hey2", true),
				new TextLines("hey3", true),false,Collections.singletonList(ldm));
		
		dislay.display(logMock_,result, 3);
		I_Tests4J_LineDiffTextDisplayMessages messages =  Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		
		assertEquals(messages.getTheLineOfTextIsDifferent(), logRecord_.getArg(0));
		assertEquals(messages.getExpected() + " " + 0, logRecord_.getArg(1));
		assertEquals("hey2", logRecord_.getArg(2));
		assertEquals(messages.getDifferences(), logRecord_.getArg(3));
		assertEquals("'2'", logRecord_.getArg(4));
		assertEquals(messages.getActual() + " " + 0, logRecord_.getArg(5));
		assertEquals("hey3", logRecord_.getArg(6));
		assertEquals(messages.getDifferences(), logRecord_.getArg(7));
		assertEquals("'3'", logRecord_.getArg(8));
		assertEquals(9, logRecord_.count());
	}
	
	@Test
	public void testDisplayFourLinesLimitToThree() {
		
	}


	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 15, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 56;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
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
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
