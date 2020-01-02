package uncaughtexcrption;

/**
 * Created by zhengjie on 2020/1/2.
 * 单线程，抛出，处理，有异常堆栈
 */
public class ExceptionInChildThread implements Runnable{
    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
        }
    }
    @Override
    public void run() {
       throw new RuntimeException();
    }
}
