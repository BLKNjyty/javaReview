package ThreadPoolTest.ThreadPoolExecutorTest;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 11:03
 */


public class MyMonitorThread implements Runnable
{
    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run=true;

    public MyMonitorThread(ThreadPoolExecutor executor, int delay)
    {
        this.executor = executor;
        this.seconds=delay;
    }

    public void shutdown(){
        this.run=false;
    }

    @Override
    public void run()
    {
        //getTaskCount()返回线程池已执行和未执行的总数
        //getActiveCount当前线程池中正在执行的任务的线程的数量
        while(run){
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated()));
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

