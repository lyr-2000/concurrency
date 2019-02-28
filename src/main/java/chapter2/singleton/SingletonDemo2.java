package chapter2.singleton;

/**
 * @author czd
 * 实现单例模式
 */
public class SingletonDemo2 {
    /**
     * 此方式缺点:当多个线程一起实例化这个类时，可能会导致不是单例模式
     */
    private static  SingletonDemo2 instance ;
    private SingletonDemo2(){
        //empty
    }
    public static SingletonDemo2 getInstance(){
        if(instance == null){
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
