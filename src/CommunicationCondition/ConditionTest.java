package CommunicationCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args){
        Demo demo = new Demo();
        for(int i=0;i<3;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.c();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.b();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.a();
                }
            }).start();
        }
    }
}

class Demo {
    private int signal = 0;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void a(){
        lock.lock();
        while(signal != 0){
            try{
                a.await();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("a正在运行");
        try {
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        signal ++;
        b.signal();
        lock.unlock();
    }

    public void b(){
        lock.lock();
        while(signal != 1){
            try{
                b.await();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("b正在运行");
        try {
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        signal ++;
        c.signal();
        lock.unlock();
    }

    public void c(){
        lock.lock();
        while(signal != 2){
            try{
                c.await();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("c正在运行");
        try {
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        signal = 0;
        a.signal();
        lock.unlock();
    }
}
