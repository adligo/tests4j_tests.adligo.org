package org.adligo.tests4j_tests.jacoco.api_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.IgnoreTest;
import org.adligo.tests4j.models.shared.IgnoreTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.system.I_CoverageRecorder;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;

@PackageScope (packageName="org.adligo.tests4j_4jacoco")
@IgnoreTrial
public class MultiRecordingTrial extends ApiTrial {

	@Test
	@IgnoreTest
	public void testSimpleRecording() {
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		Tests4J_Params params = new Tests4J_Params();
		plugin.instrumentClasses(params);
		
		I_CoverageRecorder recorder = plugin.createRecorder("foo");
		assertNotNull(recorder);
		recorder.startRecording();
		recorder.pauseRecording();
		List<I_PackageCoverage> coverage =  recorder.endRecording();
		assertNotNull(coverage);
		assertEquals(0, coverage.size());
	}
}
