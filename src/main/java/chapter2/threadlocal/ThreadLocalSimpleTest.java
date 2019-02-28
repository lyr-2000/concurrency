package chapter2.threadlocal;

/**
 * @author czd
 */
public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        /**
         * 设置默认值
         * @return
         */
        @Override
        protected String initialValue() {
            return "Hello";
        }
    };

    public static void main(String[] args) {
        threadLocal.set("Hello World");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(threadLocal.get());
    }
}
