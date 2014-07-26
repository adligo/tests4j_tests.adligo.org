package org.adligo.tests4j_tests.shared.report.summary;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.shared.report.summary.AbstractProgressDisplay;

public class MockProgressReporter extends AbstractProgressDisplay {

	protected MockProgressReporter(I_Tests4J_Log pLogger) {
		super(pLogger);
	}

}
