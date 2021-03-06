package synchtonized;

/**
 * Created by zhengjie on 2019/12/21.
 */
public class SynchronizedClassClass5 implements Runnable{

    static SynchronizedClassClass5 instance1=new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2=new SynchronizedClassClass5();

    private void method(){
        synchronized (SynchronizedClassClass5.class){
            System.out.println("我是类锁第二种形式，名字为："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

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
}
