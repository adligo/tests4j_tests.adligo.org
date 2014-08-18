package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineDiffType.class, minCoverage=94.0)
public class LineDiffTypeTrial extends SourceFileCountingTrial {

	
	@Test
	public void testTypes() {
		assertEquals(4, LineDiffType.values().length);
		assertEquals("Match", LineDiffType.Match.toString());
		assertEquals("PartialMatch", LineDiffType.PartialMatch.toString());
		assertEquals("MissingExpectedLine", LineDiffType.MissingExpectedLine.toString());
		assertEquals("MissingActualLine", LineDiffType.MissingActualLine.toString());
		
	}

	@Test
	public void testLookup() {
		MockLineDiffType mock  = new MockLineDiffType();
		mock.setId(LineDiffType.Match.getId());
		assertSame(LineDiffType.Match, LineDiffType.get(mock));
		mock.setId(LineDiffType.PartialMatch.getId());
		assertSame(LineDiffType.PartialMatch, LineDiffType.get(mock));
		mock.setId(LineDiffType.MissingActualLine.getId());
		assertSame(LineDiffType.MissingActualLine, LineDiffType.get(mock));
		mock.setId(LineDiffType.MissingExpectedLine.getId());
		assertSame(LineDiffType.MissingExpectedLine, LineDiffType.get(mock));
		
	}
	
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 9;
	}

	@Override
	public int getUniqueAsserts() {
		return 9;
	}
}
