package synchtonized;

/**
 * Created by zhengjie on 2019/12/21.
 * 类锁第一种形式
 */
public class SynchronizedClassStatic4 implements Runnable{

    static SynchronizedClassStatic4 instance1=new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 instance2=new SynchronizedClassStatic4();
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance1);
        Thread t2=new Thread(instance2);
        t1.join();
        t2.join();
        t1.start();
        t2.start();

    }
    @Override
    public void run() {
        method();

    }
    public  synchronized static void method(){
        System.out.println("我是类锁方法修饰符，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
