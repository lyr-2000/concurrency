package chapter3.atomicstampedreference;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author czd
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        //1、 如果当前引用 == 预期引用，则以原子方式将该标志的值设置为给定的更新值。
        String expectedReference = "abc";
        String newReference = "def";
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>(expectedReference,1);
        Boolean bool = atomicStampedReference.attemptStamp("abc" , 5);
        System.out.println("Boolean: " + bool);
        System.out.println("atomicStampedReference : reference  " + atomicStampedReference.getReference());
        System.out.println("atomicStampedReference : stampe  " + atomicStampedReference.getStamp());

        //2、如果当前引用 == 预期引用，并且当前标志等于预期标志，则以原子方式将该引用和该标志的值设置为给定的更新值。
        AtomicStampedReference<String> atomicStampedReference1 = new AtomicStampedReference<>(expectedReference,1);
        Boolean bool1 = atomicStampedReference1.compareAndSet("abc" , "edf",1,10);
        System.out.println("Boolean: " + bool1);
        System.out.println("atomicStampedReference : reference  " + atomicStampedReference1.getReference());
        System.out.println("atomicStampedReference : stampe  " + atomicStampedReference1.getStamp());

        //3、无条件地同时设置该引用和标志的值。
        AtomicStampedReference<String> atomicStampedReference2 = new AtomicStampedReference<>(expectedReference , 10);
        System.out.println("atomicStampedReference : reference  " + atomicStampedReference2.getReference());
        System.out.println("atomicStampedReference : stampe  " + atomicStampedReference2.getStamp());
        atomicStampedReference2.set(newReference,100);
        System.out.println("atomicStampedReference : reference  " + atomicStampedReference2.getReference());
        System.out.println("atomicStampedReference : stampe  " + atomicStampedReference2.getStamp());
    }
}
