package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_AssertsLineText_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.line_text.DiffIndexes;
import org.adligo.tests4j.shared.asserts.line_text.I_DiffIndexes;
import org.adligo.tests4j.shared.common.Tests4J_System;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=DiffIndexes.class, minCoverage=95.0)
@AllowedDependencies (groups=Tests4J_AssertsLineText_DependencyGroup.class)
public class DiffIndexesTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.START_END_DIFF_REQUIRES_POSITIVE_INDEXES)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(-1, 0, null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.START_END_DIFF_REQUIRES_POSITIVE_INDEXES)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(0, -1, null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.START_END_DIFF_REQUIRES_POSITIVE_INDEXES)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(0, 0, -1, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.START_END_DIFF_REQUIRES_POSITIVE_INDEXES)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(0, 0, 1, -1);
					}
				});
		

		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.DIFF_LEFT_TO_RIGHT_NEEDS_CORRESPONDING_RIGHT_TO_LEFT_DIFF)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(0, null, 3, 1);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.MATCH_LEFT_TO_RIGHT_NEEDS_CORRESPONDING_RIGHT_TO_LEFT_MATCH)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(0, 1, 3, null);
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.WHEN_THERE_ARE_NO_MATCHES_THE_DIFFS_MUST_BOUND_THE_STRING)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(4, 0, null, null);
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.FOR_LEFT_DIFFS_THE_DIFF_RIGHT_TO_LEFT_MUST_BE_IMMEDIATELY_FOLLOWED_BY_THE_RIGHT_TO_LEFT_MATCH)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(0, 4, 6, 6);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.FOR_LEFT_MATCHES_THE_MATCH_RIGHT_TO_LEFT_MUST_BE_IMMEDIATELY_FOLLOWED_BY_THE_LEFT_TO_RIGHT_DIFF)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(6, 7, 0, 4);
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.MATCH_ERROR_PART_ONE + 
				Tests4J_System.SYSTEM.lineSeperator() +
				DiffIndexes.MATCH_L2R_DIFF_L2R_MATCH_R2L_DIFF_R2L)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(2, 5, 0, 4);
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.MATCH_ERROR_PART_ONE + 
				Tests4J_System.SYSTEM.lineSeperator() +
				DiffIndexes.DIFF_L2R_MATCH_L2R_DIFF_R2L_MATCH_R2L)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(0, 4, 2, 5);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				DiffIndexes.EITHER_THE_MATCH_OF_DIFF_MUST_START_AT_THE_LEFT)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DiffIndexes(1, 4, 5, 5);
					}
				});
	}
	
	@Test
	public void testConstructorAndGettersAndToString() {
		I_DiffIndexes sed = new DiffIndexes(0, 1, null, null);
		assertEquals(0, sed.getDiffLeftToRight());
		assertEquals(1, sed.getDiffRightToLeft());
		assertNull(sed.getMatchLeftToRight());
		assertNull(sed.getMatchRightToLeft());
		assertEquals("DiffIndexes [diffLeftToRight=0, diffRightToLeft=1, matchLeftToRight=null, matchRightToLeft=null]", sed.toString());
		
		
		sed = new DiffIndexes(2, 3, 0, 1);
		assertEquals(2, sed.getDiffLeftToRight());
		assertEquals(3, sed.getDiffRightToLeft());
		assertEquals(0, sed.getMatchLeftToRight());
		assertEquals(1, sed.getMatchRightToLeft());
		assertEquals("DiffIndexes [diffLeftToRight=2, diffRightToLeft=3, matchLeftToRight=0, matchRightToLeft=1]", sed.toString());
		
		sed = new DiffIndexes(2, 2, null, null);
		assertEquals(2, sed.getDiffLeftToRight());
		assertEquals(2, sed.getDiffRightToLeft());
		assertNull(sed.getMatchLeftToRight());
		assertNull(sed.getMatchRightToLeft());
		assertEquals("DiffIndexes [diffLeftToRight=2, diffRightToLeft=2, matchLeftToRight=null, matchRightToLeft=null]", sed.toString());
		
		sed = new DiffIndexes(4, 5, 0, 3);
		assertEquals(4, sed.getDiffLeftToRight());
		assertEquals(5, sed.getDiffRightToLeft());
		assertEquals(0, sed.getMatchLeftToRight());
		assertEquals(3, sed.getMatchRightToLeft());
		assertEquals("DiffIndexes [diffLeftToRight=4, diffRightToLeft=5, matchLeftToRight=0, matchRightToLeft=3]", sed.toString());
		
		
	}

	@Test
	public void testAllNull() {
		//text to the left of this is different;
		I_DiffIndexes sed = new DiffIndexes(null, null, null, null);
		assertNull(sed.getDiffLeftToRight());
		assertNull(sed.getDiffRightToLeft());
		assertNull(sed.getMatchLeftToRight());
		assertNull(sed.getMatchRightToLeft());
		assertTrue(sed.isEmpty());
	}
	
	@Test
	public void testGetLeftDiffsRightMatches() {
		//text to the left of this is different;
		I_DiffIndexes sed = new DiffIndexes(null, null, 0, 0);
		String[] diffs = sed.getDifferences("a");
		assertEquals(0, diffs.length);
		
		String[] matches = sed.getMatches("a");
		assertEquals(1, matches.length);
		assertEquals("a", matches[0]);
		
		//left most char only is different
		sed = new DiffIndexes(0, 0, null, null);
		diffs = sed.getDifferences("a");
		assertEquals(1, diffs.length);
		assertEquals("a", diffs[0]);
		
		matches = sed.getMatches("a");
		assertEquals(0, matches.length);
		
		//left most chars are different
		sed = new DiffIndexes(0, 2, 3, 3);
		diffs = sed.getDifferences("abcd");
		assertEquals(1, diffs.length);
		assertEquals("abc", diffs[0]);
		
		matches = sed.getMatches("abcd");
		assertEquals(1, matches.length);
		assertEquals("d", matches[0]);
	}
	
	@Test
	public void testGetLeftMatchesAndDifferencesNullLine() {
		//text to the right of this is different;
		I_DiffIndexes sed = new DiffIndexes(null, null, 0, 0);
		String[] diffs = sed.getDifferences(null);
		assertEquals(0, diffs.length);
		
		String[] matches = sed.getMatches(null);
		assertEquals(0, matches.length);
	}
	
	
	@Test
	public void testGetLeftMatchesRightDifferent() {
		//text to the right of this is different;
		I_DiffIndexes sed = new DiffIndexes(null, null, 0, 0);
		String[] diffs = sed.getDifferences("a");
		assertEquals(0, diffs.length);
		
		String[] matches = sed.getMatches("a");
		assertEquals(1, matches.length);
		assertEquals("a", matches[0]);
		
		//right most char only is different
		sed = new DiffIndexes(1, 1, 0, 0);
		diffs = sed.getDifferences("ab");
		assertEquals(1, diffs.length);
		assertEquals("b", diffs[0]);
		
		matches = sed.getMatches("ab");
		assertEquals(1, matches.length);
		assertEquals("a", matches[0]);
		
		//right most chars are different
		sed = new DiffIndexes(2, 3, 0, 1);
		diffs = sed.getDifferences("abcd");
		assertEquals(1, diffs.length);
		assertEquals("cd", diffs[0]);
		
		matches = sed.getMatches("abcd");
		assertEquals(1, matches.length);
		assertEquals("ab", matches[0]);
	}
	
	@Test
	public void testGetMiddleDiff() {
		//middle char is different
		I_DiffIndexes sed = new DiffIndexes(1, 1, 0, 2);
		String[] diffs = sed.getDifferences("abc");
		assertEquals(1, diffs.length);
		assertEquals("b", diffs[0]);
		
		String[] matches = sed.getMatches("abc");
		assertEquals(2, matches.length);
		assertEquals("a", matches[0]);
		assertEquals("c", matches[1]);
		
	}
	
	@Test
	public void testGetMiddleMatches() {
		//middle char is different
		I_DiffIndexes sed = new DiffIndexes(0, 2, 1, 1);
		String[] diffs = sed.getDifferences("abc");
		assertEquals(2, diffs.length);
		assertEquals("a", diffs[0]);
		assertEquals("c", diffs[1]);
		
		
		String[] matches = sed.getMatches("abc");
		assertEquals(1, matches.length);
		assertEquals("b", matches[0]);
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 8);
	}
	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 70;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 47;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
