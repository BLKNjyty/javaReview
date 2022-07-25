package joinAndInterrupt.test1;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 19:33
 */
public class JoinTest1 {

    /**
     * main线程通过调用t.interrupt()方法中断t线程，但是要注意，
     * interrupt()方法仅仅向t线程发出了“中断请求”，至于t线程是否能立刻响应，要看具体代码。
     * 而t线程的while循环会检测isInterrupted()，所以上述代码能正确响应interrupt()请求，使得自身立刻结束运行run()方法。
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}
