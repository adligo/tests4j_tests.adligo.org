package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
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
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithRefMockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

public class CRDT_Assert_MockRefEverything extends TrialDelegate {
	private I_ClassReferencesDiscoveryTrial trial;
	
	public CRDT_Assert_MockRefEverything(I_ClassReferencesDiscoveryTrial p) {
		super(p);
		trial = p;
	}

	public void test() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery crd = trial.getClassReferenceDiscovery();
		
		String clazzName = MockWithRefMockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		List<String> order = crd.discoverAndLoad(MockWithRefMockWithEverything.class);
		assertOrder(ccbClassLoader, clazzName, order);
		
		assertReferences(crd, clazzName);
	}


	private void assertOrder(I_CachedClassBytesClassLoader ccbClassLoader,
			String clazzName, List<String> order) {
		assertNotNull(order);
		
		int counter = 0;
		assertEquals(Object.class.getName(), order.get(counter++));
		
		assertEquals(MockWithNothing.class.getName(), order.get(counter++));
		assertEquals(String.class.getName(), order.get(counter++));
		assertEquals(Long.class.getName(), order.get(counter++));
		assertEquals(Exception.class.getName(), order.get(counter++));
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
		
		assertEquals(MockI_StringAndLong.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalA.class.getName(), order.get(counter++));
		assertEquals(MockWithBidirectionalB.class.getName(), order.get(counter++));
		
		assertEquals(MockWithExtensionA.class.getName(), order.get(counter++));
		assertEquals(MockWithMethodException.class.getName(), order.get(counter++));
		assertEquals(MockWithMethodReturn.class.getName(), order.get(counter++));
		
		assertEquals(PrintStream.class.getName(), order.get(counter++));
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
		
		assertEquals(MockWithEverything.class.getName(), order.get(counter++));
		
		assertEquals(MockWithEverything.class.getName() + "$1", order.get(counter++));
		assertEquals(clazzName, order.get(counter++));
		
		assertEquals(43, counter);
		assertEquals(43, order.size());
		assertTrue(ccbClassLoader.hasCache(clazzName));
		
		CRDT_Assert_MockWithEverything ed = trial.getEverythingDelegate();
		ed.assertHasMockWithEverythingCache();
		assertHasMockWithRefMockWithEverythingCache();
		
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		assertEquals(34, refsCache.size());
	}
	
	
	private void assertReferences(ClassReferencesDiscovery crd, String clazzName) {
		I_ClassReferences cr =  crd.getReferences(clazzName);
		assertRefs(clazzName, cr);
	}

	public void assertHasMockWithRefMockWithEverythingCache() { 
		
		
		String className = MockWithRefMockWithEverything.class.getName();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		I_ClassReferences crefs =  refsCache.get(className);
		assertRefs(className, crefs);
	}

	private void assertRefs(String className, I_ClassReferences crefs) {
		
		assertNotNull(crefs);
		assertEquals(className, crefs.getClassName());
		assertFalse(crefs.hasCircularReferences());
		
		Set<String> refs = crefs.getReferences();
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
		
		assertContains(refs, MockWithEverything.class.getName() + "$1");
		assertContains(refs, MockWithEverything.class.getName());
		assertContains(refs, className);
		
		assertEquals(43, refs.size());
	}
	
	
}
