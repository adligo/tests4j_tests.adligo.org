package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import org.adligo.tests4j.models.shared.association.I_ClassParentsLocal;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j.run.helpers.ClassFilter;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_ClassParentsDiscovery;

import java.util.Map;

public interface I_ClassParentsDiscoveryTrial extends I_Trial {

	public abstract CachedClassBytesClassLoader getCcbClassLoader();

	public abstract I_ClassParentsDiscovery getClassParentsDiscovery();

	public abstract Map<String, I_ClassParentsLocal> getParentsCache();

	public abstract ClassFilter getClassFilter();

	public CPDT_Assert_Simple getSimple();
	
	public CPDT_Assert_Linear_to_20 getLinearTo20();
}