package chapter2.observers;

/**
 * @author czd
 */
public class ObjectClient {
    public static void main(String[] args) {
        Subject subject = new Subject();
        //确立观察者的关系
        new BinaryObserver(subject);
        new OctalObserver(subject);
        //开始改变状态
        subject.setState(10);
        subject.setState(15);
        subject.setState(10);
        System.out.println("=============");
        subject.setState(15);
    }
}
