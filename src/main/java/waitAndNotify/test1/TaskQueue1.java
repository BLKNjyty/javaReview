package waitAndNotify.test1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:53
 */

/**
 * 实际上while()循环永远不会退出。因为线程在执行while()循环时，已经在getTask()入口获取了this锁，
 * 其他线程根本无法调用addTask()，因为addTask()执行条件也是获取this锁。
 * 因此，执行上述代码，线程会在getTask()中因为死循环而100%占用CPU资源。
 */
public class TaskQueue1 {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
        }
        return queue.remove();
    }
}
