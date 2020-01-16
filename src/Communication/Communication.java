package Communication;

public class Communication {

    private volatile int signal;

    public void set(int value){
        this.signal = value;
    }

    public int get (){
        return signal;
    }

    public static void main(String[] args){
        Communication c = new Communication();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c) {
                    System.out.println("修改状态的线程执行...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c.set(1);
                    c.notify();
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //等待signal为1开始执行，否则不能执行,类似自旋锁，性能损耗太严重
//                while (c.get()==1){
//
//                }
//
//                //当信号为1的时候，执行代码
//
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c) {
                    while (c.get() != 1) {
                        try {
                            c.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("状态值修改成功");
                }
            }
        }).start();
    }
}
