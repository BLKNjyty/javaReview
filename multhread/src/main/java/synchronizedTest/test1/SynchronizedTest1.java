package synchronizedTest.test1;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:05
 */

/**
 * 可以看出，最后的结果不一定为0
 * 这就相当于，假设n的值是100，如果两个线程同时执行n = n + 1，得到的结果很可能不是102，而是101
 * 这是因为线程执行n=n+1实际上是ILOAD-->IADD--->ISTORE三个步骤，因此可能出现线程1在这个过程中执行+1，线程二已经执行了好几个-1的操作
 *
 */
public class SynchronizedTest1 {
    public static void main(String[] args) throws Exception {
        Thread add = new AddThread1();
        Thread dec = new DecThread1();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter1.count);
    }
}
