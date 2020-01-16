package Countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Demo {

    public void meeting(CountDownLatch cdl){
        System.out.println(Thread.currentThread().getName()+"到了会议室");
        try {
            cdl.countDown();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
