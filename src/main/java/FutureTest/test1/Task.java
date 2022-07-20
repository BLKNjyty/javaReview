package FutureTest.test1;

import java.util.concurrent.Callable;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 13:34
 */
class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        return System.currentTimeMillis()+"";
    }
}