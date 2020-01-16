package ForkJoin;

import java.util.Vector;
import java.util.concurrent.*;

public class Demo extends RecursiveTask<Integer> {

    private int begin;
    private int end;

    public Demo(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //divide task
        if(end-begin<=2){
            //计算结果
            for(int i=begin;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            //divide
            Demo d1 = new Demo(begin, (begin+end)/2);
            Demo d2 = new Demo((begin+end)/2+1, end);

            //execute
            d1.fork();
            d2.fork();

            Integer a = d1.join();
            Integer b = d2.join();

            sum = a+b;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new Demo(0, 500));
        System.out.println("......");
        System.out.println("计算的值为:"+future.get());
    }
}
