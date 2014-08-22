package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassAlias;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.common.I_OrderedClassDependencies;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

public class DAT_Assert_Circular_to_10 extends TrialDelegate {
	private I_DiscoveryApiTrial trial;
	
	public DAT_Assert_Circular_to_10(I_DiscoveryApiTrial p) {
		super(p);
		trial = p;
	}

	
	public void delegate001_MockWithBidirectionalA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithBidirectionalA.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(2));
		
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertBiToDeps(orderedClassDiscovery, className);
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertBiARefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		
		assertHasMockWithBidirectionalACache();
		assertHasMockWithBidirectionalBCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}


	private void assertBiToDeps(OrderedClassDiscovery orderedClassDiscovery, String className) {
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
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
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		
		I_ClassDependencies crefs =  refsCache.get(className);
		assertBiARefs(className, crefs);
	}


	private void assertBiARefs(String className, I_ClassDependencies crefs) {
		
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertTrue(crefs.hasCircularDependencies());
		
		Set<String> circular = crefs.getCircularDependenciesNames();
		assertContains(circular, MockWithBidirectionalB.class.getName());
		assertEquals(1, circular.size());
		
		Set<String> refs = crefs.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalB.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, className);
		assertEquals(3, refs.size());
	}
	
	public void delegate002_MockWithBidirectionalB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithBidirectionalB.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(1));
		assertEquals(className, order.get(2));
		
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertBiToDeps(orderedClassDiscovery, className);
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertBiBRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		
		assertHasMockWithBidirectionalBCache();
		assertHasMockWithBidirectionalACache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	
	}

	public void assertHasMockWithBidirectionalBCache() {
		String className = MockWithBidirectionalB.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertBiBRefs(className, crefs);
	}
	

	private void assertBiBRefs(String clazzName, I_ClassDependencies cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		assertTrue(cr.hasCircularDependencies());
		Set<String> circles = cr.getCircularDependenciesNames();
		assertContains(circles, MockWithBidirectionalA.class.getName());
		assertEquals(1, circles.size());
		
		Set<String> refs = cr.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, MockWithBidirectionalA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	public void delegate003_MockWithTriangleA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithTriangleA.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(MockWithTriangleB.class.getName(), order.get(2));
		assertEquals(MockWithTriangleC.class.getName(), order.get(3));
		
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleToDeps(orderedClassDiscovery, className);
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertTriARefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(4, refsCache.size());
	}
	
	public void assertHasMockWithTriangleACache() {
		String className = MockWithTriangleA.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertTriARefs(className, crefs);
	}
	
	private void assertTriARefs(String clazzName, I_ClassDependencies cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		assertTrue(cr.hasCircularDependencies());
		Set<String> circles = cr.getCircularDependenciesNames();
		assertContains(circles, MockWithTriangleB.class.getName());
		assertContains(circles, MockWithTriangleC.class.getName());
		assertEquals(2, circles.size());
		
		Set<String> refs = cr.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleB.class.getName());
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	private void assertTriangleToDeps(OrderedClassDiscovery orderedClassDiscovery, String className) {
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
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
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithTriangleB.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithTriangleA.class.getName(), order.get(1));
		assertEquals(className, order.get(2));
		assertEquals(MockWithTriangleC.class.getName(), order.get(3));
		
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleToDeps(orderedClassDiscovery, className);
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertTriaBRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(4, refsCache.size());
	}


	
	
	public void assertHasMockWithTriangleBCache() {
		String className = MockWithTriangleB.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertTriaBRefs(className, crefs);
	}
	
	private void assertTriaBRefs(String clazzName, I_ClassDependencies cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		Set<String> circles = cr.getCircularDependenciesNames();
		assertContains(circles, MockWithTriangleA.class.getName());
		assertContains(circles, MockWithTriangleC.class.getName());
		assertEquals(2, circles.size());
		
		Set<String> refs = cr.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, MockWithTriangleC.class.getName());
		assertContains(refs, MockWithTriangleA.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(4, refs.size());
	}
	
	public void delegate005_MockWithTriangleC() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithTriangleC.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithTriangleA.class.getName(), order.get(1));
		assertEquals(MockWithTriangleB.class.getName(), order.get(2));
		
		assertEquals(className, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertTriangleToDeps(orderedClassDiscovery, className);
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertTriCRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(4, refsCache.size());
	}
	
	public void assertHasMockWithTriangleCCache() {
		String className = MockWithTriangleC.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);

		assertTriCRefs(className, crefs);
	}


	private void assertTriCRefs(String className, I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		Set<String> circles = crefs.getCircularDependenciesNames();
		assertContains(circles, MockWithTriangleB.class.getName());
		assertContains(circles, MockWithTriangleA.class.getName());
		assertEquals(2, circles.size());
		
		Set<String> refs = crefs.getDependencyNames();
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
