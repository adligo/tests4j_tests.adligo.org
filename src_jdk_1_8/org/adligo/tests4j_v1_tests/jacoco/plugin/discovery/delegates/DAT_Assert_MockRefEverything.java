package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.common.I_OrderedClassDependencies;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
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
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithImportOnlyInMethod;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithRefMockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

public class DAT_Assert_MockRefEverything extends TrialDelegate {
	private I_DiscoveryApiTrial trial;
	
	public DAT_Assert_MockRefEverything(I_DiscoveryApiTrial p) {
		super(p);
		trial = p;
	}

	public void test() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockWithRefMockWithEverything.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(clazz);
		List<String> order = ocd.getOrder();
		assertOrder(ccbClassLoader, className, order);
		
		assertReferences(orderedClassDiscovery, clazz);
	}


	private void assertOrder(I_CachedClassBytesClassLoader ccbClassLoader,
			String clazzName, List<String> order) {
		assertNotNull(order);
		
		DAT_Assert_MockWithEverything everything = trial.getEverythingDelegate();
		int counter = everything.assertOrder(order);
		 
		assertEquals(clazzName, order.get(counter++));
		
		assertEquals(58, counter);
		assertEquals(58, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		DAT_Assert_MockWithEverything ed = trial.getEverythingDelegate();
		ed.assertHasMockWithEverythingCache();
		assertHasMockWithRefMockWithEverythingCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(58, refsCache.size());
	}
	
	
	private void assertReferences(OrderedClassDiscovery orderedClassDiscovery, Class<?> clazz) {
		String clazzName = clazz.getName();
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertRefs(clazzName, cr);
	}

	public void assertHasMockWithRefMockWithEverythingCache() { 
		
		
		String className = MockWithRefMockWithEverything.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertRefs(className, crefs);
	}

	private void assertRefs(String className, I_ClassDependenciesLocal crefs) {
		
		assertNotNull(crefs);
		assertEquals(className, crefs.getName());
		assertFalse(crefs.hasCircularDependencies());
		
		Set<String> refs = crefs.getDependencyNames();
		assertNotNull(refs);
		assertContains(refs, Object.class.getName());
		assertContains(refs, Serializable.class.getName());
		assertContains(refs, Throwable.class.getName());
		assertContains(refs, Exception.class.getName());
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
		
		assertContains(refs, MockWithEverything.class.getName() + "$1");
		assertContains(refs, MockWithEverything.class.getName());
		assertContains(refs, className);
		
		assertEquals(58, refs.size());
	}
	
	
}
