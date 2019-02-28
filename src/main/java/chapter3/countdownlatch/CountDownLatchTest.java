package chapter3.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author czd
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(){
            @Override
            public void run() {
                System.out.println("我要将水煮开（需要3分钟）.....现在有一批食材要处理，我需要另外一个人帮我处理");
                try {
                    //模拟做事情所需要的时间
                    Thread.sleep(3000);
                    countDownLatch.await();
                    System.out.println("这个时候可以等待面煮熟了....");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("我在准备一些食材....（需要2分钟）");
                try {
                    //模拟做事情所需要的时间
                    Thread.sleep(3000);
                    System.out.println("食材准备好了！花费2分钟");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }
        }.start();

        try {
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("一共花费3分钟！");
    }
}
