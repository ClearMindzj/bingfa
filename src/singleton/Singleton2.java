package singleton;

/**
 * Created by zhengjie on 2020/1/12.
 * 饿汉（静态代码块）可用
 */
public class Singleton2 {
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE=new Singleton2();
    }

    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
