package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_OtherStringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;

public class CRDT_Assert_Linear_to_30 extends TrialDelegate {
	private I_ClassReferencesDiscoveryTrial trial;
	
	public CRDT_Assert_Linear_to_30(I_ClassReferencesDiscoveryTrial p) {
		super(p);
		trial = p;
	}


	public void delegate021_MockI_OtherStringAndLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassReferencesDiscovery crd = trial.getClassReferenceDiscovery();
		
		String className = MockI_OtherStringAndLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		List<String> order = crd.discoverAndLoad(MockI_OtherStringAndLong.class);
		assertNotNull(order);
		
		//4 counts
		assertEquals(Long.class.getName(), order.get(0));
		assertEquals(String.class.getName(), order.get(1));
		
		//2 counts
		assertEquals(MockI_GetLong.class.getName(), order.get(2));
		assertEquals(MockI_GetString.class.getName(), order.get(3));
		assertEquals(MockI_SetLong.class.getName(), order.get(4));
		assertEquals(MockI_SetString.class.getName(), order.get(5));
		
		//1 counts
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(6));
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(7));
		
		assertEquals(MockI_StringAndLong.class.getName(), order.get(8));
		assertEquals(className, order.get(9));
		assertEquals(10, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = crd.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		assertEquals(Long.class.getName(), dep.getClassName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		assertEquals(MockI_GetLong.class.getName(), dep.getClassName());
		assertEquals(3, dep.getReferences());

		dep =  it.next();
		assertEquals(MockI_GetString.class.getName(), dep.getClassName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		assertEquals(MockI_SetLong.class.getName(), dep.getClassName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		assertEquals(MockI_SetString.class.getName(), dep.getClassName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		assertEquals(MockI_GetAndSetLong.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		assertEquals(MockI_GetAndSetString.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		assertEquals(MockI_StringAndLong.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(9, deps.size());
		I_ClassReferences cr =  crd.getReferences(className);
		assertMockI_OtherStringAndLongCacheRefs(className, cr);
		
		CRDT_Assert_Linear_to_20 to20 = trial.getLinear_to20();
		to20.assertHasMockI_GetLongCache();
		to20.assertHasMockI_SetLongCache();
		to20.assertHasMockI_GetAndSetLongCache();
		
		to20.assertHasMockI_GetStringCache();
		to20.assertHasMockI_SetStringCache();
		to20.assertHasMockI_GetAndSetStringCache();
		
		to20.assertHasMockI_StringAndLongCache();
		assertHasMockI_OtherStringAndLongCache();
		
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		assertEquals(8, refsCache.size());
	}
	
	public void assertHasMockI_OtherStringAndLongCache() {
		String className = MockI_OtherStringAndLong.class.getName();
		Map<String,I_ClassReferences> refsCache = trial.getRefsCache();
		I_ClassReferences crefs =  refsCache.get(className);
		assertMockI_OtherStringAndLongCacheRefs(className, crefs);
	}


	private void assertMockI_OtherStringAndLongCacheRefs(String className,
			I_ClassReferences crefs) {
		assertNotNull(crefs);
		assertEquals(className, crefs.getClassName());
		assertFalse(crefs.hasCircularReferences());
		
		Set<String> refs = crefs.getReferences();
		assertNotNull(refs);
		assertContains(refs, String.class.getName());
		assertContains(refs, Long.class.getName());
		
		
		assertContains(refs, MockI_GetString.class.getName());
		assertContains(refs, MockI_SetString.class.getName());
		assertContains(refs, MockI_GetLong.class.getName());
		assertContains(refs, MockI_SetLong.class.getName());
		
		assertContains(refs, MockI_GetAndSetString.class.getName());
		assertContains(refs, MockI_GetAndSetLong.class.getName());
		
		assertContains(refs, MockI_StringAndLong.class.getName());
		assertContains(refs, className);
		assertEquals(10, refs.size());
	}
	
	public void assertHasAllCache() {
		assertHasMockI_OtherStringAndLongCache();
	}
}
