package threadcoreknowledge.threadobjectcommonclass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhengjie on 2019/12/27.
 * 演示sleep不释放lock
 */
public class SleepDontReleaseLock implements Runnable{
    private static  final Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        SleepDontReleaseLock runner=new SleepDontReleaseLock();
        new Thread(runner).start();
        new Thread(runner).start();
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+Thread.currentThread().getName()+"苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
