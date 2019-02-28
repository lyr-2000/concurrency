package chapter3.forkjoin.recursivetask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author czd
 */
public class RecursiveTaskTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        //计算0-50的总和
       ForkJoinTask<Integer> futur = pool.submit(new CalculatedRecursiveTask(0,50));
        try {
            Integer result = futur.get();
            System.out.println("0-50的总和：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
