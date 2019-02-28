package chapter3.forkjoin.recursivetask;

import java.util.concurrent.RecursiveTask;

/**
 * @author czd
 */
public class CalculatedRecursiveTask extends RecursiveTask<Integer> {

    private  Integer start;
    private  Integer end;
    private Integer Max = 10;

    public CalculatedRecursiveTask(Integer start , Integer end ) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start <= Max){
            Integer sum = 0;
            for(Integer i = start; i <= end; i++){
                sum += i;
            }
            return sum;
        }else{
            Integer middle = (start + end)/2;
            CalculatedRecursiveTask leftTask = new CalculatedRecursiveTask(start , middle);
            CalculatedRecursiveTask rightTask = new CalculatedRecursiveTask(middle+1 , end);

            //fork()是执行，join()是返回结果
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }

    }
}
