package threadcoreknowledge.stopthread.volatiledemo;

/**
 * Created by zhengjie on 2019/12/24.
 * 演示volatile局限：看似可行
 */
public class WrongWayVolatile implements Runnable {
    private volatile boolean cancled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num < 10000 && !cancled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile r=new WrongWayVolatile();
        Thread thread=new Thread(r);
        thread.start();
        Thread.sleep(5000);
        r.cancled=true;
    }
}
