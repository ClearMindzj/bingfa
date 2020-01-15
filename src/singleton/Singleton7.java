package singleton;

/**
 * Created by zhengjie on 2020/1/12.
 * 静态内部类，可用。
 */
public class Singleton7 {
    private volatile static Singleton7 instance;

    private Singleton7(){

    }

    private static class SingletonInstance{
        private static final Singleton7 INSTANCE=new Singleton7();

    }
    public  static Singleton7 getInstance(){
         return SingletonInstance.INSTANCE;
    }
}
