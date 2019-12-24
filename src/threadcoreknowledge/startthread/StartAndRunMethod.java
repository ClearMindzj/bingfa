package threadcoreknowledge.startthread;

/**
 * Created by zhengjie on 2019/12/23.
 * 对比start和run方式
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable=()->{
            System.out.println(Thread.currentThread().getName());
        };
        //runnable.run();
        new Thread(runnable).start();
    }
}
