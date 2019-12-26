package threadcoreknowledge.sixstates;

/**
 * Created by zhengjie on 2019/12/26.
 * 展示blocked、waiting、timewaiting
 */
public class BlockedWaitingTimeWaiting implements  Runnable {
    public static void main(String[] args) {
        BlockedWaitingTimeWaiting runnable=new BlockedWaitingTimeWaiting();
        Thread thread1=new Thread(runnable);
        thread1.start();
        Thread thread2=new Thread(runnable);
        thread2.start();
        //打印出timewaiting，因为正在sleep
        System.out.println(thread1.getState());
        //打印blocked，还没拿到锁
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出waiting
        System.out.println(thread1.getState());
    }
    @Override
    public void run() {
        syn();

    }
    private synchronized void syn(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
