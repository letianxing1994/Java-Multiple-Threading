package semaphore;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Demo {

    public void meeting(Semaphore s){
        try {
            s.acquire();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"正在运行");
        s.release();
    }

}
