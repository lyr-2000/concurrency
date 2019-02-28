package chapter3.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author czd
 */
public class ExchangerTest2 {
    public static void main(String[] args) {
        final Exchanger<Object> exchanger = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始启动....");
                try {
                    Object object = new Object();
                    Object obj = exchanger.exchange(object);
                    System.out.println(Thread.currentThread().getName() + " Thread-A send Object: " + object);
                    System.out.println(Thread.currentThread().getName() + " Thread-A get Object: " + obj);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        },"Thread-A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始启动....");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    Object object = new Object();
                    Object obj = exchanger.exchange(object);
                    System.out.println(Thread.currentThread().getName() + " Thread-B send Object: " + object);
                    System.out.println(Thread.currentThread().getName() + " Thread-B get Object: " + obj);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        },"Thread-B").start();
    }
}
