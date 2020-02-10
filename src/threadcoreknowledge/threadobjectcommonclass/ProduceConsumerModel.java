package threadcoreknowledge.threadobjectcommonclass;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by zhengjie on 2019/12/27.
 * 用wait/notify实现
 */
public class ProduceConsumerModel {
    public static void main(String[] args) {
        EventStoreage stroage=new EventStoreage();
        Producer producer=new Producer(stroage);
        Consumer consumer=new Consumer(stroage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
    class Producer implements Runnable{
     private EventStoreage stroage;
     public  Producer(EventStoreage stroage){
         this.stroage=stroage;

     }
        @Override
        public void run() {

            for (int i=0;i<1000;i++){
             stroage.put();
            }
        }
    }
    class Consumer implements Runnable{
        private EventStoreage stroage;
        public  Consumer(EventStoreage stroage){
            this.stroage=stroage;

        }
        @Override
        public void run() {

            for (int i=0;i<1000;i++){
                stroage.take();
            }
        }
    }
    class EventStoreage {
        private int maxSize;
        private LinkedList<Date> storage;
        public EventStoreage(){
            maxSize=100;
            storage=new LinkedList<>();
        }
        public synchronized void put(){
            while (storage.size()==maxSize){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            System.out.println("仓库里有了"+storage.size()+"个产品");
            notify();
        }
        public synchronized void take(){
            while(storage.size()==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("拿到了"+storage.poll()+"现在仓库还剩下"+storage.size());
            notify();
        }
    }

