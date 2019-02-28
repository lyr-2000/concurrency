package chapter1;

/**
 * @author czd
 */
public class ProduceAndConsumeVersion1 {
    private static int i = 0;
    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;
    /**
     * 线程生产者
     */
    public  void produce(){
        synchronized (LOCK){
            if (isProduce){
                try {
                    LOCK.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("Produce -->" + i++);
                isProduce = true;
                LOCK.notify();
            }

        }
    }

    /**
     * 线程消费者
     */
    public  void consume(){
        synchronized (LOCK){
            if (isProduce){
                System.out.println("Consume -->" + i);
                isProduce = false;
                LOCK.notify();
            }else {
                try {
                    LOCK.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
       final ProduceAndConsumeVersion1 produceAndConsume = new ProduceAndConsumeVersion1();
        new Thread("Produce"){
            @Override
            public void run() {
                while (true){
                    produceAndConsume.produce();
                }

            }
        }.start();
        new Thread("Consume"){
            @Override
            public void run() {
                while (true){
                    produceAndConsume.consume();
                }

            }
        }.start();
    }
}
