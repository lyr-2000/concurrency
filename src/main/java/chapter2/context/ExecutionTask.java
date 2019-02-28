package chapter2.context;

/**
 * @author czd
 */
public class ExecutionTask implements Runnable{
    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();


    @Override
    public void run() {
        Context context = ActionContext.getInstance().getContext();
        queryFromDBAction.execute();
        System.out.println("The name query success!");
        queryFromHttpAction.execute();
        System.out.println("The idt query success!");
        System.out.println("The name is" + context.getName() +"and The IdCard is" + context.getId());
    }
}
