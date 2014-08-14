package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;

public class CDDT_Assert_Simple extends TrialDelegate {
	private I_ClassDependenciesDiscoveryTrial trial;
	
	public CDDT_Assert_Simple(I_ClassDependenciesDiscoveryTrial p) {
		super(p);
		trial = p;
	}
	
	public void delegate001_MockWithNothing() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithNothing.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithNothingDeps(className, cd);
		
		assertHasMockWithNothingCache();
		assertEquals(1, depsCache.size());
	}

	public void assertHasMockWithNothingCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithNothing.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithNothingDeps(className, cd);
	}

	private void assertMockWithNothingDeps(String className,
			I_ClassDependencies cd) {
		
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		I_Dependency dep = cdeps.get(0);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(1);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(2, cdeps.size());
	}
	
	public void delegate002_MockWithString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String clazzName = MockWithString.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));

		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithString.class);
		assertTrue(ccbClassLoader.hasCache(clazzName));
		assertMockWithStringDeps(clazzName, cd);
		
		assertHasMockWithStringCache();
		assertEquals(1, depsCache.size());
	}
	
	public void assertHasMockWithStringCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithString.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithStringDeps(className, cd);
	}
	
	private void assertMockWithStringDeps(String className,
			I_ClassDependencies cd) {
		
		assertNotNull(cd);
		assertEquals(MockWithString.class.getName(), cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());

		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(3, cdeps.size());
	}
	
	public void delegate003_MockException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockException.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockException.class);
		assertTrue(ccbClassLoader.hasCache(className));
		assertMockExceptionDeps(className, cd);
		
		assertHasMockExceptionCache();
		assertEquals(1, depsCache.size());
	}

	public void assertHasMockExceptionCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockException.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockExceptionDeps(className, cd);
	}
	
	private void assertMockExceptionDeps(String clazzName,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Exception.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());

		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(2, cdeps.size());
	}
	
	public void assertAllCache() {
		assertHasMockWithNothingCache();
		assertHasMockWithStringCache();
		assertHasMockExceptionCache();
	}
}
