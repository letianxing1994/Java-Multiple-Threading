package Countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args){
        Demo demo = new Demo();
        CountDownLatch cb = new CountDownLatch(10);
        for(int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.meeting(cb);
                }
            }).start();
        }
        try {
            cb.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("会议室到达10人");
    }
}
