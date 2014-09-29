package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j.shared.asserts.dependency.ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAlias;
import org.adligo.tests4j.shared.asserts.dependency.I_Dependency;
import org.adligo.tests4j.system.shared.trials.TrialDelegate;
import org.adligo.tests4j_4jacoco.plugin.common.I_OrderedClassDependencies;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

public class DAT_Assert_Linear_to_20 extends TrialDelegate {
	private I_DiscoveryApiTrial trial;
	
	public DAT_Assert_Linear_to_20(I_DiscoveryApiTrial p) {
		super(p);
		trial = p;
	}

	public void delegate011_MockWithAbstractMethodParam() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithAbstractMethodParam.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithNothing.class.getName(), order.get(1));
		assertEquals(className, order.get(2));
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithNothing.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(2, deps.size());
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithAbstractMethodParamRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		
		assertHasMockWithAbstractMethodParamCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}

	public void assertHasMockWithAbstractMethodParamCache() {
		String className = MockWithAbstractMethodParam.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithAbstractMethodParamRefs(className, crefs);
	}
	
	private void assertMockWithAbstractMethodParamRefs(String clazzName,
			I_ClassDependencies cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		assertFalse(cr.hasCircularDependencies());
		
		Set<String> refs = cr.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, clazzName);
		assertEquals(3, refs.size());
	}
	
	public void delegate012_MockWithExtensionA() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithExtensionA.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		//ok in this case Object is not on top as 
		//
		//  MockWithNothing -> selfClass (MockWithNothing) AND -> Object
		// MockWithExtensionA -> selfClass (MockWithExtensionA) AND MockWithNothing -> Object
		assertEquals(Object.class.getName(), order.get(0)); 
		assertEquals(MockWithNothing.class.getName(), order.get(1));
		assertEquals(className, order.get(2));//zero
		assertEquals(3, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithNothing.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(2, deps.size());
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithExtensionARefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		
		assertHasMockWithExtensionACache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}
	
	
	public void assertHasMockWithExtensionACache() {
		String className = MockWithExtensionA.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithExtensionARefs(className, crefs);
	}

	private void assertMockWithExtensionARefs(String className,
			I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, className);
		assertEquals(3, refs.size());
	}

	public void delegate013_MockWithExtensionB() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithExtensionB.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithNothing.class.getName(), order.get(1));
		
		assertEquals(MockWithExtensionA.class.getName(), order.get(2));
		assertEquals(className, order.get(3));
		assertEquals(4, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithNothing.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithExtensionA.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(3, deps.size());
		
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithExtensionBRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		
		assertHasMockWithExtensionACache();
		assertHasMockWithExtensionBCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(4, refsCache.size());
	}
	
	public void assertHasMockWithExtensionBCache() {
		String className = MockWithExtensionB.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockWithExtensionBRefs(className, crefs);
	}

	private void assertMockWithExtensionBRefs(String className,
			I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, Object.class.getName());
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithExtensionA.class.getName());
		assertContains(refs, className);
		assertEquals(4, refs.size());
	}
	/**
	 * sushi anyone?
	 * @throws Exception
	 */

	public void delegate014_MockI_GetLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_GetLong.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(MockI_GetLong.class);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Object.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		
		assertEquals(Number.class.getName(), order.get(counter++));
		
		assertEquals(Long.class.getName(), order.get(counter++));
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Number.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Long.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		assertEquals(5, deps.size());
		
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_GetLongRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasSerilizableCache();
		simple.assertHasCompareableCache();
		simple.assertHasNumberCache();
		simple.assertHasLongCache();
		assertHasMockI_GetLongCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(6, refsCache.size());
	}	

	public void assertHasMockI_GetLongCache() {
		String className = MockI_GetLong.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_GetLongRefs(className, crefs);
	}
	

	private void assertMockI_GetLongRefs(String clazzName, I_ClassDependenciesLocal cr) {
		assertNotNull(cr);
		assertEquals(clazzName, cr.getName());
		assertFalse(cr.hasCircularDependencies());
		
		Set<String> refs = cr.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, Comparable.class.getName());
		assertContains(refs, Number.class.getName());
		
		assertContains(refs, Long.class.getName());
		assertContains(refs, clazzName);
		assertEquals(6, refs.size());
	}
	
	public void delegate015_MockI_SetLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_SetLong.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Object.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		assertEquals(Number.class.getName(), order.get(counter++));
		
		assertEquals(Long.class.getName(), order.get(counter++));
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Number.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Long.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
			
		assertEquals(5, deps.size());
		
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_SetLongRefs(className, cr);;
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasSerilizableCache();
		simple.assertHasObjectCache();
		simple.assertHasCompareableCache();
		simple.assertHasNumberCache();
		simple.assertHasLongCache();
		assertHasMockI_SetLongCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(6, refsCache.size());
	}
	
	public void assertHasMockI_SetLongCache() {
		String className = MockI_SetLong.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_SetLongRefs(className, crefs);
	}

	private void assertMockI_SetLongRefs(String className,
			I_ClassDependenciesLocal crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, Object.class.getName());
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Comparable.class.getName());
		assertContains(refs, Number.class.getName());
		
		assertContains(refs, Long.class.getName());
		assertContains(refs, className);
		assertEquals(6, refs.size());
	}

	public void delegate016_MockI_GetString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_GetString.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(MockI_GetString.class);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(CharSequence.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(CharSequence.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(5, deps.size());
		
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_GetStringRefs(className, cr);
		
		
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasSerilizableCache();
		simple.assertHasCharSequenceCache();
		simple.assertHasCompareableCache();
		simple.assertHasObjectCache();
		simple.assertHasStringCache();
		
		assertHasMockI_GetStringCache();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(6, refsCache.size());
	}
	

	public void assertHasMockI_GetStringCache() {
		String className = MockI_GetString.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_GetStringRefs(className, crefs);
	}

	private void assertMockI_GetStringRefs(String className,
			I_ClassDependenciesLocal crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, Comparable.class.getName());
		assertContains(refs, CharSequence.class.getName());
		
		assertContains(refs, String.class.getName());
		assertContains(refs, className);
		assertEquals(6, refs.size());
	}
	
	public void delegate017_MockI_SetString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_SetString.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(CharSequence.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(CharSequence.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(5, deps.size());
		
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_SetStringRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasSerilizableCache();
		simple.assertHasCompareableCache();
		simple.assertHasStringCache();
		simple.assertHasCharSequenceCache();
		
		assertHasMockI_SetStringCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(6, refsCache.size());
	}
	
	public void assertHasMockI_SetStringCache() {
		String className = MockI_SetString.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_SetStringRefs(className, crefs);
	}

	private void assertMockI_SetStringRefs(String className,
			I_ClassDependenciesLocal crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, Comparable.class.getName());
		assertContains(refs, CharSequence.class.getName());
		
		assertContains(refs, String.class.getName());
		assertEquals(6, refs.size());
	}
	
	public void delegate018_MockI_GetAndSetLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_GetAndSetLong.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(Comparable.class.getName(), order.get(counter++));
		assertEquals(Number.class.getName(), order.get(counter++));
		
		assertEquals(Long.class.getName(), order.get(counter++));
		
		//2 counts
		assertEquals(MockI_GetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_SetLong.class.getName(), order.get(counter++));
		
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Number.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Long.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetLong.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_SetLong.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(7, deps.size());
		
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_GetAndSetLongRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasSerilizableCache();
		simple.assertHasNumberCache();
		simple.assertHasCompareableCache();
		simple.assertHasLongCache();
		
		assertHasMockI_GetLongCache();
		assertHasMockI_SetLongCache();
		assertHasMockI_GetAndSetLongCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(8, refsCache.size());
	}
	
	public void assertHasMockI_GetAndSetLongCache() {
		String className = MockI_GetAndSetLong.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_GetAndSetLongRefs(className, crefs);
	}

	private void assertMockI_GetAndSetLongRefs(String className,
			I_ClassDependenciesLocal crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, Comparable.class.getName());
		assertContains(refs, Number.class.getName());
		
		assertContains(refs, Long.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		assertContains(refs, className);
		assertEquals(8, refs.size());
	}

	public void delegate019_MockI_GetAndSetString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_GetAndSetString.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(MockI_GetAndSetString.class);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(CharSequence.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		
		assertEquals(Object.class.getName(), order.get(counter++));
		
		
		assertEquals(String.class.getName(), order.get(counter++));
		
		//2 counts
		assertEquals(MockI_GetString.class.getName(), order.get(counter++));
		assertEquals(MockI_SetString.class.getName(), order.get(counter++));
		
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(CharSequence.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetString.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_SetString.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(7, deps.size());
		
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_GetAndSetStringRefs(className, cr);

		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasSerilizableCache();
		simple.assertHasCharSequenceCache();
		
		simple.assertHasCompareableCache();
		simple.assertHasStringCache();
		
		assertHasMockI_GetStringCache();
		assertHasMockI_SetStringCache();
		assertHasMockI_GetAndSetStringCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(8, refsCache.size());
	}
	
	public void assertHasMockI_GetAndSetStringCache() {
		String className = MockI_GetAndSetString.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_GetAndSetStringRefs(className, crefs);
	}

	private void assertMockI_GetAndSetStringRefs(String className,
			I_ClassDependenciesLocal crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, Object.class.getName());
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, CharSequence.class.getName());
		assertContains(refs, Comparable.class.getName());
		
		assertContains(refs, String.class.getName());
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, className);
		assertEquals(8, refs.size());
	}
	

	public void delegate020_MockI_StringAndLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_StringAndLong.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Object.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		assertEquals(CharSequence.class.getName(), order.get(counter++));
		
		assertEquals(Number.class.getName(), order.get(counter++));

		assertEquals(Long.class.getName(), order.get(counter++));
		assertEquals(String.class.getName(), order.get(counter++));
		
		//2 counts
		assertEquals(MockI_GetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetString.class.getName(), order.get(counter++));
		assertEquals(MockI_SetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_SetString.class.getName(), order.get(counter++));
		
		//1 counts
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(counter++));

		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(10, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(10, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(9, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(CharSequence.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Number.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Long.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetLong.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetString.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_SetLong.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_SetString.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetAndSetLong.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetAndSetString.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(13, deps.size());
		
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_StringAndLongRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasSerilizableCache();
		simple.assertHasCharSequenceCache();
		
		simple.assertHasCompareableCache();
		simple.assertHasNumberCache();
		simple.assertHasLongCache();
		simple.assertHasStringCache();
		
		assertHasMockI_GetLongCache();
		assertHasMockI_SetLongCache();
		assertHasMockI_GetAndSetLongCache();
		
		assertHasMockI_GetStringCache();
		assertHasMockI_SetStringCache();
		assertHasMockI_GetAndSetStringCache();
		
		assertHasMockI_StringAndLongCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(14, refsCache.size());
	}
	
	public void assertHasMockI_StringAndLongCache() {
		String className = MockI_StringAndLong.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_StringAndLongRefs(className, crefs);
	}

	private void assertMockI_StringAndLongRefs(String className,
			I_ClassDependenciesLocal crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, Comparable.class.getName());
		assertContains(refs, CharSequence.class.getName());
		assertContains(refs, Number.class.getName());
		
		assertContains(refs, String.class.getName());
		assertContains(refs, Long.class.getName());
		
		
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		
		assertContains(refs, MockI_GetAndSetString.class.getName());
		assertContains(refs, MockI_GetAndSetLong.class.getName());
		
		assertContains(refs, className);
		assertEquals(14, refs.size());
	}
	
	public void assertHasAllCache() {
		assertHasMockI_GetAndSetLongCache();
		assertHasMockI_GetAndSetStringCache();
		assertHasMockI_GetLongCache();
		assertHasMockI_GetStringCache();
		assertHasMockI_SetLongCache();
		assertHasMockI_SetStringCache();
		assertHasMockI_StringAndLongCache();
		assertHasMockWithAbstractMethodParamCache();
		assertHasMockWithExtensionACache();
		assertHasMockWithExtensionBCache();
	}
}
