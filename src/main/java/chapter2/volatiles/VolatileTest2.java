package chapter2.volatiles;

/**
 * @author czd
 */
public class VolatileTest2 {
    private static  volatile int INIT_VALUE = 0;
    private final static int INIT_MAX = 100;

    public static void main(String[] args) {
        new Thread("Read"){
            @Override
            public void run() {
                while (INIT_VALUE < INIT_MAX){
                    System.out.println("Read>>>>>"+ ++INIT_VALUE);
                    try {
                        sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread("Update"){
            @Override
            public void run() {
                while (INIT_VALUE < INIT_MAX){
                    System.out.println("Update>>>>>"+ ++INIT_VALUE);
                    try {
                        sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
