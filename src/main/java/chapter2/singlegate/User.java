package chapter2.singlegate;

/**
 * @author czd
 */
public class User extends Thread {
    private Gate gate;
    private String name;
    private String address;

    public User(String name , String address , Gate gate){
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(name + ">>>>>can into the gate");
        while (true){
            gate.pass(name , address);
        }
    }
}
