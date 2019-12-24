package threadcoreknowledge.stopthread;

/**
 * Created by zhengjie on 2019/12/23.
 * 带有sleep终端线程写法
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            int num = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && num <= 10000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100整数倍");
                    }
                    num++;

                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
