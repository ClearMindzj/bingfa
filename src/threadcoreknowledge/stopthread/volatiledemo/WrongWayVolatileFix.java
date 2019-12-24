package threadcoreknowledge.stopthread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhengjie on 2019/12/24.
 */
public class WrongWayVolatileFix {

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatileFix body=new WrongWayVolatileFix();
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Product product = body.new Product(storage);
        Thread produceThread = new Thread(product);
        produceThread.start();
        Thread.sleep(1000);
        Consumer consumer = body.new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要和更多数据了");
         produceThread.interrupt();
        //一旦消费者不需要更多数据，我们应该让生产者停下来



    }


    class Product implements Runnable {
        BlockingQueue storage;

        public Product(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num < 10000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        storage.put(num);
                        System.out.println(num + "放到仓库中");
                    }
                    num++;

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者停止运行");
            }
        }
    }

    class Consumer {
        BlockingQueue storage;

        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNums() {
            if (Math.random() > 0.95) {
                return false;
            }
            return true;
        }
    }
}
