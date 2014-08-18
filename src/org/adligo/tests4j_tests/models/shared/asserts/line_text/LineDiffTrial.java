package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import java.util.Iterator;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_LineDiff;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiff;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffMutant;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineDiff.class)
public class LineDiffTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				LineDiffMutant.LINE_NUMBERS_MUST_BE_NEGATIVE_ONE_OR_GREATER)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new LineDiff(new I_LineDiff() {
							
							@Override
							public int compareTo(I_LineDiff o) {
								return 0;
							}
							
							@Override
							public LineDiffType getType() {
								return null;
							}
							
							@Override
							public I_DiffIndexesPair getIndexes() {
								// TODO Auto-generated method stub
								return null;
							}
							
							@Override
							public int getExpectedLineNbr() {
								return -2;
							}
							
							@Override
							public Integer getActualLineNbr() {
								// TODO Auto-generated method stub
								return null;
							}
						});
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				LineDiffMutant.LINE_NUMBERS_MUST_BE_NEGATIVE_ONE_OR_GREATER)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new LineDiff(new I_LineDiff() {
							
							@Override
							public int compareTo(I_LineDiff o) {
								return 0;
							}
							
							@Override
							public LineDiffType getType() {
								return null;
							}
							
							@Override
							public I_DiffIndexesPair getIndexes() {
								// TODO Auto-generated method stub
								return null;
							}
							
							@Override
							public int getExpectedLineNbr() {
								return -1;
							}
							
							@Override
							public Integer getActualLineNbr() {
								// TODO Auto-generated method stub
								return -2;
							}
						});
					}
				});
	}
	
	@Test
	public void testTypes() {
		LineDiff ld = new LineDiff();
		assertNull(ld.getType());
		assertNull(ld.getActualLineNbr());
		assertEquals(0, ld.getExpectedLineNbr());
		assertNull(ld.getIndexes());
		
		LineDiffMutant ldm = new LineDiffMutant();
		ldm.setType(LineDiffType.PartialMatch);
		ldm.setActualLineNbr(1);
		ldm.setExpectedLineNbr(0);
		DiffIndexesPair pair = new DiffIndexesPair(new DiffIndexes(0, 1, null, null) , new DiffIndexes(1, 2, null, null));
		ldm.setIndexes(pair);
		ld = new LineDiff(ldm);
		
		assertEquals(LineDiffType.PartialMatch, ld.getType());
		assertEquals(1, ld.getActualLineNbr());
		assertEquals(0, ld.getExpectedLineNbr());
		assertSame(pair, ld.getIndexes());
		
	}

	@Test
	public void testComparable() {
		TreeSet<I_LineDiff> ordered = new TreeSet<I_LineDiff>();
		LineDiffMutant ldm0 = new LineDiffMutant();
		ldm0.setExpectedLineNbr(0);
		LineDiff ld0 = new LineDiff(ldm0);
		ordered.add(ld0);
		
		LineDiffMutant ldm1 = new LineDiffMutant();
		ldm1.setExpectedLineNbr(1);
		LineDiff ld1 = new LineDiff(ldm1);
		ordered.add(ld1);
		
		LineDiffMutant ldm2 = new LineDiffMutant();
		ldm2.setExpectedLineNbr(2);
		LineDiff ld2 = new LineDiff(ldm2);
		ordered.add(ld2);
		
		assertEquals(3, ordered.size());
		Iterator<I_LineDiff> it =  ordered.iterator();
		assertSame(ld0, it.next());
		assertSame(ld1, it.next());
		assertSame(ld2, it.next());
	}
	
	@Test
	public void testEqualsHashCodeAndToString() {
		LineDiffMutant a = new LineDiffMutant();
		LineDiffMutant b = new LineDiffMutant();
		b.setExpectedLineNbr(1);
		
		
		assertEquals(new LineDiff(a),new LineDiff(a));
		assertEquals(new LineDiff(a).hashCode(), new LineDiff(a).hashCode());
		assertEquals("LineDiff [type=null, exampleLineNbr=0, actualLineNbr=null]", new LineDiff(a).toString());
		
		assertNotEquals(new LineDiff(a),new LineDiff(b));
		assertNotEquals(new LineDiff(a).hashCode(), new LineDiff(b).hashCode());
		assertEquals("LineDiff [type=null, exampleLineNbr=1, actualLineNbr=null]", new LineDiff(b).toString());
		
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 20;
	}

	@Override
	public int getUniqueAsserts() {
		return 15;
	}
}
