package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

public class CDDT_Assert_Circular_to_010 extends TrialDelegate {
	private I_ClassDependenciesDiscoveryTrial trial;
	
	public CDDT_Assert_Circular_to_010(I_ClassDependenciesDiscoveryTrial p) {
		super(p);
		trial = p;
	}
	
	public void delegate001_MockWithBidirectionalA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithBidirectionalA.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithBidirectionalA.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithBiADeps(className, cd);
		
		assertHasMockWithBidirectionalACache();
		assertEquals(1, depsCache.size());
	}

	public void assertHasMockWithBidirectionalACache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithBidirectionalA.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithBiADeps(className, cd);
	}
	
	private void assertMockWithBiADeps(String className, I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertTrue(cd.hasCircularReferences());
		
		Set<String> circles = cd.getCircularReferences();
		assertContains(circles, MockWithBidirectionalB.class.getName());
		assertEquals(1, circles.size());
		
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockWithBidirectionalB.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(3, cdeps.size());
	}
	
	public void delegate002_MockWithBidirectionalB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithBidirectionalB.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithBidirectionalB.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithBiBDeps(className, cd);
		
		assertHasMockWithBidirectionalBCache();
		assertEquals(1, depsCache.size());
	}

	public void assertHasMockWithBidirectionalBCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithBidirectionalB.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithBiBDeps(className, cd);
		
	}
	
	private void assertMockWithBiBDeps(String className, I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertTrue(cd.hasCircularReferences());
		
		Set<String> circles = cd.getCircularReferences();
		assertContains(circles, MockWithBidirectionalA.class.getName());
		assertEquals(1, circles.size());
		
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(MockWithBidirectionalA.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(3, cdeps.size());
	}
	

	public void delegate003_MockWithTriangleA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithTriangleA.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithTriangleA.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleDeps(className, cd);
		
		assertHasMockWithTriangleACache();
		assertEquals(1, depsCache.size());
	}
	
	public void assertHasMockWithTriangleACache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithTriangleA.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		
		assertTriangleDeps(className, cd);
	}

	private void assertTriangleDeps(String className, I_ClassDependencies cd) {
		List<String> allTri = new ArrayList<String>();
		allTri.add(MockWithTriangleA.class.getName());
		allTri.add(MockWithTriangleB.class.getName());
		allTri.add(MockWithTriangleC.class.getName());
		allTri.remove(className);
		
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertTrue(cd.hasCircularReferences());
		Set<String> circles = cd.getCircularReferences();
		assertContains(circles, allTri.get(0));
		assertContains(circles, allTri.get(1));
		assertEquals(2, circles.size());
		
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(3, dep.getReferences());

		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(MockWithTriangleA.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
			
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockWithTriangleB.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockWithTriangleC.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(4, cdeps.size());
	}
	public void delegate004_MockWithTriangleB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithTriangleB.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithTriangleB.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleDeps(className, cd);
		
		assertHasMockWithTriangleBCache();
		assertEquals(1, depsCache.size());
	}
	
	public void assertHasMockWithTriangleBCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithTriangleB.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertTriangleDeps(className, cd);
	}
	
	
	public void delegate005_MockWithTriangleC() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithTriangleC.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithTriangleC.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleDeps(className, cd);
		
		assertHasMockWithTriangleCCache();
		assertEquals(1, depsCache.size());
	}
	
	public void assertHasMockWithTriangleCCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithTriangleC.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertTriangleDeps(className, cd);
	}
	
	public void assertHasAll() {
		assertHasMockWithBidirectionalACache();
		assertHasMockWithBidirectionalBCache();
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
	}
}
