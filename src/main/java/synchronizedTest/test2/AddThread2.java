package synchronizedTest.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:15
 */

/**
 * synchronized锁类:1.synchronized（类.class）2.加在static方法之前
 * synchronized锁当前类实例：1.synchronized(this) 2.加在普通方法前
 * synchronized 也可以自定指定锁对象
 */
public class AddThread2 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter2.lock) {
                Counter2.count += 1;
            }
        }
    }
}