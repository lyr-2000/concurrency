package chapter3.condition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author czd
 */
public class ConditionTest2 {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition produceCondition = reentrantLock.newCondition();

    private static Condition consumerCondition = reentrantLock.newCondition();

    private static LinkedList<Long> dataPool = new LinkedList<>();

    private final static Integer MAX = 100;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            new Thread("Producer--" + i){
                @Override
                public void run() {
                    produceData();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }


        for (int i = 0; i < 10; i++){
            new Thread("Consumer--" + i){
                @Override
                public void run() {
                    consumerData();
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }


    }

    /**
     * 生产者生成数据
     */
    public static void produceData() {
        try {
            reentrantLock.lock();
            while (dataPool.size() >= MAX){
                produceCondition.await();
            }

            Long value = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " 生产了一个数据>>>" + value);
            dataPool.addLast(value);
            consumerCondition.signalAll();
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
            while (dataPool.isEmpty()){
                consumerCondition.await();
            }

            Long value = dataPool.removeFirst();
            System.out.println(Thread.currentThread().getName() + " 消费了一个数据>>>" + value);
            produceCondition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }


}