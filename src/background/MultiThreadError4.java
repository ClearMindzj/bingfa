package background;

/**
 * Created by zhengjie on 2020/1/6.
 * 发布逸出
 */
public class MultiThreadError4{
    static Point point;

    public static void main(String[] args) throws InterruptedException {
        new PointMaker().start();
        Thread.sleep(50);
        if(point!=null){
            System.out.println(point);
        }
    }

}

class  Point{
    private final int x,y;
    public Point(int x,int y) throws InterruptedException {
        this.x=x;
        MultiThreadError4.point=this;
        Thread.sleep(100);
        this.y=y;
    }

    @Override
    public String toString() {
        return x+","+y;
    }
}

class PointMaker extends Thread{
    @Override
    public void run() {
        try {
            new Point(1,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}