package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2019/12/27.
 * 三个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify，notifyall
 * start先执行，不代表这个线程先启动
 */
public class WaitNotifyAll implements Runnable{

    private static final Object resourceA=new Object();

    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName()+"got A Lock");
            try {
                System.out.println(Thread.currentThread().getName()+"wait to start");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"waiting to end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll r=new WaitNotifyAll();
        Thread thread1=new Thread(r);
        Thread thread2=new Thread(r);
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    resourceA.notifyAll();
                    System.out.println("C notifyall");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();
    }
}
