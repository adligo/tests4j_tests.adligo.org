package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.Flushable;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.association.I_ClassAssociations;
import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j.shared.asserts.reference.ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAlias;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_Dependency;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.system.shared.trials.TrialDelegate;
import org.adligo.tests4j_4jacoco.plugin.common.I_OrderedClassDependencies;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithCallToArithmeticException_Constructor;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;

public class DAT_Assert_Simple extends TrialDelegate {
	private I_DiscoveryApiTrial trial;
	
	public DAT_Assert_Simple(I_DiscoveryApiTrial p) {
		super(p);
		trial = p;
	}

	public void delegate001_MockWithNothing() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithNothing.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		
		assertNotNull(order);
		assertEquals(Object.class.getName(), order.get(0));
		assertEquals(className, order.get(1));
		assertEquals(2, order.size());
		
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		assertEquals(1, deps.size());
		
		I_ClassAssociations cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithNothingRefs(className, cr);
		assertHasObjectCache();
		assertHasMockWithNothingCache();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		assertEquals(2, refsCache.size());
	}

	public void assertHasMockWithNothingCache() {
		String className = MockWithNothing.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertMockWithNothingRefs(className, refs);
	}

	private void assertMockWithNothingRefs(String className,
			I_ClassAssociations refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, className);
		assertEquals(2, refsRefs.size());
	}
	
	public void delegate002_MockWithString() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithString.class;
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
		
		
		I_ClassAssociations cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockWithStringRefs(className, cr);
		
		assertHasObjectCache();
		assertHasSerilizableCache();
		assertHasCharSequenceCache();
		
		assertHasCompareableCache();
		assertHasStringCache();
		
		assertHasMockWithStringCache();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		assertEquals(6, refsCache.size());
	}
	
	public void assertHasMockWithStringCache() {
		String className = MockWithString.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertMockWithStringRefs(className, refs);
	}

	private void assertMockWithStringRefs(String className,
			I_ClassAssociations refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Serializable.class.getName());
		assertContains(refsRefs, CharSequence.class.getName());
		assertContains(refsRefs, Comparable.class.getName());
		
		assertContains(refsRefs, String.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, className);
		assertEquals(6, refsRefs.size());
	}
	
	public void delegate003_MockException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockException.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertNotNull(order);
		int counter = 0;
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(Throwable.class.getName(), order.get(counter++));
		assertEquals(Exception.class.getName(), order.get(counter++));
		//note no Comparable, Number Long here since the Serializable version id is a 
		//primitive long, the classes aren't referenced
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
		assertEquals(Throwable.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Exception.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		assertEquals(4, deps.size());
		
		I_ClassAssociations cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertHasObjectCache();
		
		assertHasThrowableCache();
		assertHasExceptionCache();
		assertHasMockExceptionCache();
		assertMockExceptionRefs(className, cr);
		

		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		assertEquals(5, refsCache.size());
	}
	
	public void delegate004_MockWithCallToArithmeticException() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithCallToArithmeticException_Constructor.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		I_ClassAssociationsLocal cdl = ocd.getClassDependencies();
		List<I_ClassAttributes> atribs = cdl.getReferences();
		
		assertNotNull(atribs);
		I_ClassAttributes ref = atribs.get(0);
		assertNotNull(ref);
		assertEquals(String.class.getName(), ref.getName());
		
		ref = atribs.get(1);
		assertNotNull(ref);
		assertEquals(Object.class.getName(), ref.getName());
		Set<I_MethodSignature> methods = ref.getMethods();
		assertContains(methods, new MethodSignature("<init>", null, null));
		assertEquals(MethodSignature.class.getName(), methods.iterator().next().getClass().getName());
		assertEquals(1, methods.size());
		
		ref = atribs.get(2);
		assertNotNull(ref);
		assertEquals(ArithmeticException.class.getName(), ref.getName());
		methods = ref.getMethods();
		assertNotNull(methods);
		assertContains(methods, new MethodSignature("<init>", new String[] {String.class.getName()}, null));
		assertEquals(MethodSignature.class.getName(), methods.iterator().next().getClass().getName());
		assertEquals(1, methods.size());
		
			
		ref = atribs.get(3);
		assertNotNull(ref);
		assertEquals(MockWithCallToArithmeticException_Constructor.class.getName(), ref.getName());
		Set<I_FieldSignature> fields = ref.getFields();
		assertNotNull(fields);
		assertContains(fields, new FieldSignature("x", ArithmeticException.class.getName()));
		assertEquals(FieldSignature.class.getName(), fields.iterator().next().getClass().getName());
		assertEquals(1, fields.size());
		assertEquals(4, atribs.size());
		
	}
	public void assertHasObjectCache() {
		String className = Object.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}

	public void assertHasAutoCloseableCache() {
		String className = AutoCloseable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}
	
	public void assertHasSerilizableCache() {
		String className = Serializable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}
	
	public void assertHasCompareableCache() {
		String className = Comparable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}
	
	public void assertHasTypeCache() {
		String className = Type.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}
	
	public void assertHasGenericDeclarationCache() {
		String className = GenericDeclaration.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertTrue(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, TypeVariable.class.getName());
		assertEquals(1, refsRefs.size());
	}
	
	public void assertHasAnnotatedElementCache() {
		String className = AnnotatedElement.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Annotation.class.getName());
		assertContains(refsRefs, Class.class.getName());
		assertEquals(2, refsRefs.size());
		
		assertTrue(refs.hasCircularDependencies());
		
	}
	
	public void assertHasTypeVariableCache() {
		String className = TypeVariable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertTrue(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Type.class.getName());
		assertContains(refsRefs, String.class.getName());
		assertContains(refsRefs, GenericDeclaration.class.getName());
		assertEquals(3, refsRefs.size());
	}
	
	public void assertHasClassCache() {
		String className = Class.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertTrue(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Type.class.getName());
		assertContains(refsRefs, String.class.getName());
		assertContains(refsRefs, GenericDeclaration.class.getName());
		assertContains(refsRefs, AnnotatedElement.class.getName());
		assertEquals(4, refsRefs.size());
	}
	
	public void assertHasCharSequenceCache() {
		String className = Comparable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}
	
	public void assertHasAppendableCache() {
		String className = Appendable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}
	
	public void assertHasFlushableCache() {
		String className = Flushable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertSimple(className, refs);
	}
	
	private void assertSimple(String className,
			I_ClassAssociations refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertEquals(0, refsRefs.size());
	}
	
	public void assertHasCloseableCache() {
		String className = Closeable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, AutoCloseable.class.getName());
		assertEquals(1, refsRefs.size());
	}
	
	public void assertHasOutputStreamCache() {
		String className = OutputStream.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, AutoCloseable.class.getName());
		assertContains(refsRefs, Closeable.class.getName());
		assertContains(refsRefs, Flushable.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertEquals(4, refsRefs.size());
	}
	
	public void assertHasFilterOutputStreamCache() {
		String className = FilterOutputStream.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, AutoCloseable.class.getName());
		assertContains(refsRefs, Closeable.class.getName());
		assertContains(refsRefs, Flushable.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, OutputStream.class.getName());
		assertEquals(5, refsRefs.size());
	}
	
	public void assertHasPrintStreamCache() {
		String className = PrintStream.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Appendable.class.getName());
		assertContains(refsRefs, AutoCloseable.class.getName());
		assertContains(refsRefs, Closeable.class.getName());
		assertContains(refsRefs, FilterOutputStream.class.getName());
		assertContains(refsRefs, Flushable.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, OutputStream.class.getName());
		assertEquals(7, refsRefs.size());
	}
	
	public void assertHasThrowableCache() {
		String className = Throwable.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Serializable.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertEquals(2, refsRefs.size());
	}
	
	
	
	public void assertHasExceptionCache() {
		String className = Exception.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, Throwable.class.getName());
		assertContains(refsRefs, Serializable.class.getName());
		assertEquals(3, refsRefs.size());
	}
	
	public void assertHasNumberCache() {
		String className = Number.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, Serializable.class.getName());
		assertEquals(2, refsRefs.size());
	}
	
	public void assertHasLongCache() {
		String className = Long.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, Serializable.class.getName());
		assertContains(refsRefs, Number.class.getName());
		assertContains(refsRefs, Comparable.class.getName());
		assertEquals(4, refsRefs.size());
	}
	
	public void assertHasStringCache() {
		String className = String.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, Serializable.class.getName());
		assertContains(refsRefs, CharSequence.class.getName());
		assertContains(refsRefs, Comparable.class.getName());
		assertEquals(4, refsRefs.size());
	}
	
	public void assertHasMockExceptionCache() {
		String className = MockException.class.getName();
		Map<String,I_ClassAssociationsLocal> refsCache = trial.getRefsCache();
		I_ClassAssociations refs =  refsCache.get(className);
		assertMockExceptionRefs(className, refs);
	}

	private void assertMockExceptionRefs(String className,
			I_ClassAssociations refs) {
		assertNotNull(refs);
		assertEquals(className, refs.getName());
		assertFalse(refs.hasCircularDependencies());
		
		Set<String> refsRefs = refs.getDependencyNames();
		assertContains(refsRefs, Serializable.class.getName());
		assertContains(refsRefs, Object.class.getName());
		assertContains(refsRefs, Throwable.class.getName());
		assertContains(refsRefs, Exception.class.getName());
		assertContains(refsRefs, className);
		assertEquals(5, refsRefs.size());
	}
	
	public void assertHasAllCache() {
		assertHasObjectCache();
		assertHasThrowableCache();
		assertHasExceptionCache();
		assertHasMockExceptionCache();
		
		assertHasSerilizableCache();
		assertHasCharSequenceCache();
		
		assertHasCompareableCache();
		assertHasStringCache();
		
		assertHasMockExceptionCache();
		assertHasMockWithNothingCache();
		assertHasMockWithStringCache();
	}
}
