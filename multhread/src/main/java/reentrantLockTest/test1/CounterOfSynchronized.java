package reentrantLockTest.test1;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 10:18
 */
public class CounterOfSynchronized {
    private int count;

    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }
}
