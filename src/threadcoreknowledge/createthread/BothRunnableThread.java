package threadcoreknowledge.createthread;

/**
 * Created by zhengjie on 2019/12/23.
 * 同时实现两种实现线程方式
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        })
        {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
