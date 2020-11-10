package java0.conc0303;

/**
 * Join单线程实现
 *
 * @author 61404
 */
public class JoinSingleThreadImpl {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Integer result;

        MyThread thread = new MyThread();

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + thread.res);

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
