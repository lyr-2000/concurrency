package ThreadPool;

import java.util.concurrent.*;

/**
 * @author czd
 */
public class Worker implements  Runnable {
    private String name;
    public Worker(String name){
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行任务 任务编号: -->" + name);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成任务 任务编号: -->" + name);
    }


}
