import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread1 implements Callable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Callable<String> call1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "sasa";
            }
        };
        Callable<String> call2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "sasa";
            }
        };
        Thread1 t = new Thread1();
        Thread1 t1 = new Thread1();
        FutureTask<String> ft = new FutureTask<>(call1);
        FutureTask<String> ft1 = new FutureTask<>(call2);
        Thread thread = new Thread(ft);
        Thread thread1 = new Thread(ft1);
        thread.start();
        thread1.start();
        try {
            System.out.println(ft.get()+ft1.get());
        }catch (Exception e){
            e.printStackTrace();
        }

	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) 
			System.out.println(Thread.currentThread().getName()+"我是由callable创建的");
		return "sasa";
	}

}
