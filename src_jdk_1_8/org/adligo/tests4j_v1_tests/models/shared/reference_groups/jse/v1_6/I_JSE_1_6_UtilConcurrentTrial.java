package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_UtilConcurrent;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Lang;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=I_JSE_1_6_UtilConcurrent.class)
@AllowedReferences (groups=JSE_1_6_Lang.class)
public class I_JSE_1_6_UtilConcurrentTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
	  assertEquals("java.util.concurrent.BlockingDeque",I_JSE_1_6_UtilConcurrent.BLOCKING_DEQUE);
	  assertEquals("java.util.concurrent.BlockingQueue",I_JSE_1_6_UtilConcurrent.BLOCKING_QUEUE);
	  assertEquals("java.util.concurrent.Callable",I_JSE_1_6_UtilConcurrent.CALLABLE);
	  assertEquals("java.util.concurrent.CompletionService",I_JSE_1_6_UtilConcurrent.COMPLETION_SERVICE);
	  assertEquals("java.util.concurrent.ConcurrentMap",I_JSE_1_6_UtilConcurrent.CONCURRENT_MAP);
	  assertEquals("java.util.concurrent.ConcurrentNavigableMap",I_JSE_1_6_UtilConcurrent.CONCURRENT_NAVIGABLE_MAP);
	  assertEquals("java.util.concurrent.Delayed",I_JSE_1_6_UtilConcurrent.DELAYED);
	  assertEquals("java.util.concurrent.Executor",I_JSE_1_6_UtilConcurrent.EXECUTOR);
	  assertEquals("java.util.concurrent.ExecutorService",I_JSE_1_6_UtilConcurrent.EXECUTOR_SERVICE);
	  
	  assertEquals("java.util.concurrent.Future",I_JSE_1_6_UtilConcurrent.FUTURE);
	  assertEquals("java.util.concurrent.RejectedExecutionHandler",I_JSE_1_6_UtilConcurrent.REJECTED_EXECUTION_HANDLER);
	  assertEquals("java.util.concurrent.RunnableFuture",I_JSE_1_6_UtilConcurrent.RUNNABLE_FUTURE);
	  assertEquals("java.util.concurrent.RunnableScheduledFuture",I_JSE_1_6_UtilConcurrent.RUNNABLE_SCHEDULED_FUTURE);
	  assertEquals("java.util.concurrent.ScheduledExecutorService",I_JSE_1_6_UtilConcurrent.SCHEDULED_EXECUTOR_SERVICE);
	  assertEquals("java.util.concurrent.ScheduledFuture",I_JSE_1_6_UtilConcurrent.SCHEDULED_FUTURE);
	  assertEquals("java.util.concurrent.ThreadFactory",I_JSE_1_6_UtilConcurrent.THREAD_FACTORY);
	  
	  assertEquals("java.util.concurrent.AbstractExecutorService",I_JSE_1_6_UtilConcurrent.ABSTRACT_EXECUTOR_SERVICE);
	  assertEquals("java.util.concurrent.ArrayBlockingQueue",I_JSE_1_6_UtilConcurrent.ARRAY_BLOCKING_QUEUE);
	  assertEquals("java.util.concurrent.ConcurrentHashMap",I_JSE_1_6_UtilConcurrent.CONCURRENT_HASH_MAP);
	  assertEquals("java.util.concurrent.ConcurrentLinkedQueue",I_JSE_1_6_UtilConcurrent.CONCURRENT_LINKED_QUEUE);
	  assertEquals("java.util.concurrent.ConcurrentSkipListMap",I_JSE_1_6_UtilConcurrent.CONCURRENT_SKIP_LIST_MAP);
	  assertEquals("java.util.concurrent.ConcurrentSkipListSet",I_JSE_1_6_UtilConcurrent.CONCURRENT_SKIP_LIST_SET);
	  assertEquals("java.util.concurrent.CopyOnWriteArrayList",I_JSE_1_6_UtilConcurrent.COPY_ON_WRITE_ARRAY_LIST);
	  assertEquals("java.util.concurrent.CopyOnWriteArraySet",I_JSE_1_6_UtilConcurrent.COPY_ON_WRITE_ARRAY_SET);
	  assertEquals("java.util.concurrent.CountDownLatch",I_JSE_1_6_UtilConcurrent.COUNT_DOWN_LATCH);
	  assertEquals("java.util.concurrent.CyclicBarrier",I_JSE_1_6_UtilConcurrent.CYCLIC_BARRIER);
	  assertEquals("java.util.concurrent.DelayQueue",I_JSE_1_6_UtilConcurrent.DELAY_QUEUE);
	  
	  assertEquals("java.util.concurrent.Exchanger",I_JSE_1_6_UtilConcurrent.EXCHANGER);
	  assertEquals("java.util.concurrent.ExecutorCompletionService",I_JSE_1_6_UtilConcurrent.EXECUTOR_COMPLETION_SERVICE);
	  assertEquals("java.util.concurrent.Executors",I_JSE_1_6_UtilConcurrent.EXECUTORS);
	  
	  assertEquals("java.util.concurrent.FutureTask",I_JSE_1_6_UtilConcurrent.FUTURE_TASK);
	  assertEquals("java.util.concurrent.LinkedBlockingDeque",I_JSE_1_6_UtilConcurrent.LINKED_BLOCKING_DEQUE);
	  assertEquals("java.util.concurrent.LinkedBlockingQueue",I_JSE_1_6_UtilConcurrent.LINKED_BLOCKING_QUEUE);
	  
	  assertEquals("java.util.concurrent.PriorityBlockingQueue",I_JSE_1_6_UtilConcurrent.PRIORITY_BLOCKING_QUEUE);
	  assertEquals("java.util.concurrent.ScheduledThreadPoolExecutor",I_JSE_1_6_UtilConcurrent.SCHEDULED_THREAD_POOL_EXECUTOR);
	  assertEquals("java.util.concurrent.Semaphore",I_JSE_1_6_UtilConcurrent.SEMAPHORE);
	  assertEquals("java.util.concurrent.SynchronousQueue",I_JSE_1_6_UtilConcurrent.SYNCHRONOUS_QUEUE);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor",I_JSE_1_6_UtilConcurrent.THREAD_POOL_EXECUTOR);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor",I_JSE_1_6_UtilConcurrent.THREAD_POOL_EXECUTOR);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$AbortPolicy",I_JSE_1_6_UtilConcurrent.THREAD_POOL_EXECUTOR_ABORT_POLICY);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy",I_JSE_1_6_UtilConcurrent.THREAD_POOL_EXECUTOR_CALLER_RUNS_POLICY);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$DiscardOldestPolicy",I_JSE_1_6_UtilConcurrent.THREAD_POOL_EXECUTOR_DISCARD_OLDEST_POLICY);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$DiscardPolicy",I_JSE_1_6_UtilConcurrent.THREAD_POOL_EXECUTOR_DISCARD_POLICY);
	  assertEquals("java.util.concurrent.TimeUnit",I_JSE_1_6_UtilConcurrent.TIME_UNIT);
	  assertEquals("java.util.concurrent.BrokenBarrierException",I_JSE_1_6_UtilConcurrent.BROKEN_BARRIER_EXCEPTION);
	  assertEquals("java.util.concurrent.CancellationException",I_JSE_1_6_UtilConcurrent.CANCELLATION_EXCEPTION);
	  assertEquals("java.util.concurrent.ExecutionException",I_JSE_1_6_UtilConcurrent.EXECUTION_EXCEPTION);
	  assertEquals("java.util.concurrent.RejectedExecutionException",I_JSE_1_6_UtilConcurrent.REJECTED_EXECUTION_EXCEPTION);
	  assertEquals("java.util.concurrent.TimeoutException",I_JSE_1_6_UtilConcurrent.TIMEOUT_EXCEPTION);

	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 49;
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
		int thisUniqueAsserts = 48;
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
