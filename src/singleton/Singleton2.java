package singleton;

/**
 * Created by zhengjie on 2020/1/12.
 * 饿汉（静态代码块）可用
 */
public class Singleton2 {
    public static void main(String[] args) {
        System.out.println("2a");
    }
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE=new Singleton2();
        System.out.println("a");
    }

    private Singleton2(){
        System.out.println("3a");

    }
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
