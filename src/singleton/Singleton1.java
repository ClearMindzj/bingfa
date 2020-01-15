package singleton;

/**
 * Created by zhengjie on 2020/1/12.
 * 饿汉（静态常量） 可用，因为类一初始化就实例了。
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE=new Singleton1();

    private Singleton1(){

    }
    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
