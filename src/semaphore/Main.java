package semaphore;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        Demo demo = new Demo();
        Semaphore s = new Semaphore(5);
        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.meeting(s);
                }
            }).start();
        }
    }
}
