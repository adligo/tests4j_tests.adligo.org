package org.adligo.tests4j_tests.run.remote.io;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.AfterTrial;
import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.Tests4J_ThreadFactory;
import org.adligo.tests4j.run.remote.io.UTF8_CharacterBuilder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.remote.io.helpers.I_UTF8_TestProgressMonitor;
import org.adligo.tests4j_tests.run.remote.io.helpers.StartCapture;
import org.adligo.tests4j_tests.run.remote.io.helpers.UTF8_CharacterBuilder_ChuckTester;
import org.adligo.tests4j_tests.run.remote.io.helpers.UTF8_Generator;

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
@SourceFileScope (sourceClass=UTF8_CharacterBuilder.class, minCoverage=0.0)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.run.remote.nio.helpers")
public class UTF8_CharacterBuilderWithThreadsTrial extends SourceFileCountingTrial implements I_UTF8_TestProgressMonitor {
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
		Thread ct = Thread.currentThread();
		ThreadGroup group = ct.getThreadGroup();
		String groupName = group.getName();
		if (groupName.indexOf(Tests4J_ThreadFactory.TRIAL_THREAD_NAME) == -1) {
			while (group != null) {
				group = group.getParent();
				if (group != null) {
					String nextName = group.getName();
					if (nextName.indexOf(Tests4J_ThreadFactory.TRIAL_THREAD_NAME) != -1) {
						break;
					}
				}
			}
		}
		final ThreadGroup fixedGroup = group;
		final AtomicInteger id = new AtomicInteger();
		exetutor = Executors.newFixedThreadPool(8, new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(fixedGroup, r, "UGF8_CharacterBuilderWithThreadsTrialThread-" + id.addAndGet(1));
			}
		});
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
		System.out.print("hey");
	}

	@Override
	public void completedCharGroup() {
		double dc = (double) finishedCharGroups.addAndGet(1);
		double max = (double) charGroupCount;
		double pct = dc/max * 100;
		log(this.getClass().getName() +  " at " + ((int) pct) + "% " +charGroupCount);
	}

	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 12906;
	}

	@Override
	public int getUniqueAsserts() {
		return 19;
	}
	
	@AfterTrial
	public static void afterTrial() {
		exetutor.shutdownNow();
	}
}
