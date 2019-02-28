package chapter2.context;

/**
 * @author czd
 * 模拟从其他地方拿取数据
 */
public class QueryFromHttpAction {
    public void execute(){
        Context context = ActionContext.getInstance().getContext();
        String name = context.getName();
        String id = getCardId(name);
        context.setId(id);
    }

    public String getCardId(String name){
        try {
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "身份证号码:123456789>>>>>" + Thread.currentThread().getId();
    }
}
