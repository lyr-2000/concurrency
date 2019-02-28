package chapter1;

import java.util.Arrays;

/**
 * @author czd
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("TG1");
        Thread thread = new Thread(threadGroup,"thread"){
            @Override
            public void run() {
                System.out.println("ThreadGroup的名字:" + getThreadGroup().getName());
                System.out.println("ThreadGroupParent的名字:" + getThreadGroup().getParent());
            }
        };
        thread.start();
//        try {
//            thread.join();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        ThreadGroup threadGroup1 = new ThreadGroup(threadGroup,"TG2");
        Thread thread1 = new Thread(threadGroup1,"thread1"){
            @Override
            public void run() {
                System.out.println(getThreadGroup().getName());
                System.out.println(getThreadGroup().getParent());
                System.out.println(getThreadGroup().getParent().getParent());
            }
        };
        thread1.start();
//        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"TG3");

        //获取当前ThreadGroup的下的线程以及他的子ThreadGroup线程组有多少个线程是活跃的
        System.out.println("threadGroup下的活跃的线程-->" + threadGroup.activeCount());

        //获取当前线程组下的活跃的线程组，子线程组和孙子线程组也包括
        System.out.println("threadGroup下的活跃的线程组-->" + threadGroup.activeGroupCount());

    }
}
