package java0.conc0303;

import java.util.concurrent.*;

/**
 * CompletableFuture实现
 * @author 61404
 */
public class CompletableFutureImpl {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return sum();
        });

        try {
            System.out.println("异步计算结果为：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
}
