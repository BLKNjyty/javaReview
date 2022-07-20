package joinAndInterrupt.test1;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 19:33
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}


