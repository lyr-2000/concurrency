package chapter2.producerconsumer;

/**
 * @author czd
 */
public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
