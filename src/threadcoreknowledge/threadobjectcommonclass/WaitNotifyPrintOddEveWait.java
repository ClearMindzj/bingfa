package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2019/12/27.
 * 两个线程交替打印0-100奇偶数，用wait和notify
 */
public class WaitNotifyPrintOddEveWait {
    private  static  int count=0;
    private  static  final  Object lock=new Object();
    //1,拿到锁，就打印
    //2.打印完，唤醒其他线程，自己就休眠
    public static void main(String[] args) {
        Thread thread1=new Thread(new TurningRunning(),"偶数：");
        Thread thread2=new Thread(new TurningRunning(),"奇数：");
        thread1.start();
        thread2.start();
    }

    static  class TurningRunning implements Runnable{

        @Override
        public void run() {
            while (count<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+count++);
                    lock.notify();
                    if(count<=100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

}
