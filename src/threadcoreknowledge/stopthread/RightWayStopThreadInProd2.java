package threadcoreknowledge.stopthread;

/**
 * Created by zhengjie on 2019/12/23.
 * 最佳实践2：在catch子语句中调用Thread.currentThread().interrupt()来恢复设置中断状态，以便于在后续的执行中
    依然能检查到刚刚发生了中断，回到刚才RightWayStopThreadInPro补上中断，让它跳出。
 */
public class RightWayStopThreadInProd2 implements Runnable{
    public static void main(String[] args) {
        Thread thread=new Thread(new RightWayStopThreadInProd2());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupt");
                break;
            }
                reInMethod();
                System.out.println("保存日志");


        }
    }

    private void reInMethod() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }
}
