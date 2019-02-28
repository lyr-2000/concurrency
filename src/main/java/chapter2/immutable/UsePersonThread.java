package chapter2.immutable;

/**
 * @author czd
 */
public class UsePersonThread extends Thread{
    private Person person;
    public UsePersonThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + " person >>>>>" +person.toString());
        }
    }
}
