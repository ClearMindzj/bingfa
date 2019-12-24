package synchtonized;

/**
 * Created by zhengjie on 2019/12/22.
 * 可重入粒度测试：调用类另外的方法
 */
public class SynchronizedOtherMethod11 {

    public synchronized void method1(){
        System.out.println("我说method1");
        method2();
    }
    public synchronized void method2(){
        System.out.println("我是method2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMethod11 synchronizedOtherMethod11=new SynchronizedOtherMethod11();
        synchronizedOtherMethod11.method1();
    }

}
