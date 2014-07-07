package org.adligo.tests4j_tests.jacoco.api_trials;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.coverage.CoverageUnits;
import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.system.I_CoverageRecorder;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.IgnoreTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_tests.base_abstract_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.jacoco.api_trials.mocks.MockRunnable;

@PackageScope (packageName="org.adligo.tests4j_4jacoco")
@IgnoreTrial
public class MultiRecordingTrial extends ApiCountingTrial {

	@BeforeTrial
	public static void beforeTrial() {
		
	}
	
	@Test
	@IgnoreTest
	public void testSimpleRecording() throws Exception {
		
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(MockRunnable.class);
		List<Class<?>> instClass = plugin.instrumentClassesAny(classes);
		assertNotNull(instClass);
		assertEquals(1, instClass.size());
		Class<?> mr = instClass.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks.MockRunnable", mr.getName());
		
		I_CoverageRecorder recorder = plugin.createRecorder();
		assertNotNull(recorder);
		recorder.startRecording();
		
		Constructor<?> mrc =  mr.getConstructor(new Class[] {Boolean.class, Boolean.class});
		Object obj = mrc.newInstance(true, true);
		Method run = mr.getMethod("run", null);
		run.invoke(obj, null);
		
		Method getI = mr.getMethod("getI", null);
		assertEquals(4, getI.invoke(obj,null));
		Method getJ = mr.getMethod("getJ", null);
		assertEquals(4, getJ.invoke(obj, null));
		
		List<I_PackageCoverage> coverage =  recorder.endRecording();
		assertNotNull(coverage);
		assertEquals(1, coverage.size());
		
		I_PackageCoverage cover = coverage.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks", cover.getPackageName());
		Set<String> sourceFileNames = cover.getSourceFileNames();
		assertEquals(1, sourceFileNames.size());
		assertContains(sourceFileNames, "MockRunnable");
		I_SourceFileCoverage sfCover =  cover.getCoverage("MockRunnable");
		assertNotNull(sfCover);
		assertEquals(new CoverageUnits(89), sfCover.getCoverageUnits());
		assertEquals(new CoverageUnits(85), sfCover.getCoveredCoverageUnits());
		assertEquals(new BigDecimal("96"), sfCover.getPercentageCovered());
		
	}
	
	@Test
	@IgnoreTest
	public void testSimpleRecording100Pct() throws Exception {
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(MockRunnable.class);
		List<Class<?>> instClass = plugin.instrumentClassesAny(classes);
		assertNotNull(instClass);
		assertEquals(1, instClass.size());
		Class<?> mr = instClass.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks.MockRunnable", mr.getName());
		
		I_CoverageRecorder recorder = plugin.createRecorder();
		assertNotNull(recorder);
		recorder.startRecording();
		
		Constructor<?> mrc =  mr.getConstructor(new Class[] {Boolean.class, Boolean.class});
		Object obj = mrc.newInstance(true, true);
		Method run = mr.getMethod("run", null);
		run.invoke(obj, null);
		
		Method getI = mr.getMethod("getI", null);
		assertEquals(4, getI.invoke(obj,null));
		Method getJ = mr.getMethod("getJ", null);
		assertEquals(4, getJ.invoke(obj, null));
		
		obj = mrc.newInstance(true, false);
		run.invoke(obj, null);
		assertEquals(1, getI.invoke(obj,null));
		assertEquals(1, getJ.invoke(obj, null));
		
		obj = mrc.newInstance(false, true);
		run.invoke(obj, null);
		assertEquals(1, getI.invoke(obj,null));
		assertEquals(1, getJ.invoke(obj, null));
		
		List<I_PackageCoverage> coverage =  recorder.endRecording();
		assertNotNull(coverage);
		assertEquals(1, coverage.size());
		
		I_PackageCoverage cover = coverage.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks", cover.getPackageName());
		Set<String> sourceFileNames = cover.getSourceFileNames();
		assertEquals(1, sourceFileNames.size());
		assertContains(sourceFileNames, "MockRunnable");
		I_SourceFileCoverage sfCover =  cover.getCoverage("MockRunnable");
		assertNotNull(sfCover);
		assertEquals(new CoverageUnits(89), sfCover.getCoverageUnits());
		assertEquals(new CoverageUnits(89), sfCover.getCoveredCoverageUnits());
		BigDecimal pctCovered = sfCover.getPercentageCovered();
		assertEquals(new BigDecimal("100.00"), pctCovered);
		
	}
	
	@Test
	@IgnoreTest
	public void testDualRecordingWithPause() throws Exception {
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		plugin.setWriteOutInstrumentedClassFiles(true);
		
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(MockRunnable.class);
		List<Class<?>> instClass = plugin.instrumentClassesAny(classes);
		assertNotNull(instClass);
		assertEquals(1, instClass.size());
		Class<?> mr = instClass.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks.MockRunnable", mr.getName());
		
		I_CoverageRecorder recorder = plugin.createRecorder();
		assertNotNull(recorder);
		recorder.startRecording();
		
		Constructor<?> mrc =  mr.getConstructor(new Class[] {Boolean.class, Boolean.class});
		Object obj = mrc.newInstance(false, false);
		Method run = mr.getMethod("run", null);
		run.invoke(obj, null);
		
		Method getI = mr.getMethod("getI", null);
		assertEquals(0, getI.invoke(obj,null));
		Method getJ = mr.getMethod("getJ", null);
		assertEquals(0, getJ.invoke(obj, null));
		
		I_CoverageRecorder innerRecorder = plugin.createRecorder();
		assertNotNull(innerRecorder);
		innerRecorder.startRecording();
		List<I_PackageCoverage> coverage =  recorder.endRecording();
		
		Object inObj = mrc.newInstance(true, true);
		run.invoke(inObj, null);
		assertEquals(4, getI.invoke(inObj,null));
		assertEquals(4, getJ.invoke(inObj, null));
		
		List<I_PackageCoverage> inCoverage =  innerRecorder.endRecording();
		
		
		
		assertNotNull(coverage);
		assertEquals(1, coverage.size());
		
		//test inner coverage
		I_PackageCoverage inCover = inCoverage.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks", inCover.getPackageName());
		Set<String> inSourceFileNames = inCover.getSourceFileNames();
		assertEquals(1, inSourceFileNames.size());
		assertContains(inSourceFileNames, "MockRunnable");
		I_SourceFileCoverage insfCover =  inCover.getCoverage("MockRunnable");
		assertNotNull(insfCover);
		assertEquals(new CoverageUnits(89), insfCover.getCoverageUnits());
		assertEquals(new CoverageUnits(85), insfCover.getCoveredCoverageUnits());
		assertEquals(new BigDecimal("96"), insfCover.getPercentageCovered());
		
		//test outer coverage
		I_PackageCoverage cover = coverage.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks", cover.getPackageName());
		Set<String> sourceFileNames = cover.getSourceFileNames();
		assertEquals(1, sourceFileNames.size());
		assertContains(sourceFileNames, "MockRunnable");
		I_SourceFileCoverage sfCover =  cover.getCoverage("MockRunnable");
		assertNotNull(sfCover);
		assertEquals(new CoverageUnits(89), sfCover.getCoverageUnits());
		assertEquals(new CoverageUnits(33), sfCover.getCoveredCoverageUnits());
		assertEquals(new BigDecimal("37"), sfCover.getPercentageCovered());
		
	}
	
	@Test
	@IgnoreTest
	public void testDualRecording() throws Exception {
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		plugin.setWriteOutInstrumentedClassFiles(true);
		
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(MockRunnable.class);
		List<Class<?>> instClass = plugin.instrumentClassesAny(classes);
		assertNotNull(instClass);
		assertEquals(1, instClass.size());
		Class<?> mr = instClass.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks.MockRunnable", mr.getName());
		
		I_CoverageRecorder recorder = plugin.createRecorder();
		assertNotNull(recorder);
		recorder.startRecording();
		
		Constructor<?> mrc =  mr.getConstructor(new Class[] {Boolean.class, Boolean.class});
		Object obj = mrc.newInstance(false, false);
		Method run = mr.getMethod("run", null);
		run.invoke(obj, null);
		
		Method getI = mr.getMethod("getI", null);
		assertEquals(0, getI.invoke(obj,null));
		Method getJ = mr.getMethod("getJ", null);
		assertEquals(0, getJ.invoke(obj, null));
		
		I_CoverageRecorder innerRecorder = plugin.createRecorder();
		assertNotNull(innerRecorder);
		innerRecorder.startRecording();

		
		Object inObj = mrc.newInstance(true, true);
		run.invoke(inObj, null);
		assertEquals(4, getI.invoke(inObj,null));
		assertEquals(4, getJ.invoke(inObj, null));
		
		List<I_PackageCoverage> inCoverage =  innerRecorder.endRecording();
		
		
		List<I_PackageCoverage> coverage =  recorder.endRecording();
		assertNotNull(coverage);
		assertEquals(1, coverage.size());
		
		//test inner coverage
		I_PackageCoverage inCover = inCoverage.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks", inCover.getPackageName());
		Set<String> inSourceFileNames = inCover.getSourceFileNames();
		assertEquals(1, inSourceFileNames.size());
		assertContains(inSourceFileNames, "MockRunnable");
		I_SourceFileCoverage insfCover =  inCover.getCoverage("MockRunnable");
		assertNotNull(insfCover);
		assertEquals(new CoverageUnits(89), insfCover.getCoverageUnits());
		assertEquals(new CoverageUnits(85), insfCover.getCoveredCoverageUnits());
		assertEquals(new BigDecimal("96"), insfCover.getPercentageCovered());
		
		//test outer coverage
		I_PackageCoverage cover = coverage.get(0);
		assertEquals("org.adligo.tests4j_tests.jacoco.api_trials.mocks", cover.getPackageName());
		Set<String> sourceFileNames = cover.getSourceFileNames();
		assertEquals(1, sourceFileNames.size());
		assertContains(sourceFileNames, "MockRunnable");
		I_SourceFileCoverage sfCover =  cover.getCoverage("MockRunnable");
		assertNotNull(sfCover);
		assertEquals(new CoverageUnits(89), sfCover.getCoverageUnits());
		assertEquals(new CoverageUnits(88), sfCover.getCoveredCoverageUnits());
		assertEquals(new BigDecimal("99"), sfCover.getPercentageCovered());
		
	}
	
	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_PackageCoverage coverage = p.getPackageCoverage();
			
			assertGreaterThanOrEquals(0.0, coverage.getPercentageCoveredDouble());
		}
	}
	

	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 0;
	}

	@Override
	public int getUniqueAsserts() {
		return 0;
	}
}
