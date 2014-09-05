package org.adligo.tests4j_tests.trials_api.common;

import org.adligo.tests4j.shared.output.I_Tests4J_Log;

public class Tests4J_LogRunnerMock implements I_Tests4J_Log{

	@Override
	public void log(String p) {
	}

	@Override
	public void onThrowable(Throwable p) {
	}

	@Override
	public boolean isLogEnabled(Class<?> clazz) {
		return false;
	}

	@Override
	public boolean isMainLog() {
		return false;
	}

	@Override
	public String getLineSeperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentThreadName() {
		return " on thread " + this.getClass().getSimpleName() + " ";
	}

}
