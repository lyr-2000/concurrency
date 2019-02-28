package chapter2.immutable;

/**
 * @author czd
 * 不可变对象类必须满足的条件:1.只能存在getter方法，不能存在setter方法
 *                           2.变量必须定义为final和private
 *                           3.这个类是不可被继承的，即定义此类为final
 */
final public class Person {
    private final String name;
    private final String address;
    public Person(String name , String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
