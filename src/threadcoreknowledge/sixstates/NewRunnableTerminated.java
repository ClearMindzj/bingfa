package threadcoreknowledge.sixstates;

/**
 * Created by zhengjie on 2019/12/26.
 * 展示线程的NEW、Runnable、Terminated状态
 * 即使是正在运行，也是Runnable状态，而不是Running
 */
public class NewRunnableTerminated implements Runnable {
    public static void main(String[] args) {
        Thread thread=new Thread(new NewRunnableTerminated());
        //打印new状态
        System.out.println(Thread.currentThread().getName());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
    @Override
    public void run() {

        for(int i=0;i<1000;i++){
            System.out.println(i);
        }
    }
}
