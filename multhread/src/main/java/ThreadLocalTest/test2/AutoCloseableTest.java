package ThreadLocalTest.test2;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 15:11
 */

/**
 * 我们可以通过AutoCloseable接口配合try (resource) {...}结构，让编译器自动为我们关闭。
 * 例如，一个保存了当前用户名的ThreadLocal可以封装为一个UserContext对象
 */
public class AutoCloseableTest {
    public static void main(String[] args) {
        try(UserContext ctx=new UserContext("李四")){
            String user = UserContext.currentUser();
            System.out.println(user);
            processUser1();
            processUser2();
        }


    }
    public static  void processUser1(){
        String user =UserContext.currentUser();
        System.out.println();
        //do something else

    }
    public static   void processUser2(){
        String user = UserContext.currentUser();
        //do something else
    }
}
