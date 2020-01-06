package background;

/**
 * Created by zhengjie on 2020/1/6.
 * 演示死锁
 */
public class MultiThreadError implements Runnable {
    int flag=1;
    static Object object1=new Object();
    static Object object2=new Object();

    public static void main(String[] args) {
        MultiThreadError m1=new MultiThreadError();
        MultiThreadError m2=new MultiThreadError();
        m1.flag=1;
        m2.flag=0;
        new Thread(m1).start();
        new Thread(m2).start();
    }

    @Override
    public void run() {
        System.out.println(flag);
       if(flag==1){
           synchronized (object1){
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (object2){
                   System.out.println("1");
               }
           }

       }
        if(flag==0){
            synchronized (object2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("0");
                }
            }

        }
    }
}
