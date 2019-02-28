package chapter1;

/**
 * @author czd
 */
public class TicketWindow implements Runnable {
    private static int index = 1;
    private static int Max = 500;
    private final Object MONITOR = new Object();
    @Override
    public void run() {
        while (true){
            if (ticketCheck2()){
                break;
            }
//            synchronized (MONITOR){
//                if (index > Max){
//                    break;
//                }
//                System.out.println(Thread.currentThread() + "票号:" + index++);
//            }

        }

    }

    /**
     * This锁
     * @return
     */
    public  synchronized boolean ticketCheck(){
        if(index > Max){
            return true;
        }
        System.out.println(Thread.currentThread() + "票号:" + index++);

        return false;
    }
    /**
     * This锁
     */
    public  synchronized boolean ticketCheck2(){
        synchronized(this){
            if(index > Max){
                return true;
            }
            System.out.println(Thread.currentThread() + "票号:" + index++);

            return false;
        }

    }
}
