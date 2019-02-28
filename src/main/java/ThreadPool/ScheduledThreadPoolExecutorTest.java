package ThreadPool;

import java.sql.Time;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author czd
 */
public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
       //1、schedule(Runnable command, long delay, TimeUnit unit)
//        ScheduledFuture future = scheduledThreadPoolExecutor.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("当前时间：" + System.currentTimeMillis() +" 我只执行一次！");
//            }
//        }, 2 ,TimeUnit.SECONDS);

        //cancel(true):是取消延迟执行
//        future.cancel(true);

        //2、scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
//        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("当前时间：" + System.currentTimeMillis() + " 我是周期性执行！");
//            }
//        }, 2 , 5,TimeUnit.SECONDS);

        //3、scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前时间：" + System.currentTimeMillis() + " 我是周期性执行！");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 2 , 5,TimeUnit.SECONDS);
    }
}
