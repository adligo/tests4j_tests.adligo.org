package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.Flushable;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassAlias;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.common.I_OrderedClassDependencies;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithImportOnlyInMethod;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodExceptionBlock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;

public class DAT_Assert_Linear_to_10 extends TrialDelegate {
	private I_DiscoveryApiTrial trial;
	
	public DAT_Assert_Linear_to_10(I_DiscoveryApiTrial p) {
		super(p);
		trial = p;
	}

	
	public void delegate001_MockWithMethodReturn() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithMethodReturn.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithNothing.class.getName(), order.get(1));
		assertEquals(className, order.get(2));
		assertEquals(3, order.size());
		
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
		assertMockWithMethodReturnRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithMethodReturnCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}
	
	public void assertHasMockWithMethodReturnCache() {
		String className = MockWithMethodReturn.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithMethodReturnRefs(className, crefs);
	}
	
	private void assertMockWithMethodReturnRefs(String clazzName, I_ClassDependencies cr) {
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
	
	public void delegate002_MockWithFeild() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithField.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		//string is first because I_System doesn't reference itself or Object
		// MockWithField -> self(MockWithField super Object) and I_System
		//  I_System -> String ONLY
		int counter = 0;
		assertEquals(AutoCloseable.class.getName(), order.get(counter++));
		assertEquals(Object.class.getName(), order.get(counter++));
		assertEquals(Closeable.class.getName(), order.get(counter++));
		assertEquals(Flushable.class.getName(), order.get(counter++));
		assertEquals(OutputStream.class.getName(), order.get(counter++));
		assertEquals(FilterOutputStream.class.getName(), order.get(counter++));
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Appendable.class.getName(), order.get(counter++));
		assertEquals(CharSequence.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		
		assertEquals(PrintStream.class.getName(), order.get(counter++));
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(I_System.class.getName(), order.get(counter++));
		
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		
		I_ClassAlias alias = dep.getAlias();
		assertEquals(AutoCloseable.class.getName(), alias.getName());
		assertEquals(6, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(6, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Closeable.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Flushable.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(OutputStream.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(FilterOutputStream.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Appendable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(CharSequence.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(PrintStream.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(I_System.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(13, deps.size());
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithFieldRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasAutoCloseableCache();
		simple.assertHasAppendableCache();
		simple.assertHasCloseableCache();
		
		simple.assertHasFilterOutputStreamCache();
		simple.assertHasFlushableCache();
		
		simple.assertHasObjectCache();
		simple.assertHasOutputStreamCache();
		
		simple.assertHasPrintStreamCache();
		
		simple.assertHasStringCache();
		simple.assertHasSerilizableCache();
		simple.assertHasCharSequenceCache();
		simple.assertHasCompareableCache();
		
		assertHasI_SystemCache();
		assertHasMockWithFieldCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(14, refsCache.size());
	}

	public void assertHasI_SystemCache() {
		String className = I_System.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, Appendable.class.getName());
		assertContains(refs, AutoCloseable.class.getName());
		assertContains(refs, CharSequence.class.getName());
		assertContains(refs, Closeable.class.getName());
		assertContains(refs, Comparable.class.getName());
		
		assertContains(refs, FilterOutputStream.class.getName());
		assertContains(refs, Flushable.class.getName());
		
		assertContains(refs, Object.class.getName());
		assertContains(refs, OutputStream.class.getName());
		assertContains(refs, PrintStream.class.getName());
		
		assertContains(refs, Serializable.class.getName());
		
		assertContains(refs, String.class.getName());
		assertContains(refs, className);
		assertEquals(13, refs.size());
	}
	
	public void assertHasMockWithFieldCache() {
		String className = MockWithField.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithFieldRefs(className, crefs);
	}

	private void assertMockWithFieldRefs(String className,
			I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, Appendable.class.getName());
		assertContains(refs, AutoCloseable.class.getName());
		assertContains(refs, CharSequence.class.getName());
		assertContains(refs, Closeable.class.getName());
		assertContains(refs, Comparable.class.getName());
		
		assertContains(refs, FilterOutputStream.class.getName());
		assertContains(refs, Flushable.class.getName());
		
		assertContains(refs, I_System.class.getName());
		
		assertContains(refs, Object.class.getName());
		assertContains(refs, OutputStream.class.getName());
		assertContains(refs, PrintStream.class.getName());
		
		assertContains(refs, Serializable.class.getName());
		
		assertContains(refs, String.class.getName());
		assertContains(refs, className);
		assertEquals(14, refs.size());
	}
	
	public void delegate003_MockWithMethodParams() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithMethodParams.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(MockWithNothing.class.getName(), order.get(1));
		assertEquals(MockWithMethodReturn.class.getName(), order.get(2));
		
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
		assertEquals(MockWithMethodReturn.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(3, deps.size());
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithMethodParamsRefs(className, cr);

		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		
		assertHasMockWithMethodReturnCache();
		assertHasMockWithMethodParamsCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(4, refsCache.size());
	}
	

	public void assertHasMockWithMethodParamsCache() {
		String className = MockWithMethodParams.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithMethodParamsRefs(className, crefs);
	}


	private void assertMockWithMethodParamsRefs(String className,
			I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithMethodReturn.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, className);
		assertEquals(4, refs.size());
	}
	
	public void delegate004_MockWithImportOnlyInMethod() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithImportOnlyInMethod.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(AutoCloseable.class.getName(), order.get(counter++));
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(Closeable.class.getName(), order.get(counter++));
		assertEquals(Flushable.class.getName(), order.get(counter++));
		assertEquals(OutputStream.class.getName(), order.get(counter++));
		assertEquals(FilterOutputStream.class.getName(), order.get(counter++));
		
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Appendable.class.getName(), order.get(counter++));
		assertEquals(CharSequence.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		
		assertEquals(PrintStream.class.getName(), order.get(counter++));
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(I_System.class.getName(), order.get(counter++));
		
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(AutoCloseable.class.getName(), alias.getName());
		assertEquals(6, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(6, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Closeable.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Flushable.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(OutputStream.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(FilterOutputStream.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Appendable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(CharSequence.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(PrintStream.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(I_System.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(13, deps.size());
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithImportOnlyInMethodRefs(className, cr);
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasAppendableCache();
		simple.assertHasAutoCloseableCache();
		
		simple.assertHasCloseableCache();
		
		simple.assertHasFilterOutputStreamCache();
		simple.assertHasFlushableCache();
		
		simple.assertHasObjectCache();
		simple.assertHasOutputStreamCache();
		
		simple.assertHasPrintStreamCache();
		
		simple.assertHasSerilizableCache();
		simple.assertHasCharSequenceCache();
		simple.assertHasCompareableCache();
		simple.assertHasStringCache();
		
		assertHasI_SystemCache();
		assertHasMockWithImportOnlyInMethodCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(14, refsCache.size());
	}
	
	public void assertHasMockWithImportOnlyInMethodCache() {
		String className = MockWithImportOnlyInMethod.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithImportOnlyInMethodRefs(className, crefs);
	}

	private void assertMockWithImportOnlyInMethodRefs(String className,
			I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, Appendable.class.getName());
		assertContains(refs, AutoCloseable.class.getName());
		assertContains(refs, CharSequence.class.getName());
		assertContains(refs, Closeable.class.getName());
		assertContains(refs, Comparable.class.getName());
		
		assertContains(refs, I_System.class.getName());
		
		assertContains(refs, FilterOutputStream.class.getName());
		assertContains(refs, Flushable.class.getName());
		
		assertContains(refs, Object.class.getName());
		assertContains(refs, OutputStream.class.getName());
		assertContains(refs, PrintStream.class.getName());
		
		assertContains(refs, Serializable.class.getName());
		
		assertContains(refs, String.class.getName());
		
		assertContains(refs, className);
		assertEquals(14, refs.size());
	}

	public void delegate005_MockWithStaticFeild() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithStaticField.class;
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
		assertMockWithStaticFieldRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		assertHasMockWithStaticFieldCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}
	
	public void assertHasMockWithStaticFieldCache() {
		String className = MockWithStaticField.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithStaticFieldRefs(className, crefs);
	}

	private void assertMockWithStaticFieldRefs(String clazzName, I_ClassDependencies cr) {
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
	
	public void delegate006_MockWithStaticInitalizer() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithStaticInitalizer.class;
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
		assertMockWithStaticInitalizerRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		
		assertHasMockWithStaticInitalizerCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
		
	}
	
	public void assertHasMockWithStaticInitalizerCache() {
		String className = MockWithStaticInitalizer.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithStaticInitalizerRefs(className, crefs);
	}
	
	private void assertMockWithStaticInitalizerRefs(String clazzName, I_ClassDependencies cr) {
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
	
	public void delegate007_MockWithArray() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithArray.class;
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
		assertMockWithArrayRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		
		assertHasMockWithArrayCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}

	
	public void assertHasMockWithArrayCache() {
		String className = MockWithArray.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithArrayRefs(className, crefs);
	}

	private void assertMockWithArrayRefs(String clazzName, I_ClassDependencies cr) {
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
	
	public void delegate008_MockWithMethodException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithMethodException.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Object.class.getName(), order.get(counter++));
		assertEquals(Serializable.class.getName(), order.get(counter++));
		
		assertEquals(Throwable.class.getName(), order.get(counter++));
		assertEquals(Exception.class.getName(), order.get(counter++));
		
		assertEquals(MockException.class.getName(), order.get(counter++));
		assertEquals(MockWithNothing.class.getName(), order.get(counter++));
		
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Throwable.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Exception.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockException.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithNothing.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(6, deps.size());
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithMethodExceptionRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasSerilizableCache();
		simple.assertHasThrowableCache();
		simple.assertHasExceptionCache();
		
		simple.assertHasMockWithNothingCache();
		simple.assertHasMockExceptionCache();
		
		assertHasMockWithMethodExceptionCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(7, refsCache.size());
	}
	
	public void assertHasMockWithMethodExceptionCache() {
		String className = MockWithMethodException.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithMethodExceptionRefs(className, crefs);
	}

	private void assertMockWithMethodExceptionRefs(String className,
			I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockException.class.getName());
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Throwable.class.getName());
		assertContains(refs, Exception.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, className);
		assertEquals(7, refs.size());
	}

	public void delegate009_MockWithMethodExceptionBlock() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithMethodExceptionBlock.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Object.class.getName(), order.get(counter++));
		assertEquals(Serializable.class.getName(), order.get(counter++));
		
		assertEquals(Throwable.class.getName(), order.get(counter++));
		assertEquals(Exception.class.getName(), order.get(counter++));
		
		assertEquals(MockException.class.getName(), order.get(counter++));
		assertEquals(MockWithNothing.class.getName(), order.get(counter++));
		
		//this has a 2 count
		assertEquals(MockWithMethodException.class.getName(), order.get(counter++));

		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(6, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Throwable.class.getName(), alias.getName());
		assertEquals(4, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Exception.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockException.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithNothing.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockWithMethodException.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(7, deps.size());
		
		I_ClassDependencies cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithMethodExceptionBlockRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasThrowableCache();
		simple.assertHasExceptionCache();
		
		simple.assertHasMockWithNothingCache();
		simple.assertHasMockExceptionCache();
		
		assertHasMockWithMethodExceptionCache();
		assertHasMockWithMethodExceptionBlockCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		//7?
		assertEquals(8, refsCache.size());
	}
	
	public void assertHasMockWithMethodExceptionBlockCache() {
		String className = MockWithMethodExceptionBlock.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithMethodExceptionBlockRefs(className, crefs);
	}

	private void assertMockWithMethodExceptionBlockRefs(String className,
			I_ClassDependencies crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertContains(refs, MockWithNothing.class.getName());
		assertContains(refs, MockWithMethodException.class.getName());
		assertContains(refs, MockException.class.getName());
		assertContains(refs, Exception.class.getName());
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Throwable.class.getName());
		assertContains(refs, Object.class.getName());
		assertContains(refs, className);
		assertEquals(8, refs.size());
	}

	public void delegate010_MockWithAbstractMethodReturn() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithAbstractMethodReturn.class;
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
		assertMockWithAbstractMethodReturnRefs(className, cr);
		
		DAT_Assert_Simple simple =  trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasMockWithNothingCache();
		
		assertHasMockWithAbstractMethodReturnCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(3, refsCache.size());
	}
	
	public void assertHasMockWithAbstractMethodReturnCache() {
		String className = MockWithAbstractMethodReturn.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependencies crefs =  refsCache.get(className);
		assertMockWithAbstractMethodReturnRefs(className, crefs);
	}

	private void assertMockWithAbstractMethodReturnRefs(String className,
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
	

	public void assertHasAllCache() {
		assertHasI_SystemCache();
		assertHasMockWithAbstractMethodReturnCache();
		assertHasMockWithArrayCache();
		assertHasMockWithFieldCache();
		assertHasMockWithImportOnlyInMethodCache();
		assertHasMockWithMethodExceptionBlockCache();
		assertHasMockWithMethodExceptionCache();
		assertHasMockWithMethodParamsCache();
		assertHasMockWithMethodReturnCache();
		assertHasMockWithStaticFieldCache();
		assertHasMockWithStaticInitalizerCache();
	}
}
