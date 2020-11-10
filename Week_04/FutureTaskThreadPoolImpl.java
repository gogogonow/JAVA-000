package java0.conc0303;

import java.util.concurrent.*;

/**
 * FutureTask线程池实现
 * @author 61404
 */
public class FutureTaskThreadPoolImpl {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        executor.submit(task);

        try {
            System.out.println("异步计算结果为：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        executor.shutdown();
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
