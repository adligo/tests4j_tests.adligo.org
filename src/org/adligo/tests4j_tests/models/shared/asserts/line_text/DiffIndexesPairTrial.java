package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexesPair;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=DiffIndexesPair.class, minCoverage=75.0)
public class DiffIndexesPairTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorAndGetters() {
		I_DiffIndexes sed = new DiffIndexes(0, 1, null, null);
		
		I_DiffIndexes sed2 = new DiffIndexes(2, 3, null, null);
		
		I_DiffIndexesPair pair = new DiffIndexesPair(sed, sed2);
		assertSame(sed, pair.getExpected());
		assertSame(sed2, pair.getActual());
	}
	
	@Test
	public void testCompareLinesEndMatch() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("cab", "dab");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(0, exampleIndexes.getDiffRightToLeft());
		assertEquals(1, exampleIndexes.getMatchLeftToRight());
		assertEquals(2, exampleIndexes.getMatchRightToLeft());
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(0, actualIndexes.getDiffRightToLeft());
		assertEquals(1, actualIndexes.getMatchLeftToRight());
		assertEquals(2, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesEndMatchActualLonger() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("cab", "fcab");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertNull(exampleIndexes.getDiffLeftToRight());
		assertNull(exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(2, exampleIndexes.getMatchRightToLeft());
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(0, actualIndexes.getDiffRightToLeft());
		assertEquals(1, actualIndexes.getMatchLeftToRight());
		assertEquals(3, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesEndMatchExpectedLonger() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("fcab", "cab");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(0, exampleIndexes.getDiffRightToLeft());
		assertEquals(1, exampleIndexes.getMatchLeftToRight());
		assertEquals(3, exampleIndexes.getMatchRightToLeft());
		
		assertNull(actualIndexes.getDiffLeftToRight());
		assertNull(actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(2, actualIndexes.getMatchRightToLeft());
		
	}
	
	@Test
	public void testCompareLinesLeftMatch() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("abc", "aba");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(2, exampleIndexes.getDiffLeftToRight());
		assertEquals(2, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(1, exampleIndexes.getMatchRightToLeft());
		
		assertEquals(2, actualIndexes.getDiffLeftToRight());
		assertEquals(2, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(1, actualIndexes.getMatchRightToLeft());
	}
	
	
	@Test
	public void testCompareLinesMiddleDiff() throws Exception {
		String example = "abcbloff123";
		String actual = "abcscoff234123";
		DiffIndexesPair result = new DiffIndexesPair(example,actual);
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(2, parts.length);
		//left part
		assertEquals("abc", parts[0]);
		//right part
		assertEquals("123", parts[1]);
		
		//middle part
		parts = exampleIndexes.getDifferences(example);
		assertEquals("bloff", parts[0]);
		
		
		assertEquals(3, exampleIndexes.getDiffLeftToRight());
		assertEquals(7, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(10, exampleIndexes.getMatchRightToLeft());
		
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(2, parts.length);
		//left part
		assertEquals("abc", parts[0]);
		//right part
		assertEquals("123", parts[1]);
		//middle part
		parts = actualIndexes.getDifferences(actual);
		assertEquals(1, parts.length);
		assertEquals("scoff234", parts[0]);
		
		
		assertEquals(3, actualIndexes.getDiffLeftToRight());
		assertEquals(10, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(13, actualIndexes.getMatchRightToLeft());
	}

	@Test
	public void testCompareLinesMiddleDiffMismatch() throws Exception {
		String example = "123a2456";
		String actual = "1279a2045";
		DiffIndexesPair result = new DiffIndexesPair(example,actual);
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//left part
		assertEquals("12", parts[0]);
		
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(1, parts.length);
		//right part
		assertEquals("3a2456", parts[0]);
		
		assertEquals(2, exampleIndexes.getDiffLeftToRight());
		assertEquals(7, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(1, exampleIndexes.getMatchRightToLeft());
		
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		//left part
		assertEquals("12", parts[0]);
		
		
		parts = actualIndexes.getDifferences(actual);
		assertEquals(1, parts.length);
		//right part
		assertEquals("79a2045", parts[0]);
		
		
		
		assertEquals(2, actualIndexes.getDiffLeftToRight());
		assertEquals(8, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(1, actualIndexes.getMatchRightToLeft());
	}
	
	
	@Test
	public void testCompareLinesLeftMatch_MiddleMatch() throws Exception {
		String example = "a1";
		String actual = "1279a2045";
		DiffIndexesPair result = new DiffIndexesPair(example,actual);
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//left part
		assertEquals("a", parts[0]);
		
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(1, parts.length);
		//right part
		assertEquals("1", parts[0]);
		
		assertEquals(1, exampleIndexes.getDiffLeftToRight());
		assertEquals(1, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(0, exampleIndexes.getMatchRightToLeft());
		
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		//left part
		assertEquals("a", parts[0]);
		
		
		parts = actualIndexes.getDifferences(actual);
		assertEquals(2, parts.length);
		//left part
		assertEquals("1279", parts[0]);
		//right part
		assertEquals("2045", parts[1]);
		
		
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(8, actualIndexes.getDiffRightToLeft());
		assertEquals(4, actualIndexes.getMatchLeftToRight());
		assertEquals(4, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesMiddleMatch() throws Exception {
		String example = "jscoffde";
		String actual = "abcscoff2";
		DiffIndexesPair result = new DiffIndexesPair(example,actual);
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//middle part
		assertEquals("scoff", parts[0]);
		
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(2, parts.length);
		//left part
		assertEquals("j", parts[0]);
		//right part
		assertEquals("de", parts[1]);
		
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(7, exampleIndexes.getDiffRightToLeft());
		assertEquals(1, exampleIndexes.getMatchLeftToRight());
		assertEquals(5, exampleIndexes.getMatchRightToLeft());
		
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		//middle part
		assertEquals("scoff", parts[0]);
		
		
		parts = actualIndexes.getDifferences(actual);
		assertEquals(2, parts.length);
		//left part
		assertEquals("abc", parts[0]);
		//right part
		assertEquals("2", parts[1]);
		
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(8, actualIndexes.getDiffRightToLeft());
		assertEquals(3, actualIndexes.getMatchLeftToRight());
		assertEquals(7, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesMiddleMatchMismatch() throws Exception {
		String example = "jsabcefde";
		String actual = "abcscoff321";
		DiffIndexesPair result = new DiffIndexesPair(example,actual);
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//middle part
		assertEquals("s", parts[0]);
		
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(2, parts.length);
		//left part
		assertEquals("j", parts[0]);
		//right part
		assertEquals("abcefde", parts[1]);
		
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(8, exampleIndexes.getDiffRightToLeft());
		assertEquals(1, exampleIndexes.getMatchLeftToRight());
		assertEquals(1, exampleIndexes.getMatchRightToLeft());
		
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		//middle part
		assertEquals("s", parts[0]);
		
		
		parts = actualIndexes.getDifferences(actual);
		assertEquals(2, parts.length);
		//left part
		assertEquals("abc", parts[0]);
		//right part
		assertEquals("coff321", parts[1]);
		
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(10, actualIndexes.getDiffRightToLeft());
		assertEquals(3, actualIndexes.getMatchLeftToRight());
		assertEquals(3, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesMiddleMatchMismatchRight() throws Exception {
		String example = "org.abl";
		String actual = "sun.pl";
		DiffIndexesPair result = new DiffIndexesPair(example, actual);
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//right part
		assertEquals("l", parts[0]);
		
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(1, parts.length);
		//left part
		assertEquals("org.ab", parts[0]);
		
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(5, exampleIndexes.getDiffRightToLeft());
		assertEquals(6, exampleIndexes.getMatchLeftToRight());
		assertEquals(6, exampleIndexes.getMatchRightToLeft());
		
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		//right part
		assertEquals("l", parts[0]);
		
		
		parts = actualIndexes.getDifferences(actual);
		assertEquals(1, parts.length);
		//left part
		assertEquals("sun.p", parts[0]);
		
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(4, actualIndexes.getDiffRightToLeft());
		assertEquals(5, actualIndexes.getMatchLeftToRight());
		assertEquals(5, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesLeftMatchDiffLenghts() throws Exception {
		String example = "abce";
		String actual = "abcde";
		DiffIndexesPair result = new DiffIndexesPair(example, actual);
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(2, parts.length);
		//left part
		assertEquals("abc", parts[0]);
		//right part
		assertEquals("e", parts[1]);
		//middle part
		parts = exampleIndexes.getDifferences(example);
		assertEquals(1, parts.length);
		assertEquals("", parts[0]);
		
		assertEquals(3, exampleIndexes.getDiffLeftToRight());
		assertEquals(2, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(3, exampleIndexes.getMatchRightToLeft());
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(2, parts.length);
		//left part
		assertEquals("abc", parts[0]);
		//right part
		assertEquals("e", parts[1]);
		
		
		//middle part
		parts = actualIndexes.getDifferences(actual);
		assertEquals(1, parts.length);
		assertEquals("d", parts[0]);
				
		assertEquals(3, actualIndexes.getDiffLeftToRight());
		assertEquals(3, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(4, actualIndexes.getMatchRightToLeft());
		
		
		
	}
	
	
	
	@Override
	public int getTests() {
		return 12;
	}

	@Override
	public int getAsserts() {
		return 187;
	}

	@Override
	public int getUniqueAsserts() {
		return 118;
	}
}
