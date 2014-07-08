package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import java.util.Iterator;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_LineDiff;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffMutant;
import org.adligo.tests4j.models.shared.asserts.line_text.LineDiffType;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineDiffMutant.class)
public class LineDiffMutantTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				LineDiffMutant.LINE_NUMBERS_MUST_BE_NEGATIVE_ONE_OR_GREATER)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new LineDiffMutant(new I_LineDiff() {
							
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
							public int getExampleLineNbr() {
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
						new LineDiffMutant(new I_LineDiff() {
							
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
							public int getExampleLineNbr() {
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
	public void testSetterExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				LineDiffMutant.LINE_NUMBERS_MUST_BE_NEGATIVE_ONE_OR_GREATER)),
				new I_Thrower() {
					
					@Override
					public void run() {
						LineDiffMutant ldm = new LineDiffMutant();
						ldm.setExampleLineNbr(-2);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				LineDiffMutant.LINE_NUMBERS_MUST_BE_NEGATIVE_ONE_OR_GREATER)),
				new I_Thrower() {
					
					@Override
					public void run() {
						LineDiffMutant ldm = new LineDiffMutant();
						ldm.setActualLineNbr(-2);
					}
				});
	}
	
	@Test
	public void testConstructorAndGetterSetters() {
		LineDiffMutant ldm = new LineDiffMutant();
		assertNull(ldm.getType());
		assertNull(ldm.getActualLineNbr());
		assertEquals(0, ldm.getExampleLineNbr());
		assertNull(ldm.getIndexes());
		
		ldm.setType(LineDiffType.PARTIAL_MATCH);
		ldm.setActualLineNbr(1);
		ldm.setExampleLineNbr(0);
		DiffIndexesPair pair = new DiffIndexesPair(new DiffIndexes(0, 1) , new DiffIndexes(1, 2));
		ldm.setIndexes(pair);
		
		assertEquals(LineDiffType.PARTIAL_MATCH, ldm.getType());
		assertEquals(1, ldm.getActualLineNbr());
		assertEquals(0, ldm.getExampleLineNbr());
		assertSame(pair, ldm.getIndexes());
		
		LineDiffMutant ldm2 = new LineDiffMutant(ldm);
		assertEquals(LineDiffType.PARTIAL_MATCH, ldm2.getType());
		assertEquals(1, ldm2.getActualLineNbr());
		assertEquals(0, ldm2.getExampleLineNbr());
		assertSame(pair, ldm2.getIndexes());
	}
	
	@Test
	public void testComparable() {
		TreeSet<I_LineDiff> ordered = new TreeSet<I_LineDiff>();
		LineDiffMutant ldm0 = new LineDiffMutant();
		ldm0.setExampleLineNbr(0);
		ordered.add(ldm0);
		
		LineDiffMutant ldm1 = new LineDiffMutant();
		ldm1.setExampleLineNbr(1);
		ordered.add(ldm1);
		
		LineDiffMutant ldm2 = new LineDiffMutant();
		ldm2.setExampleLineNbr(2);
		ordered.add(ldm2);
		
		assertEquals(3, ordered.size());
		Iterator<I_LineDiff> it =  ordered.iterator();
		assertSame(ldm0, it.next());
		assertSame(ldm1, it.next());
		assertSame(ldm2, it.next());
		
		LineDiffMutant ldm1_5 = new LineDiffMutant();
		ldm1_5.setExampleLineNbr(1);
		ldm1_5.setActualLineNbr(5);
		ordered.add(ldm1_5);
		
		LineDiffMutant ldm1_6 = new LineDiffMutant();
		ldm1_6.setExampleLineNbr(1);
		ldm1_6.setActualLineNbr(6);
		ordered.add(ldm1_6);
		
		assertEquals(5, ordered.size());
		it =  ordered.iterator();
		assertSame(ldm0, it.next());
		assertSame(ldm1, it.next());
		assertSame(ldm1_5, it.next());
		assertSame(ldm1_6, it.next());
		assertSame(ldm2, it.next());
	}
	
	@Test
	public void testEqualsHashCode() {
		LineDiffMutant a = new LineDiffMutant();
		LineDiffMutant b = new LineDiffMutant();
		b.setExampleLineNbr(1);
		
		LineDiffMutant c = new LineDiffMutant();
		LineDiffMutant d = new LineDiffMutant();
		d.setActualLineNbr(1);
		LineDiffMutant e = new LineDiffMutant();
		e.setType(LineDiffType.MATCH);
		
		assertEquals(a,a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a,b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a,c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a,d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a,e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}

	
	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 36;
	}

	@Override
	public int getUniqueAsserts() {
		return 20;
	}
}
