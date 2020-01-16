import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Thread3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<100;i++)
					System.out.println(Thread.currentThread().getName()+" is running");
			}
        	    
        });
        
        executor.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<100;i++)
					System.out.println(Thread.currentThread().getName()+" is running");
			}
        	    
        });
	}
}
