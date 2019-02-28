package chapter3.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author czd
 */
public class CyclicBarrierTest2 {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            Thread.sleep(4000);
            System.out.println("reset前>>>NumberWaiting: " + cyclicBarrier.getNumberWaiting());
            System.out.println("reset前>>>Parties: " + cyclicBarrier.getParties());
            System.out.println("reset前>>>isBroken: " + cyclicBarrier.isBroken());
            Thread.sleep(2000);
            cyclicBarrier.reset();
            System.out.println("reset后>>>NumberWaiting: " + cyclicBarrier.getNumberWaiting());
            System.out.println("reset后>>>Parties: " + cyclicBarrier.getParties());
            System.out.println("reset后>>>isBroken: " + cyclicBarrier.isBroken());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
