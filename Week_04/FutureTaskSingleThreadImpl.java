package java0.conc0303;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask单线程实现
 *
 * @author 61404
 */
public class FutureTaskSingleThreadImpl {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        new Thread(task).start();

        try {
            System.out.println("异步计算结果为：" + task.get());
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
