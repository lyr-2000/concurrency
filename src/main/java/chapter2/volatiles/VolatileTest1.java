package chapter2.volatiles;

/**
 * @author czd
 */
public class VolatileTest1 {
    private static volatile int INIT_VALUE = 0;
    private final static int INIT_MAX = 5;

    public static void main(String[] args) {
        new Thread("Read"){
            @Override
            public void run() {
                int localValue = INIT_VALUE;
                while (localValue < INIT_MAX){
                    if (localValue != INIT_VALUE){
                        System.out.println("这是读操作 Value:>>>>>>" + INIT_VALUE);
                        localValue = INIT_VALUE;
                    }
                }
            }
        }.start();
        new Thread("Update"){
            @Override
            public void run() {
                int localValue = INIT_VALUE;
                while (localValue < INIT_MAX){
                    System.out.println("这是更新操作 Value:>>>>>>" + ++localValue);
                    INIT_VALUE = localValue;
                    try {
                        sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
