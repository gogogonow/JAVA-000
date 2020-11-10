package java0.conc0303;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SemaphoreImpl {
    final Semaphore semaphore = new Semaphore(1);
    private volatile Integer result = null;


    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        SemaphoreImpl impl = new SemaphoreImpl();

        impl.sum();

        System.out.println("异步计算结果为：" + impl.getResult());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private void sum() throws InterruptedException {
        semaphore.acquire();
        result = fibo(36);
        semaphore.release();
    }

    private int getResult() throws InterruptedException {
        semaphore.acquire();
        int ret = this.result;
        semaphore.release();
        return ret;
    }

    private int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}