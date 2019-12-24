package synchtonized;

/**
 * Created by zhengjie on 2019/12/21.
 * 对象锁，方法锁
 * 两个线程同时访问一个对象的同步方法
 */
public class SynchronizedObjectMethod3 implements Runnable {

    static  SynchronizedObjectMethod3 instance=new SynchronizedObjectMethod3();
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.join();
        t2.join();
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void method() throws InterruptedException {
        System.out.println("我是对象锁方法修饰符，我叫："+Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
