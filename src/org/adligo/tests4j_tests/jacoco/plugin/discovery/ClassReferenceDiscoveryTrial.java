package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.I_Dependency;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferenceDiscovery;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
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

@SourceFileScope (sourceClass=ClassReferenceDiscovery.class, minCoverage=50.0)
public class ClassReferenceDiscoveryTrial extends SourceFileCountingTrial {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassReferenceDiscovery crd;
	
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(super.getLog());
		crd = new ClassReferenceDiscovery(ccbClassLoader, super.getLog());
	}
	@Test
	public void test01_MockWithNothing() throws Exception {
		String clazzName = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		crd.discoverAndLoad(MockWithNothing.class);
		assertTrue(ccbClassLoader.hasCache(clazzName));
		List<I_Dependency> deps = crd.getDependencies();
		I_Dependency dep = deps.get(0);
		assertNotNull(dep);
		assertEquals(clazzName, dep.getClazzName());
		assertEquals(0, dep.getReferences());
		assertEquals(1, deps.size());
	}
	
	@Test
	public void test02_MockWithEverything() throws Exception {
		String clazzName = MockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		crd.discoverAndLoad(MockWithEverything.class);
		assertTrue(ccbClassLoader.hasCache(clazzName));
		List<I_Dependency> deps = crd.getDependencies();
		
		I_Dependency top = deps.get(0);
		assertEquals(6, top.getReferences());
		assertEquals(MockWithNothing.class.getName(), top.getClazzName());
		
		top = deps.get(1);
		assertEquals(4, top.getReferences());
		assertEquals(MockException.class.getName(), top.getClazzName());
		
		top = deps.get(2);
		assertEquals(3, top.getReferences());
		assertEquals(MockWithMethodReturn.class.getName(), top.getClazzName());
		
		
		Set<String> withTwo = new HashSet<String>();
		Set<String> withOne = new HashSet<String>();
		Set<String> withZero = new HashSet<String>();
		for (int i = 4; i < deps.size(); i++) {
			top = deps.get(i);
			if (top.getReferences() == 2) {
				withTwo.add(top.getClazzName());
			} else if (top.getReferences() == 1) {
				withOne.add(top.getClazzName());
			} else if (top.getReferences() == 0) {
				withZero.add(top.getClazzName());
			}
		}
		
		assertContains(withTwo, MockWithArray.class.getName());
		assertContains(withTwo, MockWithMethodExceptionBlock.class.getName());
		assertContains(withTwo, MockWithMethodParams.class.getName());
		assertContains(withTwo,  MockWithField.class.getName());
		assertContains(withTwo,  MockWithImportOnlyInMethod.class.getName());
		assertContains(withTwo,  MockWithStaticInitalizer.class.getName());
		
		assertEquals(7, withTwo.size());
		assertEquals(0, withOne.size());
		
		assertContains(withZero, clazzName);
		assertContains(withZero, clazzName + "$1");
		assertEquals(2, withZero.size());
	}

	@Test
	public void test02_RefToMockWithEverything() throws Exception {
		
	}
	
	@Override
	public int getTests() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getAsserts() {
		return 25;
	}

	@Override
	public int getUniqueAsserts() {
		return 25;
	}
}
