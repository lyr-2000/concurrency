package chapter2.singlegate;

/**
 * @author czd
 */
public class SingleClient {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Bei" , "Beijing" , gate);
        User sh = new User("Shang" , "Shanghai" , gate);
        User gz = new User("Guang" , "GuangZhou" , gate);
        bj.start();
        sh.start();
        gz.start();
    }
}
