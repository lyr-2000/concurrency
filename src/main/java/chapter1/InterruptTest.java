package chapter1;

public class InterruptTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    System.out.println("i -->" + i);
                    if (i > 50){
                        interrupt();
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++){
                    System.out.println("j -->" + j);

                }
            }
        };
        thread1.start();
        try {
            thread1.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        thread2.start();

    }
}
