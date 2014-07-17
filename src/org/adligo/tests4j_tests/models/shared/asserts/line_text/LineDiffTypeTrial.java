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
		assertEquals("MISSING_EXAMPLE_LINE", LineDiffType.MISSING_EXAMPLE_LINE.toString());
		assertEquals("MISSING_ACTUAL_LINE", LineDiffType.MISSING_ACTUAL_LINE.toString());
		
	}

	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 5;
	}

	@Override
	public int getUniqueAsserts() {
		return 5;
	}
}
