package synchtonized;

/**
 * Created by zhengjie on 2019/12/22.
 * 同时访问同步方法和非同步方法
 */
public class SynchronizedYesandNo6 implements Runnable {
    static SynchronizedYesandNo6 instance=new SynchronizedYesandNo6();
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance );
        t1.join();
        t2.join();
        t1.start();
        t2.start();

    }


    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }

    }
    public  synchronized void method1(){
        System.out.println("我是加锁方法，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
    public static  void method2(){
        System.out.println("我是没加锁方法，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
