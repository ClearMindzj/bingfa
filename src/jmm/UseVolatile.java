package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhengjie on 2020/1/11.
 */
public class UseVolatile implements Runnable {
  boolean done = false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Runnable r = new UseVolatile();
            Thread thread1 = new Thread(r);
            Thread thread2 = new Thread(r);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println(((UseVolatile) r).done);
            System.out.println(((UseVolatile) r).realA.get());
            if(((UseVolatile) r).done==false) break;
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            setDone();
            realA.incrementAndGet();
        }
    }

    private void setDone() {
        done = true;
    }

}
