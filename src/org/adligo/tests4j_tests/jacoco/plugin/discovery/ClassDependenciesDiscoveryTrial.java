package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.system.I_Tests4J_System;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.ClassFilter;
import org.adligo.tests4j.run.discovery.I_ClassDependencies;
import org.adligo.tests4j.run.discovery.I_ClassDependenciesCache;
import org.adligo.tests4j.run.discovery.I_Dependency;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_DiscoveryMemory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockRefEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithImportOnlyInMethod;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodExceptionBlock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;

@SourceFileScope (sourceClass=ClassReferencesDiscovery.class, minCoverage=50.0)
public class ClassDependenciesDiscoveryTrial extends SourceFileCountingTrial implements I_DiscoveryMemory {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassReferencesDiscovery crd;
	private Map<String,I_ClassDependencies> depsCache = new HashMap<String, I_ClassDependencies>();
	private final ClassFilter classFilter = new ClassFilter();
	
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(super.getLog());
		crd = new ClassReferencesDiscovery(ccbClassLoader, super.getLog(), this);
		depsCache.clear();
	}
	
	@Test
	public void test01_MockWithNothing() throws Exception {
		String clazzName = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		/*
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithNothing.class);
		assertEquals(MockWithNothing.class.getName(), cd.getClassName());
		List<I_Dependency> cdeps =  cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
		I_Dependency dep = cdeps.get(0);
		assertNotNull(dep);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(1, cdeps.size());
		
		assertHasMockWithNothingCache();
		assertEquals(1, depsCache.size());
		*/
	}

	
	
	@Override
	public int getTests() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getAsserts() {
		return 323;
	}

	@Override
	public int getUniqueAsserts() {
		return 201;
	}
	@Override
	public void putIfAbsent(I_ClassDependencies p) {
		depsCache.put(p.getClassName(),  p);
	}
	@Override
	public I_ClassDependencies get(String name) {
		return depsCache.get(name);
	}

	@Override
	public boolean isFiltered(Class<?> clazz) {
		return classFilter.isFiltered(clazz);
	}
}
