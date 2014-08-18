package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_LineDiff;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLines;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLinesCompare;
import org.adligo.tests4j.models.shared.en.Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TextLinesCompare.class, minCoverage=90.0)
public class TextLinesCompareTrial extends SourceFileCountingTrial {

	
	
	
	@Test
	public void test1LineMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a", "a", true);
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
	
	@Test
	public void test1LineEmptyMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("\n", "\n", true);
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
	
	@Test
	public void test1LineMatchFail() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a", "b", true);
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
	
	@Test
	public void test2LineMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb", "a\rb", true);
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
	@Test
	public void test2LineMatchFail_AB_BB() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb", "b\rb", true);
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
	@Test
	public void test2LineMatchFail_AB_DC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb", "d\rc", true);
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
	@Test
	public void test2LineMatchFail_AB_AC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\rb", "a\rc", true);
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
	
	@Test
	public void test3LineMatchAchievement() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb\r\nc", "a\rb\rc", true);
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
	@Test
	public void test3LineMatchFail_ABC_BBC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb\r\nc", "b\rb\rc", true);
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
	@Test
	public void test3LineMatchFail_ABC_CBA() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb\r\nc", "c\rb\ra", true);
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
	@Test
	public void test3LineMatchFail_ABC_CBD() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb\r\nc", "c\rb\rd", true);
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
	@Test
	public void test3LineMatchFail_ABC_DEF() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb\r\nc", "d\ne\nf", true);
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
	@Test
	public void test3LineMatchFail_ABC_AEC() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a\nb\r\nc", "a\ne\nc", true);
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
	
	@Test
	public void testMultiLine2x2CharPartialMatchEndOfFirstLine() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a1\na2", "b1\na2", true);
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
	
	
	@Test
	public void testMultiLine2x2CharPartialMatchEndOfLastLine() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a1\na2", "a1\nb2", true);
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
	
	@Test
	public void testMultiLine3x3CharPartialMatchMiddleOfMiddleLine() {
		TextLinesCompare tlc = new TextLinesCompare();
		I_TextLinesCompareResult result = tlc.compare("a1\n123a2456\nc4", "b2\n1279a20456\nc4", true);
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

	
	
	@Override
	public int getTests() {
		return 16;
	}

	@Override
	public int getAsserts() {
		return 404;
	}

	@Override
	public int getUniqueAsserts() {
		return 238;
	}
}
