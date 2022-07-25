package reentrantLockTest.test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 10:21
 */

/**
 * synchronized关键字用于加锁，但这种锁一是很重，二是获取时必须一直等待，没有额外的尝试机制
 *
 */
public class TaskQueue3 {
    private final Lock  lock=new ReentrantLock();
    private  final Condition condition=lock.newCondition();
    private Queue<String> queue=new LinkedList<>();

    public void addTask(String s){
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}
