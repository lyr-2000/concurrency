package chapter2.singleton;

/**
 * @author czd
 * 实现单例模式
 */
public class SingletonDemo5 {
    /**
     * 优雅的实现单例模式
     * 保证内存的可见性，即多个线程看到的数据是同一份
     * 保证有序性
     */
    private static volatile SingletonDemo5 instance ;
    private SingletonDemo5(){
        //empty
    }
    public  static SingletonDemo5 getInstance(){
        if(instance == null){
            synchronized (SingletonDemo5.class){
                if(instance == null){
                    instance = new SingletonDemo5();
                }
            }
        }

        return instance;
    }
}
