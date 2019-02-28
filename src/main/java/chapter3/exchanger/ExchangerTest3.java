package chapter3.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author czd
 */
public class ExchangerTest3 {
    public static void main(final String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始启动....");
                while (true){
                    try {
                        AtomicInteger atomicInteger = new AtomicInteger(1);
                        atomicInteger.set(exchanger.exchange(atomicInteger.get()));
                        System.out.println("Thread-A Value:" + atomicInteger.get());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }


            }
        },"Thread-A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始启动....");
                while (true){
                    try {
                        AtomicInteger atomicInteger = new AtomicInteger(2);
                        atomicInteger.set(exchanger.exchange(atomicInteger.get()));
                        System.out.println("Thread-B Value:" + atomicInteger.get());
                        TimeUnit.SECONDS.sleep(2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }


            }
        },"Thread-B").start();
    }
}
