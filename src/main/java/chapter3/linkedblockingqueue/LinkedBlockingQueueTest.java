package chapter3.linkedblockingqueue;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author czd
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        /**
         * 1、LinkedBlockingQueue(int capacity)：
         *     创建一个具有给定（固定）容量的 LinkedBlockingQueue
         *
         * 2、LinkedBlockingQueue() ：
         *     创建一个容量为 Integer.MAX_VALUE 的 LinkedBlockingQueue，无边界
         */
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue(5);
        //1、put(E e)：将指定的元素插入此队列的尾部，如果该队列已满，则等待可用的空间,无返回值
        try {
            linkedBlockingQueue.put(6);
            System.out.println("put后：" + linkedBlockingQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //2、peek()：将指定元素插入到此队列的尾部，如有必要，则等待空间变得可用。
        Integer peekResult = linkedBlockingQueue.peek();
        System.out.println("peekResult: " + peekResult);

        /**
         * 3.1、poll()：获取并移除此队列的头，如果此队列为空，则返回 null。
         * 3.2、poll(long timeout, TimeUnit unit)：获取并移除此队列的头部，在指定的等待时间前等待可用的元素（如果有必要）。
         */

        Integer pollResult = linkedBlockingQueue.poll();
        System.out.println("pollResult: " + pollResult);
        Integer afterPollResult = linkedBlockingQueue.poll();
        System.out.println("poll后的结果: " + afterPollResult);



        /**
         * 4.1 offer(E e) ： 将指定元素插入到此队列的尾部（如果立即可行且不会超出此队列的容量），
         *                 在成功时返回 true，如果此队列已满，则返回 false。
         *
         * 4.2 offer(E e, long timeout, TimeUnit unit)：将指定元素插入到此队列的尾部，
         *                 如有必要，则等待指定的时间以使空间变得可用
         */
        Boolean offerBoolean = linkedBlockingQueue.offer(7);
        System.out.println("是否成功offer: " + offerBoolean);

        //5、remove(Objec8t o): 从此队列移除指定元素的单个实例（如果存在）。。返回值为Boolean
        Boolean remove8Boolean = linkedBlockingQueue.remove(8);
        System.out.println("移除8是否成功：" + remove8Boolean);
        Boolean remove7Boolean = linkedBlockingQueue.remove(7);
        System.out.println("移除7是否成功：" + remove7Boolean);

        //6、size()：返回此队列中元素的数量。
        try {
            linkedBlockingQueue.put(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sizeQueue = linkedBlockingQueue.size();
        System.out.println("arrayBlockingQueue.size = " + sizeQueue);

        //7、remainingCapacity()：返回理想情况下（没有内存和资源约束）此队列可接受并且不会被阻塞的附加元素数量
        try {
            linkedBlockingQueue.put(8);
            linkedBlockingQueue.put(9);
            linkedBlockingQueue.put(10);
            Integer numbers = linkedBlockingQueue.remainingCapacity();
            System.out.println("此队列可接受并且不会被阻塞的附加元素数量: " + numbers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //8、iterator() 返回在此队列中的元素上按适当顺序进行迭代的迭代器，返回值为Iterator<E>
        Iterator<Integer> iterator = linkedBlockingQueue.iterator();
        while (iterator.hasNext()){
            Integer result = iterator.next();
            System.out.println("iterator的结果result: " + result);
        }

        //9、take()：获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
        try {
            Integer takeResult = linkedBlockingQueue.take();
            System.out.println("takeResult: " + takeResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //10、clear()： 从队列彻底移除所有元素。
        linkedBlockingQueue.clear();
        System.out.println("看一下是否还存在元素：" + linkedBlockingQueue.peek());
    }
}
