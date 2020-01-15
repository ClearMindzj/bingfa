package singleton;

/**
 * Created by zhengjie on 2020/1/12.
 * 双重检查
 */
public class Singleton6 {
    private volatile static Singleton6 instance;

    private Singleton6(){

    }
    public  static Singleton6 getInstance(){
        if(instance ==null){  //1.这会触发空指针。
            synchronized (Singleton6.class){
                if(instance==null){
                    instance=new Singleton6();
                }
            }
        }
        return instance;
    }
}
