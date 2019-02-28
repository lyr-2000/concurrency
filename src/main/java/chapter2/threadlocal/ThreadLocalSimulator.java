package chapter2.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czd
 * @param <T>
 * 重写ThreadLocal
 */
public class ThreadLocalSimulator<T> {
    private final Map<Thread ,T> map = new HashMap<>();
    public void set(T t){
        synchronized (this){
            Thread key = Thread.currentThread();
            map.put(key , t);
        }
    }
    public T get(){
        synchronized (this){
            Thread key = Thread.currentThread();
            T threadValue = map.get(key);
            if (threadValue == null){
                return initialValue();
            }
            return threadValue;
        }
    }

    public T initialValue(){
        return null;
    }
}
