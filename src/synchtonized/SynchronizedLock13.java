package synchtonized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhengjie on 2019/12/22.
 */
public class SynchronizedLock13 {
    Lock lock=new ReentrantLock();

    public synchronized void method1(){
        System.out.println("我是synchronized形式的锁");
    }
    public void method2(){
        lock.lock();
        try {
            System.out.println("我是lock形式锁");
        }finally {
          lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedLock13 s=new SynchronizedLock13();
        s.method1();
        s.method2();
    }
}
