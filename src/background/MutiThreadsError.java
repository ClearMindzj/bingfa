package background;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhengjie on 2020/1/6.
 * 第一种：运行结果出错，找出具体出错位置
 */
public class MutiThreadsError implements Runnable {
    static MutiThreadsError instance = new MutiThreadsError();
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongIndex = new AtomicInteger();
    static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    final boolean[] marked = new boolean[10000000];
    int index = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("index:" + instance.index);
        System.out.println("正确" + realIndex.get());
        System.out.println("错误" + wrongIndex.get());
    }

    @Override
    public void run() {
        marked[0] = true;
        for (int i = 0; i < 1000000; i++) {
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            realIndex.incrementAndGet();
            synchronized (instance){
                if (marked[index]&&marked[index-1]) {
                    System.out.println("发生错误" + index);
                    wrongIndex.incrementAndGet();
                }
                marked[index] = true;
            }

        }
    }
}
