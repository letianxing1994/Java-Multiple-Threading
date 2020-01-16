package 生产者和消费者;

public class PushTarget implements Runnable {

    private Tmall tmall;

    public PushTarget(Tmall tmall){
        this.tmall = tmall;
    }

    @Override
    public void run() {
        while(true) {
            tmall.push();
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
