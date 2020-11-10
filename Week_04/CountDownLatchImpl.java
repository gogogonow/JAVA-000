package java0.conc0303;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch单线程实现
 *
 * @author 61404
 */
public class CountDownLatchImpl {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        AtomicInteger value = new AtomicInteger();

        long start = System.currentTimeMillis();

        new Thread(() -> {
            value.set(sum());
            latch.countDown();
        }).start();

        latch.await();

        System.out.println("异步计算结果为：" + value);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public static class MyThread extends Thread {

        private Integer res;

        @Override
        public void run() {
            res = sum();
        }
    }
}
