package java0.conc0303;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CyclicBarrier单线程实现
 *
 * @author 61404
 */
public class CyclicBarrierImpl {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        AtomicInteger value = new AtomicInteger();

        CyclicBarrier barrier = new CyclicBarrier(1, () -> {
            System.out.println("异步计算结果为：" + value);

            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        });

        new Thread(() -> {
            try {
                value.set(sum());
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
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
