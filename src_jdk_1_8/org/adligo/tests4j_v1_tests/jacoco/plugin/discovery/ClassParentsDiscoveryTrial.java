package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.adligo.tests4j.models.shared.association.ClassParentsLocal;
import org.adligo.tests4j.models.shared.association.I_ClassParentsCache;
import org.adligo.tests4j.models.shared.association.I_ClassParentsLocal;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j.run.helpers.ClassFilter;
import org.adligo.tests4j.run.helpers.ClassFilterMutant;
import org.adligo.tests4j.shared.common.CacheControl;
import org.adligo.tests4j.system.shared.trials.IgnoreTest;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassParentsDiscovery;
import org.adligo.tests4j_4jacoco.plugin.discovery.I_ClassParentsDiscovery;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetString;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetString;
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
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithRefMockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;
import org.adligo.tests4j_tests.system.shared.mocks.Tests4J_LogMock;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.CPDT_Assert_Linear_to_20;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.CPDT_Assert_Linear_to_30;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.CPDT_Assert_Simple;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.ClassReferencesCacheMock;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.delegates.I_ClassParentsDiscoveryTrial;

@SourceFileScope (sourceClass=ClassParentsDiscovery.class, minCoverage=81.0)
public class ClassParentsDiscoveryTrial extends SourceFileCountingTrial implements I_ClassParentsCache, I_ClassParentsDiscoveryTrial {
	private CachedClassBytesClassLoader ccbClassLoader;
	private ClassParentsDiscovery classParentsDiscovery;
	
	private Map<String,I_ClassParentsLocal> parentsCache = new HashMap<String, I_ClassParentsLocal>();
	private final ClassFilter classFilter = new ClassFilter();
	private Tests4J_LogMock logMock = new Tests4J_LogMock();
	private CPDT_Assert_Simple simple;
	private CPDT_Assert_Linear_to_20 linearTo20;
	private CPDT_Assert_Linear_to_30 linearTo30;
	private CacheControl cacheControl = new CacheControl();
	
	public ClassParentsDiscoveryTrial() {
		ClassFilterMutant cfm = new ClassFilterMutant();
		cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
		simple = new CPDT_Assert_Simple(this);
		linearTo20 = new CPDT_Assert_Linear_to_20(this);
		linearTo30 = new CPDT_Assert_Linear_to_30(this);
		
		ccbClassLoader = new CachedClassBytesClassLoader(logMock,
				null,null, cacheControl);
		
		
		classParentsDiscovery = new ClassParentsDiscovery();
		classParentsDiscovery.setCache(this);
		classParentsDiscovery.setLog(logMock);
		classParentsDiscovery.setClassFilter(classFilter);
		classParentsDiscovery.setClassLoader(ccbClassLoader);
	}
	@Override
	public void beforeTests() {
		parentsCache.clear();
		cacheControl.clear();
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
		simple.delegateObjectOnlyParents(MockWithMethodReturn.class);
	}
	
	@Test
	public void test1002_MockWithFeild() throws Exception {
		simple.delegateObjectOnlyParents(MockWithField.class);
	}

	@Test
	public void test1003_MockWithMethodParams() throws Exception {
		simple.delegateObjectOnlyParents(MockWithMethodParams.class);
	}
	
	@Test
	public void test1004_MockWithImportOnlyInMethod() throws Exception {
		simple.delegateObjectOnlyParents(MockWithImportOnlyInMethod.class);
	}
	
	@Test
	public void test1005_MockWithStaticFeild() throws Exception {
		simple.delegateObjectOnlyParents(MockWithStaticField.class);
	}
	
	@Test
	public void test1006_MockWithStaticInitalizer() throws Exception {
		simple.delegateObjectOnlyParents(MockWithStaticInitalizer.class);
	}
	
	@Test
	public void test1007_MockWithArray() throws Exception {
		simple.delegateObjectOnlyParents(MockWithArray.class);
	}
	
	
	@Test
	public void test1008_MockWithMethodException() throws Exception {
		simple.delegateObjectOnlyParents(MockWithMethodException.class);
	}
	
	@Test
	public void test1009_MockWithMethodExceptionBlock() throws Exception {
		simple.delegateObjectOnlyParents(MockWithMethodExceptionBlock.class);
	}
	
	@Test
	public void test1010_MockWithAbstractMethodReturn() throws Exception {
		simple.delegateObjectOnlyParents(MockWithAbstractMethodReturn.class);
	}
	
	@Test
	public void test1011_MockWithAbstractMethodParam() throws Exception {
		simple.delegateObjectOnlyParents(MockWithAbstractMethodParam.class);
	}

	@Test
	public void test1012_MockWithExtensionA() throws Exception {
		linearTo20.delegate012_MockWithExtensionA();
	}
	
	@Test
	public void test1013_MockWithExtensionB() throws Exception {
		linearTo20.delegate013_MockWithExtensionB();
	}
	
	/**
	 * sushi anyone?
	 * @throws Exception
	 */
	@Test
	public void test1014_MockI_GetLong() throws Exception {
		simple.delegateNoParents(MockI_GetLong.class);
	}
	
	@Test
	public void test1015_MockI_SetLong() throws Exception {
		simple.delegateNoParents(MockI_SetLong.class);
	}
	
	@Test
	public void test1016_MockI_GetString() throws Exception {
		simple.delegateNoParents(MockI_GetString.class);
	}
	
	@Test
	public void test1017_MockI_SetString() throws Exception {
		simple.delegateNoParents(MockI_SetString.class);
	}
	
	@Test
	public void test1018_MockI_GetAndSetLong() throws Exception {
		linearTo20.delegate018_MockI_GetAndSetLong();
	}
	
	@Test
	public void test1019_MockI_GetAndSetString() throws Exception {
		linearTo20.delegate019_MockI_GetAndSetString();
	}
	
	@Test
	public void test1020_MockI_StringAndLong() throws Exception {
		linearTo20.delegate020_MockI_StringAndLong();
	}
	
	@Test
	public void test1021_MockI_OtherStringAndLong() throws Exception {
		linearTo30.delegate021_MockI_OtherStringAndLong();
	}
	
	/**
	 * 2000's are circular reference tests
	 * @throws Exception
	 */
	@Test
	public void test2001_MockWithBidirectionalA() throws Exception {
		simple.delegateObjectOnlyParents(MockWithBidirectionalA.class);
	}
	
	@Test
	public void test2002_MockWithBidirectionalB() throws Exception {
		simple.delegateObjectOnlyParents(MockWithBidirectionalB.class);
	}
	
	@Test
	public void test2003_MockWithTriangleA() throws Exception {
		simple.delegateObjectOnlyParents(MockWithTriangleA.class);
	}
	
	@Test
	public void test2004_MockWithTriangleB() throws Exception {
		simple.delegateObjectOnlyParents(MockWithTriangleB.class);
	}
	
	@Test
	public void test2005_MockWithTriangleC() throws Exception {
		simple.delegateObjectOnlyParents(MockWithTriangleC.class);
	}
	
	/**
	 * 3000's are large scale tests
	 * @throws Exception
	 */
	@Test
	public void test3001_MockWithEverything() throws Exception {
		simple.delegateObjectOnlyParents(MockWithEverything.class);
	}
	
	@Test
	public void test3002_MockRefEverything() throws Exception {
		simple.delegateObjectOnlyParents(MockWithRefMockWithEverything.class);
	}
	
	
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassParentsDiscoveryTrial#getCcbClassLoader()
	 */
	@Override
	public CachedClassBytesClassLoader getCcbClassLoader() {
		return ccbClassLoader;
	}
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassParentsDiscoveryTrial#getClassReferenceDiscovery()
	 */
	@Override
	public I_ClassParentsDiscovery getClassParentsDiscovery() {
		return classParentsDiscovery;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassParentsDiscoveryTrial#getClassFilter()
	 */
	@Override
	public ClassFilter getClassFilter() {
		return classFilter;
	}
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_tests.jacoco.plugin.discovery.I_ClassParentsDiscoveryTrial#getLogMock()
	 */
	@Override
	public Tests4J_LogMock getLogMock() {
		return logMock;
	}

	public Map<String, I_ClassParentsLocal> getParentsCache() {
		return parentsCache;
	}

	@Override
	public CPDT_Assert_Simple getSimple() {
		return simple;
	}
	@Override
	public CPDT_Assert_Linear_to_20 getLinearTo20() {
		return linearTo20;
	}
	
	@Override
	public void putParentsIfAbsent(I_ClassParentsLocal p) {
		assertEquals(ClassParentsLocal.class.getName(), p.getClass().getName());
		if (!parentsCache.containsKey(p.getName())) {
			parentsCache.put(p.getName(), p);
		}
	}
	@Override
	public I_ClassParentsLocal getParents(String name) {
		return parentsCache.get(name);
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 31);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 2116;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 2);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 468;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}


}
