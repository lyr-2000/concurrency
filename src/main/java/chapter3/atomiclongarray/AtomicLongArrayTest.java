package chapter3.atomiclongarray;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author czd
 */
public class AtomicLongArrayTest {
    public static void main(String[] args) {
        //1、创建给定长度的新 AtomicIntegerArray。
        AtomicLongArray atomicLongArray = new AtomicLongArray(10);
        //2、将位置 i 的元素设置为给定值,默认值为0
        atomicLongArray.set(9,10);
        System.out.println("Value: " + atomicLongArray.get(9) + "默认值：" + atomicLongArray.get(0));

        //3、返回该数组的长度
        AtomicLongArray atomicLongArray1 = new AtomicLongArray(10);
        System.out.println("数组长度：" + atomicLongArray1.length());

        //4、以原子方式先对给定下标加上特定的值，再获取相加后的值
        AtomicLongArray atomicLongArray2 = new AtomicLongArray(10);
        atomicLongArray2.set(5,10);
        System.out.println("Value: " + atomicLongArray2.get(5));
        atomicLongArray2.addAndGet(5,10);
        System.out.println("Value: " + atomicLongArray2.get(5));

        //5、如果当前值 == 预期值，则以原子方式将位置 i 的元素设置为给定的更新值。
        AtomicLongArray atomicLongArray3 = new AtomicLongArray(10);
        atomicLongArray3.set(5,10);
        System.out.println("当前值： " + atomicLongArray3.get(5));
        Boolean bool = atomicLongArray3.compareAndSet(5,10,30);
        System.out.println("结果值： " + atomicLongArray3.get(5) + " Result: " + bool);

        //6、以原子方式先将当前下标的值减1，再获取减1后的结果
        AtomicLongArray atomicLongArray4 = new AtomicLongArray(10);
        atomicLongArray4.set(5,10);
        System.out.println("下标为5的值为：" + atomicLongArray4.get(5));
        Long result1 = atomicLongArray4.decrementAndGet(5);
        System.out.println("result1的值为：" + result1);
        System.out.println("下标为5的值为：" + atomicLongArray4.get(5));

        //7、以原子方式先获取当前下标的值，再将当前下标的值加上给定的值
        AtomicLongArray atomicLongArray5 = new AtomicLongArray(10);
        atomicLongArray5.set(5,10);
        Long result2 = atomicLongArray5.getAndAdd(5,5);
        System.out.println("result2的值为：" + result2);
        System.out.println("下标为5的值为：" + atomicLongArray5.get(5));

        //8、 以原子方式先获取当前下标的值，再对当前下标的值减1
        AtomicLongArray atomicLongArray6 = new AtomicLongArray(10);
        atomicLongArray6.set(1,10);
        System.out.println("下标为1的值为：" + atomicLongArray6.get(1));
        Long result3 = atomicLongArray6.getAndDecrement(1);
        System.out.println("result3的值为：" + result3);
        System.out.println("下标为1的值为：" + atomicLongArray6.get(1));

        //9、 以原子方式先获取当前下标的值，再对当前下标的值加1
        AtomicLongArray atomicLongArray7 = new AtomicLongArray(10);
        atomicLongArray7.set(2,10);
        System.out.println("下标为2的值为：" + atomicLongArray7.get(2));
        Long result4 = atomicLongArray7.getAndIncrement(2);
        System.out.println("result4的值为：" + result4);
        System.out.println("下标为2的值为：" + atomicLongArray7.get(2));

        //10、将位置 i 的元素以原子方式设置为给定值，并返回旧值。
        AtomicLongArray atomicLongArray8 = new AtomicLongArray(10);
        atomicLongArray8.set(3,10);
        System.out.println("下标为3的值为：" + atomicLongArray8.get(3));
        Long result5 = atomicLongArray8.getAndSet(3,50);
        System.out.println("result5的值为：" + result5);
        System.out.println("下标为3的值为：" + atomicLongArray8.get(3));

        //11、 以原子方式先对下标加1再获取值
        AtomicLongArray atomicLongArray9 = new AtomicLongArray(10);
        atomicLongArray9.set(4,10);
        System.out.println("下标为4的值为：" + atomicLongArray9.get(4));
        Long result6 = atomicLongArray9.incrementAndGet(4);
        System.out.println("result6的值为：" + result6);
        System.out.println("下标为4的值为：" + atomicLongArray9.get(4));
    }
}
