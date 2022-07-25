package waitAndNotify.test2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:57
 */

/**
 * 当一个线程执行到getTask()方法内部的while循环时，它必定已经获取到了this锁，此时，
 * 线程执行while条件判断，如果条件成立（队列为空），线程将执行this.wait()，进入等待状态。
 * wait()方法必须在当前获取的锁对象上调用，这里获取的是this锁，因此调用this.wait()
 *
 * 必须在synchronized块中才能调用wait()方法，因为wait()方法调用时，会释放线程获得的锁，wait()方法返回后，线程又会重新试图获得锁。
 */
public class TaskQueue2 {
    Queue<String> queue = new LinkedList<>();

    /**
     * addTask()方法，内部调用了this.notifyAll()而不是this.notify()，
     * 使用notifyAll()将唤醒所有当前正在this锁等待的线程，而notify()只会唤醒其中一个（具体哪个依赖操作系统，有一定的随机性）
     */
    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }


    /**
     * wait()方法返回时需要重新获得this锁。假设当前有3个线程被唤醒，唤醒后，
     * 首先要等待执行addTask()的线程结束此方法后，才能释放this锁，随后，这3个线程中只能有一个获取到this锁，剩下两个将继续等待。
     *
     * 注意while不可改变为if，因为假设三个线程一个获得了this锁，remove之后，释放锁。还是有可能被其他两个线程再次获取锁，此时remove就会报空指针错误。
     */
    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
