package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;

public class DependencyAssertHelper {
	private Map<Integer, Set<String>> results = new HashMap<Integer,Set<String>>();
	
	public DependencyAssertHelper() {}
	
	public int calc(I_ClassDependencies p, int maxRefs) {
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
		Set<Entry<Integer,Set<String>>> entires = results.entrySet();
		int toRet = 0;
		for (Entry<Integer,Set<String>> e: entires) {
			if (e.getKey() >= maxRefs) {
				toRet = toRet + e.getValue().size();
			}
		}
		return toRet;
	}
	
	public Set<String> getClassNames(int references) {
		return results.get(references);
	}
}
