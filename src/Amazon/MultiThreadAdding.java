package Amazon;

import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;

public class MultiThreadAdding{
    CountDownLatch cdl;
    public MultiThreadAdding(CountDownLatch cdl){
        this.cdl = cdl;
    }

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(9);
        int[] arr = {101, 23, 553, 123, 56, 71, 23, 53522, 293};
        PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<>();
        MultiThreadAdding mta = new MultiThreadAdding(cdl);
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pq.put(num);
                    mta.add();
                }
            }).start();
        }
        try {
            cdl.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    public void add(){
        try {
            this.cdl.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
