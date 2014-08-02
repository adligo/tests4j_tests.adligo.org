package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.system.I_Tests4J_System;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.ClassFilter;
import org.adligo.tests4j.run.discovery.I_ClassDependencies;
import org.adligo.tests4j.run.discovery.I_Dependency;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_DiscoveryMemory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockRefEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalB;
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
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;

// hmm minCoverage is 89% during a run of just this package and 81% during all the trials run
@SourceFileScope (sourceClass=ClassDependenciesDiscovery.class, minCoverage=81.0)
public class ClassDependenciesDiscoveryTrial extends SourceFileCountingTrial implements I_DiscoveryMemory {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassDependenciesDiscovery crd;
	private Map<String,I_ClassDependencies> depsCache = new HashMap<String, I_ClassDependencies>();
	private final ClassFilter classFilter = new ClassFilter();
	
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(super.getLog());
		crd = new ClassDependenciesDiscovery(ccbClassLoader, super.getLog(), this);
		depsCache.clear();
	}
	
	@Test
	public void test01_MockWithNothing() throws Exception {
		String clazzName = MockWithNothing.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
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
	}

	protected void assertHasMockWithNothingCache() {
		String clazzName = MockWithNothing.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		dep = cdeps.get(0);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(1, cdeps.size());
	}
	
	@Test
	public void test02_MockWithEverything() throws Exception {
		String clazzName = MockWithEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockWithEverything.class);
		assertEquals(MockWithEverything.class.getName(), cd.getClassName());
		cd.getDependencies();
		
		assertTrue(ccbClassLoader.hasCache(clazzName));

		assertHasMockWithEverythingCache();
		assertEquals(22, depsCache.size());
	}

	protected void assertHasMockWithEverythingCache() {
		assertHasMockWithNothingCache();
		assertHasMockWithMethodReturnCache();
		assertHasMockWithFieldCache();
		assertHasMockWithImportOnlyInMethodCache();
		assertHasMockWithStaticFieldCache();
		assertHasMockWithStaticInitalizerCache();
		assertHasMockWithArrayCache();
		assertHasMockWithMethodExceptionCache();
		assertHasMockWithMethodExceptionBlockCache();
		assertHasMockWithAbstractMethodExceptionCache();
		assertHasMockWithAbstractMethodParamCache();
		assertHasMockWithAbstractMethodReturnCache();
		
		assertHasMockWithBidirectionalACache();
		assertHasMockWithBidirectionalBCache();
		
		assertHasMockWithTriangleACache();
		assertHasMockWithTriangleBCache();
		assertHasMockWithTriangleCCache();
		
		String clazzName = MockWithEverything.class.getName();
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		List<I_Dependency> deps = cd.getDependencies();
		assertEquals(clazzName, cd.getClassName());
		assertNotNull(deps);
		Map<String, I_Dependency> dmap = new HashMap<String, I_Dependency>();
		for (I_Dependency d: deps) {
			dmap.put(d.getClassName(), d);
		}
		I_Dependency top = dmap.get(MockWithNothing.class.getName());
		assertNotNull(top);
		assertEquals(27, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(0));
		
		top = dmap.get(MockException.class.getName());
		assertNotNull(top);
		assertEquals(10, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(1));

		//C is here because it is referenced from MockWithEverything directly
		top = dmap.get(MockWithTriangleC.class.getName());
		assertNotNull(top);
		assertEquals(6, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(2));
		
		DependencyAssertHelper adh = new DependencyAssertHelper(cd);
		
		Set<String> fives = adh.getClassNames(5);
		assertContains(fives, MockWithTriangleA.class.getName());
		assertContains(fives, MockWithTriangleB.class.getName());
		assertContains(fives, MockWithMethodReturn.class.getName());
		assertContains(fives, I_Tests4J_System.class.getName());
		assertContains(fives, MockWithBidirectionalA.class.getName());
		assertEquals(5, fives.size());
		
		Set<String> fours = adh.getClassNames(4);
		assertContains(fours, MockWithMethodException.class.getName());
		assertContains(fours, MockWithBidirectionalB.class.getName());
		assertEquals(2, fours.size());
		
		Set<String> threes = adh.getClassNames(3);
		assertContains(threes, MockWithStaticField.class.getName());
		assertEquals(1, threes.size());
		
		Set<String> twos = adh.getClassNames(2);
		assertContains(twos, MockWithArray.class.getName());
		assertContains(twos, MockWithMethodExceptionBlock.class.getName());
		assertContains(twos, MockWithMethodParams.class.getName());
		assertContains(twos, MockWithField.class.getName());
		assertContains(twos, MockWithImportOnlyInMethod.class.getName());
		assertContains(twos, MockWithAbstractMethodParam.class.getName());
		assertContains(twos, MockWithAbstractMethodException.class.getName());
		assertContains(twos, MockWithStaticInitalizer.class.getName());
		assertContains(twos, MockWithAbstractMethodReturn.class.getName());
		assertEquals(9, twos.size());
		
		Set<String> ones = adh.getClassNames(1);
		assertContains(ones, clazzName);
		assertContains(ones, clazzName + "$1");
	}
	
	protected void assertHasMockWithMethodReturnCache() {
		String clazzName = MockWithMethodReturn.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		dep = cdeps.get(0);
		assertEquals(MockWithNothing.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		
		dep = cdeps.get(1);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(2, cdeps.size());
	}
	
	protected void assertHasMockWithFieldCache() {
		String clazzName = MockWithField.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		dep = cdeps.get(0);
		assertEquals(I_Tests4J_System.class.getName(), dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		
		dep = cdeps.get(1);
		assertEquals(clazzName, dep.getClassName());
		assertEquals(0, dep.getReferences());
		assertEquals(2, cdeps.size());
	}
	
	protected void assertHasMockWithMethodParamsCache() {
		String clazzName = MockWithMethodParams.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodReturn.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodParams.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithImportOnlyInMethodCache() {
		String clazzName = MockWithImportOnlyInMethod.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(I_Tests4J_System.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithImportOnlyInMethod.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithStaticFieldCache() {
		String clazzName = MockWithStaticField.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithStaticField.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithStaticInitalizerCache() {
		String clazzName = MockWithStaticInitalizer.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithStaticInitalizer.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithArrayCache() {
		String clazzName = MockWithArray.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithArray.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithMethodExceptionCache() {
		String clazzName = MockWithMethodException.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockException.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodException.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithMethodExceptionBlockCache() {
		String clazzName = MockWithMethodExceptionBlock.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockException.class.getName());
		assertNotNull(dep);
		assertEquals(2, dep.getReferences());

		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodException.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithMethodExceptionBlock.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(4, deps.size());
	}
	
	protected void assertHasMockWithAbstractMethodExceptionCache() {
		String clazzName = MockWithAbstractMethodException.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockException.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());

		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithAbstractMethodException.class.getName());
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(3, deps.size());
	}

	
	protected void assertHasMockWithAbstractMethodParamCache() {
		String clazzName = MockWithAbstractMethodParam.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		
		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithAbstractMethodReturnCache() {
		String clazzName = MockWithAbstractMethodReturn.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		

		dep = deps.get(MockWithNothing.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(0, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithBidirectionalACache() {
		String clazzName = MockWithBidirectionalA.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		

		dep = deps.get(MockWithBidirectionalB.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithBidirectionalBCache() {
		String clazzName = MockWithBidirectionalB.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		

		dep = deps.get(MockWithBidirectionalA.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(2, deps.size());
	}
	
	protected void assertHasMockWithTriangleACache() {
		String clazzName = MockWithTriangleA.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		

		dep = deps.get(MockWithTriangleB.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithTriangleC.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithTriangleBCache() {
		String clazzName = MockWithTriangleB.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		

		dep = deps.get(MockWithTriangleA.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithTriangleC.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(3, deps.size());
	}
	
	protected void assertHasMockWithTriangleCCache() {
		String clazzName = MockWithTriangleC.class.getName();
		I_Dependency dep;
		I_ClassDependencies cd = depsCache.get(clazzName);
		assertNotNull(cd);
		assertEquals(clazzName, cd.getClassName());
		List<I_Dependency> cdeps = cd.getDependencies();
		assertNotNull(cdeps);
		Map<String, I_Dependency> deps = new HashMap<String, I_Dependency>();
		for (I_Dependency d: cdeps) {
			deps.put(d.getClassName(), d);
		}
		

		dep = deps.get(MockWithTriangleA.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(MockWithTriangleB.class.getName());
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		
		dep = deps.get(clazzName);
		assertNotNull(dep);
		assertEquals(1, dep.getReferences());
		assertEquals(3, deps.size());
	}
	@Test
	@IgnoreTest
	public void test03_RefToMockWithEverything() throws Exception {
		String clazzName = MockRefEverything.class.getName();
		assertFalse(ccbClassLoader.hasCache(clazzName));
		I_ClassDependencies cd = crd.discoverAndLoad(MockRefEverything.class);
		assertEquals(clazzName, cd.getClassName());
		
		assertTrue(ccbClassLoader.hasCache(clazzName));
		assertHasMockWithEverythingCache();
		I_ClassDependencies cdeps = depsCache.get(clazzName);
		assertNotNull(cdeps);
		assertEquals(clazzName, cdeps.getClassName());
		
		List<I_Dependency> deps = cd.getDependencies();
		Map<String,I_Dependency> dmap = new HashMap<String,I_Dependency>();
		for (I_Dependency d: deps) {
			dmap.put(d.getClassName(), d);
		}
		
		I_Dependency top = dmap.get(MockWithNothing.class.getName());
		assertNotNull(top);
		assertEquals(15, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(0));
		
		top = dmap.get(MockException.class.getName());
		assertNotNull(top);
		assertEquals(4, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(1));
		
		top = dmap.get(MockWithMethodReturn.class.getName());
		assertNotNull(top);
		assertEquals(3, top.getReferences());
		//for ordering assert the order
		assertSame(top, deps.get(2));
		
		//can't assert the order of the 1 references
		top = dmap.get(MockWithArray.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithMethodExceptionBlock.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithMethodParams.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithField.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithImportOnlyInMethod.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithStaticInitalizer.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithAbstractMethodException.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithAbstractMethodReturn.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithAbstractMethodParam.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithEverything.class.getName());
		assertNotNull(top);
		assertEquals(1, top.getReferences());
		
		top = dmap.get(MockWithEverything.class.getName() + "$1");
		assertNotNull(top);
		assertEquals(0, top.getReferences());
		
		top = dmap.get(MockRefEverything.class.getName());
		assertNotNull(top);
		assertEquals(0, top.getReferences());
		
		assertHasMockWithEverythingCache();
		assertEquals(18, depsCache.size());
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 201;
	}

	@Override
	public int getUniqueAsserts() {
		return 136;
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

	@Override
	public boolean isFiltered(String className) {
		return classFilter.isFiltered(className);
	}
}
