package readwriteLock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class readwritelocktest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock rl = rwl.readLock();
        ReentrantReadWriteLock.WriteLock wl = rwl.writeLock();
        ReentrantReadWriteLock rwl1 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock rl1 = rwl.readLock();
        ReentrantReadWriteLock.WriteLock wl1 = rwl1.writeLock();
        map.put(1, 1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                wl.lock();
//                wl1.lock();
                System.out.println(Thread.currentThread().getName() + "获取了第一把写锁");
                while(true) {
                    System.out.println(Thread.currentThread().getName() + "获取了第一把写锁");
                }
//                rl.unlock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                wl1.lock();
                System.out.println(Thread.currentThread().getName() + "获取了第二把写锁");
                while(true) {
                    System.out.println(Thread.currentThread().getName() + "获取了第二把写锁");
                }
//                wl1.unlock();
            }
        }).start();
//        for (int i = 0; i < 15; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    wl.lock();
//                    System.out.println("我是线程:"+Thread.currentThread().getName()+" "+"我得到了数据"+map.get(1));
//                    try {
//                        Thread.sleep(100);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    wl.unlock();
//                }
//            }).start();
//        }
    }

}
