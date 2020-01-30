package test;

import java.util.concurrent.CountDownLatch;

public class Hello {

    int exist = 100;
    int empty = 0;

    /**
     * 生产者
     */
    public void produce() {
        while (true) {
            if (empty > 0) {
                synchronized (this) {
                    if (empty > 0) {
                        exist++;
                        empty--;
                        System.out.println("生产, exist= "+exist+"empty= "+empty);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 消费者
     */
    public void consume() {
        while (true) {
            if (exist > 0) {
                synchronized (this) {
                    if (exist > 0) {
                        empty++;
                        exist--;
                        System.out.println("消费, exist= "+exist+"empty= "+empty);
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Hello hello = new Hello();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("第二个线程运行过");
                for (int i = 0; i < 9999050; i++) {
                    hello.produce();
                }
                countDownLatch.countDown();
            }

        }).start();



        new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 9999100; i++) {

                    hello.consume();
                }
                countDownLatch.countDown();
            }

        }).start();


        try {
            countDownLatch.await();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(hello.exist);
        System.out.println(hello.empty);

    }
}
