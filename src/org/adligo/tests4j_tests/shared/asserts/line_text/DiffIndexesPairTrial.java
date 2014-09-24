package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_AssertsLineText_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.line_text.DiffIndexes;
import org.adligo.tests4j.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.shared.asserts.line_text.I_DiffIndexes;
import org.adligo.tests4j.shared.asserts.line_text.I_DiffIndexesPair;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=DiffIndexesPair.class, minCoverage=75.0)
@AllowedDependencies (groups=Tests4J_AssertsLineText_DependencyGroup.class)
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
	public void testCompareLinesRightMatch() throws Exception {
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
	public void testCompareLinesRightMatchExpectedLonger() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("rcab", "dab");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(1, exampleIndexes.getDiffRightToLeft());
		assertEquals(2, exampleIndexes.getMatchLeftToRight());
		assertEquals(3, exampleIndexes.getMatchRightToLeft());
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(0, actualIndexes.getDiffRightToLeft());
		assertEquals(1, actualIndexes.getMatchLeftToRight());
		assertEquals(2, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesRightMatchActualLonger() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("cab", "rdab");
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
		assertEquals(1, actualIndexes.getDiffRightToLeft());
		assertEquals(2, actualIndexes.getMatchLeftToRight());
		assertEquals(3, actualIndexes.getMatchRightToLeft());
	}
	@Test
	public void testCompareLinesMatchActualLongerOnLeft() throws Exception {
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
	public void testCompareLinesMatchActualLongerOnRight() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("cab", "cabf");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertNull(exampleIndexes.getDiffLeftToRight());
		assertNull(exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(2, exampleIndexes.getMatchRightToLeft());
		
		assertEquals(3, actualIndexes.getDiffLeftToRight());
		assertEquals(3, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(2, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesMatchExpectedLongerOnLeft() throws Exception {
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
	public void testCompareLinesMatchExpectedLongerOnRight() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("cabf", "cab");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(3, exampleIndexes.getDiffLeftToRight());
		assertEquals(3, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(2, exampleIndexes.getMatchRightToLeft());
		
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
	public void testCompareLinesLeftMatchExampleLonger() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("abce", "aba");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(2, exampleIndexes.getDiffLeftToRight());
		assertEquals(3, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(1, exampleIndexes.getMatchRightToLeft());
		
		assertEquals(2, actualIndexes.getDiffLeftToRight());
		assertEquals(2, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(1, actualIndexes.getMatchRightToLeft());
	}

	@Test
	public void testCompareLinesLeftMatchActualLonger() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("abc", "abde");
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
		assertEquals(3, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(1, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testCompareLinesLeftMatchActualLongerAtLeft_MockWithArray_vs_MockWithMethodReturn_Issue() throws Exception {
		String expected = "Arrayorg.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith";
		String actual = "MethodReturnorg.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith";
		
		DiffIndexesPair result = new DiffIndexesPair(expected, actual);

		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(4, exampleIndexes.getDiffRightToLeft());
		assertEquals(5, exampleIndexes.getMatchLeftToRight());
		assertEquals(69, exampleIndexes.getMatchRightToLeft());
		
		String [] matches = exampleIndexes.getMatches(expected);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		String [] diffs = exampleIndexes.getDifferences(expected);
		assertEquals(1, diffs.length);
		assertEquals("Array", diffs[0]);
		
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(11, actualIndexes.getDiffRightToLeft());
		assertEquals(12, actualIndexes.getMatchLeftToRight());
		assertEquals(76, actualIndexes.getMatchRightToLeft());
		
		matches = actualIndexes.getMatches(actual);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		diffs = actualIndexes.getDifferences(actual);
		assertEquals(1, diffs.length);
		assertEquals("MethodReturn", diffs[0]);
	}
	
	@Test
	public void testCompareLinesLeftMatchExpectedLongerAtLeft_MockWithArray_vs_MockWithMethodReturn_Issue() throws Exception {
		String expected = "MethodReturnorg.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith";
		String actual = "Arrayorg.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith";
		
		DiffIndexesPair result = new DiffIndexesPair(expected, actual);

		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(11, exampleIndexes.getDiffRightToLeft());
		assertEquals(12, exampleIndexes.getMatchLeftToRight());
		assertEquals(76, exampleIndexes.getMatchRightToLeft());
		
		String [] matches = exampleIndexes.getMatches(expected);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		String [] diffs = exampleIndexes.getDifferences(expected);
		assertEquals(1, diffs.length);
		assertEquals("MethodReturn", diffs[0]);
		
		
		assertEquals(0, actualIndexes.getDiffLeftToRight());
		assertEquals(4, actualIndexes.getDiffRightToLeft());
		assertEquals(5, actualIndexes.getMatchLeftToRight());
		assertEquals(69, actualIndexes.getMatchRightToLeft());
		
		matches = actualIndexes.getMatches(actual);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		diffs = actualIndexes.getDifferences(actual);
		assertEquals(1, diffs.length);
		assertEquals("Array", diffs[0]);
	}
	
	@Test
	public void testCompareLinesLeftMatchActualLongerAtRight_MockWithArray_vs_MockWithMethodReturn_Issue() throws Exception {
		String expected = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray";
		String actual = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn";
		
		DiffIndexesPair result = new DiffIndexesPair(expected, actual);

		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(65, exampleIndexes.getDiffLeftToRight());
		assertEquals(69, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(64, exampleIndexes.getMatchRightToLeft());
		
		String [] matches = exampleIndexes.getMatches(expected);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		String [] diffs = exampleIndexes.getDifferences(expected);
		assertEquals(1, diffs.length);
		assertEquals("Array", diffs[0]);
		
		
		assertEquals(65, actualIndexes.getDiffLeftToRight());
		assertEquals(76, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(64, actualIndexes.getMatchRightToLeft());
		
		matches = actualIndexes.getMatches(actual);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		diffs = actualIndexes.getDifferences(actual);
		assertEquals(1, diffs.length);
		assertEquals("MethodReturn", diffs[0]);
	}
	
	@Test
	public void testCompareLinesLeftMatchActualLongerAtRight_MockWithArray_vs_MockWithBidirectionalA_Issue() throws Exception {
		String expected = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray";
		String actual = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA";
		
		DiffIndexesPair result = new DiffIndexesPair(expected, actual);

		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(65, exampleIndexes.getDiffLeftToRight());
		assertEquals(69, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(64, exampleIndexes.getMatchRightToLeft());
		
		String [] matches = exampleIndexes.getMatches(expected);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		String [] diffs = exampleIndexes.getDifferences(expected);
		assertEquals(1, diffs.length);
		assertEquals("Array", diffs[0]);
		
		
		assertEquals(65, actualIndexes.getDiffLeftToRight());
		assertEquals(78, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(64, actualIndexes.getMatchRightToLeft());
		
		matches = actualIndexes.getMatches(actual);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		diffs = actualIndexes.getDifferences(actual);
		assertEquals(1, diffs.length);
		assertEquals("BidirectionalA", diffs[0]);
	}
	
	@Test
	public void testCompareLinesLeftMatchExpectedLongerAtRight_MockWithArray_vs_MockWithMethodReturn_Issue() throws Exception {
		String expected = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn";
		String actual = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray";
		
		DiffIndexesPair result = new DiffIndexesPair(expected, actual);

		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(65, exampleIndexes.getDiffLeftToRight());
		assertEquals(76, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(64, exampleIndexes.getMatchRightToLeft());
		
		String [] matches = exampleIndexes.getMatches(expected);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		String [] diffs = exampleIndexes.getDifferences(expected);
		assertEquals(1, diffs.length);
		assertEquals("MethodReturn", diffs[0]);
		
		
		assertEquals(65, actualIndexes.getDiffLeftToRight());
		assertEquals(69, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(64, actualIndexes.getMatchRightToLeft());
		
		matches = actualIndexes.getMatches(actual);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		diffs = actualIndexes.getDifferences(actual);
		assertEquals(1, diffs.length);
		assertEquals("Array", diffs[0]);
	}
	
	@Test
	public void testCompareLinesLeftMatchExpectedLongerAtRight_MockWithArray_vs_MockWithBidirectionalA_Issue() throws Exception {
		String expected = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA";
		String actual = "org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray";
		
		DiffIndexesPair result = new DiffIndexesPair(expected, actual);

		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(65, exampleIndexes.getDiffLeftToRight());
		assertEquals(78, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(64, exampleIndexes.getMatchRightToLeft());
		
		String [] matches = exampleIndexes.getMatches(expected);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		String [] diffs = exampleIndexes.getDifferences(expected);
		assertEquals(1, diffs.length);
		assertEquals("BidirectionalA", diffs[0]);
		
		
		assertEquals(65, actualIndexes.getDiffLeftToRight());
		assertEquals(69, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(64, actualIndexes.getMatchRightToLeft());
		
		matches = actualIndexes.getMatches(actual);
		assertEquals(1, matches.length);
		assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWith", matches[0]);
		
		diffs = actualIndexes.getDifferences(actual);
		assertEquals(1, diffs.length);
		assertEquals("Array", diffs[0]);
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
	public void testCompareLinesOuterMatchActualLonger() throws Exception {
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
	
	@Test
	public void testCompareLinesOuterMatchExpectedLonger() throws Exception {
		String example = "abcde";
		String actual = "abce";
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
		assertEquals("d", parts[0]);
		
		assertEquals(3, exampleIndexes.getDiffLeftToRight());
		assertEquals(3, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(4, exampleIndexes.getMatchRightToLeft());
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(2, parts.length);
		//left part
		assertEquals("abc", parts[0]);
		//right part
		assertEquals("e", parts[1]);
		
		
		//middle part
		parts = actualIndexes.getDifferences(actual);
		assertEquals(1, parts.length);
		assertEquals("", parts[0]);
				
		assertEquals(3, actualIndexes.getDiffLeftToRight());
		assertEquals(2, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(3, actualIndexes.getMatchRightToLeft());
		
		
		
	}
	
	@Test
	public void testLongTextVsA() {
		String example = "The following actual line of text is missing in the expected lines of text;";
		String actual = "a";
		DiffIndexesPair result = new DiffIndexesPair(example, "a");

		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//middle part
		assertEquals("a", parts[0]);
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(2, parts.length);
		assertEquals("The following ", parts[0]);
		assertEquals("ctual line of text is missing in the expected lines of text;", parts[1]);
		
		assertEquals(0, exampleIndexes.getDiffLeftToRight());
		assertEquals(example.length() -1, exampleIndexes.getDiffRightToLeft());
		assertEquals(14, exampleIndexes.getMatchLeftToRight());
		assertEquals(14, exampleIndexes.getMatchRightToLeft());
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		assertEquals("a", parts[0]);
		
		
		//middle part
		parts = actualIndexes.getDifferences(actual);
		assertEquals(0, parts.length);
				
		assertNull(actualIndexes.getDiffLeftToRight());
		assertNull(actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(0, actualIndexes.getMatchRightToLeft());
	}
	
	@Test
	public void testActualEndCharDiff() {
		String example = "The";
		String actual = "The2";
		DiffIndexesPair result = new DiffIndexesPair(example, actual);

		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//middle part
		assertEquals("The", parts[0]);
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(0, parts.length);
		
		assertNull(exampleIndexes.getDiffLeftToRight());
		assertNull(exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(2, exampleIndexes.getMatchRightToLeft());
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		assertEquals("The", parts[0]);
		
		
		//right
		parts = actualIndexes.getDifferences(actual);
		assertEquals(1, parts.length);
		assertEquals("2", parts[0]);
		
		assertEquals(3, actualIndexes.getDiffLeftToRight());
		assertEquals(3, actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(2, actualIndexes.getMatchRightToLeft());
	}
	
	
	@Test
	public void testExpectedEndCharDiff() {
		String example = "The2";
		String actual = "The";
		DiffIndexesPair result = new DiffIndexesPair(example, actual);

		I_DiffIndexes exampleIndexes = result.getExpected();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		
		String [] parts = exampleIndexes.getMatches(example);
		assertEquals(1, parts.length);
		//left part
		assertEquals("The", parts[0]);
		
		parts = exampleIndexes.getDifferences(example);
		assertEquals(1, parts.length);
		//right part
		assertEquals("2", parts[0]);
				
		assertEquals(3, exampleIndexes.getDiffLeftToRight());
		assertEquals(3, exampleIndexes.getDiffRightToLeft());
		assertEquals(0, exampleIndexes.getMatchLeftToRight());
		assertEquals(2, exampleIndexes.getMatchRightToLeft());
		
		parts = actualIndexes.getMatches(actual);
		assertEquals(1, parts.length);
		assertEquals("The", parts[0]);
		
		
		//right
		parts = actualIndexes.getDifferences(actual);
		assertEquals(0, parts.length);
		
		assertNull(actualIndexes.getDiffLeftToRight());
		assertNull(actualIndexes.getDiffRightToLeft());
		assertEquals(0, actualIndexes.getMatchLeftToRight());
		assertEquals(2, actualIndexes.getMatchRightToLeft());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 28);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 440;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 276;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
