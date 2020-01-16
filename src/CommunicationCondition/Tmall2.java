package CommunicationCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tmall2 {

    private int count;

    private Lock lock = new ReentrantLock();
    Condition p = lock.newCondition();
    Condition t = lock.newCondition();

    public final int MAX_COUNT = 10;

    public void push (){
        lock.lock();
        while(count >= MAX_COUNT){
            try {
                System.out.println(Thread.currentThread().getName()+"库存数量达到上限");
                p.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"生产者生产，当前库存为："+count);
        t.signal();
        lock.unlock();
    }

    public void take(){
        lock.lock();
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
        p.signal();
        lock.unlock();
    }
}
