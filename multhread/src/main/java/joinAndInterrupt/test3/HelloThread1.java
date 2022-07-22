package joinAndInterrupt.test3;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 19:46
 */

/**
 * 在Java虚拟机中，变量的值保存在主内存中，但是，当线程访问变量时，它会先获取一个副本，
 *       并保存在自己的工作内存中。如果线程修改了变量的值，虚拟机会在某个时刻把修改后的值回写到主内存
 * volatile关键字的目的是告诉虚拟机：
 * 1.每次访问变量时，总是获取主内存的最新值；
 * 2.每次修改变量后，立刻回写到主内存。
 */
public class HelloThread1  extends Thread {
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}
