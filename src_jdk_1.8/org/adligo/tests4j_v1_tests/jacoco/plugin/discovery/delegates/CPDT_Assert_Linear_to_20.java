package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.util.List;

import org.adligo.tests4j.models.shared.association.I_ClassParents;
import org.adligo.tests4j.models.shared.association.I_ClassParentsLocal;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j.system.shared.trials.TrialDelegate;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_ClassParentsDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

public class CPDT_Assert_Linear_to_20 extends TrialDelegate {
	private I_ClassParentsDiscoveryTrial trial;
	
	public CPDT_Assert_Linear_to_20(I_ClassParentsDiscoveryTrial p) {
		super(p);
		trial = p;
	}

	
	public void delegate012_MockWithExtensionA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		
		I_ClassParentsDiscovery cpd = trial.getClassParentsDiscovery();
		
		Class<?> clazz = MockWithExtensionA.class;
		assertEquals(0, ccbClassLoader.getCacheSize());
		I_ClassParents cps = cpd.findOrLoad(clazz);
		assertMockWithExtensionAParents((I_ClassParentsLocal) cps);
		
		assertTrue(ccbClassLoader.hasCache(Object.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockWithNothing.class.getName()));
		assertTrue(ccbClassLoader.hasCache(clazz.getName()));
		assertEquals(3, ccbClassLoader.getCacheSize());
	}

	private void assertMockWithExtensionAParents(I_ClassParentsLocal cps) {
		CPDT_Assert_Simple simple = trial.getSimple();
		
		assertNotNull(cps);
		Class<?> clazz = MockWithExtensionA.class;
		String className = clazz.getName();
		
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		simple.assertNoParents((I_ClassParentsLocal) parents.get(0), Object.class.getName());
		simple.assertObjectOnlyParents(MockWithNothing.class.getName(), (I_ClassParentsLocal) parents.get(1));
		assertEquals(2, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(MockWithNothing.class.getName(), parentNames.get(1));
		assertEquals(2, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	public void delegate013_MockWithExtensionB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		
		I_ClassParentsDiscovery cpd = trial.getClassParentsDiscovery();
		
		Class<?> clazz = MockWithExtensionB.class;
		assertEquals(0, ccbClassLoader.getCacheSize());
		I_ClassParents cps = cpd.findOrLoad(clazz);
		
		assertMockWithExtensionBParents((I_ClassParentsLocal) cps);
		
		assertTrue(ccbClassLoader.hasCache(Object.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockWithNothing.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockWithExtensionA.class.getName()));
		assertTrue(ccbClassLoader.hasCache(clazz.getName()));
		assertEquals(4, ccbClassLoader.getCacheSize());
	}
	
	private void assertMockWithExtensionBParents(I_ClassParentsLocal cps) {
		CPDT_Assert_Simple simple = trial.getSimple();
		
		assertNotNull(cps);
		Class<?> clazz = MockWithExtensionB.class;
		String className = clazz.getName();
		
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		simple.assertNoParents((I_ClassParentsLocal) parents.get(0), Object.class.getName());
		simple.assertObjectOnlyParents(MockWithNothing.class.getName(), (I_ClassParentsLocal) parents.get(1));
		assertMockWithExtensionAParents((I_ClassParentsLocal) parents.get(2));
		assertEquals(3, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(MockWithNothing.class.getName(), parentNames.get(1));
		assertEquals(MockWithExtensionA.class.getName(), parentNames.get(2));
		assertEquals(3, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	public void delegate018_MockI_GetAndSetLong() throws Exception {
		Class<?> clazz = MockI_GetAndSetLong.class;
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		I_ClassParentsDiscovery classReferenceDiscovery = trial.getClassParentsDiscovery();
		
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassParents cps = classReferenceDiscovery.findOrLoad(clazz);
		assertMockI_GetAndSetLongParents((I_ClassParentsLocal) cps);

		assertTrue(ccbClassLoader.hasCache(MockI_GetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_SetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(className));
		assertEquals(3, ccbClassLoader.getCacheSize());
	}

	public void assertMockI_GetAndSetLongParents(I_ClassParentsLocal cps) {
		CPDT_Assert_Simple simple = trial.getSimple();
		
		assertNotNull(cps);
		Class<?> clazz = MockI_GetAndSetLong.class;
		String className = clazz.getName();
		
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		simple.assertNoParents((I_ClassParentsLocal) parents.get(0), MockI_GetLong.class.getName());
		simple.assertNoParents((I_ClassParentsLocal) parents.get(1), MockI_SetLong.class.getName());
		assertEquals(2, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetLong.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetLong.class.getName(), parentNames.get(1));
		assertEquals(2, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	public void delegate019_MockI_GetAndSetString() throws Exception {
		Class<?> clazz = MockI_GetAndSetString.class;
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		I_ClassParentsDiscovery classReferenceDiscovery = trial.getClassParentsDiscovery();
		
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassParents cps = classReferenceDiscovery.findOrLoad(clazz);
		assertMockI_GetAndSetStringParents((I_ClassParentsLocal) cps);

		assertTrue(ccbClassLoader.hasCache(MockI_GetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_SetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(className));
		assertEquals(3, ccbClassLoader.getCacheSize());
	}
	
	public void assertMockI_GetAndSetStringParents(I_ClassParentsLocal cps) {
		CPDT_Assert_Simple simple = trial.getSimple();
		
		assertNotNull(cps);
		Class<?> clazz = MockI_GetAndSetString.class;
		String className = clazz.getName();
		
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		simple.assertNoParents((I_ClassParentsLocal) parents.get(0), MockI_GetString.class.getName());
		simple.assertNoParents((I_ClassParentsLocal) parents.get(1), MockI_SetString.class.getName());
		assertEquals(2, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetString.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetString.class.getName(), parentNames.get(1));
		assertEquals(2, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	public void delegate020_MockI_StringAndLong() throws Exception {
		Class<?> clazz = MockI_StringAndLong.class;
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		I_ClassParentsDiscovery classReferenceDiscovery = trial.getClassParentsDiscovery();
		
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassParents cps = classReferenceDiscovery.findOrLoad(clazz);
		assertMockI_StringAndLongParents((I_ClassParentsLocal) cps);

		assertTrue(ccbClassLoader.hasCache(MockI_GetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_SetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_GetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_SetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_GetAndSetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_GetAndSetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(className));
		assertEquals(7, ccbClassLoader.getCacheSize());
	}
	
	public void assertMockI_StringAndLongParents(I_ClassParentsLocal cps) {
		CPDT_Assert_Simple simple = trial.getSimple();
		
		assertNotNull(cps);
		Class<?> clazz = MockI_StringAndLong.class;
		String className = clazz.getName();
		
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		simple.assertNoParents((I_ClassParentsLocal) parents.get(0), MockI_GetLong.class.getName());
		simple.assertNoParents((I_ClassParentsLocal) parents.get(1), MockI_SetLong.class.getName());
		assertMockI_GetAndSetLongParents((I_ClassParentsLocal) parents.get(2));
		simple.assertNoParents((I_ClassParentsLocal) parents.get(3), MockI_GetString.class.getName());
		simple.assertNoParents((I_ClassParentsLocal) parents.get(4), MockI_SetString.class.getName());
		assertMockI_GetAndSetStringParents((I_ClassParentsLocal) parents.get(5));
		assertEquals(6, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetLong.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetLong.class.getName(), parentNames.get(1));
		assertEquals(MockI_GetAndSetLong.class.getName(), parentNames.get(2));
		assertEquals(MockI_GetString.class.getName(), parentNames.get(3));
		assertEquals(MockI_SetString.class.getName(), parentNames.get(4));
		assertEquals(MockI_GetAndSetString.class.getName(), parentNames.get(5));
		assertEquals(6, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
}
