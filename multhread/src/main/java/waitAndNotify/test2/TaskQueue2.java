package waitAndNotify.test2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:57
 */
public class TaskQueue2 {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
