package chapter3.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author czd
 */
public class ConditionTest1 {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();
    private static Integer data = 0;
    private static volatile boolean noUse = true;

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (true){
                    produceData();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    consumerData();
                }
            }
        }.start();


    }

    /**
     * 生产者生成数据
     */
    public static void produceData() {
        try {
            reentrantLock.lock();
            while (noUse){
                condition.await();
            }

            data++;
            System.out.println("生产一个数据：" + data);
            TimeUnit.SECONDS.sleep(2);
            noUse = true;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }

    /**
     * 消费者消费数据
     */

    public static void consumerData() {
        try {
            reentrantLock.lock();
            while (!noUse){
                condition.await();
            }
            System.out.println("消费者消费一个数据：" + data);
            TimeUnit.SECONDS.sleep(2);
            noUse = false;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }


}