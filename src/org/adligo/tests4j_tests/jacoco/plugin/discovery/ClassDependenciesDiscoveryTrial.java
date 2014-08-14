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
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_DiscoveryMemory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CDDT_Assert_Circular_to_010;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CDDT_Assert_Linear_to_010;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CDDT_Assert_Linear_to_020;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CDDT_Assert_Linear_to_030;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CDDT_Assert_Simple;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.I_ClassDependenciesDiscoveryTrial;
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
public class ClassDependenciesDiscoveryTrial extends SourceFileCountingTrial implements I_DiscoveryMemory, I_ClassDependenciesDiscoveryTrial {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassDependenciesDiscovery classDepsDiscovery;
	private Map<String,I_ClassDependencies> depsCache = new HashMap<String, I_ClassDependencies>();
	private I_ClassFilter classFilter = new ClassFilter();
	private I_ClassFilter basicClassFilter;
	private CDDT_Assert_Simple simple;
	private CDDT_Assert_Linear_to_010 linearTo0010;
	private CDDT_Assert_Linear_to_020 linearTo0020;
	private CDDT_Assert_Linear_to_030 linearTo0030;
	private CDDT_Assert_Circular_to_010 circularTo10;
	
	public ClassDependenciesDiscoveryTrial() {
		simple = new CDDT_Assert_Simple(this);
		linearTo0010 = new CDDT_Assert_Linear_to_010(this);
		linearTo0020 = new CDDT_Assert_Linear_to_020(this);
		linearTo0030 = new CDDT_Assert_Linear_to_030(this);
		circularTo10 = new CDDT_Assert_Circular_to_010(this);
	}
	
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(super.getLog());
		
		ClassFilterMutant cfm = new ClassFilterMutant();
		cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
		basicClassFilter = new ClassFilter(cfm);
		
		classDepsDiscovery = new ClassDependenciesDiscovery(ccbClassLoader, super.getLog(), this);
		depsCache.clear();
	}
	
	@Test
	public void test0001_MockWithNothing() throws Exception {
		simple.delegate001_MockWithNothing();
	}
	
	@Test
	public void test0002_MockWithString() throws Exception {
		simple.delegate002_MockWithString();
	}
	
	@Test
	public void test0003_MockException() throws Exception {
		simple.delegate003_MockException();
	}
	
	/**
	 * 000-020 are reserved for simple tests of a single dependency
	 * @throws Exception
	 */
	@Test
	public void test1001_MockWithMethodReturn() throws Exception {
		linearTo0010.delegate001_MockWithMethodReturn();
	}
	
	@Test
	public void test1002_MockWithField() throws Exception {
		linearTo0010.delegate002_MockWithField();
	}

	@Test
	public void test1003_MockWithMethodParams() throws Exception {
		linearTo0010.delegate003_MockWithMethodParams();
	}
	
	@Test
	public void test1004_MockWithImportOnlyInMethod() throws Exception {
		linearTo0010.delegate004_MockWithImportOnlyInMethod();
	}
	
	@Test
	public void test1005_MockWithStaticFeild() throws Exception {
		linearTo0010.delegate005_MockWithStaticFeild();
	}
	
	@Test
	public void test1006_MockWithStaticInitalizer() throws Exception {
		linearTo0010.delegate006_MockWithStaticInitalizer();
	}
	
	@Test
	public void test1007_MockWithArray() throws Exception {
		linearTo0010.delegate007_MockWithArray();
	}
	
	@Test
	public void test1008_MockWithMethodException() throws Exception {
		linearTo0010.delegate008_MockWithMethodException();
	}
	
	@Test
	public void test1009_MockWithMethodExceptionBlock() throws Exception {
		linearTo0010.delegate009_MockWithMethodExceptionBlock();
	}
	
	@Test
	public void test1010_MockWithAbstractMethodReturn() throws Exception {
		linearTo0010.delegate010_MockWithAbstractMethodReturn();
	}
	
	@Test
	public void test1011_MockWithAbstractMethodParam() throws Exception {
		linearTo0020.delegate011_MockWithAbstractMethodParam();
	}
	
	@Test
	public void test1012_MockWithExtensionA() throws Exception {
		linearTo0020.delegate012_MockWithExtensionA();
	}
	@Test
	@IgnoreTest
	public void test1013_MockWithExtensionB() throws Exception {
		linearTo0020.delegate013_MockWithExtensionB();
	}
	
	@Test
	public void test1014_MockI_GetLong() throws Exception {
		linearTo0020.delegate014_MockI_GetLong();
	}
	
	@Test
	public void test1015_MockI_SetLong() throws Exception {
		linearTo0020.delegate015_MockI_SetLong();
	}
	
	@Test
	public void test1016_MockI_GetString() throws Exception {
		linearTo0020.delegate016_MockI_GetString();
	}
	@Test
	public void test1017_MockI_SetString() throws Exception {
		linearTo0020.delegate017_MockI_SetString();
	}
	@Test
	public void test1018_MockI_GetAndSetLong() throws Exception {
		linearTo0020.delegate018_MockI_GetAndSetLong();
	}
	@Test
	public void test1019_MockI_GetAndSetString() throws Exception {
		linearTo0020.delegate019_MockI_GetAndSetString();
	}
	@Test
	public void test1020_MockI_StringAndLong() throws Exception {
		linearTo0020.delegate020_MockI_StringAndLong();
	}
	@Test
	public void test1021_MockI_OtherStringAndLong() throws Exception {
		linearTo0030.delegate021_MockI_OtherStringAndLong();
	}
	
	@Test
	public void test2001_MockWithBidirectionalA() throws Exception {
		circularTo10.delegate001_MockWithBidirectionalA();
	}
	
	@Test
	public void test2002_MockWithBidirectionalB() throws Exception {
		circularTo10.delegate002_MockWithBidirectionalB();
	}
	
	@Test
	@IgnoreTest
	public void test2003_MockWithTriangleA() throws Exception {
		circularTo10.delegate003_MockWithTriangleA();
	}
	
	@Test
	@IgnoreTest
	public void test2004_MockWithTriangleB() throws Exception {
		circularTo10.delegate004_MockWithTriangleB();
	}
	
	@Test
	@IgnoreTest
	public void test2005_MockWithTriangleC() throws Exception {
		circularTo10.delegate005_MockWithTriangleC();
	}
	
	@Test
	@IgnoreTest
	public void test200_MockWithEverything() throws Exception {
		String clazzName = MockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithEverything.class);
		assertEquals(MockWithEverything.class.getName(), cd.getClassName());
		cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));

		assertHasMockWithEverythingCache();
		assertEquals(31, depsCache.size());
	}

	public void assertHasMockWithEverythingCache() {
		simple.assertAllCache();
		linearTo0010.assertHasAll();
		linearTo0020.assertHasAll();
		linearTo0030.assertHasAll();
		circularTo10.assertHasAll();
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void assertHasMockWithAbstractMethodExceptionCache() {
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

	
	
	
	
	
	
	@Test
	@IgnoreTest
	public void test201_RefToMockWithEverything() throws Exception {
		String clazzName = MockWithRefMockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockWithRefMockWithEverything.class);
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
	public void putDependenciesIfAbsent(I_ClassDependencies p) {
		depsCache.put(p.getClassName(),  p);
	}
	@Override
	public I_ClassDependencies getDependencies(String name) {
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

	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassDependenciesDiscovery#getBasicClassFilter()
	 */
	@Override
	public I_ClassFilter getBasicClassFilter() {
		return basicClassFilter;
	}

	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassDependenciesDiscovery#getCcbClassLoader()
	 */
	@Override
	public CachedClassBytesClassLoader getCcbClassLoader() {
		return ccbClassLoader;
	}

	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassDependenciesDiscovery#getClassDepsDiscovery()
	 */
	@Override
	public ClassDependenciesDiscovery getClassDepsDiscovery() {
		return classDepsDiscovery;
	}

	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassDependenciesDiscovery#getDepsCache()
	 */
	@Override
	public Map<String, I_ClassDependencies> getDepsCache() {
		return depsCache;
	}

	public I_ClassFilter getClassFilter() {
		return classFilter;
	}

	public CDDT_Assert_Simple getSimpleAsserts() {
		return simple;
	}

	@Override
	public CDDT_Assert_Linear_to_010 getCDDT_Assert_Linear_to_010() {
		return linearTo0010;
	}

	@Override
	public CDDT_Assert_Linear_to_020 getCDDT_Assert_Linear_to_020() {
		return linearTo0020;
	}

	@Override
	public CDDT_Assert_Linear_to_030 getCDDT_Assert_Linear_to_030() {
		return linearTo0030;
	}
	
	@Override
	public CDDT_Assert_Circular_to_010 getCDDT_Assert_Circular_to_010() {
		return circularTo10;
	}

	@Override
	public void putReferencesIfAbsent(I_ClassReferences p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I_ClassReferences getReferences(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public int getTests() {
		return 31;
	}

	@Override
	public int getAsserts() {
		return 1202;
	}

	@Override
	public int getUniqueAsserts() {
		return 472;
	}
}
