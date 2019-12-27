package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2019/12/27.
 * 展示sleep的时候不释放synchronized的monitor
 * sleep时间到了以后才释放锁
 */
public class SleepDontReleaseMonitor implements Runnable{
    public static void main(String[] args) {
           SleepDontReleaseMonitor runner=new SleepDontReleaseMonitor();
           new Thread(runner).start();
           new Thread(runner).start();
    }


    @Override
    public void run() {
        syn();
    }
    public synchronized void syn(){
        System.out.println("线程"+Thread.currentThread().getName()+"获取到了monitor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"退出了代码块");

    }
}
