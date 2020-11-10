package java0.conc0303;

/**
 * Synchronize实现
 *
 * @author 61404
 */
public class SynchronizeImpl {

    public static void main(String[] args) throws InterruptedException {

        final Object lock = new Object();

        Integer value = null;

        long start = System.currentTimeMillis();
        new DisplayThread(lock, value, start).start();
        new CalThread(lock, value).start();
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

    public static class CalThread extends Thread {

        final Object lock;
        Integer value;

        public CalThread(Object lock, Integer value) {
            this.lock = lock;
            this.value = value;
        }

        @Override
        public void run() {
            synchronized (lock) {
                value = sum();
                lock.notifyAll();
            }
        }
    }

    public static class DisplayThread extends Thread {

        final Object lock;
        Integer value;
        long start;

        public DisplayThread(Object lock, Integer value, long start) {
            this.lock = lock;
            this.value = value;
            this.start = start;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println("异步计算结果为：" + value);
                    System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
