package chapter1;

/**
 * @author czd
 */
public class TryConcurrency {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
//                for (int i = 0; i < 10000; i++){
//                    System.out.println("i -->" + i);
//                }
            }

        };
        thread.start();
        new Thread(){
            @Override
            public void run(){
                  System.out.println(Thread.currentThread().getName());
//                for (int j = 0; j < 10000; j++){
//                    System.out.println("j -->" + j);
//                }
            }
        }.start();

    }
}
