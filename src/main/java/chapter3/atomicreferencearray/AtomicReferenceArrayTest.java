package chapter3.atomicreferencearray;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author czd
 */
public class AtomicReferenceArrayTest {
    public static void main(String[] args) {
        //1、创建给定长度的新 AtomicReferenceArray。
        AtomicReferenceArray<Integer> atomicReferenceArray = new AtomicReferenceArray<>(10);
        //2、set：将位置 i 的元素设置为给定值。
        atomicReferenceArray.set(1,5);
        System.out.println("Vaule: " + atomicReferenceArray.get(1));

        //3、如果当前值 == 预期值，则以原子方式将位置 i 的元素设置为给定的更新值。
        AtomicReferenceArray<Integer> atomicReferenceArray1 = new AtomicReferenceArray<>(10);
        atomicReferenceArray1.set(2,10);
        System.out.println("Value: " + atomicReferenceArray1.get(2));
        boolean bool = atomicReferenceArray1.compareAndSet(2,10,20);
        System.out.println("是否预期值与当前值相等：" + bool);
        System.out.println("Value: " + atomicReferenceArray1.get(2));

        //4、返回该数组的长度。
        AtomicReferenceArray<Integer> atomicReferenceArray2 = new AtomicReferenceArray<>(10);
        System.out.println("数组长度：" + atomicReferenceArray2.length());

        //5、获取当前索引的值，再将此索引设置新的值
        AtomicReferenceArray<Integer> atomicReferenceArray3 = new AtomicReferenceArray<>(10);
        atomicReferenceArray3.set(2,10);
        System.out.println("旧值：" + atomicReferenceArray3.get(2));
        Integer result = atomicReferenceArray3.getAndSet(2,50);
        System.out.println("获取的result值：" + result);
        System.out.println("新值：" + atomicReferenceArray3.get(2));
    }
}
