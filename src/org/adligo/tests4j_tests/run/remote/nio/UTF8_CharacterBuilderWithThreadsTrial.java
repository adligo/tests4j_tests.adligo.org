package org.adligo.tests4j_tests.run.remote.nio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.adligo.tests4j.models.shared.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.AfterTrial;
import org.adligo.tests4j.models.shared.BeforeTrial;
import org.adligo.tests4j.models.shared.IgnoreTest;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.run.remote.nio.UTF8_CharacterBuilder;
import org.adligo.tests4j_tests.run.remote.nio.helpers.I_UTF8_TestProgressMonitor;
import org.adligo.tests4j_tests.run.remote.nio.helpers.StartCapture;
import org.adligo.tests4j_tests.run.remote.nio.helpers.UTF8_Generator;
import org.adligo.tests4j_tests.run.remote.nio.helpers.UTF8_CharacterBuilder_ChuckTester;

/**
 * This class tests the UTF8 charset
 * as a input stream.
 * 
 *  //TODO thread pool 8ish and remove or reduce skips from this class
 *  
 *  51 minutes seems to be optimal for this class currently.
 *  
 * @author scott
 *
 */
@SourceFileScope (sourceClass=UTF8_CharacterBuilder.class)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.run.remote.nio.helpers")
public class UTF8_CharacterBuilderWithThreadsTrial extends SourceFileTrial implements I_UTF8_TestProgressMonitor {
	private static final int threadCount = 32;
	private static ExecutorService exetutor;
	/**
	 * the number of chars to put for the key of
	 * utf8chars, or the number of chars 
	 * which to pull out a capture subset.
	 * 
	 * Note if Increment and Capture are the
	 * same all utf8 chars will be tested
	 */
	private static final long INCREMENT = 5000000; 
	/**
	 * This is the number of characters you want to 
	 * check for each INCREMENT ie 1000 means
	 * put the first 1000 utf8  chars in the 
	 * utf8chars map List<byte []>
	 * 
	 * set to 100 for a 30 sec or so runtime on a 
	 * i7 quad
	 * 
	 * set to 10 for a 10 sec or so runtime on a 
	 * i7 quad 
	 */
	private static final long CAPTURE = 10; 
	private static final int charGroupCount = new Long(UTF8_Generator.SIX_BYTE_MAX_CODE_POINT_LONG/INCREMENT).intValue() + 1;
	private static ArrayBlockingQueue<StartCapture> charGroups = 
			new ArrayBlockingQueue<StartCapture>(charGroupCount );
	private AtomicInteger finishedCharGroups = new AtomicInteger();
	
	@BeforeTrial
	public static void beforeTrial() {
		System.out.println("charGroupCount is " + charGroupCount);
		exetutor = Executors.newFixedThreadPool(8);
		for (long i = 0; i < UTF8_Generator.SIX_BYTE_MAX_CODE_POINT_LONG; i = i + INCREMENT) {
			charGroups.add(new StartCapture(i, CAPTURE));
		}
	}
	
	@Test 
	public void testSiginifantCodePoints() throws Exception {
		assertEquals(128L, UTF8_Generator.ONE_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(2048L, UTF8_Generator.TWO_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(65536L, UTF8_Generator.THREE_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(2097152L, UTF8_Generator.FOUR_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(67108864L, UTF8_Generator.FIVE_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(2147483648L, UTF8_Generator.SIX_BYTE_MAX_CODE_POINT_LONG);
	}
		
	
	@Test
	public void testChars() throws Exception {
		for (int i = 0; i < threadCount; i++) {
			exetutor.submit(new UTF8_CharacterBuilder_ChuckTester(charGroups,this));
		}
		while (charGroupCount > finishedCharGroups.get()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException x) {
				x.printStackTrace();
				return;
			}
		}
	}

	@Override
	public void completedCharGroup() {
		double dc = (double) finishedCharGroups.addAndGet(1);
		double max = (double) charGroupCount;
		double pct = dc/max * 100;
		log(this.getClass().getName() +  " at " + ((int) pct) + "% " +charGroupCount);
	}
	
	/**
	 * (non-Javadoc)
	 * @see org.adligo.tests4j.models.shared.SourceFileTrial#afterTrialTests(org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage)
	 */
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertEquals(12906L, p.getAssertions());
		assertEquals(19L, p.getUniqueAssertions());
		
		//not sure what I am missing, I probably need 
		//to finish the eclipse plug-in coverage source-lighter
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage cover =  p.getCoverage();
			assertGreaterThanOrEquals(22.0, cover.getPercentageCoveredDouble());
		}
	}

	
	
	@AfterTrial
	public static void afterTrial() {
		exetutor.shutdownNow();
	}
}
