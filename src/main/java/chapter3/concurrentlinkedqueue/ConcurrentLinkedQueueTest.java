package chapter3.concurrentlinkedqueue;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author czd
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        /**
         * 构造方法摘要
         * ConcurrentLinkedQueue():
         *           创建一个最初为空的 ConcurrentLinkedQueue
         */
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue();
        /**
         * 1、add(E e) :将指定元素插入此队列的尾部，返回值为Boolean。
         */
        Boolean addBoolean = concurrentLinkedQueue.add(5);
        System.out.println("是否添加到队列尾部成功: " + addBoolean);

        /**
         * 2、contains(Object o) :如果此队列包含指定元素，则返回 true。
         */
        Boolean containsBoolean = concurrentLinkedQueue.contains(5);
        System.out.println("是否包含5：" + containsBoolean);

        /**
         * 3、isEmpty() ：如果此队列不包含任何元素，则返回 true
         */
        Boolean isEmptyBoolean = concurrentLinkedQueue.isEmpty();
        System.out.println("concurrentLinkedQueue是否为空：" + isEmptyBoolean);

        /**
         * 4、iterator() ：返回在此队列元素上以恰当顺序进行迭代的迭代器，返回值为 Iterator<E>	。
         */
        concurrentLinkedQueue.add(6);
        concurrentLinkedQueue.add(7);
        concurrentLinkedQueue.add(8);
        System.out.println("=====================");
        Iterator<Integer> iterator = concurrentLinkedQueue.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator的结果：" + iterator.next());
        }

        /**
         * 5、ffer(E e) ：将指定元素插入此队列的尾部，返回值为boolean。
         */
        Boolean offerBoolean = concurrentLinkedQueue.offer(9);
        System.out.println("是否插入队列尾部成功：" + offerBoolean);


        /**
         * 6、peek() ：获取但不移除此队列的头；如果此队列为空，则返回 null。
         */
        Integer peekResult = concurrentLinkedQueue.peek();
        System.out.println("队列的第一个信息：" + peekResult);

        /**
         * 7、poll() ：获取并移除此队列的头，如果此队列为空，则返回 null。
         */
        Integer pollResult = concurrentLinkedQueue.poll();
        System.out.println("队列的第一个信息：" + pollResult);

        /**
         * 8、remove(Object o) ：从队列中移除指定元素的单个实例（如果存在），返回值为Boolean。
         */
        Boolean removeBoolean = concurrentLinkedQueue.remove(9);
        System.out.println("是否移除9成功？" + removeBoolean);

        /**
         * 9、size()：返回此队列中的元素数量
         */
        Integer size = concurrentLinkedQueue.size();
        System.out.println("队列的元素数量：" + size);

    }
}
