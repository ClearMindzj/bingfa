package threadcoreknowledge.createthread;

/**
 * Created by zhengjie on 2019/12/23.
 * Runnable 方式
 */
public class RunnableStyle implements Runnable {

    public static void main(String[] args) {
        Thread thread=new Thread(new RunnableStyle());
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("Runnable 实现");
    }
}
