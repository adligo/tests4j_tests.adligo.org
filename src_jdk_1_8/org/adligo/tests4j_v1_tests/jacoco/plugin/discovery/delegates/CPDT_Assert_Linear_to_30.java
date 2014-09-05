package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.util.List;

import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_ClassParentsDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_OtherStringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;

public class CPDT_Assert_Linear_to_30 extends TrialDelegate {
	private I_ClassParentsDiscoveryTrial trial;
	
	public CPDT_Assert_Linear_to_30(I_ClassParentsDiscoveryTrial p) {
		super(p);
		trial = p;
	}


	public void delegate021_MockI_OtherStringAndLong() throws Exception {
		Class<?> clazz = MockI_OtherStringAndLong.class;
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		I_ClassParentsDiscovery classReferenceDiscovery = trial.getClassParentsDiscovery();
		
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		assertEquals(0, ccbClassLoader.getCacheSize());
		I_ClassParents cps = classReferenceDiscovery.findOrLoad(clazz);
		assertMockI_OtherStringAndLongParents((I_ClassParentsLocal) cps);

		assertTrue(ccbClassLoader.hasCache(MockI_GetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_SetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_GetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_SetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_GetAndSetLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_GetAndSetString.class.getName()));
		assertTrue(ccbClassLoader.hasCache(MockI_StringAndLong.class.getName()));
		assertTrue(ccbClassLoader.hasCache(className));
		assertEquals(8, ccbClassLoader.getCacheSize());
	}
	
	public void assertMockI_OtherStringAndLongParents(I_ClassParentsLocal cps) {
		CPDT_Assert_Simple simple = trial.getSimple();
		CPDT_Assert_Linear_to_20 linear20 = trial.getLinearTo20();
		
		
		assertNotNull(cps);
		Class<?> clazz = MockI_OtherStringAndLong.class;
		String className = clazz.getName();
		
		assertNotNull(cps);
		assertEquals(className, cps.getName());
		assertEquals(className, cps.getTarget().getName());
		
		List<I_ClassParents> parents = cps.getParents();
		assertNotNull(parents);
		simple.assertNoParents((I_ClassParentsLocal) parents.get(0), MockI_GetLong.class.getName());
		simple.assertNoParents((I_ClassParentsLocal) parents.get(1), MockI_SetLong.class.getName());
		linear20.assertMockI_GetAndSetLongParents((I_ClassParentsLocal) parents.get(2));
		simple.assertNoParents((I_ClassParentsLocal) parents.get(3), MockI_GetString.class.getName());
		simple.assertNoParents((I_ClassParentsLocal) parents.get(4), MockI_SetString.class.getName());
		linear20.assertMockI_GetAndSetStringParents((I_ClassParentsLocal) parents.get(5));
		linear20.assertMockI_StringAndLongParents((I_ClassParentsLocal) parents.get(6));
		assertEquals(7, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cps.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetLong.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetLong.class.getName(), parentNames.get(1));
		assertEquals(MockI_GetAndSetLong.class.getName(), parentNames.get(2));
		assertEquals(MockI_GetString.class.getName(), parentNames.get(3));
		assertEquals(MockI_SetString.class.getName(), parentNames.get(4));
		assertEquals(MockI_GetAndSetString.class.getName(), parentNames.get(5));
		assertEquals(MockI_StringAndLong.class.getName(), parentNames.get(6));
		assertEquals(7, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
}
