package chapter1;

/**
 * @author czd
 */
public class Worker extends Thread {
    private boolean start = true;
    private int number = 1;
    @Override
    public void run() {
        while (true){
            if (Thread.interrupted()){
                break;
            }
            System.out.println("i +" + number++);


        }
    }
    public void shutDown(){
        this.start = false;
    }
}
