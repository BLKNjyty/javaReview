package readWriteLockTest.test;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 10:30
 */

/**
 * 使用ReadWriteLock可以提高读取效率：
 *
 * ReadWriteLock只允许一个线程写入；
 *
 * ReadWriteLock允许多个线程在没有写入时同时读取；
 *
 * ReadWriteLock适合读多写少的场景。
 * !!!但是其是悲观锁:如果有线程正在读，写线程需要等待读线程释放锁后才能获取写锁，即读的过程中不允许写
 */
public class CounterOdReadWriteLock {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}
