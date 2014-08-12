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
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_DiscoveryMemory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_OtherStringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithRefMockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithImportOnlyInMethod;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodExceptionBlock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;
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
	private I_ClassFilter primitiveClassFilter;
	
	public ClassReferencesDiscoveryTrial() {
		ClassFilterMutant cfm = new ClassFilterMutant();
		cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
		primitiveClassFilter =new ClassFilter(cfm);
		
	}
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(logMock);
		crd = new ClassReferencesDiscovery(ccbClassLoader, logMock, this);
		
		
		depsCache.clear();
	}
	
	@Test
	public void test001_MockWithNothing() throws Exception {
		String clazzName = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithNothing.class);
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}


	@Test
	public void test002_MockWithString() throws Exception {
		String clazzName = MockWithString.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithString.class);
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(String.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, clazzName);
		assertContains(refs, Object.class.getName());
		assertContains(refs, String.class.getName());
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test003_MockWithMethodReturn() throws Exception {
		String clazzName = MockWithMethodReturn.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodReturn.class);
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithNothing.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test004_MockWithFeild() throws Exception {
		String clazzName = MockWithField.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithField.class);
		assertNotNull(order);
		
		//string is first because I_System doesn't reference itself or Object
		// MockWithField -> self(MockWithField super Object) and I_System
		//  I_System -> String ONLY
		assertEquals(String.class.getName(), order.get(0));
		assertEquals(I_System.class.getName(), order.get(1));
		assertEquals(Object.class.getName(), order.get(2));
		assertEquals(clazzName, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, I_System.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, String.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}

	@Test
	public void test005_MockWithMethodParams() throws Exception {
		String clazzName = MockWithMethodParams.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodParams.class);
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithNothing.class.getName(), order.get(1));
		assertEquals(MockWithMethodReturn.class.getName(), order.get(2));
		
		assertEquals(clazzName, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithMethodReturn.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	@Test
	public void test006_MockWithImportOnlyInMethod() throws Exception {
		String clazzName = MockWithImportOnlyInMethod.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithImportOnlyInMethod.class);
		assertNotNull(order);
		assertEquals(String.class.getName(), order.get(0));
		assertEquals(I_System.class.getName(), order.get(1));
		assertEquals(Object.class.getName(), order.get(2));
		assertEquals(clazzName, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, I_System.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, String.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	@Test
	public void test007_MockWithStaticFeild() throws Exception {
		String clazzName = MockWithStaticField.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithStaticField.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test008_MockWithStaticInitalizer() throws Exception {
		String clazzName = MockWithStaticInitalizer.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithStaticInitalizer.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test009_MockWithArray() throws Exception {
		String clazzName = MockWithArray.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithArray.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	
	@Test
	public void test010_MockWithMethodException() throws Exception {
		String clazzName = MockWithMethodException.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodException.class);
		assertNotNull(order);
		//4 counts
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(Exception.class.getName(), order.get(2));
		assertEquals(MockException.class.getName(), order.get(3));
		
		assertEquals(clazzName, order.get(4));
		assertEquals(5, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockException.class.getName());
		assertContains(refs, Exception.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(5, refs.size());
	}
	
	@Test
	public void test011_MockWithMethodExceptionBlock() throws Exception {
		String clazzName = MockWithMethodExceptionBlock.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithMethodExceptionBlock.class);
		assertNotNull(order);
		
		//ok this one is trick, the following actual have a 4 count
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(Exception.class.getName(), order.get(2));
		assertEquals(MockException.class.getName(), order.get(3));
		
		//this has a 2 count
		assertEquals(MockWithMethodException.class.getName(), order.get(4));

		assertEquals(clazzName, order.get(5));
		assertEquals(6, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithMethodException.class.getName());
		assertContains(refs, MockException.class.getName());
		assertContains(refs, Exception.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(6, refs.size());
	}
	
	@Test
	public void test012_MockWithAbstractMethodReturn() throws Exception {
		String clazzName = MockWithAbstractMethodReturn.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithAbstractMethodReturn.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test013_MockWithAbstractMethodParam() throws Exception {
		String clazzName = MockWithAbstractMethodParam.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithAbstractMethodParam.class);
		assertNotNull(order);
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}

	
	@Test
	public void test014_MockWithExtensionA() throws Exception {
		String clazzName = MockWithExtensionA.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithExtensionA.class);
		assertNotNull(order);
		
		//ok in this case Object is not on top as 
		//
		//  MockWithNothing -> selfClass (MockWithNothing) AND -> Object
		// MockWithExtensionA -> selfClass (MockWithExtensionA) AND MockWithNothing
		assertEquals(MockWithNothing.class.getName(), order.get(0)); //2 count
		assertEquals(Object.class.getName(), order.get(1)); //1 count
		assertEquals(clazzName, order.get(2));//zero
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, Object.class.getName());
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test015_MockWithExtensionB() throws Exception {
		String clazzName = MockWithExtensionB.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithExtensionB.class);
		assertNotNull(order);
		
		
		assertEquals(MockWithNothing.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		assertEquals(MockWithExtensionA.class.getName(), order.get(2));
		assertEquals(clazzName, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, Object.class.getName());
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithExtensionA.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	
	/**
	 * sushi anyone?
	 * @throws Exception
	 */
	@Test
	public void test016_MockI_GetLong() throws Exception {
		String clazzName = MockI_GetLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_GetLong.class);
		assertNotNull(order);
		
		
		assertEquals(Long.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, Long.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test017_MockI_SetLong() throws Exception {
		String clazzName = MockI_SetLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_SetLong.class);
		assertNotNull(order);
		
		
		assertEquals(Long.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, Long.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test018_MockI_GetString() throws Exception {
		String clazzName = MockI_GetString.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_GetString.class);
		assertNotNull(order);
		
		
		assertEquals(String.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, String.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test019_MockI_SetString() throws Exception {
		String clazzName = MockI_SetString.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_SetString.class);
		assertNotNull(order);
		
		
		assertEquals(String.class.getName(), order.get(0));
		assertEquals(clazzName, order.get(1));
		assertEquals(2, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, String.class.getName());
		assertContains(refs, clazzName);
		assertEquals(2, refs.size());
	}
	
	@Test
	public void test020_MockI_GetAndSetLong() throws Exception {
		String clazzName = MockI_GetAndSetLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_GetAndSetLong.class);
		assertNotNull(order);
		
		//4 counts
		assertEquals(Long.class.getName(), order.get(0));
		
		//2 counts
		assertEquals(MockI_SetLong.class.getName(), order.get(1));
		assertEquals(MockI_GetLong.class.getName(), order.get(2));
		
		assertEquals(clazzName, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, Long.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	@Test
	public void test021_MockI_GetAndSetString() throws Exception {
		String clazzName = MockI_GetAndSetString.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_GetAndSetString.class);
		assertNotNull(order);
		
		//4 counts
		assertEquals(String.class.getName(), order.get(0));
		
		//2 counts
		assertEquals(MockI_GetString.class.getName(), order.get(1));
		assertEquals(MockI_SetString.class.getName(), order.get(2));
		
		assertEquals(clazzName, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, String.class.getName());
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	@Test
	public void test022_MockI_StringAndLong() throws Exception {
		String clazzName = MockI_StringAndLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_StringAndLong.class);
		assertNotNull(order);
		
		//8 counts
		assertEquals(Long.class.getName(), order.get(0));
		assertEquals(String.class.getName(), order.get(1));
		
		
		//4 counts
		assertEquals(MockI_SetLong.class.getName(), order.get(2));
		assertEquals(MockI_GetString.class.getName(), order.get(3));
		assertEquals(MockI_SetString.class.getName(), order.get(4));
		assertEquals(MockI_GetLong.class.getName(), order.get(5));
		
		
		//2 counts
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(6));
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(7));
		
		
		assertEquals(clazzName, order.get(8));
		assertEquals(9, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, String.class.getName());
		assertContains(refs, Long.class.getName());
		
		
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		
		assertContains(refs, MockI_GetAndSetString.class.getName());
		assertContains(refs, MockI_GetAndSetLong.class.getName());
		
		assertContains(refs, clazzName);
		assertEquals(9, refs.size());
	}
	
	@Test
	public void test023_MockI_OtherStringAndLong() throws Exception {
		String clazzName = MockI_OtherStringAndLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockI_OtherStringAndLong.class);
		assertNotNull(order);
		
		//8 counts
		assertEquals(Long.class.getName(), order.get(0));
		assertEquals(String.class.getName(), order.get(1));
		
		
		//4 counts
		assertEquals(MockI_SetLong.class.getName(), order.get(2));
		assertEquals(MockI_GetString.class.getName(), order.get(3));
		assertEquals(MockI_SetString.class.getName(), order.get(4));
		assertEquals(MockI_GetLong.class.getName(), order.get(5));
		
		
		//2 counts
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(6));
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(7));
		
		
		assertEquals(MockI_StringAndLong.class.getName(), order.get(8));
		assertEquals(clazzName, order.get(9));
		assertEquals(10, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, String.class.getName());
		assertContains(refs, Long.class.getName());
		
		
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		
		assertContains(refs, MockI_GetAndSetString.class.getName());
		assertContains(refs, MockI_GetAndSetLong.class.getName());
		
		assertContains(refs, MockI_StringAndLong.class.getName());
		assertContains(refs, clazzName);
		assertEquals(10, refs.size());
	}
	
	@Test
	public void test024_MockWithBidirectionalA() throws Exception {
		String clazzName = MockWithBidirectionalA.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithBidirectionalA.class);
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(1));
		
		assertEquals(clazzName, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalB.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test025_MockWithBidirectionalB() throws Exception {
		String clazzName = MockWithBidirectionalB.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithBidirectionalB.class);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	@Test
	public void test026_MockWithTriangleA() throws Exception {
		String clazzName = MockWithTriangleA.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithTriangleA.class);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithTriangleC.class.getName(), order.get(1));
		assertEquals(MockWithTriangleB.class.getName(), order.get(2));
		assertEquals(clazzName, order.get(3));
		
		
		
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleB.class.getName());
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	@Test
	public void test027_MockWithTriangleB() throws Exception {
		String clazzName = MockWithTriangleB.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithTriangleB.class);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithTriangleA.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(MockWithTriangleC.class.getName(), order.get(3));
		
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleC.class.getName());
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	@Test
	public void test028_MockWithTriangleC() throws Exception {
		String clazzName = MockWithTriangleC.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithTriangleC.class);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithTriangleB.class.getName(), order.get(1));
		assertEquals(clazzName, order.get(2));
		assertEquals(MockWithTriangleA.class.getName(), order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, MockWithTriangleB.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	
	
	@Test
	public void test100_MockWithEverything() throws Exception {
		String clazzName = MockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithEverything.class);
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(MockWithNothing.class.getName(), order.get(counter++));
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(Long.class.getName(), order.get(counter++));
		assertEquals(MockException.class.getName(), order.get(counter++));
		
		assertEquals(MockI_SetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_SetString.class.getName(), order.get(counter++));
		assertEquals(MockI_GetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetString.class.getName(), order.get(counter++));
		
		
		
		assertEquals(MockWithMethodReturn.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleB.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleC.class.getName(), order.get(counter++));
		assertEquals(MockWithMethodException.class.getName(), order.get(counter++));
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(counter++));
		assertEquals(I_System.class.getName(), order.get(counter++));
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleA.class.getName(), order.get(counter++));
		
		assertEquals(MockWithMethodExceptionBlock.class.getName(), order.get(counter++));
		assertEquals(MockWithStaticField.class.getName(), order.get(counter++));
		
		assertEquals(MockI_StringAndLong.class.getName(), order.get(counter++));
		assertEquals(Exception.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(counter++));
		assertEquals(MockWithExtensionA.class.getName(), order.get(counter++));
		
		assertEquals(MockWithImportOnlyInMethod.class.getName(), order.get(counter++));
		assertEquals(MockWithStaticInitalizer.class.getName(), order.get(counter++));
		
		
		assertEquals(StringBuilder.class.getName(), order.get(counter++));
		assertEquals(PrintStream.class.getName(), order.get(counter++));
		assertEquals(System.class.getName(), order.get(counter++));
		assertEquals(MockWithAbstractMethodReturn.class.getName(), order.get(counter++));
		assertEquals(MockWithArray.class.getName(), order.get(counter++));
		
		assertEquals(MockWithMethodParams.class.getName(), order.get(counter++));
		
		assertEquals(MockWithField.class.getName(), order.get(counter++));
		assertEquals(MockWithAbstractMethodParam.class.getName(), order.get(counter++));
		
		
		assertEquals(MockWithAbstractMethodException.class.getName(), order.get(counter++));
		
		assertEquals(MockWithExtensionB.class.getName(), order.get(counter++));
		assertEquals(MockWithString.class.getName(), order.get(counter++));
		assertEquals(MockI_OtherStringAndLong.class.getName(), order.get(counter++));
		
		assertEquals(Class.class.getName(), order.get(counter++));
		assertEquals(clazzName, order.get(counter++));
		assertEquals(Math.class.getName(), order.get(counter++));
		assertEquals(clazzName + "$1", order.get(counter++));
		
		assertEquals(42, counter);
		assertEquals(42, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		
		assertContains(refs, Object.class.getName());
		assertContains(refs, Class.class.getName());
		assertContains(refs, Math.class.getName());
		
		assertContains(refs, PrintStream.class.getName());
		assertContains(refs, System.class.getName());
		assertContains(refs, String.class.getName());
		assertContains(refs, StringBuilder.class.getName());
		
		assertContains(refs, StringBuilder.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		
		assertContains(refs, MockI_GetAndSetLong.class.getName());
		assertContains(refs, MockI_GetAndSetString.class.getName());
		assertContains(refs, MockI_StringAndLong.class.getName());
		assertContains(refs, MockI_OtherStringAndLong.class.getName());
		
		assertContains(refs, MockWithExtensionA.class.getName());
		assertContains(refs, MockWithExtensionB.class.getName());
		
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
		assertContains(refs, MockWithString.class.getName());
		
		assertContains(refs, clazzName + "$1");
		
		assertContains(refs, clazzName);
		
		assertEquals(42, refs.size());
	}
	
	@Test
	public void test101_MockRefEverything() throws Exception {
		String clazzName = MockWithRefMockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithRefMockWithEverything.class);
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(MockWithNothing.class.getName(), order.get(counter++));
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(Long.class.getName(), order.get(counter++));
		assertEquals(MockException.class.getName(), order.get(counter++));
		
		assertEquals(MockI_SetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_SetString.class.getName(), order.get(counter++));
		assertEquals(MockI_GetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetString.class.getName(), order.get(counter++));
		
		
		
		assertEquals(MockWithMethodReturn.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleB.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleC.class.getName(), order.get(counter++));
		assertEquals(MockWithMethodException.class.getName(), order.get(counter++));
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(counter++));
		assertEquals(I_System.class.getName(), order.get(counter++));
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleA.class.getName(), order.get(counter++));
		
		assertEquals(MockWithMethodExceptionBlock.class.getName(), order.get(counter++));
		assertEquals(MockWithStaticField.class.getName(), order.get(counter++));
		
		assertEquals(MockI_StringAndLong.class.getName(), order.get(counter++));
		assertEquals(Exception.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(counter++));
		assertEquals(MockWithExtensionA.class.getName(), order.get(counter++));
		
		assertEquals(MockWithImportOnlyInMethod.class.getName(), order.get(counter++));
		assertEquals(MockWithStaticInitalizer.class.getName(), order.get(counter++));
		
		
		assertEquals(StringBuilder.class.getName(), order.get(counter++));
		assertEquals(PrintStream.class.getName(), order.get(counter++));
		assertEquals(System.class.getName(), order.get(counter++));
		assertEquals(MockWithAbstractMethodReturn.class.getName(), order.get(counter++));
		assertEquals(MockWithArray.class.getName(), order.get(counter++));
		
		assertEquals(MockWithMethodParams.class.getName(), order.get(counter++));
		
		assertEquals(MockWithField.class.getName(), order.get(counter++));
		assertEquals(MockWithAbstractMethodParam.class.getName(), order.get(counter++));
		
		
		assertEquals(MockWithAbstractMethodException.class.getName(), order.get(counter++));
		
		assertEquals(MockWithExtensionB.class.getName(), order.get(counter++));
		assertEquals(MockWithEverything.class.getName(), order.get(counter++));
		assertEquals(MockWithString.class.getName(), order.get(counter++));
		assertEquals(MockI_OtherStringAndLong.class.getName(), order.get(counter++));
		
		assertEquals(Class.class.getName(), order.get(counter++));
		
		assertEquals(Math.class.getName(), order.get(counter++));
		assertEquals(MockWithEverything.class.getName() + "$1", order.get(counter++));
		assertEquals(clazzName, order.get(counter++));
		
		assertEquals(43, counter);
		assertEquals(43, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertNotNull(cr);
		assertEquals(clazzName, cr.getClassName());
		Set<String> refs = cr.getReferences();
		assertNotNull(refs);
		
		assertContains(refs, Object.class.getName());
		assertContains(refs, Class.class.getName());
		assertContains(refs, Math.class.getName());
		
		assertContains(refs, PrintStream.class.getName());
		assertContains(refs, System.class.getName());
		assertContains(refs, String.class.getName());
		assertContains(refs, StringBuilder.class.getName());
		
		assertContains(refs, StringBuilder.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		
		assertContains(refs, MockI_GetAndSetLong.class.getName());
		assertContains(refs, MockI_GetAndSetString.class.getName());
		assertContains(refs, MockI_StringAndLong.class.getName());
		assertContains(refs, MockI_OtherStringAndLong.class.getName());
		
		assertContains(refs, MockWithExtensionA.class.getName());
		assertContains(refs, MockWithExtensionB.class.getName());
		
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
		assertContains(refs, MockWithString.class.getName());
		
		assertContains(refs, MockWithEverything.class.getName() + "$1");
		assertContains(refs, MockWithEverything.class.getName());
		assertContains(refs, clazzName);
		
		assertEquals(43, refs.size());
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
		return 30;
	}

	@Override
	public int getAsserts() {
		return 608;
	}

	@Override
	public int getUniqueAsserts() {
		return 543;
	}

	@Override
	public I_ClassFilter getBasicClassFilter() {
		return primitiveClassFilter;
	}
}
