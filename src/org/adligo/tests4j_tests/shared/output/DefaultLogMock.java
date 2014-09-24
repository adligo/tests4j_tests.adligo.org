package org.adligo.tests4j_tests.shared.output;

import org.adligo.tests4j.shared.common.I_System;
import org.adligo.tests4j.shared.output.DefaultLog;

public class DefaultLogMock extends DefaultLog {

	public I_System getSystem() {
		return super.system;
	}
}
