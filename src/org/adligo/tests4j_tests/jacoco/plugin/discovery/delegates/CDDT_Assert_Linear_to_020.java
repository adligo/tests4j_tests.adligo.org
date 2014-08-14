package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

public class CDDT_Assert_Linear_to_020 extends TrialDelegate {
	private I_ClassDependenciesDiscoveryTrial trial;
	
	public CDDT_Assert_Linear_to_020(I_ClassDependenciesDiscoveryTrial p) {
		super(p);
		trial = p;
	}
	
	public void delegate011_MockWithAbstractMethodParam() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithAbstractMethodParam.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithAbstractMethodParam.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithAbstractMethodParamDeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithAbstractMethodParamCache();
		assertEquals(2, depsCache.size());
	}

	public void assertHasMockWithAbstractMethodParamCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithAbstractMethodParam.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithAbstractMethodParamDeps(className, cd);
	}
	
	private void assertMockWithAbstractMethodParamDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(3, cdeps.size());
	}
	
	
	public void delegate012_MockWithExtensionA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithExtensionA.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithExtensionA.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithExtensionADeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithExtensionACache();
		assertEquals(2, depsCache.size());
		
	}
	
	public void assertHasMockWithExtensionACache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithExtensionA.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithExtensionADeps(className, cd);
	}

	private void assertMockWithExtensionADeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(3, cdeps.size());
	}

	
	public void delegate013_MockWithExtensionB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithExtensionB.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithExtensionB.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithExtensionBDeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithExtensionACache();
		assertHasMockWithExtensionBCache();
		assertEquals(3, depsCache.size());
	}

	public void assertHasMockWithExtensionBCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithExtensionB.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithExtensionBDeps(className, cd);
	}
	
	private void assertMockWithExtensionBDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockWithExtensionA.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(4, cdeps.size());
	}
	
	public void delegate014_MockI_GetLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_GetLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_GetLong.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertGetOrSetLongDeps(className, cd);
		assertHasMockI_GetLongCache();
		assertEquals(1, depsCache.size());
	}

	public void assertHasMockI_GetLongCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_GetLong.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertGetOrSetLongDeps(className, cd);
	}
	
	public void delegate015_MockI_SetLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_SetLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_SetLong.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertGetOrSetLongDeps(className, cd);
		
		assertHasMockI_SetLongCache();
		assertEquals(1, depsCache.size());
	}
	
	public void assertHasMockI_SetLongCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_SetLong.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertGetOrSetLongDeps(className, cd);
	}
	
	private void assertGetOrSetLongDeps(String className, I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Long.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(2, cdeps.size());
	}
	
	public void delegate016_MockI_GetString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_GetString.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_GetString.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertGetOrSetStringDeps(className, cd);
		
		assertHasMockI_GetStringCache();
		assertEquals(1, depsCache.size());
	}
	
	public void assertHasMockI_GetStringCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_GetString.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertGetOrSetStringDeps(className, cd);
	}
	
	public void delegate017_MockI_SetString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_SetString.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_SetString.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertGetOrSetStringDeps(className, cd);
		
		assertHasMockI_SetStringCache();
		assertEquals(1, depsCache.size());
	}
	
	public void assertHasMockI_SetStringCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_SetString.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertGetOrSetStringDeps(className, cd);
	}
	
	
	private void assertGetOrSetStringDeps(String className, I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(2, cdeps.size());
	}
	public void delegate018_MockI_GetAndSetLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_GetAndSetLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_GetAndSetLong.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockI_GetAndSetLongDeps(className, cd);
		
		assertHasMockI_GetLongCache();
		assertHasMockI_SetLongCache();
		assertHasMockI_GetAndSetLongCache();
		assertEquals(3, depsCache.size());
	}

	public void assertHasMockI_GetAndSetLongCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_GetAndSetLong.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockI_GetAndSetLongDeps(className, cd);
	}
	
	private void assertMockI_GetAndSetLongDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Long.class.getName(), dep.getClassName());
		assertEquals(3, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(MockI_GetLong.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockI_SetLong.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(4, cdeps.size());
	}
	

	public void delegate019_MockI_GetAndSetString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_GetAndSetString.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_GetAndSetString.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockI_GetAndSetStringDeps(className, cd);
		
		assertHasMockI_GetStringCache();
		assertHasMockI_SetStringCache();
		assertHasMockI_GetAndSetStringCache();
		assertEquals(3, depsCache.size());
	}

	public void assertHasMockI_GetAndSetStringCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_GetAndSetString.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockI_GetAndSetStringDeps(className, cd);
	}
	
	private void assertMockI_GetAndSetStringDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(3, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(MockI_GetString.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockI_SetString.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(4, cdeps.size());
	}
	

	public void delegate020_MockI_StringAndLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_StringAndLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_StringAndLong.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockI_StringAndLongDeps(className, cd);
		
		assertHasMockI_GetStringCache();
		assertHasMockI_SetStringCache();
		assertHasMockI_GetAndSetStringCache();
		assertHasMockI_GetLongCache();
		assertHasMockI_SetLongCache();
		assertHasMockI_GetAndSetLongCache();
		assertHasMockI_StringAndLongCache();
		assertEquals(7, depsCache.size());
	}

	public void assertHasMockI_StringAndLongCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_StringAndLong.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockI_StringAndLongDeps(className, cd);
	}
	private void assertMockI_StringAndLongDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Long.class.getName(), dep.getClassName());
		assertEquals(6, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(6, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockI_GetLong.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(MockI_GetString.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(4);
		assertNotNull(dep);
		assertEquals(MockI_SetLong.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(5);
		assertNotNull(dep);
		assertEquals(MockI_SetString.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(6);
		assertNotNull(dep);
		assertEquals(MockI_GetAndSetLong.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(7);
		assertNotNull(dep);
		assertEquals(MockI_GetAndSetString.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		
		
		dep = cdeps.get(8);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(9, cdeps.size());
	}
	
	public void assertHasAll() {
		assertHasMockWithAbstractMethodParamCache();
		assertHasMockWithExtensionACache();
		assertHasMockWithExtensionBCache();
		
		assertHasMockI_GetLongCache();
		assertHasMockI_GetStringCache();
		
		assertHasMockI_SetLongCache();
		assertHasMockI_SetStringCache();
		
		assertHasMockI_GetAndSetLongCache();
		assertHasMockI_GetAndSetStringCache();
		
		assertHasMockI_StringAndLongCache();
	}
}
