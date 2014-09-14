package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_IO;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_SQL;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
//TODO look at minCoverage again should be 97.0?
@SourceFileScope (sourceClass=GWT_2_6_IO.class, minCoverage=0.0)
public class GWT_2_6_SqlTrial extends SourceFileCountingTrial {
	private GWT_2_6_SqlDelegates delegates;
	
	public GWT_2_6_SqlTrial() {
		delegates = new GWT_2_6_SqlDelegates(this);
	}
	

	@Test
	public void testDate() {
		I_ClassAttributes result = GWT_2_6_SQL.getDate();
		assertEquals("java.sql.Date", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		delegates.delegateDateMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(31, ms.size());
	}

	@Test
	public void testTime() {
		I_ClassAttributes result = GWT_2_6_SQL.getTime();
		assertEquals("java.sql.Time", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		delegates.delegateTimeMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(31, ms.size());
	}

	@Test
	public void testTimestamp() {
		I_ClassAttributes result = GWT_2_6_SQL.getTimestamp();
		assertEquals("java.sql.Timestamp", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		delegates.delegateTimestampMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(37, ms.size());
	}

	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 128;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 2);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 113;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
