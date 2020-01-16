
public class 重入synchronized{
    
	public synchronized void a() {
		System.out.println("a");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized void b() {
		System.out.println("b");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		重入synchronized demo = new 重入synchronized();
		重入synchronized demo1 = new 重入synchronized();
		重入synchronized demo2 = new 重入synchronized();
		// TODO Auto-generated method stub
		for(int i=0;i<2;i++) {
            new Thread(new Runnable() {

			    @Override
			    public void run() {
				    // TODO Auto-generated method stub
				    demo1.b();
			    }
        	    
            }).start();
        
            new Thread(new Runnable() {

			    @Override
			    public void run() {
				    // TODO Auto-generated method stub
				    demo1.b();
			    }
        	    
            }).start();
            
//            new Thread(new Runnable() {
//
//			    @Override
//			    public void run() {
//				    // TODO Auto-generated method stub
//				    demo2.a();
//			    }
//        	    
//            }).start();
//            
//            new Thread(new Runnable() {
//
//			    @Override
//			    public void run() {
//				    // TODO Auto-generated method stub
//				    demo2.b();
//			    }
//        	    
//            }).start();
		}
        
        while(Thread.activeCount()!=1) {
        }
        System.out.println("所有线程执行完毕了");
	}

}
