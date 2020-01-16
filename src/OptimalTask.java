
public class OptimalTask {
	private String getData1;
    private String getData2;
    private String resultdata1;
    private String resultdata2;
    public void doLongTimeTask() {
    	    try {
    	    	    System.out.println("begin task");
    	    	    Thread.sleep(3000);
    	    	    synchronized(this) {
    	    	    	    getData1 = "长时间处理任务后从远程返回的值1 threadName="+Thread.currentThread().getName();
        	    	    getData2 = "长时间处理任务后从远程返回的值2 threadName="+Thread.currentThread().getName();
    	    	    	    resultdata1 = getData1;
    	    	    	    resultdata2 = getData2;
    	    	    	    System.out.println(resultdata1);
    	    	    	    System.out.println(resultdata2);
    	    	    	    System.out.println("end task");
    	    	    }
    	    }catch(InterruptedException e) {
    	    	    e.printStackTrace();
    	    }
    }
}
