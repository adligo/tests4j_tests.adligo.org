package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;

public class CRDT_Assert_Simple extends TrialDelegate {
	private I_ClassReferencesDiscoveryTrial trial;
	
	public CRDT_Assert_Simple(I_ClassReferencesDiscoveryTrial p) {
		super(p);
		trial = p;
	}

	public void delegate001_MockWithNothing() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery classReferenceDiscovery = trial.getClassReferenceDiscovery();
		
		String className = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = classReferenceDiscovery.discoverAndLoad(MockWithNothing.class);
		
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(2, order.size());
		
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = classReferenceDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		assertEquals(1, deps.size());
		
		I_ClassReferences cr =  classReferenceDiscovery.getReferences(className);
		assertMockWithNothingRefs(className, cr);
	
		assertHasMockWithNothingCache();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		assertEquals(1, refsCache.size());
	}

	public void assertHasMockWithNothingCache() {
		String className = MockWithNothing.class.getName();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		I_ClassReferences refs =  refsCache.get(className);
		assertMockWithNothingRefs(className, refs);
	}

	private void assertMockWithNothingRefs(String className,
			I_ClassReferences refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getClassName());
		assertFalse(refs.hasCircularReferences());
		
		Set<String> refsRefs = refs.getReferences();
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, className);
		assertEquals(2, refsRefs.size());
	}
	
	public void delegate002_MockWithString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery classReferenceDiscovery = trial.getClassReferenceDiscovery();
		
		String className = MockWithString.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = classReferenceDiscovery.discoverAndLoad(MockWithString.class);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(String.class.getName(), order.get(1));
		assertEquals(className, order.get(2));
		assertEquals(3, order.size());
		
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = classReferenceDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		assertEquals(Object.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(2, deps.size());
		
		
		I_ClassReferences cr =  classReferenceDiscovery.getReferences(className);
		assertMockWithStringRefs(className, cr);
		
		assertHasMockWithStringCache();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		assertEquals(1, refsCache.size());
	}
	
	public void assertHasMockWithStringCache() {
		String className = MockWithString.class.getName();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		I_ClassReferences refs =  refsCache.get(className);
		assertMockWithStringRefs(className, refs);
	}

	private void assertMockWithStringRefs(String className,
			I_ClassReferences refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getClassName());
		assertFalse(refs.hasCircularReferences());
		
		Set<String> refsRefs = refs.getReferences();
		assertContains(refsRefs, String.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, className);
		assertEquals(3, refsRefs.size());
	}
	
	public void delegate003_MockException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery classReferenceDiscovery = trial.getClassReferenceDiscovery();
		
		String className = MockException.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = classReferenceDiscovery.discoverAndLoad(MockException.class);
		assertNotNull(order);
		assertEquals(Exception.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(2, order.size());
		
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = classReferenceDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		
		assertEquals(Exception.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		assertEquals(1, deps.size());
		
		I_ClassReferences cr =  classReferenceDiscovery.getReferences(className);
		assertMockExceptionRefs(className, cr);
		
		assertHasMockExceptionCache();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		assertEquals(1, refsCache.size());
	}
	
	public void assertHasMockExceptionCache() {
		String className = MockException.class.getName();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		I_ClassReferences refs =  refsCache.get(className);
		assertMockExceptionRefs(className, refs);
	}

	private void assertMockExceptionRefs(String className,
			I_ClassReferences refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getClassName());
		assertFalse(refs.hasCircularReferences());
		
		Set<String> refsRefs = refs.getReferences();
		assertContains(refsRefs, Exception.class.getName());
		assertContains(refsRefs, className);
		assertEquals(2, refsRefs.size());
	}
	
	public void assertHasAllCache() {
		assertHasMockExceptionCache();
		assertHasMockWithNothingCache();
		assertHasMockWithStringCache();
	}
}
