package chapter2.singleton;

/**
 * @author czd
 * 实现单例模式
 */
public class SingletonDemo1 {
    /**
     * 此方式缺点:不能实现懒加载，可能会有很长时间不使用它，会占用内存，浪费
     */
    private static final SingletonDemo1 instance = new SingletonDemo1();
    private SingletonDemo1(){
        //empty
    }
    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
