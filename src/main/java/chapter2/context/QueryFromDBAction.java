package chapter2.context;

/**
 * @author czd
 * 模拟从数据库中拿取数据
 */
public class QueryFromDBAction {
    public void execute(){
        try {
             Thread.sleep(1000);
             String name = "author" + Thread.currentThread().getName();
             ActionContext.getInstance().getContext().setName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
