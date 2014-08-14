package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

public interface I_ClassReferencesDiscoveryTrial extends I_Trial {

	public abstract I_ClassFilter getBasicClassFilter();

	public abstract CachedClassBytesClassLoader getCcbClassLoader();

	public abstract ClassReferencesDiscovery getClassReferenceDiscovery();

	public abstract Map<String, I_ClassReferences> getRefsCache();

	public abstract ClassFilter getClassFilter();

	public abstract Tests4J_LogMock getLogMock();

	public abstract I_ClassFilter getPrimitiveClassFilter();

	public CRDT_Assert_Simple getSimple();
	public CRDT_Assert_Linear_to_10 getLinear_to10();
	public CRDT_Assert_Linear_to_20 getLinear_to20();
	public CRDT_Assert_Linear_to_30 getLinear_to30();
	public CRDT_Assert_Circular_to_10 getCircular_to_10();
	public CRDT_Assert_MockWithEverything getEverythingDelegate();
}