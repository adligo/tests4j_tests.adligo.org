package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithImportOnlyInMethod;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodExceptionBlock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;

public class CDDT_Assert_Linear_to_010 extends TrialDelegate {
	private I_ClassDependenciesDiscoveryTrial trial;
	
	public CDDT_Assert_Linear_to_010(I_ClassDependenciesDiscoveryTrial p) {
		super(p);
		trial = p;
	}
	
	public void delegate001_MockWithMethodReturn() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithMethodReturn.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithMethodReturn.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithMethodReturnDeps(className, cd);

		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithMethodReturnCache();
		assertEquals(2, depsCache.size());
	}


	public void assertHasMockWithMethodReturnCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithMethodReturn.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithMethodReturnDeps(className, cd);

	}
	
	private void assertMockWithMethodReturnDeps(String className,
			I_ClassDependencies cd) {
		
		assertNotNull(cd);
		assertEquals(MockWithMethodReturn.class.getName(), cd.getClassName());
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
	
	public void delegate002_MockWithField() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithField.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithField.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithFieldDeps(className, cd);
		
		assertHasI_SystemCache();
		assertHasMockWithFieldCache();
		assertEquals(2, depsCache.size());
	}



	public void assertHasI_SystemCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String clazzName = I_System.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		
		dep = cdeps.get(0);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(1);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(2, cdeps.size());
	}
	
	public void assertHasMockWithFieldCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithField.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithFieldDeps(className, cd);
	}
	

	private void assertMockWithFieldDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(MockWithField.class.getName(), cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());

		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(I_System.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(4, cdeps.size());
	}
	public void delegate003_MockWithMethodParams() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithMethodParams.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithMethodParams.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithMethodParamsDeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithMethodReturnCache();
		assertHasMockWithMethodParamsCache();
		assertEquals(3, depsCache.size());
	}

	
	public void assertHasMockWithMethodParamsCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithMethodParams.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithMethodParamsDeps(className, cd);
	}


	private void assertMockWithMethodParamsDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
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
		assertEquals(MockWithMethodReturn.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(4, cdeps.size());
	}
	public void delegate004_MockWithImportOnlyInMethod() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithImportOnlyInMethod.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithImportOnlyInMethod.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithImportOnlyInMethodDeps(className, cd);
		
		assertHasI_SystemCache();
		assertHasMockWithImportOnlyInMethodCache();
		assertEquals(2, depsCache.size());
	}
	
	public void assertHasMockWithImportOnlyInMethodCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithImportOnlyInMethod.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithImportOnlyInMethodDeps(className, cd);
	}

	private void assertMockWithImportOnlyInMethodDeps(String className,
			I_ClassDependencies cd) {
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(I_System.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(4, cdeps.size());
	}
	
	public void delegate005_MockWithStaticFeild() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithStaticField.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithStaticField.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithStaticFieldDeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithStaticFieldCache();
		assertEquals(2, depsCache.size());
	}


	public void assertHasMockWithStaticFieldCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithStaticField.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithStaticFieldDeps(className, cd);
	}
	
	private void assertMockWithStaticFieldDeps(String className,
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
	
	public void delegate006_MockWithStaticInitalizer() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithStaticInitalizer.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithStaticInitalizer.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithStaticInitalizerDeps(className, cd);
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithStaticInitalizerCache();
		assertEquals(2, depsCache.size());
	}

	public void assertHasMockWithStaticInitalizerCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithStaticInitalizer.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithStaticInitalizerDeps(className, cd);
	}
	
	private void assertMockWithStaticInitalizerDeps(String className,
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
	
	
	
	public void delegate007_MockWithArray() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		
		String className = MockWithArray.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithArray.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithArrayDeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithArrayCache();
		assertEquals(2, depsCache.size());
	}

	public void assertHasMockWithArrayCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithArray.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithArrayDeps(className, cd);
	}
	
	private void assertMockWithArrayDeps(String className,
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
	
	@Test
	public void delegate008_MockWithMethodException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		
		String className = MockWithMethodException.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithMethodException.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		
		
		assertMockWithMethodExceptionDeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		simple.assertHasMockExceptionCache();
		assertHasMockWithMethodExceptionCache();
		assertEquals(3, depsCache.size());
	}

	private void assertMockWithMethodExceptionDeps(String className,
			I_ClassDependencies cd ) {
		
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Exception.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());

		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockException.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(4);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(5, cdeps.size());
	}
	
	public void assertHasMockWithMethodExceptionCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithMethodException.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithMethodExceptionDeps(className, cd);
	}
	
	public void delegate009_MockWithMethodExceptionBlock() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithMethodExceptionBlock.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithMethodExceptionBlock.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithMethodExceptionBlockDeps(className, cd);
		
		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockExceptionCache();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithMethodExceptionCache();
		assertHasMockWithMethodExceptionBlockCache();
		assertEquals(4, depsCache.size());
	}

	public void assertHasMockWithMethodExceptionBlockCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithMethodExceptionBlock.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithMethodExceptionBlockDeps(className, cd);
	}
	
	private void assertMockWithMethodExceptionBlockDeps(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Exception.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockException.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());

		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(4);
		assertNotNull(dep);
		assertEquals(MockWithMethodException.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(5);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(6, cdeps.size());
	}
	
	public void delegate010_MockWithAbstractMethodReturn() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockWithAbstractMethodReturn.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithAbstractMethodReturn.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockWithAbstractMethodReturnDeps(className, cd);

		CDDT_Assert_Simple simple = trial.getSimpleAsserts();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithAbstractMethodReturnCache();
		assertEquals(2, depsCache.size());
	}

	
	public void assertHasMockWithAbstractMethodReturnCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockWithAbstractMethodReturn.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockWithAbstractMethodReturnDeps(className, cd);
	}
	
	private void assertMockWithAbstractMethodReturnDeps(String className,
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

	public void assertHasAll() {
		assertHasI_SystemCache();
		assertHasMockWithAbstractMethodReturnCache();
		assertHasMockWithArrayCache();
		assertHasMockWithFieldCache();
		assertHasMockWithImportOnlyInMethodCache();
		assertHasMockWithMethodExceptionBlockCache();
		assertHasMockWithMethodExceptionCache();
		assertHasMockWithMethodParamsCache();
		assertHasMockWithMethodReturnCache();
		assertHasMockWithStaticFieldCache();
		assertHasMockWithStaticInitalizerCache();
	}
}
