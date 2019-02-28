package chapter2.threadpermessage;

/**
 * @author czd
 */
public class ThreadPerMessageTest {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageHandler();
        for (int i = 0; i < 5; i++){
            messageHandler.request(new Message("信息：" + i));
        }
    }
}
