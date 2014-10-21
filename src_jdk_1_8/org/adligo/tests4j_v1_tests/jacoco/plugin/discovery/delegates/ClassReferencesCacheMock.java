package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.util.HashMap;
import java.util.Map;

import org.adligo.tests4j.models.shared.association.I_ClassAssociationsCache;
import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;

public class ClassReferencesCacheMock implements I_ClassAssociationsCache {
	private Map<String, I_ClassAssociationsLocal> refs  = new HashMap<String, I_ClassAssociationsLocal>();
	
	@Override
	public void putDependenciesIfAbsent(I_ClassAssociationsLocal p) {
		refs.put(p.getName(), p);
	}

	@Override
	public I_ClassAssociationsLocal getDependencies(String name) {
		return refs.get(name);
	}
	
	public void clear() {
		refs.clear();
	}
}
