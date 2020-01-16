package CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Demo {

    public void meeting(CyclicBarrier cb){
        System.out.println(Thread.currentThread().getName()+"到了会议室");
        try {
            cb.await();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
