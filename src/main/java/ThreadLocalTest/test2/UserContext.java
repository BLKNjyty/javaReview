package ThreadLocalTest.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 15:12
 */
public class UserContext implements AutoCloseable {

    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() {
        ctx.remove();
    }
}