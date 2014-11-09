package org.adligo.tests4j_tests.jacoco.plugin.factories;

import org.adligo.tests4j.run.common.I_JseSystem;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePlugin;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePluginFactory;
import org.adligo.tests4j.system.shared.api.Tests4J_CoveragePluginParams;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.CoveragePlugin;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginMemory;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.whitelists.MockitoList;
import org.adligo.tests4j_4jacoco.plugin.whitelists.RequiredList;
import org.adligo.tests4j_4mockito.ReturnCount;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SourceFileScope (sourceClass=MockitoPluginFactory.class, minCoverage=100.0)
public class MockitoPluginFactoryTrial extends SourceFileCountingTrial {

	@SuppressWarnings("boxing")
  @Test 
	public void testMethod() {
		MockitoPluginFactory factory = new MockitoPluginFactory();
		
		DefaultLog logger = new DefaultLog();
		Tests4J_CoveragePluginParams params = new Tests4J_CoveragePluginParams();
		params.setWriteOutInstrumentedClasses(true);
		params.setInstrumentedClassOutputFolder("instrumentedClassOutputFolder");
		I_JseSystem sys = mock(I_JseSystem.class);
		
		File delA = mock(File.class);
		ReturnCount<Boolean> delACount = new ReturnCount<Boolean>(true);
    when(delA.getName()).thenReturn("aoo.class");
    when(delA.delete()).thenAnswer(delACount);
    
		File delB = mock(File.class);
		ReturnCount<Boolean> delBCount = new ReturnCount<Boolean>(true);
    when(delB.getName()).thenReturn("bar.class");
    when(delB.delete()).thenAnswer(delBCount);
    
		File [] list = new File[] {delA,delB};
		
		Map<String,Object> runParams = new HashMap<String,Object>();
		runParams.put(I_Tests4J_CoveragePluginFactory.LOG, logger);
		runParams.put(I_Tests4J_CoveragePluginFactory.SYSTEM, sys);
		
		File mockFile = mock(File.class);
    when(mockFile.exists()).thenReturn(true);
    when(mockFile.listFiles()).thenReturn(list);
    when(sys.newFile("instrumentedClassOutputFolder")).thenReturn(mockFile);
    
		I_Tests4J_CoveragePlugin cp =  factory.create(params, runParams);
		assertNotNull(cp);
		assertEquals(CoveragePlugin.class.getName(), cp.getClass().getName());
		
		assertEquals(CoveragePlugin.class.getName(), cp.getClass().getName());
		CoveragePlugin cplug = (CoveragePlugin) cp;
		
		CoveragePluginMemory cpm = cplug.getMemory();
		assertNotNull(cpm);
		
		Set<String> required = new RequiredList().getWhitelist();
		Set<String> mockito = new MockitoList().getWhitelist();
		Set<String> whitelist =cpm.getWhitelist();
		assertTrue(whitelist.containsAll(required));
		assertTrue(whitelist.containsAll(mockito));
		
		assertEquals(required.size() + mockito.size(), whitelist.size());
		assertEquals(1, delACount.count());
		assertEquals(1, delACount.count());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 9;
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
		int thisUniqueAsserts = 6;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
