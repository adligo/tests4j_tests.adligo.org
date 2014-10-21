package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.shared.asserts.line_text.LineSplitter;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsLineText_GwtReferenceGroup;

@SourceFileScope (sourceClass=LineSplitter.class)
@AllowedReferences (groups=Tests4J_AssertsLineText_GwtReferenceGroup.class)
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
		return super.getTests(type, 1, true);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 16;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
