package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.run.discovery.I_ClassDependencies;
import org.adligo.tests4j.run.discovery.I_Dependency;

public class DependencyAssertHelper {
	private Map<Integer, Set<String>> results = new HashMap<Integer,Set<String>>();
	
	public DependencyAssertHelper(I_ClassDependencies p) {
		List<I_Dependency> deps =  p.getDependencies();
		for (I_Dependency d: deps) {
			int refs = d.getReferences();
			Set<String> names = results.get(refs);
			if (names == null) {
				names = new HashSet<String>();
				results.put(refs, names);
			}
			names.add(d.getClassName());
		}
	}
	
	public Set<String> getClassNames(int references) {
		return results.get(references);
	}
}
