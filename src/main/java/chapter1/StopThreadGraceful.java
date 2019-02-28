package chapter1;
/**
 * @author czd
 * 优雅的停止线程
 */
public class StopThreadGraceful {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
//        worker.shutDown();
        worker.interrupt();
    }

}
