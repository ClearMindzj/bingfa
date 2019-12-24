package synchtonized;

/**
 * Created by zhengjie on 2019/12/22.
 * 调用父类方法
 */
public class SynchronizedSuperClass12 {
    protected String name;
    protected String address;
    public synchronized void dosomething(){
        System.out.println("我是父类方法");
        System.out.println(name+address);
    }



}

class TestClass extends SynchronizedSuperClass12{
    TestClass(String name1,String address1){
        name=name1;
        address=address1;
    }


    public static void main(String[] args) {
        TestClass s=new TestClass("zj","lh");
        s.dosomething();
    }

}
