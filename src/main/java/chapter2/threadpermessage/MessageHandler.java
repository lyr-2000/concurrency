package chapter2.threadpermessage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author czd
 */
public class MessageHandler {

    public void request(final Message message){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String result = message.getMessage();
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ">>>>>" + result);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
