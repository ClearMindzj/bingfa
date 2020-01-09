package background;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengjie on 2020/1/9.
 * 构造函数中新建线程
 */
public class MultiThreadsError6 {
    private Map<String, String> states;

    public MultiThreadsError6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1", "周一");
                states.put("2", "周二");
                states.put("3", "周三");
                states.put("4", "周四");
            }
        }).start();

    }

    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadsError6 multiThreadsError6 = new MultiThreadsError6();
        Map<String, String> states = multiThreadsError6.getStates();
        Thread.sleep(1000);
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));

        System.out.println(multiThreadsError6.getStatesImproved().get("1"));
        multiThreadsError6.getStatesImproved().remove("1");
        System.out.println(multiThreadsError6.getStatesImproved().get("1"));

    }
}
