package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_AssertsLineText_DependencyGroup;

//TODO look at minCoverage
@SourceFileScope (sourceClass=LineDiffType.class, minCoverage=23.0)
@AllowedDependencies (groups=Tests4J_AssertsLineText_DependencyGroup.class)
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}


	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 9;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 9;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
