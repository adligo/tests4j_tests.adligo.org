package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassParentsDiscovery;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

public interface I_ClassParentsDiscoveryTrial extends I_Trial {

	public abstract I_ClassFilter getBasicClassFilter();

	public abstract CachedClassBytesClassLoader getCcbClassLoader();

	public abstract ClassParentsDiscovery getClassParentsDiscovery();

	public abstract Map<String, I_ClassParentsLocal> getParentsCache();

	public abstract ClassFilter getClassFilter();

	public abstract Tests4J_LogMock getLogMock();

	public abstract I_ClassFilter getPrimitiveClassFilter();

	public CPDT_Assert_Simple getSimple();
	
	public CPDT_Assert_Linear_to_20 getLinearTo20();
}