package joinAndInterrupt.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 19:29
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}
