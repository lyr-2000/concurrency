package chapter3.atomicinteger;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author czd
 */
public class AtomicIntegerTest {
    /**
     * AtomicInteger特点：
     * 1、保证可见性
     * 2、保证有序性
     * 3、保证原子性
     */

    public static void main(String[] args) {
        final AtomicInteger counter = new AtomicInteger();
        final Set<Integer> set = new HashSet<>();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while (x < 500){
                    int value = counter.getAndIncrement();
                    set.add(value);
                    System.out.println(Thread.currentThread().getName() + " >>>>>> " + value);
                    x++;
                }

            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while (x < 200){
                    int value = counter.getAndIncrement();
                    set.add(value);
                    System.out.println(Thread.currentThread().getName() + " >>>>>> " + value);
                    x++;
                }

            }
        };

        Thread thread3 = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while (x < 100){
                    int value = counter.getAndIncrement();
                    set.add(value);
                    System.out.println(Thread.currentThread().getName() + " >>>>>> " + value);
                    x++;
                }

            }
        };
        try {
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("Size：" + set.size());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
