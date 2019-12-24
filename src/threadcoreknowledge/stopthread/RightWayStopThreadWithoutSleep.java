package threadcoreknowledge.stopthread;

/**
 * Created by zhengjie on 2019/12/23.
 * run方法类没有sleep或wait方法，停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num=0;
        while(!Thread.currentThread().isInterrupted()&&num<Integer.MAX_VALUE/2){
            if(num%10000==0){
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
        System.out.println("任务结束 ");
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
}
