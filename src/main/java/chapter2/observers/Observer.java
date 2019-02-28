package chapter2.observers;

/**
 * @author czd
 */
public abstract class Observer {
    protected Subject subject;

    /**
     * 更新状态的方法
     */
    public abstract void update();
}
