package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2019/12/27.
 * 两个线程交替打印奇偶数，用synchronized
 * 浪费资源
 */
public class WaitNotifyPrintOddEvnSyn {
    private static int count = 0;
    private static final Object lock = new Object();

    //新建2个线程，第一个处理奇数，另一个处理偶数（位运算）
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count);
                            count++;
                        }
                    }
                }
            }
        }, "偶数").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count);
                            count++;
                        }
                    }
                }
            }
        }, "奇数").start();
    }


}
