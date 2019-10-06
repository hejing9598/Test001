package test.map;

import lombok.Data;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by Qing on 2019/9/4.
 * <p>
 * TreeMap通过自定义类继承Conparable接口实现compareTo()方法进行排序
 * 也可以通过比较器排序:自定义比较器继承Comparator接口实现compare方法进行排序,也可以使用匿名内部类实现比较器
 */
public class TreeMap_Test {

    public static void main(String[] args) {


        TreeMap<Student4, String> map = new TreeMap<>(new MyCompara());
        TreeMap<Student4, String> map1 = new TreeMap<>(new Comparator<Student4>() {
            @Override
            public int compare(Student4 o1, Student4 o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : o1.getAge().compareTo(o2.getAge());
            }
        });

        Student4 s1 = new Student4();
        s1.setAge(1);
        s1.setName("张三");
        Student4 s2 = new Student4();
        s2.setAge(1);
        s2.setName("张三");

        map.put(s1, "武汉");
        map.put(s2, "武汉");

        System.out.println(map);
    }
}

@Data
class Student4 implements Comparable<Student4> {

    private Integer age;
    private String name;

    @Override
    public int compareTo(Student4 stu) {

        //返回0去重,返回正数排在后面,返回负数排在前面
        int result = this.name.compareTo(stu.name);
        if (result != 0) {
            return result;
        } else {
            return this.age.compareTo(stu.age) != 0 ? this.age.compareTo(stu.age) : 0;
        }
    }
}

//自定义比较器
class MyCompara implements Comparator<Student4> {
    @Override
    public int compare(Student4 o1, Student4 o2) {
        int result = o1.getName().compareTo(o2.getName());
        return result != 0 ? result : o1.getAge().compareTo(o2.getAge());
    }
}