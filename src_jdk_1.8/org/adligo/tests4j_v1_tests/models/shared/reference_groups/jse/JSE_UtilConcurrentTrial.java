package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_UtilConcurrent;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_GwtReferenceGroup;

import java.util.Map;

@SourceFileScope (sourceClass=JSE_UtilConcurrent.class,minCoverage=98.0)
@AllowedReferences (groups=Tests4J_JSE_GwtReferenceGroup.class)
public class JSE_UtilConcurrentTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_gen.console.JSEGroupGen
	  assertEquals("java.util.concurrent.BlockingDeque",JSE_UtilConcurrent.BLOCKING_DEQUE);
	  assertEquals("java.util.concurrent.BlockingQueue",JSE_UtilConcurrent.BLOCKING_QUEUE);
	  assertEquals("java.util.concurrent.Callable",JSE_UtilConcurrent.CALLABLE);
	  assertEquals("java.util.concurrent.CompletionService",JSE_UtilConcurrent.COMPLETION_SERVICE);
	  assertEquals("java.util.concurrent.ConcurrentMap",JSE_UtilConcurrent.CONCURRENT_MAP);
	  assertEquals("java.util.concurrent.ConcurrentNavigableMap",JSE_UtilConcurrent.CONCURRENT_NAVIGABLE_MAP);
	  assertEquals("java.util.concurrent.Delayed",JSE_UtilConcurrent.DELAYED);
	  assertEquals("java.util.concurrent.Executor",JSE_UtilConcurrent.EXECUTOR);
	  assertEquals("java.util.concurrent.ExecutorService",JSE_UtilConcurrent.EXECUTOR_SERVICE);
	  assertEquals("java.util.concurrent.Future",JSE_UtilConcurrent.FUTURE);
	  assertEquals("java.util.concurrent.RejectedExecutionHandler",JSE_UtilConcurrent.REJECTED_EXECUTION_HANDLER);
	  assertEquals("java.util.concurrent.RunnableFuture",JSE_UtilConcurrent.RUNNABLE_FUTURE);
	  assertEquals("java.util.concurrent.RunnableScheduledFuture",JSE_UtilConcurrent.RUNNABLE_SCHEDULED_FUTURE);
	  assertEquals("java.util.concurrent.ScheduledExecutorService",JSE_UtilConcurrent.SCHEDULED_EXECUTOR_SERVICE);
	  assertEquals("java.util.concurrent.ScheduledFuture",JSE_UtilConcurrent.SCHEDULED_FUTURE);
	  assertEquals("java.util.concurrent.ThreadFactory",JSE_UtilConcurrent.THREAD_FACTORY);
	  assertEquals("java.util.concurrent.AbstractExecutorService",JSE_UtilConcurrent.ABSTRACT_EXECUTOR_SERVICE);
	  assertEquals("java.util.concurrent.ArrayBlockingQueue",JSE_UtilConcurrent.ARRAY_BLOCKING_QUEUE);
	  assertEquals("java.util.concurrent.ConcurrentHashMap",JSE_UtilConcurrent.CONCURRENT_HASH_MAP);
	  assertEquals("java.util.concurrent.ConcurrentLinkedQueue",JSE_UtilConcurrent.CONCURRENT_LINKED_QUEUE);
	  assertEquals("java.util.concurrent.ConcurrentSkipListMap",JSE_UtilConcurrent.CONCURRENT_SKIP_LIST_MAP);
	  assertEquals("java.util.concurrent.ConcurrentSkipListSet",JSE_UtilConcurrent.CONCURRENT_SKIP_LIST_SET);
	  assertEquals("java.util.concurrent.CopyOnWriteArrayList",JSE_UtilConcurrent.COPY_ON_WRITE_ARRAY_LIST);
	  assertEquals("java.util.concurrent.CopyOnWriteArraySet",JSE_UtilConcurrent.COPY_ON_WRITE_ARRAY_SET);
	  assertEquals("java.util.concurrent.CountDownLatch",JSE_UtilConcurrent.COUNT_DOWN_LATCH);
	  assertEquals("java.util.concurrent.CyclicBarrier",JSE_UtilConcurrent.CYCLIC_BARRIER);
	  assertEquals("java.util.concurrent.DelayQueue",JSE_UtilConcurrent.DELAY_QUEUE);
	  assertEquals("java.util.concurrent.Exchanger",JSE_UtilConcurrent.EXCHANGER);
	  assertEquals("java.util.concurrent.ExecutorCompletionService",JSE_UtilConcurrent.EXECUTOR_COMPLETION_SERVICE);
	  assertEquals("java.util.concurrent.Executors",JSE_UtilConcurrent.EXECUTORS);
	  assertEquals("java.util.concurrent.FutureTask",JSE_UtilConcurrent.FUTURE_TASK);
	  assertEquals("java.util.concurrent.LinkedBlockingDeque",JSE_UtilConcurrent.LINKED_BLOCKING_DEQUE);
	  assertEquals("java.util.concurrent.LinkedBlockingQueue",JSE_UtilConcurrent.LINKED_BLOCKING_QUEUE);
	  assertEquals("java.util.concurrent.PriorityBlockingQueue",JSE_UtilConcurrent.PRIORITY_BLOCKING_QUEUE);
	  assertEquals("java.util.concurrent.ScheduledThreadPoolExecutor",JSE_UtilConcurrent.SCHEDULED_THREAD_POOL_EXECUTOR);
	  assertEquals("java.util.concurrent.Semaphore",JSE_UtilConcurrent.SEMAPHORE);
	  assertEquals("java.util.concurrent.SynchronousQueue",JSE_UtilConcurrent.SYNCHRONOUS_QUEUE);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor",JSE_UtilConcurrent.THREAD_POOL_EXECUTOR);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$AbortPolicy",JSE_UtilConcurrent.THREAD_POOL_EXECUTOR_ABORT_POLICY);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy",JSE_UtilConcurrent.THREAD_POOL_EXECUTOR_CALLER_RUNS_POLICY);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$DiscardOldestPolicy",JSE_UtilConcurrent.THREAD_POOL_EXECUTOR_DISCARD_OLDEST_POLICY);
	  assertEquals("java.util.concurrent.ThreadPoolExecutor$DiscardPolicy",JSE_UtilConcurrent.THREAD_POOL_EXECUTOR_DISCARD_POLICY);
	  assertEquals("java.util.concurrent.TimeUnit",JSE_UtilConcurrent.TIME_UNIT);
	  assertEquals("java.util.concurrent.BrokenBarrierException",JSE_UtilConcurrent.BROKEN_BARRIER_EXCEPTION);
	  assertEquals("java.util.concurrent.CancellationException",JSE_UtilConcurrent.CANCELLATION_EXCEPTION);
	  assertEquals("java.util.concurrent.ExecutionException",JSE_UtilConcurrent.EXECUTION_EXCEPTION);
	  assertEquals("java.util.concurrent.RejectedExecutionException",JSE_UtilConcurrent.REJECTED_EXECUTION_EXCEPTION);
	  assertEquals("java.util.concurrent.TimeoutException",JSE_UtilConcurrent.TIMEOUT_EXCEPTION);
	  assertEquals("java.util.concurrent.ForkJoinPool$ForkJoinWorkerThreadFactory",JSE_UtilConcurrent.FORK_JOIN_WORKER_THREAD_FACTORY);
	  assertEquals("java.util.concurrent.ForkJoinPool$ManagedBlocker",JSE_UtilConcurrent.MANAGED_BLOCKER);
	  assertEquals("java.util.concurrent.TransferQueue",JSE_UtilConcurrent.TRANSFER_QUEUE);
	  assertEquals("java.util.concurrent.ConcurrentLinkedDeque",JSE_UtilConcurrent.CONCURRENT_LINKED_DEQUE);
	  assertEquals("java.util.concurrent.ForkJoinPool",JSE_UtilConcurrent.FORK_JOIN_POOL);
	  assertEquals("java.util.concurrent.ForkJoinTask",JSE_UtilConcurrent.FORK_JOIN_TASK);
	  assertEquals("java.util.concurrent.ForkJoinWorkerThread",JSE_UtilConcurrent.FORK_JOIN_WORKER_THREAD);
	  assertEquals("java.util.concurrent.LinkedTransferQueue",JSE_UtilConcurrent.LINKED_TRANSFER_QUEUE);
	  assertEquals("java.util.concurrent.Phaser",JSE_UtilConcurrent.PHASER);
	  assertEquals("java.util.concurrent.RecursiveAction",JSE_UtilConcurrent.RECURSIVE_ACTION);
	  assertEquals("java.util.concurrent.RecursiveTask",JSE_UtilConcurrent.RECURSIVE_TASK);
	  assertEquals("java.util.concurrent.ThreadLocalRandom",JSE_UtilConcurrent.THREAD_LOCAL_RANDOM);
	  assertEquals("java.util.concurrent.ConcurrentHashMap$KeySetView",JSE_UtilConcurrent.KEY_SET_VIEW);
	  assertEquals("java.util.concurrent.CompletionException",JSE_UtilConcurrent.COMPLETION_EXCEPTION);
		assertEquals(JSE_UtilConcurrent.class.getName(), JSE_UtilConcurrent.INSTANCE.getClass().getName());
	}
	
	@Test
	public void testConstantLookup() {
		assertEquals("java.util.concurrent",JSE_UtilConcurrent.INSTANCE.getPackageName());
		
		Map<String,String> map = JSE_UtilConcurrent.INSTANCE.getModelMap();
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
    assertEquals("FORK_JOIN_WORKER_THREAD_FACTORY",map.get("java.util.concurrent.ForkJoinPool$ForkJoinWorkerThreadFactory"));
    assertEquals("MANAGED_BLOCKER",map.get("java.util.concurrent.ForkJoinPool$ManagedBlocker"));
    assertEquals("TRANSFER_QUEUE",map.get("java.util.concurrent.TransferQueue"));
    assertEquals("CONCURRENT_LINKED_DEQUE",map.get("java.util.concurrent.ConcurrentLinkedDeque"));
    assertEquals("FORK_JOIN_POOL",map.get("java.util.concurrent.ForkJoinPool"));
    assertEquals("FORK_JOIN_TASK",map.get("java.util.concurrent.ForkJoinTask"));
    assertEquals("FORK_JOIN_WORKER_THREAD",map.get("java.util.concurrent.ForkJoinWorkerThread"));
    assertEquals("LINKED_TRANSFER_QUEUE",map.get("java.util.concurrent.LinkedTransferQueue"));
    assertEquals("PHASER",map.get("java.util.concurrent.Phaser"));
    assertEquals("RECURSIVE_ACTION",map.get("java.util.concurrent.RecursiveAction"));
    assertEquals("RECURSIVE_TASK",map.get("java.util.concurrent.RecursiveTask"));
    assertEquals("THREAD_LOCAL_RANDOM",map.get("java.util.concurrent.ThreadLocalRandom"));
    assertEquals("KEY_SET_VIEW",map.get("java.util.concurrent.ConcurrentHashMap$KeySetView"));
    assertEquals("COMPLETION_EXCEPTION",map.get("java.util.concurrent.CompletionException"));
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 127;
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
		int thisUniqueAsserts = 126;
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
