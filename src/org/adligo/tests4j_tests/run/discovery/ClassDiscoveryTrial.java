package org.adligo.tests4j_tests.run.discovery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.adligo.tests4j.models.shared.system.I_Tests4J_System;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.ClassDiscovery;
import org.adligo.tests4j.run.discovery.I_Dependency;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.discovery.class_discovery_mocks.MockWithEverything;
import org.adligo.tests4j_tests.run.discovery.class_discovery_mocks.MockWithField;
import org.adligo.tests4j_tests.run.discovery.class_discovery_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.discovery.class_discovery_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.discovery.class_discovery_mocks.MockWithNothing;


@SourceFileScope (sourceClass=ClassDiscovery.class, minCoverage=80.0)
public class ClassDiscoveryTrial extends SourceFileCountingTrial {

	@Test
	public void testNothing() {
		List<String> ignoredPackages = new ArrayList<>();
		ignoredPackages.add("java");
		
		ClassDiscovery cd = new ClassDiscovery(ignoredPackages, MockWithNothing.class, getLog());
		PriorityQueue<I_Dependency> deps = cd.getDependencyQueue();
		assertEquals(1, deps.size());
		I_Dependency dep = deps.poll();
		assertEquals(MockWithNothing.class.getName(), dep.getClazzName());
		assertEquals(0, dep.getReferences());
	}
	
	@Test
	public void testField() {
		List<String> ignoredPackages = new ArrayList<>();
		ignoredPackages.add("java");
		
		ClassDiscovery cd = new ClassDiscovery(ignoredPackages, MockWithField.class, getLog());
		PriorityQueue<I_Dependency> deps = cd.getDependencyQueue();
		assertEquals(2, deps.size());
		Map<String, I_Dependency>  results = getDependencieMap(deps);
		
		I_Dependency dep = results.get(I_Tests4J_System.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = results.get(MockWithField.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
	}

	private Map<String, I_Dependency>  getDependencieMap(PriorityQueue<I_Dependency> deps) {
		Map<String, I_Dependency> results = new HashMap<String, I_Dependency>();
		I_Dependency dep = deps.poll();
		while (dep != null) {
			results.put(dep.getClazzName(), dep);
			dep = deps.poll();
		}
		return results;
	}
	
	@Test
	public void testMockWithMethodReturn() {
		List<String> ignoredPackages = new ArrayList<>();
		ignoredPackages.add("java");
		
		ClassDiscovery cd = new ClassDiscovery(ignoredPackages, MockWithMethodReturn.class, getLog());
		PriorityQueue<I_Dependency> deps = cd.getDependencyQueue();
		assertEquals(2, deps.size());
		Map<String, I_Dependency>  results = getDependencieMap(deps);
		
		I_Dependency dep = results.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = results.get(MockWithMethodReturn.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
	}
	
	@Test
	public void testMockWithMethodParams() {
		List<String> ignoredPackages = new ArrayList<>();
		ignoredPackages.add("java");
		
		ClassDiscovery cd = new ClassDiscovery(ignoredPackages, MockWithMethodParams.class, getLog());
		PriorityQueue<I_Dependency> deps = cd.getDependencyQueue();
		assertEquals(3, deps.size());
		Map<String, I_Dependency>  results = getDependencieMap(deps);
		
		I_Dependency dep = results.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = results.get(MockWithMethodReturn.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = results.get(MockWithMethodParams.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
	}
	
	@Test
	public void testMockWithEverything() {
		List<String> ignoredPackages = new ArrayList<>();
		ignoredPackages.add("java");
		
		ClassDiscovery cd = new ClassDiscovery(ignoredPackages, MockWithEverything.class, getLog());
		PriorityQueue<I_Dependency> deps = cd.getDependencyQueue();
		assertEquals(6, deps.size());
		Map<String, I_Dependency>  results = getDependencieMap(deps);
		
		I_Dependency dep = results.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(3, dep.getReferences());
		
		dep = results.get(MockWithMethodReturn.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = results.get(MockWithMethodParams.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = results.get(MockWithField.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = results.get(I_Tests4J_System.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = results.get(MockWithEverything.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
	}
	
	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 33;
	}

	@Override
	public int getUniqueAsserts() {
		return 31;
	}
}
