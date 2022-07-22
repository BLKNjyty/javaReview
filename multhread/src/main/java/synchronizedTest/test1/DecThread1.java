package synchronizedTest.test1;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:07
 */
public class DecThread1 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10000; i++) { Counter1.count -= 1; }
    }
}
