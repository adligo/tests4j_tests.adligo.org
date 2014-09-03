package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.LineSplitter;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineSplitter.class)
public class LineSplitterTrial extends SourceFileCountingTrial {

	
	@Test
	public void testMethods() {
		LineSplitter split = new LineSplitter();
		assertFalse(split.isNewLineChar('c'));
		
		assertTrue(split.isNewLineChar('\n'));
		
		assertTrue(split.isNewLineChar('\r'));
		
		assertFalse(split.isNewLineChar('a'));
		
		assertTrue(split.isNewLineChar('\r'));
		
		assertFalse(split.isNewLineChar('b'));
		
		assertTrue(split.isNewLineChar('\n'));
		
		split.setLastNewLineChar('\n');
		assertTrue(split.isLastCharNewLine());
		assertFalse(split.isMultiCharNewLine('\r'));
		assertFalse(split.isMultiCharNewLine('\n'));
		
		split.setLastNewLineChar('\r');
		assertTrue(split.isLastCharNewLine());
		assertTrue(split.isMultiCharNewLine('\n'));
		assertFalse(split.isMultiCharNewLine('\r'));
		
		split.setLastNewLineChar(null);
		assertFalse(split.isLastCharNewLine());
		assertFalse(split.isMultiCharNewLine('\n'));
		assertFalse(split.isMultiCharNewLine('\n'));
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,18);
		} else {
			return super.getAsserts(type, 16);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 4);
		} else {
			return super.getUniqueAsserts(type, 2);
		}
	}
}
