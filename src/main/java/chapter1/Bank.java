package chapter1;

public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();
        Thread thread1 = new Thread(ticketWindow , "一号窗口");
        Thread thread2 = new Thread(ticketWindow , "二号窗口");
        Thread thread3 = new Thread(ticketWindow , "三号窗口");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
