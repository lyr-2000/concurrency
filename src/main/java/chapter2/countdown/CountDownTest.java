package chapter2.countdown;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

/**
 * @author czd
 */
public class CountDownTest {
    public static void main(String[] args) {
        //5代表线程数量
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("多线程准备阶段!");
        for (int i = 0; i < 5; i++){
            new Thread(){
                @Override
                public void run() {
                    System.out.println("线程名称:>>>" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    //计算线程完成情况
                    countDownLatch.countDown();
                }
            }.start();
        }

        try {
            //等待所有线程完成再执行此语句
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("多线程完成阶段：SUCCESS！");
    }
}
