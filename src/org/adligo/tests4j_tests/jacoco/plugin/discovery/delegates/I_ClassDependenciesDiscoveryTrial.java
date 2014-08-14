package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassFilter;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;

public interface I_ClassDependenciesDiscoveryTrial extends I_Trial {

	public abstract I_ClassFilter getBasicClassFilter();

	public abstract CachedClassBytesClassLoader getCcbClassLoader();

	public abstract ClassDependenciesDiscovery getClassDepsDiscovery();

	public abstract Map<String, I_ClassDependencies> getDepsCache();
	
	public CDDT_Assert_Simple getSimpleAsserts();
	
	public CDDT_Assert_Linear_to_010 getCDDT_Assert_Linear_to_010();
	public CDDT_Assert_Linear_to_020 getCDDT_Assert_Linear_to_020();
	public CDDT_Assert_Linear_to_030 getCDDT_Assert_Linear_to_030();
	public CDDT_Assert_Circular_to_010 getCDDT_Assert_Circular_to_010();
}