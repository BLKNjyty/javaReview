package joinAndInterrupt.test1;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 19:33
 */
public class JoinTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}
