package joinAndInterrupt.test3;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 19:46
 */

/**
 * 另一个常用的中断线程的方法是设置标志位。
 * 我们通常会用一个running标志位来标识线程是否应该继续运行，
 * 在外部线程中，通过把HelloThread.running置为false，就可以让线程结束：
 */
public class JoinTest3 {
    public static void main(String[] args)  throws InterruptedException {
        HelloThread1 t = new HelloThread1();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false
    }
}
