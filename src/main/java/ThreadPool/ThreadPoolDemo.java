package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author czd
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建pool
        //创建一个可缓存线程池，应用中存在的线程数可以无限大
//        ExecutorService pool = Executors.newCachedThreadPool();

        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
//        ExecutorService pool = Executors.newFixedThreadPool(5);

        //创建一个定长线程池，支持定时及周期性任务执行
        ExecutorService pool = Executors.newScheduledThreadPool(1);

        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
//        ExecutorService pool = Executors.newSingleThreadExecutor();


        //创建一定数量的任务
        //pool接收任务并且执行
        for (int i = 1; i <= 10; i++){
            Worker worker = new Worker(i + "");
            //没有延迟，两秒执行一次任务
//            ((ScheduledExecutorService) pool).scheduleAtFixedRate(worker,0,2, TimeUnit.SECONDS);
            //1秒后执行任务，两秒执行一次任务
            ((ScheduledExecutorService) pool).scheduleAtFixedRate(worker,10,5, TimeUnit.SECONDS);
            pool.execute(worker);
        }
        //关闭pool
        pool.shutdown();

        while (!pool.isTerminated()){
            //自旋
        }
        System.out.println("全部任务完成!");

    }
}
