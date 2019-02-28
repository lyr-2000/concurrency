package chapter3.atomicintegerarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author czd
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        //1、创建给定长度的新 AtomicIntegerArray。
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        //2、将位置 i 的元素设置为给定值,默认值为0
        atomicIntegerArray.set(9,10);
        System.out.println("Value: " + atomicIntegerArray.get(9) + "默认值：" + atomicIntegerArray.get(0));

        //3、返回该数组的长度
        AtomicIntegerArray atomicIntegerArray1 = new AtomicIntegerArray(10);
        System.out.println("数组长度：" + atomicIntegerArray1.length());

        //4、以原子方式先对给定下标加上特定的值，再获取相加后的值
        AtomicIntegerArray atomicIntegerArray2 = new AtomicIntegerArray(10);
        atomicIntegerArray2.set(5,10);
        System.out.println("Value: " + atomicIntegerArray2.get(5));
        atomicIntegerArray2.addAndGet(5,10);
        System.out.println("Value: " + atomicIntegerArray2.get(5));

        //5、如果当前值 == 预期值，则以原子方式将位置 i 的元素设置为给定的更新值。
        AtomicIntegerArray atomicIntegerArray3 = new AtomicIntegerArray(10);
        atomicIntegerArray3.set(5,10);
        System.out.println("当前值： " + atomicIntegerArray3.get(5));
        Boolean bool = atomicIntegerArray3.compareAndSet(5,10,30);
        System.out.println("结果值： " + atomicIntegerArray3.get(5) + " Result: " + bool);

        //6、以原子方式先将当前下标的值减1，再获取减1后的结果
        AtomicIntegerArray atomicIntegerArray4 = new AtomicIntegerArray(10);
        atomicIntegerArray4.set(5,10);
        System.out.println("下标为5的值为：" + atomicIntegerArray4.get(5));
        Integer result1 = atomicIntegerArray4.decrementAndGet(5);
        System.out.println("result1的值为：" + result1);
        System.out.println("下标为5的值为：" + atomicIntegerArray4.get(5));

        //7、以原子方式先获取当前下标的值，再将当前下标的值加上给定的值
        AtomicIntegerArray atomicIntegerArray5 = new AtomicIntegerArray(10);
        atomicIntegerArray5.set(5,10);
        Integer result2 = atomicIntegerArray5.getAndAdd(5,5);
        System.out.println("result2的值为：" + result2);
        System.out.println("下标为5的值为：" + atomicIntegerArray5.get(5));

        //8、 以原子方式先获取当前下标的值，再对当前下标的值减1
        AtomicIntegerArray atomicIntegerArray6 = new AtomicIntegerArray(10);
        atomicIntegerArray6.set(1,10);
        System.out.println("下标为1的值为：" + atomicIntegerArray6.get(1));
        Integer result3 = atomicIntegerArray6.getAndDecrement(1);
        System.out.println("result3的值为：" + result3);
        System.out.println("下标为1的值为：" + atomicIntegerArray6.get(1));

        //9、 以原子方式先获取当前下标的值，再对当前下标的值加1
        AtomicIntegerArray atomicIntegerArray7 = new AtomicIntegerArray(10);
        atomicIntegerArray7.set(2,10);
        System.out.println("下标为2的值为：" + atomicIntegerArray7.get(2));
        Integer result4 = atomicIntegerArray7.getAndIncrement(2);
        System.out.println("result4的值为：" + result4);
        System.out.println("下标为2的值为：" + atomicIntegerArray7.get(2));

        //10、将位置 i 的元素以原子方式设置为给定值，并返回旧值。
        AtomicIntegerArray atomicIntegerArray8 = new AtomicIntegerArray(10);
        atomicIntegerArray8.set(3,10);
        System.out.println("下标为3的值为：" + atomicIntegerArray8.get(3));
        Integer result5 = atomicIntegerArray8.getAndSet(3,50);
        System.out.println("result5的值为：" + result5);
        System.out.println("下标为3的值为：" + atomicIntegerArray8.get(3));

        //11、 以原子方式先对下标加1再获取值
        AtomicIntegerArray atomicIntegerArray9 = new AtomicIntegerArray(10);
        atomicIntegerArray9.set(4,10);
        System.out.println("下标为4的值为：" + atomicIntegerArray9.get(4));
        Integer result6 = atomicIntegerArray9.incrementAndGet(4);
        System.out.println("result6的值为：" + result6);
        System.out.println("下标为4的值为：" + atomicIntegerArray9.get(4));
    }
}
