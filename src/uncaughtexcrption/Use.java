package uncaughtexcrption;

/**
 * Created by zhengjie on 2020/1/2.
 * 描述： 1. 不加try catch抛出4个异常，都带线程名字
 * 2. 加了try catch,期望捕获到第一个线程的异常，线程234不应该运行，希望看到打印出Caught Exception
 * 3. 执行时发现，根本没有Caught Exception，线程234依然运行并且抛出异常
 *
 *   说明线程的异常不能用传统方法捕获
 */
public class Use implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Use(),"MyThread-1").start();
        Thread.sleep(300);
        new Thread(new Use(),"MyThread-2").start();
        Thread.sleep(300);
        new Thread(new Use(),"MyThread-3").start();
        Thread.sleep(300);
        new Thread(new Use(),"MyThread-4 ").start();
        Thread.sleep(300);
    }

    @Override
    public void run() {
        throw new RuntimeException();


    }
}

