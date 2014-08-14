package org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_OtherStringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_StringAndLong;

public class CDDT_Assert_Linear_to_030 extends TrialDelegate {
	private I_ClassDependenciesDiscoveryTrial trial;
	
	public CDDT_Assert_Linear_to_030(I_ClassDependenciesDiscoveryTrial p) {
		super(p);
		trial = p;
	}
	
	
	public void delegate021_MockI_OtherStringAndLong() throws Exception {
		I_CachedClassBytesClassLoader ccbClassLoader = trial.getCcbClassLoader();
		ClassDependenciesDiscovery classDepsDiscovery = trial.getClassDepsDiscovery();
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		
		String className = MockI_OtherStringAndLong.class.getName();
		assertFalse(ccbClassLoader.hasCache(className));
		I_ClassDependencies cd = classDepsDiscovery.discoverAndLoad(MockI_OtherStringAndLong.class);
		assertTrue(ccbClassLoader.hasCache(className));
		
		assertMockI_OtherStringAndLong(className, cd);
		
		CDDT_Assert_Linear_to_020 linearTo20 = trial.getCDDT_Assert_Linear_to_020();
		linearTo20.assertHasMockI_GetStringCache();
		linearTo20.assertHasMockI_SetStringCache();
		linearTo20.assertHasMockI_GetAndSetStringCache();
		linearTo20.assertHasMockI_GetLongCache();
		linearTo20.assertHasMockI_SetLongCache();
		linearTo20.assertHasMockI_GetAndSetLongCache();
		linearTo20.assertHasMockI_StringAndLongCache();
		assertHasMockI_OtherStringAndLongCache();
		assertEquals(8, depsCache.size());
	}


	public void assertHasMockI_OtherStringAndLongCache() {
		Map<String, I_ClassDependencies> depsCache = trial.getDepsCache();
		String className = MockI_OtherStringAndLong.class.getName();
		I_ClassDependencies cd = depsCache.get(className);
		assertMockI_OtherStringAndLong(className, cd);
		
	}
	
	private void assertMockI_OtherStringAndLong(String className,
			I_ClassDependencies cd) {
		assertNotNull(cd);
		assertEquals(className, cd.getClassName());
		assertFalse(cd.hasCircularReferences());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(Long.class.getName(), dep.getClassName());
		assertEquals(12, dep.getReferences());
		
		dep = cdeps.get(1);
		assertNotNull(dep);
		assertEquals(String.class.getName(), dep.getClassName());
		assertEquals(12, dep.getReferences());
		
		dep = cdeps.get(2);
		assertNotNull(dep);
		assertEquals(MockI_GetLong.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(3);
		assertNotNull(dep);
		assertEquals(MockI_GetString.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(4);
		assertNotNull(dep);
		assertEquals(MockI_SetLong.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(5);
		assertNotNull(dep);
		assertEquals(MockI_SetString.class.getName(), dep.getClassName());
		assertEquals(4, dep.getReferences());
		
		dep = cdeps.get(6);
		assertNotNull(dep);
		assertEquals(MockI_GetAndSetLong.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(7);
		assertNotNull(dep);
		assertEquals(MockI_GetAndSetString.class.getName(), dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep = cdeps.get(8);
		assertNotNull(dep);
		assertEquals(MockI_StringAndLong.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		dep = cdeps.get(9);
		assertNotNull(dep);
		assertEquals(className, dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		assertEquals(10, cdeps.size());
	}
	
	public void assertHasAll() {
		assertHasMockI_OtherStringAndLongCache();
	}
}
