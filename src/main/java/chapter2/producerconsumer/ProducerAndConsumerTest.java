package chapter2.producerconsumer;


/**
 * @author czd
 */
public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        new ProducerThread(messageQueue , 1).start();
        new ConsumerThread(messageQueue , 1).start();
        new ProducerThread(messageQueue , 2).start();
        new ConsumerThread(messageQueue , 2).start();

    }
}
