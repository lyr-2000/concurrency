package chapter3.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author czd
 */
public class ExchangerTest1 {
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始启动....");
                try {
                    String result = exchanger.exchange(" 我是来自Thread-A发送的数据！",3,TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " Result: " + result);
                }catch (InterruptedException e){
                    e.printStackTrace();
                } catch (TimeoutException e){
                    System.out.println("超时了！");
                }

            }
        },"Thread-A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始启动....");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    String result = exchanger.exchange(" 我是来自Thread-B发送的数据！");
                    System.out.println(Thread.currentThread().getName() + " Result: " + result);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        },"Thread-B").start();
    }
}
