package chapter3.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author czd
 */
public class CyclicBarrierTest1 {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread1 到达指定集合地点！");
                    cyclicBarrier.await();
                    Thread.sleep(1000);
                    System.out.println("Thread1 等待其他成员到达指定到底，我来看看是否还缺人...");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("Thread2 到达指定集合地点！");
                    cyclicBarrier.await();
                    Thread.sleep(2000);
                    System.out.println("Thread2 等待其他成员到达指定到底，我来看看是否还缺人...");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

//        try {
//            cyclicBarrier.await();
//            Thread.sleep(3000);
//            System.out.println("所有成员都已经到达指定集合地点，开始出发去玩！");
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        while (true){
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("NumberWaiting: " + cyclicBarrier.getNumberWaiting());
            System.out.println("Parties: " + cyclicBarrier.getParties());
            System.out.println("isBroken: " + cyclicBarrier.isBroken());
        }

    }
}
