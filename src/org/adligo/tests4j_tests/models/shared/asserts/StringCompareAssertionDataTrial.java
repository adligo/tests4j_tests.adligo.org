package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.StringCompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.Diffndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_LineDiff;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffMutant;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLinesCompareResult;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=StringCompareAssertionData.class)
public class StringCompareAssertionDataTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				StringCompareAssertionData.STRING_COMPARE_ASSERTION_DATA_REQUIRES_A_I_TEXT_LINES_COMPARE_RESULT)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new StringCompareAssertionData(new CompareAssertionData<String>("hey", "hey"), null);
					}
				});
		
	}
	
	@Test
	public void testConstructorAndGetters() {
		List<I_LineDiff> diffs = new ArrayList<I_LineDiff>();
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setIndexes(new DiffIndexesPair(new Diffndexes(3, 3), new Diffndexes(3, 3)));
		diffs.add(ldm);
		I_TextLinesCompareResult result =  
				new TextLinesCompareResult(new TextLines("hey", true), 
				new TextLines("hey2", true), false, diffs);
		StringCompareAssertionData data = new StringCompareAssertionData(
				new CompareAssertionData<String>("hey", "hey2"), result);
		assertEquals("hey", data.getExpected());
		assertEquals("hey2", data.getActual());
		Set<String> keys = data.getKeys();
		assertNotNull(keys);
		assertEquals(3, keys.size());
		assertContains(keys, CompareAssertionData.EXPECTED);
		assertContains(keys, CompareAssertionData.ACTUAL);
		assertContains(keys, StringCompareAssertionData.COMPARISON);
		
		assertEquals("hey", data.getData(CompareAssertionData.EXPECTED));
		assertEquals("hey2", data.getData(CompareAssertionData.ACTUAL));
		assertSame(result, data.getData(StringCompareAssertionData.COMPARISON));
		
		assertEquals("hey", data.getTypedData(CompareAssertionData.EXPECTED));
		assertEquals("hey2", data.getTypedData(CompareAssertionData.ACTUAL));
	
	}
	
	@Test
	public void testEqualsAndHashCode() {
		List<I_LineDiff> diffs = new ArrayList<I_LineDiff>();
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setIndexes(new DiffIndexesPair(new Diffndexes(3, 3), new Diffndexes(3, 3)));
		diffs.add(ldm);
		I_TextLinesCompareResult result =  
				new TextLinesCompareResult(new TextLines("hey", true), 
				new TextLines("hey2", true), false, diffs);
		StringCompareAssertionData a = new StringCompareAssertionData(
				new CompareAssertionData<String>("hey", "hey2"), result);
		

		StringCompareAssertionData b = new StringCompareAssertionData(
				new CompareAssertionData<String>("hey2", "hey"), result);
		
		
		StringCompareAssertionData c = new StringCompareAssertionData(
				new CompareAssertionData<String>("hey", "hey2"), result);
		
		I_TextLinesCompareResult result2 =  
				new TextLinesCompareResult(new TextLines("hey2", true), 
				new TextLines("hey", true), false, diffs);
		
		StringCompareAssertionData d = new StringCompareAssertionData(
				new CompareAssertionData<String>("hey", "hey2"), result2);
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, new Object());
	}
	

	@Test
	public void testToString() {
		List<I_LineDiff> diffs = new ArrayList<I_LineDiff>();
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setIndexes(new DiffIndexesPair(new Diffndexes(3, 3), new Diffndexes(3, 3)));
		diffs.add(ldm);
		I_TextLinesCompareResult result =  
				new TextLinesCompareResult(new TextLines("hey", true), 
				new TextLines("hey2", true), false, diffs);
		StringCompareAssertionData a = new StringCompareAssertionData(
				new CompareAssertionData<String>("hey", "hey2"), result);
		assertEquals("StringCompareAssertionData [comparison=TextLinesCompareResult "
				+ "[example=TextLines [lines=[hey]], actual=TextLines [lines=[hey2]], "
				+ "matched=false, lineDiffs=[LineDiffMutant [type=null, exampleLineNbr=0, "
				+ "actualLineNbr=null]]], expected=hey, actual=hey2]", a.toString());
	}
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(84.0, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 23;
	}

	@Override
	public int getUniqueAsserts() {
		return 14;
	}
}
