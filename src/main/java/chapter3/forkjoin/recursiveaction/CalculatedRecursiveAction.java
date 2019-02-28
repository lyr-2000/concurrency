package chapter3.forkjoin.recursiveaction;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author czd
 */
public class CalculatedRecursiveAction extends RecursiveAction {

    private  Integer start;
    private  Integer end;
    private Integer Max = 10;

    public static AtomicInteger SUM = new AtomicInteger();

    public CalculatedRecursiveAction(Integer start , Integer end ) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start <= Max){

            for(Integer i = start; i <= end; i++){
                SUM .addAndGet(i);
            }
        }else{
            Integer middle = (start + end)/2;
            CalculatedRecursiveAction leftTask = new CalculatedRecursiveAction(start , middle);
            CalculatedRecursiveAction rightTask = new CalculatedRecursiveAction(middle+1 , end);

            //fork()是执行
            leftTask.fork();
            rightTask.fork();
        }

    }
}
