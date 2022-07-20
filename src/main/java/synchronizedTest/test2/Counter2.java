package synchronizedTest.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:16
 */
public class Counter2 {
    public static final Object lock = new Object();
    public static int count = 0;
}
