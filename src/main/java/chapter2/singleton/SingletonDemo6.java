package chapter2.singleton;

/**
 * @author czd
 * 实现单例模式
 */
public class SingletonDemo6 {
    /**
     * 优雅的实现单例模式
     * 建议使用此方式
     */

    private SingletonDemo6(){
        //empty
    }

    private static class InstanceHolder{
        private static  final SingletonDemo6  instance = new SingletonDemo6();
    }

    public static SingletonDemo6 getInstance(){
        return InstanceHolder.instance;
    }


}
