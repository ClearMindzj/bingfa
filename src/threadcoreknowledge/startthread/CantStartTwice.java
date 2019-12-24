package threadcoreknowledge.startthread;

/**
 * Created by zhengjie on 2019/12/23.
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();
    }
}
