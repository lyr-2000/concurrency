package chapter2.context;

/**
 * @author czd
 */
public class ContextTest {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            new Thread(new ExecutionTask()).start();
        }
    }
}
