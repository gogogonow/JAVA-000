package java0.conc0303;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockConditionImpl {
    final Lock lock = new ReentrantLock();
    final Condition complete = lock.newCondition();
    private volatile Integer result = null;


    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        LockConditionImpl impl = new LockConditionImpl();

        new Thread(impl::sum).start();

        System.out.println("异步计算结果为：" + impl.getResult());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private void sum() {
        lock.lock();
        try {
            result = fibo(36);
            complete.signal();
        } finally {
            lock.unlock();
        }
    }

    private int getResult() {
        lock.lock();
        try {
            while (result == null) {
                try {
                    complete.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
        return result;
    }

    private int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}