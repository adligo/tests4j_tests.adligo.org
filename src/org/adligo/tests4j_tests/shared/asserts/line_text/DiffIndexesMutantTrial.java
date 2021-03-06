package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.shared.asserts.line_text.DiffIndexesMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsLineText_GwtReferenceGroup;

@SourceFileScope (sourceClass=DiffIndexesMutant.class, minCoverage=54.0)
@AllowedReferences (groups=Tests4J_AssertsLineText_GwtReferenceGroup.class)
public class DiffIndexesMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorAndGets() {
		DiffIndexesMutant dim = new DiffIndexesMutant();
		assertNull(dim.getDiffLeftToRight());
		assertNull(dim.getDiffRightToLeft());
		assertNull(dim.getMatchLeftToRight());
		assertNull(dim.getMatchRightToLeft());
		
		dim = new DiffIndexesMutant(0, 2, 1, 1);
		assertEquals(0, dim.getDiffLeftToRight());
		assertEquals(2, dim.getDiffRightToLeft());
		assertEquals(1, dim.getMatchLeftToRight());
		assertEquals(1, dim.getMatchRightToLeft());
	}
	@Test
	public void testRejustifyHappyNoModifyCases() {
		//middle match
		DiffIndexesMutant dim = new DiffIndexesMutant(0, 2, 1, 1);
		dim.rejustify("abc");
		assertEquals(0, dim.getDiffLeftToRight());
		assertEquals(2, dim.getDiffRightToLeft());
		assertEquals(1, dim.getMatchLeftToRight());
		assertEquals(1, dim.getMatchRightToLeft());
		
		//middle diff
		dim = new DiffIndexesMutant(1, 1, 0, 2);
		dim.rejustify("abc");
		assertEquals(1, dim.getDiffLeftToRight());
		assertEquals(1, dim.getDiffRightToLeft());
		assertEquals(0, dim.getMatchLeftToRight());
		assertEquals(2, dim.getMatchRightToLeft());
		
		
		//left diff
		dim = new DiffIndexesMutant(0, 1, 2, 3);
		dim.rejustify("abcd");
		assertEquals(0, dim.getDiffLeftToRight());
		assertEquals(1, dim.getDiffRightToLeft());
		assertEquals(2, dim.getMatchLeftToRight());
		assertEquals(3, dim.getMatchRightToLeft());
		
		//right diff
		dim = new DiffIndexesMutant(2, 3, 0, 1);
		dim.rejustify("abcd");
		assertEquals(2, dim.getDiffLeftToRight());
		assertEquals(3, dim.getDiffRightToLeft());
		assertEquals(0, dim.getMatchLeftToRight());
		assertEquals(1, dim.getMatchRightToLeft());
	}
	
	@Test
	public void testRejustifyLeftMatch() {
		DiffIndexesMutant dim = new DiffIndexesMutant(1, 4, 0, 3);
		dim.rejustify("abcde");
		assertEquals(1, dim.getDiffLeftToRight());
		assertEquals(4, dim.getDiffRightToLeft());
		assertEquals(0, dim.getMatchLeftToRight());
		assertEquals(0, dim.getMatchRightToLeft());
	}
	
	
	@Test
	public void testRejustifyLeftDiff() {
		DiffIndexesMutant dim = new DiffIndexesMutant(0, 3, 1, 4);
		dim.rejustify("abcde");
		assertEquals(0, dim.getDiffLeftToRight());
		assertEquals(3, dim.getDiffRightToLeft());
		assertEquals(4, dim.getMatchLeftToRight());
		assertEquals(4, dim.getMatchRightToLeft());
	}
	
	@Test
	public void testRejustifyRightToLeftMatch() {
		DiffIndexesMutant dim = new DiffIndexesMutant(2, 8, 0, 8);
		dim.rejustify("abcdefghi");
		assertEquals(2, dim.getDiffLeftToRight());
		assertEquals(8, dim.getDiffRightToLeft());
		assertEquals(0, dim.getMatchLeftToRight());
		assertEquals(1, dim.getMatchRightToLeft());
	}
	
	
	@Test
	public void testRejustifyLeftMatch_2_7_0_6() {
		DiffIndexesMutant dim = new DiffIndexesMutant(2, 7, 0, 6);
		dim.rejustify("abcdefgh");
		assertEquals(2, dim.getDiffLeftToRight());
		assertEquals(7, dim.getDiffRightToLeft());
		assertEquals(0, dim.getMatchLeftToRight());
		assertEquals(1, dim.getMatchRightToLeft());
	}
	
	@Test
	public void testRejustifyLeftDiff_0_5_3_6() {
		DiffIndexesMutant dim = new DiffIndexesMutant(0,5,3,6);
		dim.rejustify("abcdefghi");
		assertEquals(0, dim.getDiffLeftToRight());
		assertEquals(5, dim.getDiffRightToLeft());
		assertEquals(6, dim.getMatchLeftToRight());
		assertEquals(8, dim.getMatchRightToLeft());
	}
	
	@Test
	public void testRejustifyCrossMatch_0_1_0_0() {
		DiffIndexesMutant dim = new DiffIndexesMutant(0,1,0,0);
		dim.rejustify("a1");
		assertEquals(1, dim.getDiffLeftToRight());
		assertEquals(1, dim.getDiffRightToLeft());
		assertEquals(0, dim.getMatchLeftToRight());
		assertEquals(0, dim.getMatchRightToLeft());
	}
	
	@Test
	public void testRejustifyCrossMatch_0_1_0_1() {
		DiffIndexesMutant dim = new DiffIndexesMutant(0,1,0,1);
		dim.rejustify("a1");
		assertEquals(1, dim.getDiffLeftToRight());
		assertEquals(1, dim.getDiffRightToLeft());
		assertEquals(0, dim.getMatchLeftToRight());
		assertEquals(0, dim.getMatchRightToLeft());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 9, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 52;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 30;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
