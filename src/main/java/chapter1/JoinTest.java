package chapter1;

public class JoinTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    System.out.println(Thread.currentThread().getName()+ "-->" + i);
                }
            }
        };
        thread.start();
        try {
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < 10000; i++){
            System.out.println(Thread.currentThread().getName()+ "-->" + i);
        }
        
    }
}
