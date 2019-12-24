package threadcoreknowledge.createthread.wrongways;

/**
 * Created by zhengjie on 2019/12/23.
 * Lambda创建线程
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
