package StampedLockTest;

import java.util.concurrent.locks.StampedLock;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-20 10:37
 */

/**
 * tampedLock和ReadWriteLock相比，改进之处在于：读的过程中也允许获取写锁后写入！
 * 这样一来，我们读的数据就可能不一致，所以，需要一点额外的代码来判断读的过程中是否有写入，这种读锁是一种乐观锁
 * StampedLock是不可重入锁
 */
public class MovePointTest {
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock(); // 获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp); // 释放写锁
        }
    }

    public double distanceFromOrigin() {
        //tryOptimisticRead()获取一个乐观读锁，并返回版本号
        long stamp = stampedLock.tryOptimisticRead();
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)
        //validate()去验证版本号，如果在读取过程中没有写入，版本号不变，验证成功,否则验证失败，再去获取悲观锁
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock(); // 获取一个悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp); // 释放悲观读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
