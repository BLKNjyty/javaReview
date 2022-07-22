package ThreadLocalTest.test1;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 15:01
 */

/**
 * 横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），它是一种状态，可以是用户身份、任务信息等。
 *
 * 给每个方法增加一个context参数非常麻烦，而且有些时候，如果调用链有无法修改源码的第三方库，User对象就传不进去了.
 * 顾需要ThreadLocal
 */
public class ThreadLocalTest {
    static ThreadLocal<String> threadLocalUser = new ThreadLocal<>();
    public static void main(String[] args) {
        try{
            threadLocalUser.set("张三");
            processUser1();
            processUser2();
        }finally {
            //一定要在finally中清除
            //当前线程执行完相关代码后，很可能会被重新放入线程池中，如果ThreadLocal没有被清除，该线程执行其他代码时，会把上一次的状态带进去
            threadLocalUser.remove();
        }

    }
    public static  void processUser1(){
        String user = threadLocalUser.get();
     //do something else

    }
    public static   void processUser2(){
        String user = threadLocalUser.get();
        //do something else
    }

}
