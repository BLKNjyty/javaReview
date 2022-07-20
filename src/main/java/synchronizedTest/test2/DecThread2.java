package synchronizedTest.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:16
 */
public class DecThread2 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter2.lock) {
                Counter2.count -= 1;
            }
        }
    }
}