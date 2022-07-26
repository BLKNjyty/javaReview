package waitAndNotify.test2;

import java.util.ArrayList;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-19 20:57
 */
public class WaitAndNotifyTest {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue2 q = new TaskQueue2();
        ArrayList<Thread> ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);

        for (Thread t : ts) {
            t.interrupt();
        }
    }
}
