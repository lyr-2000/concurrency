package chapter3.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author czd
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        /**
         * 3代表同一时间允许的最大线程数量
         * 当为1时，Semaphore的作用相当于一个Lock
         */
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 5; i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        //从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
                        semaphore.acquire();

                        //从此信号量获取给定数目的许可，在提供这些许可前一直将线程阻塞，或者线程已被中断。
//                        semaphore.acquire(3);

                        System.out.println(Thread.currentThread().getName() + "获取信号量");
                        TimeUnit.SECONDS.sleep(2);

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        /**
                         * 释放给定数目的许可，将其返回到信号量。
                         * 注意有release和无realse的区别
                         */
                        semaphore.release();

                        //对应上面semaphore.acquire(3);，允许多少个就得释放多少个
//                        semaphore.release(3);
                    }
                    System.out.println(Thread.currentThread().getName() + "出去");
                }
            }.start();
        }
    }
}
