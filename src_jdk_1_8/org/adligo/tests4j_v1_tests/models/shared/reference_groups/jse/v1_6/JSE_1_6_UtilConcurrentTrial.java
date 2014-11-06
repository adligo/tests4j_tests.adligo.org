package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_UtilConcurrent;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

import java.util.Map;

@SourceFileScope (sourceClass=JSE_1_6_UtilConcurrent.class,minCoverage=91.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_UtilConcurrentTrial extends SourceFileCountingTrial {

  @Test
  public void testConstantLookup() {
    Map<String,String> map = JSE_1_6_UtilConcurrent.INSTANCE.getModelMap();
    assertEquals("BLOCKING_DEQUE",map.get("java.util.concurrent.BlockingDeque"));
    assertEquals("BLOCKING_QUEUE",map.get("java.util.concurrent.BlockingQueue"));
    assertEquals("CALLABLE",map.get("java.util.concurrent.Callable"));
    assertEquals("COMPLETION_SERVICE",map.get("java.util.concurrent.CompletionService"));
    assertEquals("CONCURRENT_MAP",map.get("java.util.concurrent.ConcurrentMap"));
    assertEquals("CONCURRENT_NAVIGABLE_MAP",map.get("java.util.concurrent.ConcurrentNavigableMap"));
    assertEquals("DELAYED",map.get("java.util.concurrent.Delayed"));
    assertEquals("EXECUTOR",map.get("java.util.concurrent.Executor"));
    assertEquals("EXECUTOR_SERVICE",map.get("java.util.concurrent.ExecutorService"));
    assertEquals("FUTURE",map.get("java.util.concurrent.Future"));
    assertEquals("REJECTED_EXECUTION_HANDLER",map.get("java.util.concurrent.RejectedExecutionHandler"));
    assertEquals("RUNNABLE_FUTURE",map.get("java.util.concurrent.RunnableFuture"));
    assertEquals("RUNNABLE_SCHEDULED_FUTURE",map.get("java.util.concurrent.RunnableScheduledFuture"));
    assertEquals("SCHEDULED_EXECUTOR_SERVICE",map.get("java.util.concurrent.ScheduledExecutorService"));
    assertEquals("SCHEDULED_FUTURE",map.get("java.util.concurrent.ScheduledFuture"));
    assertEquals("THREAD_FACTORY",map.get("java.util.concurrent.ThreadFactory"));
    assertEquals("ABSTRACT_EXECUTOR_SERVICE",map.get("java.util.concurrent.AbstractExecutorService"));
    assertEquals("ARRAY_BLOCKING_QUEUE",map.get("java.util.concurrent.ArrayBlockingQueue"));
    assertEquals("CONCURRENT_HASH_MAP",map.get("java.util.concurrent.ConcurrentHashMap"));
    assertEquals("CONCURRENT_LINKED_QUEUE",map.get("java.util.concurrent.ConcurrentLinkedQueue"));
    assertEquals("CONCURRENT_SKIP_LIST_MAP",map.get("java.util.concurrent.ConcurrentSkipListMap"));
    assertEquals("CONCURRENT_SKIP_LIST_SET",map.get("java.util.concurrent.ConcurrentSkipListSet"));
    assertEquals("COPY_ON_WRITE_ARRAY_LIST",map.get("java.util.concurrent.CopyOnWriteArrayList"));
    assertEquals("COPY_ON_WRITE_ARRAY_SET",map.get("java.util.concurrent.CopyOnWriteArraySet"));
    assertEquals("COUNT_DOWN_LATCH",map.get("java.util.concurrent.CountDownLatch"));
    assertEquals("CYCLIC_BARRIER",map.get("java.util.concurrent.CyclicBarrier"));
    assertEquals("DELAY_QUEUE",map.get("java.util.concurrent.DelayQueue"));
    assertEquals("EXCHANGER",map.get("java.util.concurrent.Exchanger"));
    assertEquals("EXECUTOR_COMPLETION_SERVICE",map.get("java.util.concurrent.ExecutorCompletionService"));
    assertEquals("EXECUTORS",map.get("java.util.concurrent.Executors"));
    assertEquals("FUTURE_TASK",map.get("java.util.concurrent.FutureTask"));
    assertEquals("LINKED_BLOCKING_DEQUE",map.get("java.util.concurrent.LinkedBlockingDeque"));
    assertEquals("LINKED_BLOCKING_QUEUE",map.get("java.util.concurrent.LinkedBlockingQueue"));
    assertEquals("PRIORITY_BLOCKING_QUEUE",map.get("java.util.concurrent.PriorityBlockingQueue"));
    assertEquals("SCHEDULED_THREAD_POOL_EXECUTOR",map.get("java.util.concurrent.ScheduledThreadPoolExecutor"));
    assertEquals("SEMAPHORE",map.get("java.util.concurrent.Semaphore"));
    assertEquals("SYNCHRONOUS_QUEUE",map.get("java.util.concurrent.SynchronousQueue"));
    assertEquals("THREAD_POOL_EXECUTOR",map.get("java.util.concurrent.ThreadPoolExecutor"));
    assertEquals("THREAD_POOL_EXECUTOR",map.get("java.util.concurrent.ThreadPoolExecutor"));
    assertEquals("ABORT_POLICY",map.get("java.util.concurrent.ThreadPoolExecutor$AbortPolicy"));
    assertEquals("CALLER_RUNS_POLICY",map.get("java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy"));
    assertEquals("DISCARD_OLDEST_POLICY",map.get("java.util.concurrent.ThreadPoolExecutor$DiscardOldestPolicy"));
    assertEquals("DISCARD_POLICY",map.get("java.util.concurrent.ThreadPoolExecutor$DiscardPolicy"));
    assertEquals("TIME_UNIT",map.get("java.util.concurrent.TimeUnit"));
    assertEquals("BROKEN_BARRIER_EXCEPTION",map.get("java.util.concurrent.BrokenBarrierException"));
    assertEquals("CANCELLATION_EXCEPTION",map.get("java.util.concurrent.CancellationException"));
    assertEquals("EXECUTION_EXCEPTION",map.get("java.util.concurrent.ExecutionException"));
    assertEquals("REJECTED_EXECUTION_EXCEPTION",map.get("java.util.concurrent.RejectedExecutionException"));
    assertEquals("TIMEOUT_EXCEPTION",map.get("java.util.concurrent.TimeoutException"));
  }
	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_UtilConcurrent.INSTANCE);
	}
			
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.BlockingDeque"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.BlockingQueue"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.Callable"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.CompletionService"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ConcurrentMap"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ConcurrentNavigableMap"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.Delayed"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.Executor"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ExecutorService"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.Future"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.RejectedExecutionHandler"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.RunnableFuture"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.RunnableScheduledFuture"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ScheduledExecutorService"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ScheduledFuture"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ThreadFactory"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.AbstractExecutorService"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ArrayBlockingQueue"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ConcurrentHashMap"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ConcurrentLinkedQueue"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ConcurrentSkipListMap"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ConcurrentSkipListSet"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.CopyOnWriteArrayList"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.CopyOnWriteArraySet"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.CountDownLatch"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.CyclicBarrier"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.DelayQueue"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.Exchanger"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ExecutorCompletionService"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.Executors"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.FutureTask"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.LinkedBlockingDeque"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.LinkedBlockingQueue"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.PriorityBlockingQueue"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ScheduledThreadPoolExecutor"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.Semaphore"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.SynchronousQueue"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ThreadPoolExecutor"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ThreadPoolExecutor"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ThreadPoolExecutor$AbortPolicy"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ThreadPoolExecutor$DiscardOldestPolicy"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ThreadPoolExecutor$DiscardPolicy"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.TimeUnit"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.BrokenBarrierException"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.CancellationException"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.ExecutionException"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.RejectedExecutionException"));
    asserts.assertTrue(dg.isInGroup("java.util.concurrent.TimeoutException"));
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 98;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 49;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}
