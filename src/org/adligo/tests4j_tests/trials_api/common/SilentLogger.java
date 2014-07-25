package org.adligo.tests4j_tests.trials_api.common;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;

public class SilentLogger implements I_Tests4J_Log{

	@Override
	public void log(String p) {
	}

	@Override
	public void onException(Throwable p) {
	}

	@Override
	public boolean isLogEnabled(Class<?> clazz) {
		return false;
	}

	@Override
	public boolean isMainLog() {
		return false;
	}

}
