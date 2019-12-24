package synchtonized;

/**
 * Created by zhengjie on 2019/12/22.
 * 可重入粒度测试
 */
public class SynchronizedReurision10 {
    int a=0;
    public static void main(String[] args) {
        SynchronizedReurision10 synchronizedReurision10=new SynchronizedReurision10();
        synchronizedReurision10.method1();

    }
    private synchronized void method1(){
        System.out.println("只是a："+a);
        if(a==0){
            a++;
            method1();
        }
    }
}
