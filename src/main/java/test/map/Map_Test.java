package test.map;

import lombok.Data;

import java.util.*;

/**
 * Created by Qing on 2019/9/3.
 */
public class Map_Test {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();

//        HashMap<Student3, String> map = new HashMap<>();

//        map.put(new Student3(1, "张三"), "北京");
//        map.put(new Student3(1, "张三"), "北京");
//        map.put(new Student3(1, "张三"), "北京");
//
//        for (Map.Entry<Student3, String> entry : map.entrySet()) {
//
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }


    }


    //利用双列集合统计字符串中每个字符出现的次数
    //1.将字符串分解成char数组
    //2.循环添加进集合,char作为键,出现次数作为值
    private static void test3() {
        String str = "aaabbbfff(*&^#$%^&#$%^$%^&*(";
        char[] charArray = str.toCharArray();

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < charArray.length; i++) {

            char key = charArray[i];
            if (map.containsKey(key)) {

                map.put(key, map.get(key) + 1);
            }else {

                map.put(key,1);
            }
        }

        System.out.println(map);
    }


    //遍历
    private static void test2() {
        Map<Integer, String> map = new HashMap<>();
        String a = map.put(1, "A");
        String b = map.put(1, "B");
        String c = map.put(2, "B");

        //第一种方法 键的集合,再获取keySet的迭代器,获取每一个键,再用map.get()
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();

        while (iterator.hasNext()) {

            String value = map.get(iterator.next());
        }
        //第二种方法,使用foreach
        for (Integer integer : map.keySet()) {

            String value = map.get(integer);
        }
        //键值对 Entry是Map的内部接口
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {

            Map.Entry<Integer, String> next = iterator1.next();
            next.getKey();
            next.getValue();
        }
        //foreach
        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            entry.getKey();
            entry.getValue();
        }
    }

    private static void test1() {
        Map<Integer, String> map = new HashMap<>();

        //键第一次存入返回null,如果已经存在则覆盖值并返回被覆盖的值
        String a = map.put(1, "A");
        String b = map.put(1, "B");
        String c = map.put(2, "B");

        //根据键删除,返回被删除的值
        String remove = map.remove(1);
        //根据键值对去删除,返回boolean
        boolean remove1 = map.remove(1, "D");
        //清空集合
        map.clear();

        //判断是否包含key
        boolean containsKey = map.containsKey(1);
        //判断是否包含值
        boolean containsValue = map.containsValue("2");
        //判断集合是否为空
        boolean empty = map.isEmpty();
        System.out.println(empty);
    }
}


//HashMap底层依赖hash算法,若要实现自定义类去重徐重写hashcode和equals
class Student3 {

    private Integer age;
    private String name;

    public Student3() {
    }

    public Student3(Integer age, String name) {

        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student3 student3 = (Student3) o;

        if (age != null ? !age.equals(student3.age) : student3.age != null) return false;
        return name != null ? name.equals(student3.name) : student3.name == null;
    }

    @Override
    public int hashCode() {
        int result = age != null ? age.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}