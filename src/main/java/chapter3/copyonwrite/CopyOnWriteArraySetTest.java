package chapter3.copyonwrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author czd
 */
public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        /**
         * CopyOnWriteArraySet():
         *           创建一个空 set。
         * CopyOnWriteArraySet(Collection<? extends E> c):
         *           创建一个包含指定 collection 所有元素的 set。
         */

        /**
         * 1、add(E e)：如果指定元素并不存在于此 set 中，则添加它，返回值为Boolean
         */
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        Boolean addBoolean = copyOnWriteArraySet.add(1);
        System.out.println("是否添加成功？" + addBoolean);

        /**
         *  2、contains(Object o) ：如果此 set 包含指定元素，则返回 true
         */
        Boolean containsBoolean = copyOnWriteArraySet.contains(1);
        System.out.println("CopyOnWriteArraySet中是否存在1?" + containsBoolean);

        /**
         * 3、isEmpty() ：如果此 set 不包含任何元素，则返回 true。
         */
        Boolean isEmptyBoolean = copyOnWriteArraySet.isEmpty();
        System.out.println("copyOnWriteArraySet是否为空？" + isEmptyBoolean);

        /**
         * 4、iterator()：返回按照元素添加顺序在此 set 中包含的元素上进行迭代的迭代器，Iterator<E>。
         */
        copyOnWriteArraySet.add(2);
        copyOnWriteArraySet.add(3);
        copyOnWriteArraySet.add(4);
        copyOnWriteArraySet.add(5);

        Iterator<Integer> iterator = copyOnWriteArraySet.iterator();
        while (iterator.hasNext()){
            System.out.println("Iterator的结果: " + iterator.next());
        }

        /**
         * 5、remove(Object o) ：如果指定元素存在于此 set 中，则将其移除，返回值为Boolean。
         */
        Boolean removeBoolean = copyOnWriteArraySet.remove(5);
        System.out.println("是否移除5成功？" + removeBoolean);

        /**
         * 6、size() ：返回此 set 中的元素数目。
         */
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet1 = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet1.add(1);
        copyOnWriteArraySet1.add(2);
        copyOnWriteArraySet1.add(3);
        copyOnWriteArraySet1.add(1);
        copyOnWriteArraySet1.add(3);
        Integer size = copyOnWriteArraySet1.size();
        System.out.println("copyOnWriteArraySet1的size: " + size);

    }
}
