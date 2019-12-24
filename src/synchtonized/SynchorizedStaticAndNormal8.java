package synchtonized;

/**
 * Created by zhengjie on 2019/12/22.
 */
public class SynchorizedStaticAndNormal8 implements Runnable {
    static  SynchorizedStaticAndNormal8 instance=new SynchorizedStaticAndNormal8();
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
    public  static synchronized void method1(){
        System.out.println("我是静态加锁方法，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
    public  synchronized void method2(){
        System.out.println("我是非静态加锁方法，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
