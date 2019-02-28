package chapter1;

/**
 * @author czd
 */
public class ThreadException {
    public static void main(String[] args) {
        final Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("result:" + 1/0);
            }
        };
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t);
                System.out.println(e);
            }
        });
        thread.start();
    }
}
