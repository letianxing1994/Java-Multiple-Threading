package CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args){
        Demo demo = new Demo();
        CyclicBarrier cb = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("会议室到10个人了");
            }
        });
        for(int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.meeting(cb);
                }
            }).start();
        }
    }
}
