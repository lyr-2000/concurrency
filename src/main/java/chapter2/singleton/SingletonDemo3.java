package chapter2.singleton;

/**
 * @author czd
 * 实现单例模式
 */
public class SingletonDemo3 {
    /**
     * 此方式缺点:执行效率变慢
     */
    private static SingletonDemo3 instance ;
    private SingletonDemo3(){
        //empty
    }
    public synchronized static SingletonDemo3 getInstance(){
        if(instance == null){
            instance = new SingletonDemo3();
        }
        return instance;
    }
}
