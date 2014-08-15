package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassParentsDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;

public class CPDT_Assert_Simple extends TrialDelegate {
	private I_ClassParentsDiscoveryTrial trial;
	
	public CPDT_Assert_Simple(I_ClassParentsDiscoveryTrial p) {
		super(p);
		trial = p;
	}

	public void delegate001_MockWithNothing() throws Exception {
		delegateObjectOnlyParents(MockWithNothing.class);
	}
	
	public void delegateObjectOnlyParents(Class<?> clazz) throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassParentsDiscovery classReferenceDiscovery = trial.getClassParentsDiscovery();
		
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassParents cps = classReferenceDiscovery.findOrLoad(clazz);
		
		assertObjectOnlyParents(className,(I_ClassParentsLocal) cps);
		
		assertObjectCache();
		assertObjectOnlyParentCache(clazz);
		Map<String,I_ClassParentsLocal> refsCache = trial.getParentsCache();
		assertEquals(2, refsCache.size());
		
		assertTrue(ccbClassLoader.hasCache(clazz.getName()));
		assertEquals(1, ccbClassLoader.getCacheSize());
	}
	
	public void delegateNoParents(Class<?> clazz) throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassParentsDiscovery classReferenceDiscovery = trial.getClassParentsDiscovery();
		
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassParents cps = classReferenceDiscovery.findOrLoad(clazz);
		
		assertNoParents((I_ClassParentsLocal) cps, className);
		
		assertNoParentsCache(clazz);
		Map<String,I_ClassParentsLocal> refsCache = trial.getParentsCache();
		assertEquals(1, refsCache.size());
		
		assertTrue(ccbClassLoader.hasCache(clazz.getName()));
		assertEquals(1, ccbClassLoader.getCacheSize());
	}
	
	public void assertObjectCache() {
		String className = Object.class.getName();
		Map<String,I_ClassParentsLocal> parentsCache = trial.getParentsCache();
		I_ClassParentsLocal cps =  parentsCache.get(className);
		assertNoParents(cps, Object.class.getName());
	}
	
	public void assertNoParentsCache(Class<?> c) {
		String className = c.getName();
		Map<String,I_ClassParentsLocal> parentsCache = trial.getParentsCache();
		I_ClassParentsLocal cps =  parentsCache.get(className);
		assertNoParents(cps, c.getName());
	}

	public void assertNoParents(I_ClassParentsLocal cps, String className) {
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		assertEquals(0, parents.size());
		assertEquals("java.util.Collections$EmptyList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(0, parentNames.size());
		assertEquals("java.util.Collections$EmptyList", parentNames.getClass().getName());
	}
	
	public void assertObjectOnlyParentCache(Class<?> c) {
		String className = c.getName();
		Map<String,I_ClassParentsLocal> parentsCache = trial.getParentsCache();
		I_ClassParentsLocal cps =  parentsCache.get(className);
		
		assertObjectOnlyParents(className, cps);
	}

	public void assertObjectOnlyParents(String className, I_ClassParentsLocal cps) {
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		assertNoParents((I_ClassParentsLocal) parents.get(0), Object.class.getName());
		assertEquals(1, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(1, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	public void delegate002_MockWithString() throws Exception {
		delegateObjectOnlyParents(MockWithString.class);
	}
	
	
	public void delegate003_MockException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassParentsDiscovery classReferenceDiscovery = trial.getClassParentsDiscovery();
		
		Class<?> clazz = MockException.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassParents cps = classReferenceDiscovery.findOrLoad(clazz);
		
		assertExceptionParents(className,(I_ClassParentsLocal) cps);
		
		assertNoParentsCache(Serializable.class);
		assertObjectCache();
		assertThrowableCache();
		assertExceptionCache();
		assertExceptionParentsCache(clazz);
		Map<String,I_ClassParentsLocal> refsCache = trial.getParentsCache();
		assertEquals(5, refsCache.size());
		
		assertTrue(ccbClassLoader.hasCache(clazz.getName()));
		assertEquals(1, ccbClassLoader.getCacheSize());
	}
	
	public void assertThrowableCache() {
		String className = Throwable.class.getName();
		Map<String,I_ClassParentsLocal> parentsCache = trial.getParentsCache();
		I_ClassParents cps =  parentsCache.get(className);
		assertThrowableParents((I_ClassParentsLocal) cps);
	}

	public void assertThrowableParents(I_ClassParentsLocal cps) {
		String className = Throwable.class.getName();
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		assertNoParents((I_ClassParentsLocal) parents.get(0), Object.class.getName());
		assertNoParents((I_ClassParentsLocal) parents.get(1), Serializable.class.getName());
		
		assertEquals(2, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(Serializable.class.getName(), parentNames.get(1));
		
		assertEquals(2, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	public void assertExceptionCache() {
		String className = Exception.class.getName();
		Map<String,I_ClassParentsLocal> parentsCache = trial.getParentsCache();
		I_ClassParentsLocal cps =  parentsCache.get(className);
		assertExceptionParents(cps);
	}

	public void assertExceptionParents(I_ClassParentsLocal cps) {
		String className = Exception.class.getName();
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		assertNoParents((I_ClassParentsLocal) parents.get(0), Object.class.getName());
		assertNoParents((I_ClassParentsLocal) parents.get(1), Serializable.class.getName());
		
		assertThrowableParents((I_ClassParentsLocal) parents.get(2));
		assertEquals(3, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(Serializable.class.getName(), parentNames.get(1));
		
		assertEquals(Throwable.class.getName(), parentNames.get(2));
		assertEquals(3, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	public void assertExceptionParentsCache(Class<?> c) {
		String className = c.getName();
		Map<String,I_ClassParentsLocal> parentsCache = trial.getParentsCache();
		I_ClassParentsLocal cps =  parentsCache.get(className);
		assertExceptionParents(className, (I_ClassParentsLocal) cps);
	}

	public void assertExceptionParents(String className, I_ClassParentsLocal cps) {
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		assertNoParents((I_ClassParentsLocal) parents.get(0), Object.class.getName());
		assertNoParents((I_ClassParentsLocal) parents.get(1), Serializable.class.getName());
		
		assertThrowableParents((I_ClassParentsLocal) parents.get(2));
		assertExceptionParents((I_ClassParentsLocal) parents.get(3));
		assertEquals(4, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(Serializable.class.getName(), parentNames.get(1));
		
		assertEquals(Throwable.class.getName(), parentNames.get(2));
		assertEquals(Exception.class.getName(), parentNames.get(3));
		assertEquals(4, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	

}
