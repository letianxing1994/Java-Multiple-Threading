package 生产者和消费者;

public class Tmall {

    private int count;

    public final int MAX_COUNT = 10;

    public synchronized void push (){
        while(count >= MAX_COUNT){
            try {
                System.out.println(Thread.currentThread().getName()+"库存数量达到上限");
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"生产者生产，当前库存为："+count);
        notifyAll();
    }

    public synchronized void take(){
        while(count<=0){
            try {
                System.out.println(Thread.currentThread().getName()+"库存数量不足，库存数量为0");
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费者消费, 当前库存为： "+count);
        notifyAll();
    }
}
