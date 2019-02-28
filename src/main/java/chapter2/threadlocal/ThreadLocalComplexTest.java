package chapter2.threadlocal;

/**
 * @author czd
 */
public class ThreadLocalComplexTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "线程保险箱";
        }
    };

    /**
     * 虽然是使用同一个ThreadLocal，但是两个线程不能互相访问彼此的变量
     * ThreadLocal被称为线程保险箱
     * @param args
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                threadLocal.set("threadLocal --> T1");
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结果是:" + threadLocal.get());
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                threadLocal.set("threadLocal --> T2");
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结果是:" + threadLocal.get());
            }
        };
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ">>>>>" + threadLocal.get());

    }
}
