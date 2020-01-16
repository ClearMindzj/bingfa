package deadlock;

import java.util.Random;

/**
 * Created by zhengjie on 2020/1/16.
 */
public class LiveLock {
    static class Spoon {
        private Dinner owner;

        public Spoon(Dinner owner) {
            this.owner = owner;
        }

        public Dinner getOwner() {
            return owner;
        }

        public void setOwner(Dinner owner) {
            this.owner = owner;
        }

        public synchronized void use() {
            System.out.printf("%s吃完了!", owner.name);
        }
    }

    static class Dinner {
        private String name;
        private boolean isHungry;

        public Dinner(String name) {
            this.name = name;
            isHungry = true;
        }

        public void eatWith(Spoon spoon, Dinner spouse) {
            while (isHungry) {
                if (spoon.owner != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                if (spouse.isHungry&&new Random().nextInt(10)<9) {
                    System.out.println(name + ": 亲爱的" + spouse.name + "你先吃吧");
                    spoon.setOwner(spouse);
                    continue;
                }
                spoon.use();
                isHungry = false;
                System.out.println(name + ": 我吃完了");
                spoon.setOwner(spouse);

            }
        }
    }

    public static void main(String[] args) {
        Dinner husband = new Dinner("牛郎");
        Dinner wife = new Dinner("织女");

        Spoon spoon = new Spoon(wife);

        new Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWith(spoon, wife);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWith(spoon, husband);
            }
        }).start();
    }
}
