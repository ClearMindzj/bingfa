package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2019/12/27.
 * 展示wait和notify基本用法
 * 研究代码顺序
 * 证明wait释放锁
 */
public class Wait {

    public static Object object=new Object();

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"开始执行了");
                try {
                    object.wait();
                    System.out.println("线程"+Thread.currentThread().getName()+"等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
            }
        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                object.notify();
                System.out.println("线程"+Thread.currentThread().getName()+"调用notify");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ab");

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread1();
        Thread thread2=new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }
}

