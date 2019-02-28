package chapter3.atomicboolean;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author czd
 */
public class AtomicBooleanTest {
    public static void main(String[] args) {
        //1、AtomicBoolean 默认是false
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println("Value: " + atomicBoolean.get());

        //2、set 可以有两种设置方法
        AtomicBoolean atomicBoolean1 = new AtomicBoolean(true);
        atomicBoolean1.set(false);
        System.out.println("Value: " + atomicBoolean.get());
        /**
         * 4、如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
         * 这里需要注意的是这个方法的返回值实际上是是否成功修改，而与之前的值无关
         */

        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        atomicBoolean2.compareAndSet(false , true);
        System.out.println("Value: " + atomicBoolean2.get());

        //3、获取旧的值（当前值），重新设置新的值
        AtomicBoolean atomicBoolean3 = new AtomicBoolean();
        atomicBoolean3.getAndSet(true);
        System.out.println("Value: " + atomicBoolean3.get());
    }
}
