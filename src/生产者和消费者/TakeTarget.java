package 生产者和消费者;

public class TakeTarget implements Runnable {

    private Tmall tmall;

    public TakeTarget(Tmall tmall){
        this.tmall = tmall;
    }

    @Override
    public void run() {
        while(true) {
            tmall.take();
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
