package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.Flushable;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.common.I_OrderedClassDependencies;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_OtherStringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;
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

public class DAT_Assert_MockWithEverything extends TrialDelegate {
	private I_DiscoveryApiTrial trial;
	
	public DAT_Assert_MockWithEverything(I_DiscoveryApiTrial p) {
		super(p);
		trial = p;
	}

	public void test() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithEverything.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertOrder(ccbClassLoader, className, order);
		
		assertReferences(orderedClassDiscovery, clazz);
		
		assertHasMockWithEverythingCache();
	}
	

	private void assertOrder(I_CachedClassBytesClassLoader ccbClassLoader,
			String clazzName, List<String> order) {
		assertNotNull(order);
		
		assertOrder(order);
		assertEquals(57, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
	}

	public int assertOrder( List<String> order) {
		int counter = 0;
		String clazzName = MockWithEverything.class.getName();
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(Serializable.class.getName(), order.get(counter++));
		assertEquals(Comparable.class.getName(), order.get(counter++));
		assertEquals(CharSequence.class.getName(), order.get(counter++));
		
		
		assertEquals(MockWithNothing.class.getName(), order.get(counter++));
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(AutoCloseable.class.getName(), order.get(counter++));
		assertEquals(Closeable.class.getName(), order.get(counter++));
		assertEquals(Flushable.class.getName(), order.get(counter++));
		assertEquals(Appendable.class.getName(), order.get(counter++));
		
		assertEquals(Number.class.getName(), order.get(counter++));
		assertEquals(OutputStream.class.getName(), order.get(counter++));
		
		assertEquals(Long.class.getName(), order.get(counter++));
		
		
		
		assertEquals(Throwable.class.getName(), order.get(counter++));
		
		
		
		
		assertEquals(FilterOutputStream.class.getName(), order.get(counter++));
		assertEquals(Exception.class.getName(), order.get(counter++));
		
		assertEquals(PrintStream.class.getName(), order.get(counter++));
		
		assertEquals(MockException.class.getName(), order.get(counter++));
		
		assertEquals(MockI_GetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetString.class.getName(), order.get(counter++));
		assertEquals(MockI_SetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_SetString.class.getName(), order.get(counter++));
		
		assertEquals(I_System.class.getName(), order.get(counter++));
		
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(counter++));
		
		
		assertEquals(MockWithTriangleA.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleB.class.getName(), order.get(counter++));
		assertEquals(MockWithTriangleC.class.getName(), order.get(counter++));
		
		assertEquals("java.lang.AbstractStringBuilder", order.get(counter++));	
		assertEquals(AnnotatedElement.class.getName(), order.get(counter++));
		assertEquals(GenericDeclaration.class.getName(), order.get(counter++));
		assertEquals(Type.class.getName(), order.get(counter++));
		
		assertEquals(MockI_StringAndLong.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(counter++));
		
		assertEquals(MockWithExtensionA.class.getName(), order.get(counter++));
		assertEquals(MockWithMethodException.class.getName(), order.get(counter++));
		assertEquals(MockWithMethodReturn.class.getName(), order.get(counter++));
		
		assertEquals(Class.class.getName(), order.get(counter++));
		assertEquals(Math.class.getName(), order.get(counter++));
		
		assertEquals(StringBuilder.class.getName(), order.get(counter++));	
		
		assertEquals(System.class.getName(), order.get(counter++));
		assertEquals(MockI_OtherStringAndLong.class.getName(), order.get(counter++));
		assertEquals(MockWithAbstractMethodException.class.getName(), order.get(counter++));
		
		assertEquals(MockWithAbstractMethodParam.class.getName(), order.get(counter++));
		assertEquals(MockWithAbstractMethodReturn.class.getName(), order.get(counter++));
		assertEquals(MockWithArray.class.getName(), order.get(counter++));
		assertEquals(MockWithExtensionB.class.getName(), order.get(counter++));
		
		assertEquals(MockWithField.class.getName(), order.get(counter++));
		assertEquals(MockWithImportOnlyInMethod.class.getName(), order.get(counter++));
		
		assertEquals(MockWithMethodExceptionBlock.class.getName(), order.get(counter++));
		
		assertEquals(MockWithMethodParams.class.getName(), order.get(counter++));
		assertEquals(MockWithStaticField.class.getName(), order.get(counter++));
		assertEquals(MockWithStaticInitalizer.class.getName(), order.get(counter++));
		
		
		
		assertEquals(MockWithString.class.getName(), order.get(counter++));
		
		assertEquals(clazzName, order.get(counter++));
		assertEquals(clazzName + "$1", order.get(counter++));
		assertEquals(57, counter);
		return counter;
	}
	

	private void assertReferences(OrderedClassDiscovery orderedClassDiscovery, Class<?> clazz) {
		String clazzName = clazz.getName();
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertRefs(clazzName, cr);
		assertHasMockWithEverythingCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(57, refsCache.size());
	}

	public void assertHasMockWithEverythingCache() { 
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasAllCache();
		
		DAT_Assert_Linear_to_10 l10 = trial.getLinear_to10();
		l10.assertHasAllCache();
		
		DAT_Assert_Linear_to_20 l20 = trial.getLinear_to20();
		l20.assertHasAllCache();
		
		DAT_Assert_Linear_to_30 l30 = trial.getLinear_to30();
		l30.assertHasAllCache();
		
		DAT_Assert_Circular_to_10 c10 = trial.getCircular_to_10();
		c10.assertHasAllCache();
		
		String className = MockWithEverything.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		
		
		assertRefs(className, crefs);
	}

	private void assertRefs(String className, I_ClassDependenciesLocal crefs) {
		
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertTrue(crefs.hasCircularDependencies());
		
		Set<String> circles = crefs.getCircularDependenciesNames();
		assertContains(circles, className + "$1");
		assertEquals(1, circles.size());
		
		Set<String> refs = crefs.getDependencyNames();
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
		
		assertContains(refs, className + "$1");
		assertContains(refs, className);
		
		assertEquals(57, refs.size());
	}
}
