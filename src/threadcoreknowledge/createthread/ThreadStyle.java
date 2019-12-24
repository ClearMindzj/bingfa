package threadcoreknowledge.createthread;

/**
 * Created by zhengjie on 2019/12/23.
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("Thread 类");
    }

    public static void main(String[] args) {
          new ThreadStyle().start();
    }

}
