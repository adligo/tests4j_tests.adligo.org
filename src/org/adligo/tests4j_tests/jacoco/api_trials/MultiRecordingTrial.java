package org.adligo.tests4j_tests.jacoco.api_trials;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.system.I_CoverageRecorder;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_tests.jacoco.api_trials.mocks.MockRunnable;

@PackageScope (packageName="org.adligo.tests4j_4jacoco")
public class MultiRecordingTrial extends ApiTrial {

	@Test
	public void testSimpleRecording() {
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(MockRunnable.class);
		plugin.instrumentClasses(classes);
		
		I_CoverageRecorder recorder = plugin.createRecorder("foo");
		assertNotNull(recorder);
		recorder.startRecording();
		MockRunnable runner = new MockRunnable(true, true);
		runner.run();
		assertEquals(4, runner.getI());
		assertEquals(4, runner.getJ());
		recorder.pauseRecording();
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
		
	}
}
