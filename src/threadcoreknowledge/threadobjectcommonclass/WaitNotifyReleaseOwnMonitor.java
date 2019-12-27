package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2019/12/27.
 * 证明wait只释放当前的那把锁
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("1 got a lock");

                    synchronized (resourceB) {
                        System.out.println("1 got b lock");
                    }
                    try {
                        System.out.println(" a release a lock");
                        resourceA.wait();
                        System.out.println("1 重新获得 a");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("2 got a lock");

                    System.out.println("2 try b");
                    synchronized (resourceB) {
                        System.out.println("2 got b lock");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
