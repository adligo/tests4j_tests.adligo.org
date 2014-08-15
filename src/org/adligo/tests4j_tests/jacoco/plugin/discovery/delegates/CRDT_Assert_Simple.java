package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassAlias;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferencesLocal;
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
		
		Class<?> clazz = MockWithNothing.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = classReferenceDiscovery.findOrLoad(clazz);
		
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(2, order.size());
		
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = classReferenceDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		assertEquals(1, deps.size());
		
		I_ClassReferences cr =  classReferenceDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithNothingRefs(className, cr);
	
		assertHasMockWithNothingCache();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(1, refsCache.size());
	}

	public void assertHasMockWithNothingCache() {
		String className = MockWithNothing.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		I_ClassReferences refs =  refsCache.get(className);
		assertMockWithNothingRefs(className, refs);
	}

	private void assertMockWithNothingRefs(String className,
			I_ClassReferences refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularReferences());
		
		Set<String> refsRefs = refs.getReferenceNames();
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, className);
		assertEquals(2, refsRefs.size());
	}
	
	public void delegate002_MockWithString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery classReferenceDiscovery = trial.getClassReferenceDiscovery();
		
		Class<?> clazz = MockWithString.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = classReferenceDiscovery.findOrLoad(clazz);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(Serializable.class.getName(), order.get(1));
		assertEquals(CharSequence.class.getName(), order.get(2));
		assertEquals(Comparable.class.getName(), order.get(3));
		
		assertEquals(String.class.getName(), order.get(4));
		assertEquals(className, order.get(5));
		assertEquals(6, order.size());
		
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = classReferenceDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(2, deps.size());
		
		
		I_ClassReferences cr =  classReferenceDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithStringRefs(className, cr);
		
		assertHasMockWithStringCache();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(1, refsCache.size());
	}
	
	public void assertHasMockWithStringCache() {
		String className = MockWithString.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		I_ClassReferences refs =  refsCache.get(className);
		assertMockWithStringRefs(className, refs);
	}

	private void assertMockWithStringRefs(String className,
			I_ClassReferences refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularReferences());
		
		Set<String> refsRefs = refs.getReferenceNames();
		assertContains(refsRefs, String.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, className);
		assertEquals(3, refsRefs.size());
	}
	
	public void delegate003_MockException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery classReferenceDiscovery = trial.getClassReferenceDiscovery();
		
		Class<?> clazz = MockException.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = classReferenceDiscovery.findOrLoad(clazz);
		assertNotNull(order);
		assertEquals(Serializable.class.getName(), order.get(0));
		assertEquals(Object.class.getName(), order.get(1));
		
		assertEquals(Throwable.class.getName(), order.get(2));
		assertEquals(Exception.class.getName(), order.get(3));
		
		assertEquals(className, order.get(4));
		assertEquals(5, order.size());
		
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = classReferenceDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Exception.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Throwable.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		assertEquals(4, deps.size());
		
		I_ClassReferences cr =  classReferenceDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockExceptionRefs(className, cr);
		
		assertHasMockExceptionCache();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(1, refsCache.size());
	}
	
	public void assertHasMockExceptionCache() {
		String className = MockException.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		I_ClassReferences refs =  refsCache.get(className);
		assertMockExceptionRefs(className, refs);
	}

	private void assertMockExceptionRefs(String className,
			I_ClassReferences refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularReferences());
		
		Set<String> refsRefs = refs.getReferenceNames();
		assertContains(refsRefs, Serializable.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, Throwable.class.getName());
		assertContains(refsRefs, Exception.class.getName());
		assertContains(refsRefs, className);
		assertEquals(5, refsRefs.size());
	}
	
	public void assertHasAllCache() {
		assertHasMockExceptionCache();
		assertHasMockWithNothingCache();
		assertHasMockWithStringCache();
	}
}
