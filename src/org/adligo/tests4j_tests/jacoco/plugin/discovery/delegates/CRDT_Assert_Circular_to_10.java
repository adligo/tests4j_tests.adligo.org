package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

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
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

public class CRDT_Assert_Circular_to_10 extends TrialDelegate {
	private I_ClassReferencesDiscoveryTrial trial;
	
	public CRDT_Assert_Circular_to_10(I_ClassReferencesDiscoveryTrial p) {
		super(p);
		trial = p;
	}

	
	public void delegate001_MockWithBidirectionalA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery crd = trial.getClassReferenceDiscovery();
		
		Class<?> clazz = MockWithBidirectionalA.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = crd.findOrLoad(clazz);
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(2));
		
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertBiToDeps(crd, className);
		
		I_ClassReferences cr =  crd.getReferences(new ClassAliasLocal(clazz));
		assertBiARefs(className, cr);
		
		assertHasMockWithBidirectionalACache();
		assertHasMockWithBidirectionalBCache();
		
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(2, refsCache.size());
	}


	private void assertBiToDeps(ClassReferencesDiscovery crd, String className) {
		Set<I_Dependency> deps = crd.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithBidirectionalA.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithBidirectionalB.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(3, deps.size());
	}
	

	public void assertHasMockWithBidirectionalACache() {
		String className = MockWithBidirectionalA.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		
		I_ClassReferences crefs =  refsCache.get(className);
		assertBiARefs(className, crefs);
	}


	private void assertBiARefs(String className, I_ClassReferences crefs) {
		
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertTrue(crefs.hasCircularReferences());
		
		Set<String> circular = crefs.getCircularReferenceNames();
		assertContains(circular, MockWithBidirectionalB.class.getName());
		assertEquals(1, circular.size());
		
		Set<String> refs = crefs.getReferenceNames();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalB.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, className);
		assertEquals(3, refs.size());
	}
	
	public void delegate002_MockWithBidirectionalB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery crd = trial.getClassReferenceDiscovery();
		
		Class<?> clazz = MockWithBidirectionalB.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = crd.findOrLoad(clazz);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(1));
		assertEquals(className, order.get(2));
		
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertBiToDeps(crd, className);
		
		I_ClassReferences cr =  crd.getReferences(new ClassAliasLocal(clazz));
		assertBiBRefs(className, cr);
		
		assertHasMockWithBidirectionalBCache();
		assertHasMockWithBidirectionalACache();
		
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(2, refsCache.size());
	
	}

	public void assertHasMockWithBidirectionalBCache() {
		String className = MockWithBidirectionalB.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		I_ClassReferences crefs =  refsCache.get(className);
		assertBiBRefs(className, crefs);
	}
	

	private void assertBiBRefs(String clazzName, I_ClassReferences cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		assertTrue(cr.hasCircularReferences());
		Set<String> circles = cr.getCircularReferenceNames();
		assertContains(circles, MockWithBidirectionalA.class.getName());
		assertEquals(1, circles.size());
		
		Set<String> refs = cr.getReferenceNames();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	public void delegate003_MockWithTriangleA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery crd = trial.getClassReferenceDiscovery();
		
		Class<?> clazz = MockWithTriangleA.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = crd.findOrLoad(clazz);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(MockWithTriangleB.class.getName(), order.get(2));
		assertEquals(MockWithTriangleC.class.getName(), order.get(3));
		
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleToDeps(crd, className);
		
		I_ClassReferences cr =  crd.getReferences(new ClassAliasLocal(clazz));
		assertTriARefs(className, cr);
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}
	
	public void assertHasMockWithTriangleACache() {
		String className = MockWithTriangleA.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		I_ClassReferences crefs =  refsCache.get(className);
		assertTriARefs(className, crefs);
	}
	
	private void assertTriARefs(String clazzName, I_ClassReferences cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		assertTrue(cr.hasCircularReferences());
		Set<String> circles = cr.getCircularReferenceNames();
		assertContains(circles, MockWithTriangleB.class.getName());
		assertContains(circles, MockWithTriangleC.class.getName());
		assertEquals(2, circles.size());
		
		Set<String> refs = cr.getReferenceNames();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleB.class.getName());
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	private void assertTriangleToDeps(ClassReferencesDiscovery crd, String className) {
		Set<I_Dependency> deps = crd.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithTriangleA.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithTriangleB.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithTriangleC.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		assertEquals(4, deps.size());
	}
	
	public void delegate004_MockWithTriangleB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery crd = trial.getClassReferenceDiscovery();
		
		Class<?> clazz = MockWithTriangleB.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = crd.findOrLoad(clazz);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithTriangleA.class.getName(), order.get(1));
		assertEquals(className, order.get(2));
		assertEquals(MockWithTriangleC.class.getName(), order.get(3));
		
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleToDeps(crd, className);
		
		I_ClassReferences cr =  crd.getReferences(new ClassAliasLocal(clazz));
		assertTriaBRefs(className, cr);
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}


	
	
	public void assertHasMockWithTriangleBCache() {
		String className = MockWithTriangleB.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		I_ClassReferences crefs =  refsCache.get(className);
		assertTriaBRefs(className, crefs);
	}
	
	private void assertTriaBRefs(String clazzName, I_ClassReferences cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		Set<String> circles = cr.getCircularReferenceNames();
		assertContains(circles, MockWithTriangleA.class.getName());
		assertContains(circles, MockWithTriangleC.class.getName());
		assertEquals(2, circles.size());
		
		Set<String> refs = cr.getReferenceNames();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleC.class.getName());
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	public void delegate005_MockWithTriangleC() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery crd = trial.getClassReferenceDiscovery();
		
		Class<?> clazz = MockWithTriangleC.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = crd.findOrLoad(clazz);
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithTriangleA.class.getName(), order.get(1));
		assertEquals(MockWithTriangleB.class.getName(), order.get(2));
		
		assertEquals(className, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleToDeps(crd, className);
		
		I_ClassReferences cr =  crd.getReferences(new ClassAliasLocal(clazz));
		assertTriCRefs(className, cr);
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}
	
	public void assertHasMockWithTriangleCCache() {
		String className = MockWithTriangleC.class.getName();
		Map<String,I_ClassReferencesLocal> refsCache = trial.getRefsCache();
		I_ClassReferences crefs =  refsCache.get(className);

		assertTriCRefs(className, crefs);
	}


	private void assertTriCRefs(String className, I_ClassReferences crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		Set<String> circles = crefs.getCircularReferenceNames();
		assertContains(circles, MockWithTriangleB.class.getName());
		assertContains(circles, MockWithTriangleA.class.getName());
		assertEquals(2, circles.size());
		
		Set<String> refs = crefs.getReferenceNames();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleB.class.getName());
		assertContains(refs, MockWithTriangleC.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, className);
		assertEquals(4, refs.size());
	}
	
	public void assertHasAllCache() {
		assertHasMockWithBidirectionalACache();
		assertHasMockWithBidirectionalBCache();
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
	}
}
