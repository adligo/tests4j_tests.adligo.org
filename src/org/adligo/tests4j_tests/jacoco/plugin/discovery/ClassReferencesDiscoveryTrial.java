package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.system.I_Tests4J_System;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_DiscoveryMemory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;
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
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

@SourceFileScope (sourceClass=ClassReferencesDiscovery.class, minCoverage=89.0)
public class ClassReferencesDiscoveryTrial extends SourceFileCountingTrial implements I_DiscoveryMemory {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassReferencesDiscovery crd;
	private Map<String,I_ClassDependencies> depsCache = new HashMap<String, I_ClassDependencies>();
	private final ClassFilter classFilter = new ClassFilter();
	private Tests4J_LogMock logMock = new Tests4J_LogMock();
	
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(logMock);
		crd = new ClassReferencesDiscovery(ccbClassLoader, logMock, this);
		depsCache.clear();
	}
	
	@Test
	public void test01_MockWithNothing() throws Exception {
		String clazzName = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithNothing.class);
		assertNotNull(order);
		assertContains(order, clazzName);
		assertEquals(1, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, clazzName);
		assertEquals(1, refs.size());
	}

	@Test
	public void test02_MockWithMethodReturn() throws Exception {
		String clazzName = MockWithMethodReturn.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodReturn.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test03_MockWithFeild() throws Exception {
		String clazzName = MockWithField.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithField.class);
		assertNotNull(order);
		assertEquals(I_Tests4J_System.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, I_Tests4J_System.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}

	@Test
	public void test04_MockWithMethodParams() throws Exception {
		String clazzName = MockWithMethodParams.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodParams.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(MockWithMethodReturn.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithMethodReturn.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test05_MockWithImportOnlyInMethod() throws Exception {
		String clazzName = MockWithImportOnlyInMethod.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithImportOnlyInMethod.class);
		assertNotNull(order);
		assertEquals(I_Tests4J_System.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, I_Tests4J_System.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test06_MockWithStaticFeild() throws Exception {
		String clazzName = MockWithStaticField.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithStaticField.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test07_MockWithStaticInitalizer() throws Exception {
		String clazzName = MockWithStaticInitalizer.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithStaticInitalizer.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test08_MockWithArray() throws Exception {
		String clazzName = MockWithArray.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithArray.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	
	@Test
	public void test09_MockWithMethodException() throws Exception {
		String clazzName = MockWithMethodException.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodException.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(MockException.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockException.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test10_MockWithMethodExceptionBlock() throws Exception {
		String clazzName = MockWithMethodExceptionBlock.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodExceptionBlock.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(MockException.class.getName(), order.get(1));
		assertEquals(MockWithMethodException.class.getName(), order.get(2));
		assertEquals(clazzName, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithMethodException.class.getName());
		assertContains(refs, MockException.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test11_MockWithAbstractMethodReturn() throws Exception {
		String clazzName = MockWithAbstractMethodReturn.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithAbstractMethodReturn.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test12_MockWithAbstractMethodParam() throws Exception {
		String clazzName = MockWithAbstractMethodParam.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithAbstractMethodParam.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test13_MockWithAbstractMethodParam() throws Exception {
		String clazzName = MockWithAbstractMethodParam.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithAbstractMethodParam.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test14_MockWithBidirectionalA() throws Exception {
		String clazzName = MockWithBidirectionalA.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithBidirectionalA.class);
		assertNotNull(order);
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalB.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test15_MockWithBidirectionalB() throws Exception {
		String clazzName = MockWithBidirectionalB.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithBidirectionalB.class);
		assertNotNull(order);
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalA.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test16_MockWithTriangleA() throws Exception {
		String clazzName = MockWithTriangleA.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithTriangleA.class);
		assertNotNull(order);
		
		assertEquals(MockWithTriangleC.class.getName(), order.get(0));
		assertEquals(MockWithTriangleB.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleB.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test17_MockWithTriangleB() throws Exception {
		String clazzName = MockWithTriangleB.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithTriangleB.class);
		assertNotNull(order);
		
		assertEquals(MockWithTriangleA.class.getName(), order.get(0));
		assertEquals(MockWithTriangleC.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleC.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test18_MockWithTriangleC() throws Exception {
		String clazzName = MockWithTriangleC.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithTriangleC.class);
		assertNotNull(order);
		
		assertEquals(MockWithTriangleB.class.getName(), order.get(0));
		assertEquals(MockWithTriangleA.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test100_MockWithEverything() throws Exception {
		String clazzName = MockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithEverything.class);
		assertNotNull(order);
		
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(MockException.class.getName(), order.get(1));
		assertEquals(MockWithMethodReturn.class.getName(), order.get(2));
		assertEquals(MockWithTriangleB.class.getName(), order.get(3));
		assertEquals(MockWithTriangleC.class.getName(), order.get(4));
		assertEquals(MockWithTriangleA.class.getName(), order.get(5));
		assertEquals(MockWithMethodException.class.getName(), order.get(6));
		assertEquals(I_Tests4J_System.class.getName(), order.get(7));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(8));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(9));
		assertEquals(MockWithArray.class.getName(), order.get(10));
		assertEquals(MockWithMethodExceptionBlock.class.getName(), order.get(11));
		assertEquals(MockWithMethodParams.class.getName(), order.get(12));
		assertEquals(MockWithField.class.getName(), order.get(13));
		assertEquals(MockWithImportOnlyInMethod.class.getName(), order.get(14));
		assertEquals(MockWithStaticField.class.getName(), order.get(15));
		assertEquals(MockWithAbstractMethodParam.class.getName(), order.get(16));
		assertEquals(MockWithAbstractMethodException.class.getName(), order.get(17));
		assertEquals(MockWithStaticInitalizer.class.getName(), order.get(18));
		assertEquals(MockWithAbstractMethodReturn.class.getName(), order.get(19));
		assertEquals(clazzName + "$1", order.get(20));
		assertEquals(clazzName, order.get(21));
		assertEquals(22, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithMethodReturn.class.getName());
		assertContains(refs, MockWithBidirectionalA.class.getName());
		assertContains(refs, MockWithTriangleC.class.getName());
		assertContains(refs, MockWithArray.class.getName());
		assertContains(refs, MockWithMethodParams.class.getName());
		assertContains(refs, MockWithField.class.getName());
		assertContains(refs, MockWithImportOnlyInMethod.class.getName());
		assertContains(refs, MockWithStaticField.class.getName());
		assertContains(refs, MockWithAbstractMethodParam.class.getName());
		assertContains(refs, MockWithAbstractMethodException.class.getName());
		assertContains(refs, MockWithStaticInitalizer.class.getName());
		assertContains(refs, MockWithAbstractMethodReturn.class.getName());
		assertContains(refs, clazzName + "$1");
		assertContains(refs, clazzName);
		
		assertContains(refs, clazzName);
		assertEquals(15, refs.size());
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
	public int getTests() {
		return 19;
	}

	@Override
	public int getAsserts() {
		return 270;
	}

	@Override
	public int getUniqueAsserts() {
		return 237;
	}
}
