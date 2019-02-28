package chapter1;

public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("running");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println("done");
            }
        };
//        thread.setDaemon(true);
        thread.start();

        System.out.println(Thread.currentThread().getName());
    }
}
