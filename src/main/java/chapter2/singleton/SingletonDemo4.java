package chapter2.singleton;

/**
 * @author czd
 * 实现单例模式
 */
public class SingletonDemo4 {
    /**
     * 此方式缺点:可能会出现空指针
     */
    private static SingletonDemo4 instance ;
    private SingletonDemo4(){
        //empty
    }
    public  static SingletonDemo4 getInstance(){
        if(instance == null){
            synchronized (SingletonDemo4.class){
                if(instance == null){
                    instance = new SingletonDemo4();
                }
            }
        }

        return instance;
    }
}
