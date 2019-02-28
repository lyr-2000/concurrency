package chapter3.forkjoin.recursiveaction;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author czd
 */
public class RecursiveActionTest {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new CalculatedRecursiveAction(0,50));
        try {
            //阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束
            forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("0-50的总和：" + CalculatedRecursiveAction.SUM);
    }
}
