package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_DiscoveryMemory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithImportOnlyInMethod;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodExceptionBlock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithRefMockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

@SourceFileScope (sourceClass=ClassDependenciesDiscovery.class, minCoverage=81.0)
public class ClassDependenciesDiscoveryTrial extends SourceFileCountingTrial implements I_DiscoveryMemory {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassDependenciesDiscovery crd;
	private Map<String,I_ClassDependencies> depsCache = new HashMap<String, I_ClassDependencies>();
	private I_ClassFilter classFilter = new ClassFilter();
	private I_ClassFilter basicClassFilter;
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(super.getLog());
		
		ClassFilterMutant cfm = new ClassFilterMutant();
		cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
		basicClassFilter = new ClassFilter(cfm);
		
		crd = new ClassDependenciesDiscovery(ccbClassLoader, super.getLog(), this);
		depsCache.clear();
	}
	
	@Test
	public void test001_MockWithNothing() throws Exception {
		String clazzName = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithNothing.class);
		assertEquals(MockWithNothing.class.getName(), cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(2, cdeps.size());
		
		assertHasMockWithNothingCache();
		assertEquals(2, depsCache.size());
	}

	protected void assertHasMockWithNothingCache() {
		String clazzName = MockWithNothing.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		dep = cdeps.get(0);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(1);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(2, cdeps.size());
	}
	
	@Test
	public void test002_MockWithString() throws Exception {
		String clazzName = MockWithString.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithString.class);
		assertEquals(MockWithString.class.getName(), cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		
		assertEquals(3, cdeps.size());
		
		assertHasMockWithStringCache();
		assertEquals(3, depsCache.size());
	}
	
	protected void assertHasMockWithStringCache() {
		String clazzName = MockWithString.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		dep = cdeps.get(0);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(1);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(3, cdeps.size());
	}
	
	@Test
	public void test003_MockWithMethodReturn() throws Exception {
		String clazzName = MockWithMethodReturn.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithMethodReturn.class);
		assertEquals(MockWithMethodReturn.class.getName(), cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		
		assertEquals(3, cdeps.size());
		
		assertHasMockWithMethodReturnCache();
		assertEquals(3, depsCache.size());
	}
	

	protected void assertHasMockWithMethodReturnCache() {
		String clazzName = MockWithMethodReturn.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		
		dep = cdeps.get(0);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(3, cdeps.size());
	}
	
	@Test
	public void test004_MockWithField() throws Exception {
		String clazzName = MockWithField.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithField.class);
		assertEquals(MockWithField.class.getName(), cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		
		assertEquals(4, cdeps.size());
		
		assertHasMockWithFieldCache();
		assertEquals(4, depsCache.size());
	}

	protected void assertHasMockWithFieldCache() {
		String clazzName = MockWithField.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		
		dep = cdeps.get(0);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(2);
		assertEquals(I_System.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		
		dep = cdeps.get(3);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(4, cdeps.size());
	}
	
	@Test
	public void test005_MockWithMethodParams() throws Exception {
		String clazzName = MockWithMethodParams.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithMethodParams.class);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertHasMockWithMethodParamsCache();
		assertEquals(4, depsCache.size());
	}
	
	protected void assertHasMockWithMethodParamsCache() {
		String clazzName = MockWithMethodParams.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(4, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithMethodReturn.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodParams.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(4, deps.size());
	}
	
	@Test
	public void test006_MockWithImportOnlyInMethod() throws Exception {
		String clazzName = MockWithImportOnlyInMethod.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithImportOnlyInMethod.class);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertHasMockWithImportOnlyInMethodCache();
		assertEquals(4, depsCache.size());
	}
	
	protected void assertHasMockWithImportOnlyInMethodCache() {
		String clazzName = MockWithImportOnlyInMethod.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		dep = deps.get(String.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(I_System.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithImportOnlyInMethod.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(4, deps.size());
	}
	
	@Test
	public void test007_MockWithStaticFeild() throws Exception {
		String clazzName = MockWithStaticField.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithStaticField.class);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
	
		assertHasMockWithStaticFieldCache();
		assertEquals(3, depsCache.size());
	}
	
	protected void assertHasMockWithStaticFieldCache() {
		String clazzName = MockWithStaticField.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithStaticField.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	
	@Test
	public void test008_MockWithStaticInitalizer() throws Exception {
		String clazzName = MockWithStaticInitalizer.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithStaticInitalizer.class);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
	
		assertHasMockWithStaticInitalizerCache();
		assertEquals(3, depsCache.size());
	}
	
	protected void assertHasMockWithStaticInitalizerCache() {
		String clazzName = MockWithStaticInitalizer.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithStaticInitalizer.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	@Test
	public void test009_MockWithArray() throws Exception {
		String clazzName = MockWithArray.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithArray.class);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
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
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
	
		assertHasMockWithArrayCache();
		assertEquals(3, depsCache.size());
	}
	

	protected void assertHasMockWithArrayCache() {
		String clazzName = MockWithArray.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithArray.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	@Test
	public void test010_MockWithMethodException() throws Exception {
		String clazzName = MockWithMethodException.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithMethodException.class);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(Exception.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(MockException.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(4);
		assertNotNull(dep);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertHasMockWithMethodExceptionCache();
		assertEquals(5, depsCache.size());
	}
	
	protected void assertHasMockWithMethodExceptionCache() {
		String clazzName = MockWithMethodException.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(Exception.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockException.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodException.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(5, deps.size());
	}
	
	@Test
	public void test011_MockWithMethodExceptionBlock() throws Exception {
		String clazzName = MockWithMethodExceptionBlock.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithMethodExceptionBlock.class);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(Exception.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(MockException.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(4);
		assertNotNull(dep);
		assertEquals(MockWithMethodException.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(5);
		assertNotNull(dep);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertHasMockWithMethodExceptionBlockCache();
		assertEquals(6, depsCache.size());
	}
	
	protected void assertHasMockWithMethodExceptionBlockCache() {
		String clazzName = MockWithMethodExceptionBlock.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(4, dep.getReferences());
		
		dep = deps.get(Exception.class.getName());
		assertNotNull(dep);
		assertEquals(4, dep.getReferences());
		
		dep = deps.get(MockException.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());

		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithMethodException.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodExceptionBlock.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(6, deps.size());
	}
	
	@Test
	@IgnoreTest
	public void test012_MockWithAbstractMethodReturn() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test013_MockWithAbstractMethodParam() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test014_MockWithExtensionA() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test015_MockWithExtensionB() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test016_MockI_GetLong() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test017_MockI_SetLong() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test018_MockI_GetString() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test019_MockI_SetString() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test020_MockI_GetAndSetLong() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test021_MockI_GetAndSetString() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test022_MockI_StringAndLong() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test023_MockI_OtherStringAndLong() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test024_MockWithBidirectionalA() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test025_MockWithBidirectionalB() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test026_MockWithTriangleA() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test027_MockWithTriangleB() throws Exception {
	}
	@Test
	@IgnoreTest
	public void test028_MockWithTriangleC() throws Exception {
		
	}
	@Test
	@IgnoreTest
	public void test100_MockWithEverything() throws Exception {
		String clazzName = MockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithEverything.class);
		assertEquals(MockWithEverything.class.getName(), cd.getClassName());
		cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));

		assertHasMockWithEverythingCache();
		assertEquals(31, depsCache.size());
	}

	protected void assertHasMockWithEverythingCache() {
		assertHasMockWithNothingCache();
		assertHasMockWithMethodReturnCache();
		assertHasMockWithFieldCache();
		assertHasMockWithImportOnlyInMethodCache();
		assertHasMockWithStaticFieldCache();
		assertHasMockWithStaticInitalizerCache();
		assertHasMockWithArrayCache();
		assertHasMockWithMethodExceptionCache();
		assertHasMockWithMethodExceptionBlockCache();
		assertHasMockWithAbstractMethodExceptionCache();
		assertHasMockWithAbstractMethodParamCache();
		assertHasMockWithAbstractMethodReturnCache();
		
		assertHasMockWithBidirectionalACache();
		assertHasMockWithBidirectionalBCache();
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		String clazzName = MockWithEverything.class.getName();
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		List<I_Dependency> deps = cd.getDependencies();
		assertEquals(clazzName, cd.getClassName());
		assertNotNull(deps);
		Map<String, I_Dependency> dmap = new HashMap<String, I_Dependency>();
		for (I_Dependency d: deps) {
			dmap.put(d.getClassName(), d);
		}
		int counter = 0;
		I_Dependency top = dmap.get(Object.class.getName());
		assertNotNull(top);
		assertEquals(80, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(counter++));
		
		
		top = dmap.get(MockWithNothing.class.getName());
		assertNotNull(top);
		assertEquals(27, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(counter++));
		
		top = dmap.get(Exception.class.getName());
		assertNotNull(top);
		assertEquals(11, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(counter++));
		
		top = dmap.get(MockException.class.getName());
		assertNotNull(top);
		assertEquals(10, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(counter++));

		//C is here because it is referenced from MockWithEverything directly
		top = dmap.get(MockWithTriangleC.class.getName());
		assertNotNull(top);
		assertEquals(6, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(counter++));
		
		DependencyAssertHelper adh = new DependencyAssertHelper();
		int result = adh.calc(cd, 6);
		assertEquals(counter, result);
		
		Set<String> fives = adh.getClassNames(5);
		assertContains(fives, MockWithTriangleA.class.getName());
		assertContains(fives, MockWithTriangleB.class.getName());
		assertContains(fives, MockWithMethodReturn.class.getName());
		assertContains(fives, String.class.getName());
		assertContains(fives, I_System.class.getName());
		assertContains(fives, MockWithBidirectionalA.class.getName());
		assertEquals(6, fives.size());
		
		Set<String> fours = adh.getClassNames(4);
		assertContains(fours, MockWithMethodException.class.getName());
		assertContains(fours, MockWithBidirectionalB.class.getName());
		assertEquals(2, fours.size());
		
		Set<String> threes = adh.getClassNames(3);
		assertContains(threes, PrintStream.class.getName());
		assertContains(threes, System.class.getName());
		assertContains(threes, StringBuilder.class.getName());
		assertContains(threes, MockWithStaticField.class.getName());
		assertEquals(4, threes.size());
		
		Set<String> twos = adh.getClassNames(2);
		assertContains(twos, Class.class.getName());
		assertContains(twos, Math.class.getName());
		assertContains(twos, MockWithArray.class.getName());
		assertContains(twos, MockWithMethodExceptionBlock.class.getName());
		assertContains(twos, MockWithMethodParams.class.getName());
		assertContains(twos, MockWithField.class.getName());
		assertContains(twos, MockWithImportOnlyInMethod.class.getName());
		assertContains(twos, MockWithAbstractMethodParam.class.getName());
		assertContains(twos, MockWithAbstractMethodException.class.getName());
		assertContains(twos, MockWithStaticInitalizer.class.getName());
		assertContains(twos, MockWithString.class.getName());
		assertContains(twos, MockWithAbstractMethodReturn.class.getName());
		assertEquals(12, twos.size());
		
		Set<String> ones = adh.getClassNames(1);
		assertContains(ones, clazzName);
		assertContains(ones, clazzName + "$1");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void assertHasMockWithAbstractMethodExceptionCache() {
		String clazzName = MockWithAbstractMethodException.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(Exception.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockException.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());

		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithAbstractMethodException.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(5, deps.size());
	}

	
	protected void assertHasMockWithAbstractMethodParamCache() {
		String clazzName = MockWithAbstractMethodParam.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithAbstractMethodReturnCache() {
		String clazzName = MockWithAbstractMethodReturn.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithBidirectionalACache() {
		String clazzName = MockWithBidirectionalA.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());
		
		dep = deps.get(MockWithBidirectionalB.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithBidirectionalBCache() {
		String clazzName = MockWithBidirectionalB.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());

		dep = deps.get(MockWithBidirectionalA.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithTriangleACache() {
		String clazzName = MockWithTriangleA.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(3, dep.getReferences());

		dep = deps.get(MockWithTriangleB.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithTriangleC.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(4, deps.size());
	}
	
	protected void assertHasMockWithTriangleBCache() {
		String clazzName = MockWithTriangleB.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(3, dep.getReferences());
		
		dep = deps.get(MockWithTriangleA.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithTriangleC.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(4, deps.size());
	}
	
	protected void assertHasMockWithTriangleCCache() {
		String clazzName = MockWithTriangleC.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(Object.class.getName());
		assertNotNull(dep);
		assertEquals(3, dep.getReferences());

		dep = deps.get(MockWithTriangleA.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithTriangleB.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(4, deps.size());
	}
	@Test
	@IgnoreTest
	public void test300_RefToMockWithEverything() throws Exception {
		String clazzName = MockWithRefMockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithRefMockWithEverything.class);
		assertEquals(clazzName, cd.getClassName());
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
		assertHasMockWithEverythingCache();
		I_ClassDependencies cdeps = depsCache.get(clazzName);
		assertNotNull(cdeps);
		assertEquals(clazzName, cdeps.getClassName());
		
		List<I_Dependency> deps = cd.getDependencies();
		Map<String,I_Dependency> dmap = new HashMap<String,I_Dependency>();
		for (I_Dependency d: deps) {
			dmap.put(d.getClassName(), d);
		}
		
		I_Dependency top = dmap.get(MockWithNothing.class.getName());
		assertNotNull(top);
		assertEquals(15, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(0));
		
		top = dmap.get(MockException.class.getName());
		assertNotNull(top);
		assertEquals(4, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(1));
		
		top = dmap.get(MockWithMethodReturn.class.getName());
		assertNotNull(top);
		assertEquals(3, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(2));
		
		//can't assert the order of the 1 references
		top = dmap.get(MockWithArray.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithMethodExceptionBlock.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithMethodParams.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithField.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithImportOnlyInMethod.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithStaticInitalizer.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithAbstractMethodException.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithAbstractMethodReturn.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithAbstractMethodParam.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithEverything.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithEverything.class.getName() + "$1");
		assertNotNull(top);
		assertEquals(0, top.getReferences());
		
		top = dmap.get(MockWithRefMockWithEverything.class.getName());
		assertNotNull(top);
		assertEquals(0, top.getReferences());
		
		assertHasMockWithEverythingCache();
		assertEquals(18, depsCache.size());
	}
	
	@Override
	public int getTests() {
		return 30;
	}

	@Override
	public int getAsserts() {
		return 292;
	}

	@Override
	public int getUniqueAsserts() {
		return 167;
	}
	@Override
	public void putIfAbsent(I_ClassDependencies p) {
		depsCache.put(p.getClassName(),  p);
	}
	@Override
	public I_ClassDependencies get(String name) {
		return depsCache.get(name);
	}

	@Override
	public boolean isFiltered(Class<?> clazz) {
		return classFilter.isFiltered(clazz);
	}

	@Override
	public boolean isFiltered(String className) {
		return classFilter.isFiltered(className);
	}

	@Override
	public I_ClassFilter getBasicClassFilter() {
		return basicClassFilter;
	}
}
