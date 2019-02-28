package chapter3.arrayblockingqueue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author czd
 */
public class ArrayBlockingQueueTest {


    public static void main(String[] args) {
        /**
         * 1、ArrayBlockingQueue(int capacity)：
         *    创建一个带有给定的（固定）容量
         * 和 默认访问策略的 ArrayBlockingQueue。（不公平的锁）
         * 2、ArrayBlockingQueue(int capacity, boolean fair)
         *    创建一个具有给定的（固定）容量
         * 和  指定访问策略的 ArrayBlockingQueue（true:公平的锁  false:不公平的锁）
         */

        //1、add(E e)：将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则抛出
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(5);
        Boolean addBoolean = arrayBlockingQueue.add(5);
        arrayBlockingQueue.add(3);
        arrayBlockingQueue.add(4);
        System.out.println("是否添加成功: " + addBoolean);

        //2、peek()：获取但不移除此队列的头；如果此队列为空，则返回 null。
        Integer peekResult = arrayBlockingQueue.peek();
        System.out.println("peekResult: " + peekResult);

        /**
         * 3.1、poll()：获取并移除此队列的头，如果此队列为空，则返回 null。
         * 3.2、poll(long timeout, TimeUnit unit)：获取并移除此队列的头部，在指定的等待时间前等待可用的元素（如果有必要）。
         */

        Integer pollResult = arrayBlockingQueue.poll();
        System.out.println("pollResult: " + pollResult);
        Integer afterPollResult = arrayBlockingQueue.poll();
        System.out.println("poll后的结果: " + afterPollResult);

        //4、put(E e)：将指定的元素插入此队列的尾部，如果该队列已满，则等待可用的空间,无返回值
        try {
            arrayBlockingQueue.put(6);
            System.out.println("put后：" + arrayBlockingQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 5.1offer(E e) ：将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量）
         *                 在成功时返回 true，如果此队列已满，则返回 false,返回值为Boolean。
         *
         * 5.2 offer(E e, long timeout, TimeUnit unit)：将指定的元素插入此队列的尾部，
         *                 如果该队列已满，则在到达指定的等待时间之前等待可用的空间,返回值为Boolean。
         */
        Boolean offerBoolean = arrayBlockingQueue.offer(7);
        System.out.println("是否成功offer: " + offerBoolean);

        //6、remove(Objec8t o): 从此队列中移除指定元素的单个实例（如果存在）。返回值为Boolean
        Boolean remove8Boolean = arrayBlockingQueue.remove(8);
        System.out.println("移除8是否成功：" + remove8Boolean);
        Boolean remove7Boolean = arrayBlockingQueue.remove(7);
        System.out.println("移除7是否成功：" + remove7Boolean);

        //7、size()：返回此队列中元素的数量。
        int sizeQueue = arrayBlockingQueue.size();
        System.out.println("arrayBlockingQueue.size = " + sizeQueue);

        //8、contains(Object o) 如果此队列包含指定的元素，则返回 true。
        Boolean containsBoolean = arrayBlockingQueue.contains(9);
        System.out.println("arrayBlockingQueue是否包含9: " + containsBoolean);

        //9、iterator() 返回在此队列中的元素上按适当顺序进行迭代的迭代器，返回值为Iterator<E>
        Iterator<Integer> iterator = arrayBlockingQueue.iterator();
        while (iterator.hasNext()){
            Integer result = iterator.next();
            System.out.println("iterator的结果result: " + result);
        }

        //11、take()：获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
        try {
            Integer takeResult = arrayBlockingQueue.take();
            System.out.println("takeResult: " + takeResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //11、clear()：自动移除此队列中的所有元素。
        arrayBlockingQueue.clear();
        System.out.println("看一下是否还存在元素：" + arrayBlockingQueue.peek());

    }
}
