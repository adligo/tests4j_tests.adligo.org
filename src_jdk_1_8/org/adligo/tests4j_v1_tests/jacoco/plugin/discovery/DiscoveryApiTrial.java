package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesCache;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsCache;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j.shared.common.CacheControl;
import org.adligo.tests4j_4jacoco.plugin.discovery.CircularDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassParentsCache;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassParentsDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.FullDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.InitialDependenciesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingClassVisitor;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.ClassReferencesCacheMock;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.DAT_Assert_Circular_to_10;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.DAT_Assert_Linear_to_10;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.DAT_Assert_Linear_to_20;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.DAT_Assert_Linear_to_30;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.DAT_Assert_MockRefEverything;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.DAT_Assert_MockWithEverything;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.DAT_Assert_Simple;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.I_DiscoveryApiTrial;
import org.objectweb.asm.Opcodes;

@PackageScope (packageName="org.adligo.tests4j_4jacoco.plugin.discovery")
public class DiscoveryApiTrial extends ApiCountingTrial implements I_DiscoveryApiTrial, I_ClassDependenciesCache {
	private CachedClassBytesClassLoader ccbClassLoader;
	private OrderedClassDiscovery orderedClassDiscovery;
	private ClassReferencesCacheMock initialRefCache = new ClassReferencesCacheMock();
	private ClassReferencesCacheMock preCircleRefCache = new ClassReferencesCacheMock();
	
	private Map<String,I_ClassDependenciesLocal> refsCache = new HashMap<String, I_ClassDependenciesLocal>();
	private final ClassFilter classFilter;
	private Tests4J_LogMock logMock = new Tests4J_LogMock();
	private final I_ClassFilter primitiveClassFilter;
	private DAT_Assert_Simple simple;
	private DAT_Assert_Linear_to_10 linear_to10;
	private DAT_Assert_Linear_to_20 linear_to20;
	private DAT_Assert_Linear_to_30 linear_to30;
	private DAT_Assert_Circular_to_10 circular;
	private DAT_Assert_MockWithEverything everythingDelegate;

	private CacheControl cacheControl = new CacheControl();
	private ClassParentsCache parentsCache = new ClassParentsCache(cacheControl);
	
	public DiscoveryApiTrial() {
		ClassFilterMutant cfm = new ClassFilterMutant();
		primitiveClassFilter =new ClassFilter(cfm);
		
		ClassFilterMutant cfm2 = new ClassFilterMutant();
		cfm2.setIgnoredPackageNames(Collections.singleton("java."));
		classFilter = new ClassFilter(cfm2);
		
		simple = new DAT_Assert_Simple(this);
		linear_to10 = new DAT_Assert_Linear_to_10(this);
		linear_to20 = new DAT_Assert_Linear_to_20(this);
		linear_to30 = new DAT_Assert_Linear_to_30(this);
		circular = new DAT_Assert_Circular_to_10(this);
		everythingDelegate = new DAT_Assert_MockWithEverything(this);
		
		ccbClassLoader = new CachedClassBytesClassLoader(logMock, null, null
				, cacheControl);
		orderedClassDiscovery = new OrderedClassDiscovery();
		orderedClassDiscovery.setCache(this);
		orderedClassDiscovery.setLog(logMock);
		orderedClassDiscovery.setClassFilter(classFilter);
		
		ClassParentsDiscovery classParentsDiscovery = new ClassParentsDiscovery();
		classParentsDiscovery.setCache(parentsCache);
		classParentsDiscovery.setClassFilter(classFilter);
		classParentsDiscovery.setClassLoader(ccbClassLoader);
		classParentsDiscovery.setLog(logMock);
		
		InitialDependenciesDiscovery inital = new InitialDependenciesDiscovery();
		inital.setBasicClassFilter(primitiveClassFilter);
		inital.setCache(initialRefCache);
		inital.setClassFilter(classFilter);
		inital.setClassLoader(ccbClassLoader);
		inital.setClassParentsDiscovery(classParentsDiscovery);
		inital.setClassVisitor(new ReferenceTrackingClassVisitor(Opcodes.ASM5, logMock));
		inital.setLog(logMock);
		
		FullDependenciesDiscovery fullDependenciesDiscovery = new FullDependenciesDiscovery();
		fullDependenciesDiscovery.setCache(preCircleRefCache);
		fullDependenciesDiscovery.setLog(logMock);
		fullDependenciesDiscovery.setClassFilter(classFilter);
		fullDependenciesDiscovery.setInitialDependenciesDiscovery(inital);
		
		orderedClassDiscovery.setFullDependenciesDiscovery(fullDependenciesDiscovery);
		
		CircularDependenciesDiscovery circleDependencyDiscovery = new CircularDependenciesDiscovery();
		circleDependencyDiscovery.setCache(this);
		circleDependencyDiscovery.setFullDependenciesDiscovery(fullDependenciesDiscovery);
		circleDependencyDiscovery.setClassFilter(classFilter);
		circleDependencyDiscovery.setLog(logMock);
		
		orderedClassDiscovery.setCircularDependenciesDiscovery(circleDependencyDiscovery);
		
	}
	@Override
	public void beforeTests() {
		cacheControl.clear();
		refsCache.clear();
		initialRefCache.clear();
		preCircleRefCache.clear();
	}
	
	@Test
	public void test0001_MockWithNothing() throws Exception {
		simple.delegate001_MockWithNothing();
	}


	@Test
	public void test0002_MockWithString() throws Exception {
		simple.delegate002_MockWithString();
	}
	
	@Test
	public void test0003_MockException() throws Exception {
		simple.delegate003_MockException();
	}
	
	@Test
	public void test0004_MockWithCallToArithmeticExceptionConstructor() throws Exception {
		simple.delegate004_MockWithCallToArithmeticException();
	}
	
	/**
	 * 1000 start linear assertions
	 * @throws Exception
	 */
	@Test
	public void test1001_MockWithMethodReturn() throws Exception {
		linear_to10.delegate001_MockWithMethodReturn();
	}
	
	@Test
	public void test1002_MockWithFeild() throws Exception {
		linear_to10.delegate002_MockWithFeild();
	}

	@Test
	public void test1003_MockWithMethodParams() throws Exception {
		linear_to10.delegate003_MockWithMethodParams();
	}
	
	@Test
	public void test1004_MockWithImportOnlyInMethod() throws Exception {
		linear_to10.delegate004_MockWithImportOnlyInMethod();
	}
	
	@Test
	public void test1005_MockWithStaticFeild() throws Exception {
		linear_to10.delegate005_MockWithStaticFeild();
	}
	
	@Test
	public void test1006_MockWithStaticInitalizer() throws Exception {
		linear_to10.delegate006_MockWithStaticInitalizer();
	}
	
	@Test
	public void test1007_MockWithArray() throws Exception {
		linear_to10.delegate007_MockWithArray();
	}
	
	@Test
	public void test1008_MockWithMethodException() throws Exception {
		linear_to10.delegate008_MockWithMethodException();
	}
	
	@Test
	public void test1009_MockWithMethodExceptionBlock() throws Exception {
		linear_to10.delegate009_MockWithMethodExceptionBlock();
	}
	
	@Test
	public void test1010_MockWithAbstractMethodReturn() throws Exception {
		linear_to10.delegate010_MockWithAbstractMethodReturn();
	}
	
	@Test
	public void test1011_MockWithAbstractMethodParam() throws Exception {
		linear_to20.delegate011_MockWithAbstractMethodParam();
	}

	
	@Test
	public void test1012_MockWithExtensionA() throws Exception {
		linear_to20.delegate012_MockWithExtensionA();
	}
	
	@Test
	public void test1013_MockWithExtensionB() throws Exception {
		linear_to20.delegate013_MockWithExtensionB();
	}
	
	/**
	 * sushi anyone?
	 * @throws Exception
	 */
	@Test
	public void test1014_MockI_GetLong() throws Exception {
		linear_to20.delegate014_MockI_GetLong();
	}
	
	@Test
	public void test1015_MockI_SetLong() throws Exception {
		linear_to20.delegate015_MockI_SetLong();
	}
	
	@Test
	public void test1016_MockI_GetString() throws Exception {
		linear_to20.delegate016_MockI_GetString();
	}
	
	@Test
	public void test1017_MockI_SetString() throws Exception {
		linear_to20.delegate017_MockI_SetString();
	}
	
	@Test
	public void test1018_MockI_GetAndSetLong() throws Exception {
		linear_to20.delegate018_MockI_GetAndSetLong();
	}
	
	@Test
	public void test1019_MockI_GetAndSetString() throws Exception {
		linear_to20.delegate019_MockI_GetAndSetString();
	}
	
	@Test
	public void test1020_MockI_StringAndLong() throws Exception {
		linear_to20.delegate020_MockI_StringAndLong();
	}
	
	@Test
	public void test1021_MockI_OtherStringAndLong() throws Exception {
		linear_to30.delegate021_MockI_OtherStringAndLong();
	}
	
	/**
	 * 2000's are circular reference tests
	 * @throws Exception
	 */
	@Test
	public void test2001_MockWithBidirectionalA() throws Exception {
		circular.delegate001_MockWithBidirectionalA();
	}
	
	@Test
	public void test2002_MockWithBidirectionalB() throws Exception {
		circular.delegate002_MockWithBidirectionalB();
	}
	
	@Test
	public void test2003_MockWithTriangleA() throws Exception {
		circular.delegate003_MockWithTriangleA();
	}
	
	@Test
	public void test2004_MockWithTriangleB() throws Exception {
		circular.delegate004_MockWithTriangleB();
	}
	
	@Test
	public void test2005_MockWithTriangleC() throws Exception {
		circular.delegate005_MockWithTriangleC();
	}
	
	/**
	 * 3000's are large scale tests
	 * @throws Exception
	 */
	@Test
	public void test3001_MockWithEverything() throws Exception {
		everythingDelegate.test();
	}
	
	@Test
	public void test3002_MockRefEverything() throws Exception {
		DAT_Assert_MockRefEverything delegate = new DAT_Assert_MockRefEverything(this);
		delegate.test();
	}
	
	public boolean isFiltered(Class<?> clazz) {
		return classFilter.isFiltered(clazz);
	}

	public boolean isFiltered(String className) {
		return classFilter.isFiltered(className);
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassReferencesDiscoveryTrial#getBasicClassFilter()
	 */
	@Override
	public I_ClassFilter getBasicClassFilter() {
		return primitiveClassFilter;
	}
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassReferencesDiscoveryTrial#getCcbClassLoader()
	 */
	@Override
	public CachedClassBytesClassLoader getCcbClassLoader() {
		return ccbClassLoader;
	}
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassReferencesDiscoveryTrial#getClassReferenceDiscovery()
	 */
	@Override
	public OrderedClassDiscovery getOrderedClassDiscovery() {
		return orderedClassDiscovery;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassReferencesDiscoveryTrial#getClassFilter()
	 */
	@Override
	public ClassFilter getClassFilter() {
		return classFilter;
	}
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassReferencesDiscoveryTrial#getLogMock()
	 */
	@Override
	public Tests4J_LogMock getLogMock() {
		return logMock;
	}
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassReferencesDiscoveryTrial#getPrimitiveClassFilter()
	 */
	@Override
	public I_ClassFilter getPrimitiveClassFilter() {
		return primitiveClassFilter;
	}
	
	public void putDependenciesIfAbsent(I_ClassDependenciesLocal p) {
		assertEquals(ClassDependenciesLocal.class.getName(), p.getClass().getName());
		if (!refsCache.containsKey(p.getName())) {
			refsCache.put(p.getName(), p);
		}
	}
	
	public I_ClassDependenciesLocal getDependencies(String name) {
		return refsCache.get(name);
	}

	public Map<String, I_ClassDependenciesLocal> getRefsCache() {
		return refsCache;
	}

	public DAT_Assert_Simple getSimple() {
		return simple;
	}
	public DAT_Assert_Linear_to_10 getLinear_to10() {
		return linear_to10;
	}
	public DAT_Assert_Linear_to_20 getLinear_to20() {
		return linear_to20;
	}
	public DAT_Assert_Linear_to_30 getLinear_to30() {
		return linear_to30;
	}
	
	public DAT_Assert_Circular_to_10 getCircular_to_10() {
		return circular;
	}
	
	public DAT_Assert_MockWithEverything getEverythingDelegate() {
		return everythingDelegate;
	}
	
	public void putParentsIfAbsent(I_ClassParentsLocal p) {
		
	}
	public I_ClassParentsLocal getParents(String name) {
		return null;
	}
	public I_ClassDependenciesCache getInitialReferencesCache() {
		return initialRefCache;
	}
	public I_ClassDependenciesCache getPreCirclesReferencesCache() {
		return preCircleRefCache;
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 32);
	}

	@Override
	public int getAsserts(I_CountType type) {
		return super.getAsserts(type, 4019);
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		return super.getUniqueAsserts(type, 1896);
	}

}
