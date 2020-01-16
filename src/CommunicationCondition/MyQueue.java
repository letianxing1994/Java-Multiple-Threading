package CommunicationCondition;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<E> {

    private Object[] obj;

    private int addIndex;
    private int removeIndex;
    private int queueSize;

    private Lock lock = new ReentrantLock();
    Condition addCondition = lock.newCondition();
    Condition removeCondition = lock.newCondition();

    public static void main(String[] args) {
        MyQueue mq = new MyQueue(10);
        for(int i=0;i<1000;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    mq.add(random.nextInt(10));
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    mq.remove();
                }
            }).start();
        }
    }

    public MyQueue(int count){
        obj = new Object[count];
    }

    public void add(E e){
        lock.lock();
        while(queueSize == obj.length){
            try{
                System.out.println(Thread.currentThread().getName()+"队列已满");
                addCondition.await();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        obj[addIndex++] = e;
        System.out.println(Thread.currentThread().getName()+"队列中加入元素"+e);
        if(addIndex==obj.length){
            addIndex = 0;
        }
        queueSize++;
        removeCondition.signal();
        try {
            Thread.currentThread().sleep(1000);
        }catch(Exception e2){
            e2.printStackTrace();
        }
        lock.unlock();
    }

    public void remove(){
        lock.lock();
        while(queueSize == 0){
            try {
                System.out.println(Thread.currentThread().getName()+"队列为空，不可以移除");
                removeCondition.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"队列中移除元素"+obj[removeIndex]);
        obj[removeIndex++] = null;
        if(removeIndex==obj.length){
            removeIndex = 0;
        }
        queueSize--;
        addCondition.signal();
        try {
            Thread.currentThread().sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        lock.unlock();
    }

}
