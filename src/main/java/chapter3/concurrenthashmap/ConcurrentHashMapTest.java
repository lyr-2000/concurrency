package chapter3.concurrenthashmap;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author czd
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        /**
         *构造方法摘要:
         * 1.1、ConcurrentHashMap()：
         *          创建一个带有默认初始容量 (16)、加载因子 (0.75) 和 concurrencyLevel (16) 的新的空映射。
         * 1.2、ConcurrentHashMap(int initialCapacity)：
         *          创建一个带有指定初始容量、默认加载因子 (0.75) 和 concurrencyLevel (16) 的新的空映射。
         */
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>(10);
        /**
         * 1、	put(K key, V value)：将指定键映射到此表中的指定值
         */
        for (int i = 0; i < 20; i++){
            concurrentHashMap.put("" + i , i);
        }

        /**
         * 2、entrySet():返回此映射所包含的映射关系的 Set 视图,返回Set<Map.Entry<K,V>>
         *
         */
        final Set<Map.Entry<String, Integer>> entries = concurrentHashMap.entrySet();
        for(Map.Entry<String , Integer> entry : entries){
            System.out.println("Key：" + entry.getKey() + " Value：" + entry.getValue());
        }
        /**
         * 注意：一般使用如下方法遍历ConcurrentHashMap
         */

//        for(Map.Entry<String , Integer> entry : concurrentHashMap.entrySet()){
//            System.out.println("Key：" + entry.getKey() + " Value：" + entry.getValue());
//        }

        /**
         * 3、contains(Object value) ：一种遗留方法，测试此表中是否有一些与指定值存在映射关系的键,返回值为Boolean。
         */
        Boolean contains2Boolean = concurrentHashMap.contains(2);
        System.out.println("concurrentHashMap是否包含Value值为2的值：" + contains2Boolean);
        Boolean contains15Boolean = concurrentHashMap.contains(15);
        System.out.println("concurrentHashMap是否包含Value值为15的值：" + contains15Boolean);

        /**
         * 4、ontainsKey(Object key) :测试指定对象是否为此表中的键，返回值为Boolean。
         */

        Boolean contains2Key = concurrentHashMap.containsKey("2");
        System.out.println("concurrentHashMap是否包含Key值为2的键：" + contains2Key);
        Boolean contains15Key = concurrentHashMap.containsKey("15");
        System.out.println("concurrentHashMap是否包含Key值为15的键：" + contains15Key);

        /**
         * 5、containsValue(Object value) ：如果此映射将一个或多个键映射到指定值，则返回 true。
         */
        Boolean contains3Boolean = concurrentHashMap.containsValue(3);
        System.out.println("concurrentHashMap是否包含Value值为3的值：" + contains3Boolean);
        Boolean contains16Boolean = concurrentHashMap.containsValue(16);
        System.out.println("concurrentHashMap是否包含Value值为16的值：" + contains16Boolean);

        /**
         * 6、isEmpty()：如果此映射不包含键-值映射关系，则返回 true。
         */
        Boolean isEmptyBoolean = concurrentHashMap.isEmpty();
        System.out.println("concurrentHashMap是否为空：" + isEmptyBoolean);

        /**
         * 7、keySet() ：返回此映射中包含的键的 Set 视图。
         */
        Set<String> keySet = concurrentHashMap.keySet();
        for (String key : keySet){
            System.out.println("concurrentHashMap中的Key键：" + key);
        }

        /**
         * 8、remove(Object key):从此映射中移除键（及其相应的值）。
         */
        Integer beforeRemove = concurrentHashMap.get("10");
        System.out.println("beforeRemove: " + beforeRemove);
        concurrentHashMap.remove("10");
        Integer afterRemove = concurrentHashMap.get("10");
        System.out.println("afterRemove: " + afterRemove);

        /**
         * 9、remove(Object key, Object value)：只有目前将键的条目映射到给定值时，才移除该键的条目。
         */
        Integer beforeMove = concurrentHashMap.get("9");
        System.out.println("beforeRemove: " + beforeMove);
        boolean removeError = concurrentHashMap.remove("9", 8);
        boolean removeTrue = concurrentHashMap.remove("9", 9);
        System.out.println("键值匹配>>>移除成功？：" + removeTrue + "  键值不匹配>>>移除成功？：" + removeError);
        Integer afterMove = concurrentHashMap.get("9");
        System.out.println("afterMove: " + afterMove);

        /**
         * 10、replace(K key, V value) ：只有目前将键的条目映射到某一值时，才替换该键的条目。
         */
        Integer beforeReplace = concurrentHashMap.get("8");
        System.out.println("beforeReplace: " + beforeReplace);
        concurrentHashMap.replace("8" , 28);
        Integer afterReplace = concurrentHashMap.get("8");
        System.out.println("afterReplace: " + afterReplace);

        /**
         * 11、replace(K key, V oldValue, V newValue):
         *           只有目前将键的条目映射到给定值时，才替换该键的条目,返回值为Boolean。
         */
        Integer beforeRep = concurrentHashMap.get("6");
        System.out.println("beforeRep: " + beforeRep);
        Boolean replaceError = concurrentHashMap.replace("6" , 16 , 26);
        Boolean replaceTrue = concurrentHashMap.replace("6" , 6 , 26);
        System.out.println("键值匹配>>>替换成功？：" + replaceTrue + "  键值不匹配>>>替换成功？：" + replaceError);
        Integer afterRep = concurrentHashMap.get("6");
        System.out.println("afterRep: " + afterRep);

        /**
         * 12、size() ：返回此映射中的键-值映射关系数。
         */
        Integer size = concurrentHashMap.size();
        System.out.println("关系数:" + size);


    }
}
