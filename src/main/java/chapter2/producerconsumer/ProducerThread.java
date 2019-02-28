package chapter2.producerconsumer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author czd
 */
public class ProducerThread extends Thread{
    private MessageQueue messageQueue;
    //创建初始值为0的counter
    private static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue messageQueue , int seq) {
        //为线程起名字
        super("Producer>>>>>" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = new Message("Message>>>>>" + counter.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + "   Put MessageData：" + message.getData());
                Thread.sleep(100);
            }catch (Exception e){
                break;
            }

        }
    }
}
