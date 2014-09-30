package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.system.shared.report.summary.TestDisplay;
import org.adligo.tests4j.system.shared.report.summary.TestFailedDisplay;
import org.adligo.tests4j.system.shared.report.summary.ThreadDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_SystemSummary_DependencyGroup;
import org.adligo.tests4j_tests.system.shared.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=TestDisplay.class, minCoverage=80.0)
@AllowedDependencies (groups=Tests4J_SystemSummary_DependencyGroup.class)
public class TestDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log = new Tests4J_LogMock();
	private TestDisplay reporter = new TestDisplay(log, new ThreadDisplay(log));
	
	@Override
	public void beforeTests() {
		log.clear();
		log.clearStates();
	}

	
	@Test
	public void testLogOff() {
		
		reporter.onStartingTest("someTrial[0]", "someTest");
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
	}
	
	@Test
	public void testStart() {
		log.setState(TestDisplay.class, true);
		
		reporter.onStartingTest("someTrial[0]", "someTest");
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getStartingTest() + "someTrial[0].someTest",
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(TestDisplay.class));
		
	}
	@Test
	public void testProgressReportLogOff() {
		
		reporter.onTestCompleted("someTrial", "someTest", false);
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
	}
	
	@Test
	public void testSuccess() {
		log.setState(TestDisplay.class, true);
		
		reporter.onTestCompleted("someTrial[0]", "someTest", true);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getTestHeading() + "someTrial[0].someTest" + messages.getPassedEOS(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(TestDisplay.class));
		
	}
	
	
	@Test
	public void testFailedDelegate() {
		log.setState(TestDisplay.class, true);
		log.setState(TestFailedDisplay.class, true);
		
		reporter.onTestCompleted("someTrial[0]", "someTest", false);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getTestHeading() + "someTrial[0].someTest" + messages.getFailedEOS(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(2, log.getStatesSize());
		assertTrue(log.isLogEnabled(TestDisplay.class));
		assertTrue(log.isLogEnabled(TestFailedDisplay.class));
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 22;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 15;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

	
}
