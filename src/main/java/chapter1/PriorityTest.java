package chapter1;

public class PriorityTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println("i -->" + i);
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int j = 0; j < 10; j++){
                    System.out.println("j -->" + j);
                }
            }
        };
//        thread1.setPriority(1);
//        thread2.setPriority(8);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread1.start();
        thread2.start();

        System.out.println("thread1ID-->" + thread1.getId());
        System.out.println("thread2ID-->" + thread2.getId());
    }
}
