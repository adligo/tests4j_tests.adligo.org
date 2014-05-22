package org.adligo.tests4j_tests.common_mocks;

import org.adligo.tests4j.models.shared.system.I_SystemExit;

public class MockSystemExitor implements I_SystemExit {
	private Integer status;
	
	@Override
	public void doSystemExit(int p) {
		status = p;
	}

	
	public Integer getStatus() {
		return status;
	}
}
