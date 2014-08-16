package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.HashMap;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.I_ClassReferencesCache;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferencesLocal;

public class ClassReferencesCacheMock implements I_ClassReferencesCache {
	private Map<String, I_ClassReferencesLocal> refs  = new HashMap<String, I_ClassReferencesLocal>();
	
	@Override
	public void putReferencesIfAbsent(I_ClassReferencesLocal p) {
		refs.put(p.getName(), p);
	}

	@Override
	public I_ClassReferencesLocal getReferences(String name) {
		return refs.get(name);
	}
	
	public void clear() {
		refs.clear();
	}
}
