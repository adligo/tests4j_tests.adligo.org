package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

import java.util.Set;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;

public class MockCachedClassBytesClassLoader extends CachedClassBytesClassLoader {

	public MockCachedClassBytesClassLoader(I_Tests4J_Log pLog,
			Set<String> pPackagesWithoutWarning,
			Set<String> pClassesWithoutWarning) {
		super(pLog, pPackagesWithoutWarning, pClassesWithoutWarning);
	}

	
	public void putBytes(String className, byte [] bytes) {
		super.putBytes(className, bytes);
	}
}
