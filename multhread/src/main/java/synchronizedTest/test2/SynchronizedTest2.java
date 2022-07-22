package synchronizedTest.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:15
 */

/**
 * synchronized保证了代码块在任意时刻最多只有一个线程能执行
 * 它表示用Counter.lock实例作为锁，两个线程在执行各自的synchronized(Counter.lock) { ... }
 * 代码块时，必须先获得锁，才能进入代码块进行。执行结束后，在synchronized语句块结束会自动释放锁。
 * 这样一来，对Counter.count变量进行读写就不可能同时进行。
 */
public class SynchronizedTest2 {
    public static void main(String[] args) throws Exception {
        Thread add = new AddThread2();
        Thread dec = new DecThread2();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter2.count);
    }
}
