package synchtonized;

/**
 * Created by zhengjie on 2019/12/21.
 * 描述：对象锁。
 */
public class SynchronizendObjectCodeBlock2 implements Runnable {
    static  SynchronizendObjectCodeBlock2 instance=new SynchronizendObjectCodeBlock2();

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
        synchronized (this) {
            System.out.println("对象锁代码块，我是：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
}
