package ThreadPoolTest.ExecutorsTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 10:55
 */

/**
 * Executors 类提供了使用了 ThreadPoolExecutor 的简单的 ExecutorService 实现，
 * 但是 ThreadPoolExecutor 提供的功能远不止于此。
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread1("" + i);
            executor.execute(worker);
        }
        executor.shutdown(); // This will make the executor accept no new threads and finish all existing threads in the queue
        while (!executor.isTerminated()) { // Wait until all threads are finish,and also you can use "executor.awaitTermination();" to wait
        }
        System.out.println("Finished all threads");
        /**
         * ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
         * // 1秒后执行一次性任务:
         * ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
         * // 2秒后开始执行定时任务，每3秒执行，不管上次任务是否结束，到点执行
         * ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
         * // 2秒后开始执行定时任务，以3秒为间隔执行，上次任务结束后的三秒执行
         * ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
         */


    }
}
