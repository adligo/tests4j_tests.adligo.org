package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassFilter;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_DiscoveryMemory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CRDT_Assert_Circular_to_10;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CRDT_Assert_Linear_to_10;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CRDT_Assert_Linear_to_20;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CRDT_Assert_Linear_to_30;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CRDT_Assert_MockRefEverything;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CRDT_Assert_MockWithEverything;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.CRDT_Assert_Simple;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.delegates.I_ClassReferencesDiscoveryTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=ClassReferencesDiscovery.class, minCoverage=89.0)
public class ClassReferencesDiscoveryTrial extends SourceFileCountingTrial implements I_DiscoveryMemory, I_ClassReferencesDiscoveryTrial {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassReferencesDiscovery classReferenceDiscovery;
	private Map<String,I_ClassReferences> refsCache = new HashMap<String, I_ClassReferences>();
	private final ClassFilter classFilter = new ClassFilter();
	private Tests4J_LogMock logMock = new Tests4J_LogMock();
	private I_ClassFilter primitiveClassFilter;
	private CRDT_Assert_Simple simple;
	private CRDT_Assert_Linear_to_10 linear_to10;
	private CRDT_Assert_Linear_to_20 linear_to20;
	private CRDT_Assert_Linear_to_30 linear_to30;
	private CRDT_Assert_Circular_to_10 circular;
	private CRDT_Assert_MockWithEverything everythingDelegate;
	
	public ClassReferencesDiscoveryTrial() {
		ClassFilterMutant cfm = new ClassFilterMutant();
		cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
		primitiveClassFilter =new ClassFilter(cfm);
		
		simple = new CRDT_Assert_Simple(this);
		linear_to10 = new CRDT_Assert_Linear_to_10(this);
		linear_to20 = new CRDT_Assert_Linear_to_20(this);
		linear_to30 = new CRDT_Assert_Linear_to_30(this);
		circular = new CRDT_Assert_Circular_to_10(this);
		everythingDelegate = new CRDT_Assert_MockWithEverything(this);
		
	}
	@Override
	public void beforeTests() {
		ccbClassLoader = new CachedClassBytesClassLoader(logMock);
		classReferenceDiscovery = new ClassReferencesDiscovery(ccbClassLoader, logMock, this);
		
		
		refsCache.clear();
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
	public void test0003_MockWithString() throws Exception {
		simple.delegate003_MockException();
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
		CRDT_Assert_MockRefEverything delegate = new CRDT_Assert_MockRefEverything(this);
		delegate.test();
	}
	
	@Override
	public void putDependenciesIfAbsent(I_ClassDependencies p) {
		throw new RuntimeException("This should not get called");
	}
	@Override
	public I_ClassDependencies getDependencies(String name) {
		throw new RuntimeException("This should not get called");
	}

	@Override
	public boolean isFiltered(Class<?> clazz) {
		return classFilter.isFiltered(clazz);
	}

	@Override
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
	public ClassReferencesDiscovery getClassReferenceDiscovery() {
		return classReferenceDiscovery;
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
	
	@Override
	public void putReferencesIfAbsent(I_ClassReferences p) {
		if (!refsCache.containsKey(p.getClassName())) {
			refsCache.put(p.getClassName(), p);
		}
	}
	
	@Override
	public I_ClassReferences getReferences(String name) {
		return refsCache.get(name);
	}

	public Map<String, I_ClassReferences> getRefsCache() {
		return refsCache;
	}

	public CRDT_Assert_Simple getSimple() {
		return simple;
	}
	public CRDT_Assert_Linear_to_10 getLinear_to10() {
		return linear_to10;
	}
	public CRDT_Assert_Linear_to_20 getLinear_to20() {
		return linear_to20;
	}
	public CRDT_Assert_Linear_to_30 getLinear_to30() {
		return linear_to30;
	}
	
	public CRDT_Assert_Circular_to_10 getCircular_to_10() {
		return circular;
	}
	
	public CRDT_Assert_MockWithEverything getEverythingDelegate() {
		return everythingDelegate;
	}
	@Override
	public int getTests() {
		return 31;
	}

	@Override
	public int getAsserts() {
		return 2386;
	}

	@Override
	public int getUniqueAsserts() {
		return 1129;
	}


}
