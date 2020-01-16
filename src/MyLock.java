import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {
    private boolean isLocked = false;
    private int lockCount = 0;
    private Thread lockBy = null;

    @Override
    public synchronized void lock() {
        while(isLocked && lockBy!=Thread.currentThread()){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockCount++;
        lockBy = Thread.currentThread();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        if(lockBy == Thread.currentThread()) {
            lockCount--;
            if (lockCount == 0)
                notify();
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
