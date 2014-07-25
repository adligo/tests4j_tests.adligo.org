package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineDiffType.class, minCoverage=94.0)
public class LineDiffTypeTrial extends SourceFileCountingTrial {

	
	@Test
	public void testTypes() {
		assertEquals(4, LineDiffType.values().length);
		assertEquals("MATCH", LineDiffType.MATCH.toString());
		assertEquals("PARTIAL_MATCH", LineDiffType.PARTIAL_MATCH.toString());
		assertEquals("MISSING_EXPECTED_LINE", LineDiffType.MISSING_EXPECTED_LINE.toString());
		assertEquals("MISSING_ACTUAL_LINE", LineDiffType.MISSING_ACTUAL_LINE.toString());
		
	}

	@Test
	public void testLookup() {
		MockLineDiffType mock  = new MockLineDiffType();
		mock.setId(LineDiffType.MATCH.getId());
		assertSame(LineDiffType.MATCH, LineDiffType.get(mock));
		mock.setId(LineDiffType.PARTIAL_MATCH.getId());
		assertSame(LineDiffType.PARTIAL_MATCH, LineDiffType.get(mock));
		mock.setId(LineDiffType.MISSING_ACTUAL_LINE.getId());
		assertSame(LineDiffType.MISSING_ACTUAL_LINE, LineDiffType.get(mock));
		mock.setId(LineDiffType.MISSING_EXPECTED_LINE.getId());
		assertSame(LineDiffType.MISSING_EXPECTED_LINE, LineDiffType.get(mock));
		
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
