package deadlock;

import java.util.Random;


/**
 * Created by zhengjie on 2020/1/15.
 * 多人同时转账
 */
public class MultiTransferMoney {
    private static final int NUM_ACCOUNTS=500;
    private static final int NUM_MONEY=1000;
     private static final int NUM_ITERATIONS =1000000;
    private static final int NUM_THREADS = 20;

    public static void main(String[] args) {
        Random random=new Random();
       TransferMoney.Account[] accounts=new TransferMoney.Account[NUM_ACCOUNTS];
        for (int i = 0; i <accounts.length ; i++) {
            accounts[i]=new TransferMoney.Account(NUM_MONEY);
        }

        class TransferThread extends Thread{

            @Override
            public void run() {
                for (int i = 0; i <NUM_ITERATIONS; i++) {
                    int fromAcct=random.nextInt(NUM_ACCOUNTS);
                    int toAcct=random.nextInt(NUM_ACCOUNTS);
                    int amount=random.nextInt(NUM_MONEY);
                    TransferMoney.transferMoney(accounts[fromAcct],accounts[toAcct],amount);
                }
            }
        }
        for (int i = 0; i <NUM_THREADS ; i++) {
            new TransferThread().start();
        }
    }
}
