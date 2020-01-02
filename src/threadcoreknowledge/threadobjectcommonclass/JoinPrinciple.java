package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2020/1/2.
 * 分析join的代替写法
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread1 finished");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thread1.start();
        System.out.println("开始等待子线程");
        thread1.join();
        System.out.println("所有子线程执行完毕");
    }
}
