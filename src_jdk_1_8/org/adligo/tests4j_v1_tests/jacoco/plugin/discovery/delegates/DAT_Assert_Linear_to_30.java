package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_OtherStringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;

public class DAT_Assert_Linear_to_30 extends TrialDelegate {
	private I_DiscoveryApiTrial trial;
	
	public DAT_Assert_Linear_to_30(I_DiscoveryApiTrial p) {
		super(p);
		trial = p;
	}


	public void delegate021_MockI_OtherStringAndLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		OrderedClassDiscovery orderedClassDiscovery = trial.getOrderedClassDiscovery();
		
		Class<?> clazz = MockI_OtherStringAndLong.class;
		String className = clazz.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_OrderedClassDependencies ocd = orderedClassDiscovery.findOrLoad(MockI_OtherStringAndLong.class);
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

		assertEquals(MockI_GetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetString.class.getName(), order.get(counter++));
		
		assertEquals(MockI_SetLong.class.getName(), order.get(counter++));		
		assertEquals(MockI_SetString.class.getName(), order.get(counter++));
		
		assertEquals(MockI_GetAndSetLong.class.getName(), order.get(counter++));
		assertEquals(MockI_GetAndSetString.class.getName(), order.get(counter++));

		//1 counts
		assertEquals(MockI_StringAndLong.class.getName(), order.get(counter++));
		assertEquals(className, order.get(counter++));
		assertEquals(counter, order.size());
		assertTrue(ccbClassLoader.hasCache(className));
		
		Set<I_Dependency> deps = orderedClassDiscovery.toDependencies(className);
		Iterator<I_Dependency> it = deps.iterator();
		I_Dependency dep =  it.next();
		I_ClassAlias alias = dep.getAlias();
		assertEquals(Serializable.class.getName(), alias.getName());
		assertEquals(11, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Object.class.getName(), alias.getName());
		assertEquals(11, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Comparable.class.getName(), alias.getName());
		assertEquals(10, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(CharSequence.class.getName(), alias.getName());
		assertEquals(6, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Number.class.getName(), alias.getName());
		assertEquals(6, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(Long.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(String.class.getName(), alias.getName());
		assertEquals(5, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetLong.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());

		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetString.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_SetLong.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_SetString.class.getName(), alias.getName());
		assertEquals(3, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetAndSetLong.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_GetAndSetString.class.getName(), alias.getName());
		assertEquals(2, dep.getReferences());
		
		dep =  it.next();
		alias = dep.getAlias();
		assertEquals(MockI_StringAndLong.class.getName(), alias.getName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(14, deps.size());
		I_ClassDependenciesLocal cr =  orderedClassDiscovery.getReferences(new ClassAliasLocal(clazz));
		assertMockI_OtherStringAndLongCacheRefs(className, cr);
		
		DAT_Assert_Simple simple = trial.getSimple();
		simple.assertHasObjectCache();
		simple.assertHasSerilizableCache();
		simple.assertHasCharSequenceCache();
		
		simple.assertHasCompareableCache();
		simple.assertHasNumberCache();
		simple.assertHasLongCache();
		simple.assertHasStringCache();
		
		
		DAT_Assert_Linear_to_20 to20 = trial.getLinear_to20();
		to20.assertHasMockI_GetLongCache();
		to20.assertHasMockI_SetLongCache();
		to20.assertHasMockI_GetAndSetLongCache();
		
		to20.assertHasMockI_GetStringCache();
		to20.assertHasMockI_SetStringCache();
		to20.assertHasMockI_GetAndSetStringCache();
		
		to20.assertHasMockI_StringAndLongCache();
		assertHasMockI_OtherStringAndLongCache();
		
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		assertEquals(15, refsCache.size());
	}
	
	public void assertHasMockI_OtherStringAndLongCache() {
		String className = MockI_OtherStringAndLong.class.getName();
		Map<String,I_ClassDependenciesLocal> refsCache = trial.getRefsCache();
		I_ClassDependenciesLocal crefs =  refsCache.get(className);
		assertMockI_OtherStringAndLongCacheRefs(className, crefs);
	}


	private void assertMockI_OtherStringAndLongCacheRefs(String className,
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
		
		assertContains(refs, MockI_StringAndLong.class.getName());
		assertContains(refs, className);
		assertEquals(15, refs.size());
	}
	
	public void assertHasAllCache() {
		assertHasMockI_OtherStringAndLongCache();
	}
}
