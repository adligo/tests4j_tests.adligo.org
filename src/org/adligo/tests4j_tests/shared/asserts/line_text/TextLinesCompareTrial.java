package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.shared.asserts.line_text.I_DiffIndexes;
import org.adligo.tests4j.shared.asserts.line_text.I_DiffIndexesPair;
import org.adligo.tests4j.shared.asserts.line_text.I_LineDiff;
import org.adligo.tests4j.shared.asserts.line_text.I_TextLines;
import org.adligo.tests4j.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.shared.asserts.line_text.TextLinesCompare;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsLineText_GwtReferenceGroup;

import java.util.List;

@SourceFileScope (sourceClass=TextLinesCompare.class, minCoverage=88.0)
@AllowedReferences (groups=Tests4J_AssertsLineText_GwtReferenceGroup.class)
public class TextLinesCompareTrial extends SourceFileCountingTrial {

  @Test
  public void testNulls() {
    TextLinesCompare tlc = new TextLinesCompare();
    I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH, null, null, false);
    assertNotNull(result);
    assertTrue(result.hasErrorMessage());
    assertEquals(Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages().getTheExpectedValueShouldNeverBeNull(),
        result.getErrorMessage());
    
    result = tlc.compare(Tests4J_EnglishConstants.ENGLISH,  "e", null, false);
    assertNotNull(result);
    assertTrue(result.hasErrorMessage());
    assertEquals(Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages().getTheActualValueIsNull(),
        result.getErrorMessage());
  }
	@SuppressWarnings("boxing")
  @Test
	public void test1LineMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH, "a", "a", true);
		assertTrue(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(1,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(1,actualLines.getLines());
		assertEquals("a", actualLines.getLine(0));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(1, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void test1LineEmptyMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH, "\n", "\n", true);
		assertTrue(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(1,expectedLines.getLines());
		assertEquals("", expectedLines.getLine(0));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(1,actualLines.getLines());
		assertEquals("", actualLines.getLine(0));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(1, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void test1LineMatchFail() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH, "a", "b", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(1,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(1,actualLines.getLines());
		assertEquals("b", actualLines.getLine(0));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(2, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
	
		diff = diffs.get(1);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void test2LineMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH,  "a\nb", "a\rb", true);
		assertTrue(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(2,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(2,actualLines.getLines());
		assertEquals("a", actualLines.getLine(0));
		assertEquals("b", actualLines.getLine(1));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(2, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
	}
	
	/**
	 * 
	 *     'a' vs 'b'   ....    a /^
	 *     'b'    'b'           b  = b
	 *                            ^\ b 
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test2LineMatchFail_AB_BB() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb", "b\rb", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(2,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(2,actualLines.getLines());
		assertEquals("b", actualLines.getLine(0));
		assertEquals("b", actualLines.getLine(1));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(3, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(-1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//diff # 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//diff # 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	
	/**
	 * 
	 *     'a' vs 'd'   ....      ^\ d
	 *     'b'    'c'             ^\ c
	 *                          a /^
	 *                          b /^ 
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test2LineMatchFail_AB_DC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb", "d\rc", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(2,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(2,actualLines.getLines());
		assertEquals("d", actualLines.getLine(0));
		assertEquals("c", actualLines.getLine(1));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(4, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//diff # 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//diff # 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//diff # 3
		diff = diffs.get(3);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	/**
	 * 
	 *     'a' vs 'a'   ....    a  = a
	 *     'b'    'c'             ^\ c
	 *                          b /^ 
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test2LineMatchFail_AB_AC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\rb", "a\rc", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(2,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(2,actualLines.getLines());
		assertEquals("a", actualLines.getLine(0));
		assertEquals("c", actualLines.getLine(1));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(3, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//diff # 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//diff # 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void test3LineMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb\r\nc", "a\rb\rc", true);
		assertTrue(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(3,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		assertEquals("c", expectedLines.getLine(2));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(3,actualLines.getLines());
		assertEquals("a", actualLines.getLine(0));
		assertEquals("b", actualLines.getLine(1));
		assertEquals("c", actualLines.getLine(2));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(3, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(2, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	/**
	 * 
	 *     'a' vs 'b'   ....    a /^
	 *     'b'    'b'           b  = b
	 *     'c'    'c'             ^\ b
	 *                          c  = c 
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test3LineMatchFail_ABC_BBC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb\r\nc", "b\rb\rc", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(3,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		assertEquals("c", expectedLines.getLine(2));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(3,actualLines.getLines());
		assertEquals("b", actualLines.getLine(0));
		assertEquals("b", actualLines.getLine(1));
		assertEquals("c", actualLines.getLine(2));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(4, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(-1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 3
		diff = diffs.get(3);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(2, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	/**
	 * 
	 *     'a' vs 'c'   ....      ^\ c
	 *     'b'    'b'             ^\ b
	 *     'c'    'a'           a  = a
	 *                          b /^ 
	 *                          c /^  
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test3LineMatchFail_ABC_CBA() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb\r\nc", "c\rb\ra", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(3,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		assertEquals("c", expectedLines.getLine(2));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(3,actualLines.getLines());
		assertEquals("c", actualLines.getLine(0));
		assertEquals("b", actualLines.getLine(1));
		assertEquals("a", actualLines.getLine(2));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(5, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
				
		
		//test line 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 3
		diff = diffs.get(3);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 4
		diff = diffs.get(4);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(2, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	/**
	 * 
	 *     'a' vs 'c'   ....      ^\ c
	 *     'b'    'b'           a /^
	 *     'c'    'd'           b  = b
	 *                            ^\ d 
	 *                          c /^  
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test3LineMatchFail_ABC_CBD() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb\r\nc", "c\rb\rd", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(3,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		assertEquals("c", expectedLines.getLine(2));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(3,actualLines.getLines());
		assertEquals("c", actualLines.getLine(0));
		assertEquals("b", actualLines.getLine(1));
		assertEquals("d", actualLines.getLine(2));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(5, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
				
		
		//test line 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 3
		diff = diffs.get(3);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 4
		diff = diffs.get(4);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(2, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	/**
	 * 
	 *     'a' vs 'd'   ....      ^\ d
	 *     'b'    'e'             ^\ e
	 *     'c'    'f'             ^\ f
	 *                          a /^ 
	 *                          b /^
	 *                          c /^  
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test3LineMatchFail_ABC_DEF() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb\r\nc", "d\ne\nf", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(3,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		assertEquals("c", expectedLines.getLine(2));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(3,actualLines.getLines());
		assertEquals("d", actualLines.getLine(0));
		assertEquals("e", actualLines.getLine(1));
		assertEquals("f", actualLines.getLine(2));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(6, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
				
		
		//test line 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 3
		diff = diffs.get(3);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 4
		diff = diffs.get(4);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 5
		diff = diffs.get(5);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(2, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	/**
	 * 
	 *     'a' vs 'a'   ....    a  = a
	 *     'b'    'e'             ^\ e
	 *     'c'    'c'           b /^
	 *                          c  = c 
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test3LineMatchFail_ABC_AEC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(
		    Tests4J_EnglishConstants.ENGLISH, "a\nb\r\nc", "a\ne\nc", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(3,expectedLines.getLines());
		assertEquals("a", expectedLines.getLine(0));
		assertEquals("b", expectedLines.getLine(1));
		assertEquals("c", expectedLines.getLine(2));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(3,actualLines.getLines());
		assertEquals("a", actualLines.getLine(0));
		assertEquals("e", actualLines.getLine(1));
		assertEquals("c", actualLines.getLine(2));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(4, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 1
		diff = diffs.get(1);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
				
		
		//test line 2
		diff = diffs.get(2);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		//test line 3
		diff = diffs.get(3);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(2, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testMultiLine2x2CharPartialMatchEndOfFirstLine() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH, "a1\na2", "b1\na2", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(2,expectedLines.getLines());
		assertEquals("a1", expectedLines.getLine(0));
		assertEquals("a2", expectedLines.getLine(1));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(2,actualLines.getLines());
		assertEquals("b1", actualLines.getLine(0));
		assertEquals("a2", actualLines.getLine(1));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(2, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.PartialMatch, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		I_DiffIndexesPair indexes = diff.getIndexes();
		assertNotNull(indexes);
		I_DiffIndexes expected = indexes.getExpected();
		I_DiffIndexes actual = indexes.getActual();
		assertEquals(0, expected.getDiffLeftToRight());
		assertEquals(0, expected.getDiffRightToLeft());
		
		assertEquals(0, actual.getDiffLeftToRight());
		assertEquals(0, actual.getDiffRightToLeft());
	
		diff = diffs.get(1);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testMultiLine2x2CharPartialMatchEndOfLastLine() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH, "a1\na2", "a1\nb2", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(2,expectedLines.getLines());
		assertEquals("a1", expectedLines.getLine(0));
		assertEquals("a2", expectedLines.getLine(1));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(2,actualLines.getLines());
		assertEquals("a1", actualLines.getLine(0));
		assertEquals("b2", actualLines.getLine(1));
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(2, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		
	
		diff = diffs.get(1);
		assertEquals(LineDiffType.PartialMatch, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		I_DiffIndexesPair indexes = diff.getIndexes();
		assertNotNull(indexes);
		I_DiffIndexes expected = indexes.getExpected();
		I_DiffIndexes actual = indexes.getActual();
		assertEquals(0, expected.getDiffLeftToRight());
		assertEquals(0, expected.getDiffRightToLeft());
		
		assertEquals(0, actual.getDiffLeftToRight());
		assertEquals(0, actual.getDiffRightToLeft());
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testMultiLine3x3CharPartialMatchMiddleOfMiddleLine() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare(Tests4J_EnglishConstants.ENGLISH, "a1\n123a2456\nc4", "b2\n1279a20456\nc4", true);
		assertFalse(result.isMatched());
		I_TextLines expectedLines = result.getExpectedLines();
		assertNotNull(expectedLines);
		assertEquals(3,expectedLines.getLines());
		assertEquals("a1", expectedLines.getLine(0));
		assertEquals("123a2456", expectedLines.getLine(1));
		assertEquals("c4", expectedLines.getLine(2));
		
		I_TextLines actualLines = result.getActualLines();
		assertNotNull(actualLines);
		assertEquals(3,actualLines.getLines());
		assertEquals("b2", actualLines.getLine(0));
		assertEquals("1279a20456", actualLines.getLine(1));
		assertEquals("c4", expectedLines.getLine(2));
		
		
		List<I_LineDiff> diffs = result.getLineDiffs();
		assertNotNull(diffs);
		assertEquals(4, diffs.size());
		I_LineDiff diff = diffs.get(0);
		assertEquals(LineDiffType.MissingActualLine, diff.getType());
		assertEquals(-1, diff.getExpectedLineNbr());
		assertEquals(0, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
		
		diff = diffs.get(1);
		assertEquals(LineDiffType.PartialMatch, diff.getType());
		assertEquals(0, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		I_DiffIndexesPair indexes = diff.getIndexes();
		assertNotNull(indexes);
		I_DiffIndexes expected = indexes.getExpected();
		I_DiffIndexes actual = indexes.getActual();
		assertEquals(1, expected.getDiffLeftToRight());
		assertEquals(1, expected.getDiffRightToLeft());
		assertEquals(0, expected.getMatchLeftToRight());
		assertEquals(0, expected.getMatchRightToLeft());
		
		assertEquals(0, actual.getDiffLeftToRight());
		assertEquals(9, actual.getDiffRightToLeft());
		assertEquals(4, actual.getMatchLeftToRight());
		assertEquals(4, actual.getMatchRightToLeft());
		
		diff = diffs.get(2);
		assertEquals(LineDiffType.MissingExpectedLine, diff.getType());
		assertEquals(1, diff.getExpectedLineNbr());
		assertEquals(1, diff.getActualLineNbr());
		indexes = diff.getIndexes();
		assertNull(indexes);
		
		diff = diffs.get(3);
		assertEquals(LineDiffType.Match, diff.getType());
		assertEquals(2, diff.getExpectedLineNbr());
		assertEquals(2, diff.getActualLineNbr());
		assertNull(diff.getIndexes());
	}

  @SuppressWarnings("boxing")
  @Test
  public void testMultiLine3x3TabAtEndOfLine() {
    TextLinesCompare tlc = new TextLinesCompare();
    I_TextLinesCompareResult tlcr = tlc.compare(Tests4J_EnglishConstants.ENGLISH, 
        "exp\nlineA\nlineB\t", "exp\nlineA\nlineB", true);
    I_TextLines actual = tlcr.getActualLines();
    assertEquals("exp", actual.getLine(0));
    assertEquals("lineA", actual.getLine(1));
    assertEquals("lineB", actual.getLine(2));
    assertEquals(3, actual.getLines());
    
    I_TextLines expected = tlcr.getExpectedLines();
    assertEquals("exp", expected.getLine(0));
    assertEquals("lineA", expected.getLine(1));
    assertEquals("lineB\t", expected.getLine(2));
    assertEquals(3, expected.getLines());
    
    List<I_LineDiff> diffs =  tlcr.getLineDiffs();
    I_LineDiff ld = diffs.get(2);
    assertNotNull(ld);
    assertEquals(LineDiffType.PartialMatch ,ld.getType());
    assertEquals(2, ld.getExpectedLineNbr());
    assertEquals(2, ld.getActualLineNbr());
  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 18, true);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 422;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 251;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
