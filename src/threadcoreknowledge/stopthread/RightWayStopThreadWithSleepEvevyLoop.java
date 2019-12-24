package threadcoreknowledge.stopthread;

/**
 * Created by zhengjie on 2019/12/23.
 */
public class RightWayStopThreadWithSleepEvevyLoop {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
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
        try

    {
        Thread.sleep(5000);
    } catch(
    InterruptedException e)

    {
        e.printStackTrace();
    }
        thread.interrupt();
}
}
