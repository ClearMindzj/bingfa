package threadcoreknowledge.stopthread;

/**
 * Created by zhengjie on 2019/12/23.
 * 最佳实践：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常
 * 那么在run（）中会强制try/catch
 */
public class RightWayStopThreadInProd implements Runnable{
    public static void main(String[] args) {
        Thread thread=new Thread(new RightWayStopThreadInProd());
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
        while (true&&!Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {

            Thread.sleep(2000);

    }
}
