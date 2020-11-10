package java0.conc0303;

import java.util.concurrent.Callable;

/**
 * Callable接口单线程实现
 *
 * @author 61404
 */
public class CallableSingleThreadImpl {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        };
        Integer result = null;
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result);

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
