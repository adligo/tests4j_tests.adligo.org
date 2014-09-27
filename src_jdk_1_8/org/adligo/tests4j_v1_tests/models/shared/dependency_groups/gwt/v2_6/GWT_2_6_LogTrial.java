package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Log;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Log;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.MethodSignature;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=GWT_2_6_Log.class, minCoverage=99.0)
public class GWT_2_6_LogTrial extends SourceFileCountingTrial {

	private GWT_2_6_LogDelegates delegates;
	
	public GWT_2_6_LogTrial() {
		delegates = new GWT_2_6_LogDelegates(this);
	}
	@Test
	public void testFormatter() {
		I_ClassAttributes result = GWT_2_6_Log.getFormatter();
		assertEquals(JSE_Log.FORMATTER, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateFormatterMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(6, ms.size());
	}

	@Test
	public void testHandler() {
		I_ClassAttributes result = GWT_2_6_Log.getHandler();
		assertEquals(JSE_Log.HANDLER, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateHandlerMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(12, ms.size());
	}

	@Test
	public void testLevel() {
		I_ClassAttributes result = GWT_2_6_Log.getLevel();
		assertEquals(JSE_Log.LEVEL, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateLevelMemberAsserts(result);
		assertEquals(9, fs.size());
		assertEquals(7, ms.size());
	}

	@Test
	public void testLogManager() {
		I_ClassAttributes result = GWT_2_6_Log.getLogManager();
		assertEquals(JSE_Log.LOG_MANAGER, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateLogManagerMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(8, ms.size());
	}

	@Test
	public void testLogRecord() {
		I_ClassAttributes result = GWT_2_6_Log.getLogRecord();
		assertEquals("java.util.logging.LogRecord", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Log.LEVEL, JSE_Lang.STRING}));
		delegates.delegateLogRecordMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(15, ms.size());
	}

	@Test
	public void testLogger() {
		I_ClassAttributes result = GWT_2_6_Log.getLogger();
		assertEquals(JSE_Log.LOGGER, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateLoggerMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(26, ms.size());
	}


	
	/**keep at the bottom of the file
	 * 
	 */
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 114;
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
