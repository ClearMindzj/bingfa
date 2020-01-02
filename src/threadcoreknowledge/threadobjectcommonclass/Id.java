package threadcoreknowledge.threadobjectcommonclass;

/**
 * Created by zhengjie on 2020/1/2.
 * Id从1开始，JVM运行起来之后，我们自己创建的线程ID早已不是0
 */
public class Id {
    public static void main(String[] args) {
        Thread thread=new Thread();
        System.out.println(Thread.currentThread().getId());
        System.out.println(thread.getId());
    }
}
