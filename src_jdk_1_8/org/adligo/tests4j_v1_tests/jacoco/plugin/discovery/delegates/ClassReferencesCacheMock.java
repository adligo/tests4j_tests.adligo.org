package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.util.HashMap;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesCache;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;

public class ClassReferencesCacheMock implements I_ClassDependenciesCache {
	private Map<String, I_ClassDependenciesLocal> refs  = new HashMap<String, I_ClassDependenciesLocal>();
	
	@Override
	public void putDependenciesIfAbsent(I_ClassDependenciesLocal p) {
		refs.put(p.getName(), p);
	}

	@Override
	public I_ClassDependenciesLocal getDependencies(String name) {
		return refs.get(name);
	}
	
	public void clear() {
		refs.clear();
	}
}
