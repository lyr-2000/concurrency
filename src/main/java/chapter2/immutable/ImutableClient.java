package chapter2.immutable;

/**
 * @author czd
 */
public class ImutableClient {
    public static void main(String[] args) {
          Person person = new Person("Guang" , "GuangZhou");
          for (int i = 0; i < 5; i++){
              new UsePersonThread(person).start();
          }


    }
}
