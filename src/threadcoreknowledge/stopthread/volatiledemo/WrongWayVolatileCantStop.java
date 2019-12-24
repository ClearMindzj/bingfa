package threadcoreknowledge.stopthread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhengjie on 2019/12/24.
 * 演示用volatile的局限2
 * 陷入阻塞时，volatile是无法线程的
 * 此例中，生产者生产速度很快，消费者消费速度慢
 * 所以阻塞队列满了以后，生产者会阻塞，等待消费者消费
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage=new ArrayBlockingQueue(10);
        Product product=new Product(storage);
        Thread produceThread=new Thread(product);
        produceThread.start();
        Thread.sleep(1000);
        Consumer consumer=new Consumer(storage);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take()+"被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要和更多数据了");
        //一旦消费者不需要更多数据，我们应该让生产者停下来
        product.cancled=true;


    }
}

class Product implements Runnable{
     BlockingQueue storage;
     public volatile boolean cancled=false;
    public Product(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num < 10000 && !cancled) {
                if (num % 100 == 0) {
                    storage.put(num);
                    System.out.println(num + "放到仓库中");
                }
                num++;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者停止运行");
        }
    }
}

class Consumer{
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        if(Math.random()>0.95){
            return false;
        }
        return true;
    }
}