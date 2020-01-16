import java.util.Timer;
import java.util.TimerTask;

public class Thread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Timer timer = new Timer("定时器线程");
        Timer timer2  = new Timer("计时器线程");
        timer.schedule(new TimerTask() {
        	    public void run() {
        	    	    for(int i=0;i<100;i++)
        	    	        System.out.println(Thread.currentThread().getName()+" is running");
        	    }
        }, 1);
        timer2.schedule(new TimerTask() {
    	        public void run() {
    	    	        for(int i=0;i<100;i++)
    	    	            System.out.println(Thread.currentThread().getName()+" is frunning");
    	        }
        }, 1);
	}

}
