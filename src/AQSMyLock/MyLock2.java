package AQSMyLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock2 implements Lock {

    //adapter
    Helper helper = new Helper();

    private class Helper extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {

            //如果是最开始的第一个线程进来，可以拿到锁，因此我们可以返回true

            //如果第二个线程和保存的线程值一致，则为重入锁

            //如果判断是第一个线程进来还是其他线程进来
            int state = getState();
            Thread t = Thread.currentThread();

            if(state == 0){
                //保证原子性操作,期望值是否和当前值一致
                if(compareAndSetState(0, arg)){
                    //设置当前线程获取独占锁
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }else if(getExclusiveOwnerThread() == t){
                setState(state + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            //锁的获取和释放是一一对应的，那么调用此方法的线程一定是当前线程

            if(Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }

            int state = getState() - arg;

            boolean flag = false;

            if(getState() == 0){
                //其他线程可以来抢资源了
                setExclusiveOwnerThread(null);
                flag = true;
            }

            setState(state);

            return flag;
        }

        Condition newCondition(){
            return new ConditionObject();
        }

    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

}
