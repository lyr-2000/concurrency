package chapter1;

/**
 * @author czd
 */
public class ProduceAndConsumeVersion2 {
    private static int i = 0;
    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;
    /**
     * 线程生产者
     */
    public  void produce(){
        synchronized (LOCK){
            while (isProduce){
                try {
                    LOCK.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("在睡觉");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("Produce -->" + i++);
            isProduce = true;
            LOCK.notifyAll();
        }
    }

    /**
     * 线程消费者
     */
    public  void consume(){
        synchronized (LOCK){
            while (!isProduce){
                try {
                    LOCK.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("在睡觉");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Consume -->" + i);
            isProduce = false;
            LOCK.notifyAll();


        }
    }

    public static void main(String[] args) {
       final ProduceAndConsumeVersion2 produceAndConsume = new ProduceAndConsumeVersion2();
        new Thread("Produce1"){
            @Override
            public void run() {
                while (true){
                    produceAndConsume.produce();
                }

            }
        }.start();
        new Thread("Produce2"){
            @Override
            public void run() {
                while (true){
                    produceAndConsume.produce();
                }

            }
        }.start();
        new Thread("Consume1"){
            @Override
            public void run() {
                while (true){
                    produceAndConsume.consume();
                }

            }
        }.start();
        new Thread("Consume2"){
            @Override
            public void run() {
                while (true){
                    produceAndConsume.consume();
                }

            }
        }.start();
    }
}
