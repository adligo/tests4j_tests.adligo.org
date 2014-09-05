package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

public interface I_DiscoveryApiTrial extends I_Trial {

	public abstract I_ClassFilter getBasicClassFilter();

	public abstract CachedClassBytesClassLoader getCcbClassLoader();

	public abstract OrderedClassDiscovery getOrderedClassDiscovery();

	public abstract Map<String, I_ClassDependenciesLocal> getRefsCache();

	public abstract ClassFilter getClassFilter();

	public abstract Tests4J_LogMock getLogMock();

	public abstract I_ClassFilter getPrimitiveClassFilter();

	public DAT_Assert_Simple getSimple();
	public DAT_Assert_Linear_to_10 getLinear_to10();
	public DAT_Assert_Linear_to_20 getLinear_to20();
	public DAT_Assert_Linear_to_30 getLinear_to30();
	public DAT_Assert_Circular_to_10 getCircular_to_10();
	public DAT_Assert_MockWithEverything getEverythingDelegate();
}