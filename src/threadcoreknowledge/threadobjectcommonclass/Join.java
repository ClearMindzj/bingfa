package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2020/1/2.
 * join方法
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("开始等待子线程");
        thread1.join();
        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
