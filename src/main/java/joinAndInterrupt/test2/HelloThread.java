package joinAndInterrupt.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 19:30
 */
public class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}