package test.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Qing on 2019/9/1.
 */
public class List_Test2 {

    public static void main(String[] args) {


        ArrayList list = new ArrayList();
        Person person = new Person("张三", 13);
        Person person1 = new Person("李四", 14);
        Person person2 = new Person("王五", 15);
        Person person3 = new Person("赵六", 16);
        Person person4 = new Person("钱七", 17);

        list.add(person);
        list.add(person);
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        ArrayList single = getSingle(list);
        System.out.println(single.toString());



    }


    //重写引用数据的equals（）方法进行去重
    private static ArrayList getSingle(ArrayList arrayList) {

        //创建一个新的空集合
        ArrayList newList = new ArrayList();

        //获取原本集合的迭代器
        Iterator iterator = arrayList.iterator();

        //循环判断添加
        while (iterator.hasNext()) {

            //如果新集合不包含此元素,则添加进新集合
            Person person = (Person) iterator.next();
            if (!newList.contains(person)) {

                newList.add(person);
            }
        }

        return newList;
    }
}

class Person implements Comparable<Person>{

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    //重写equals
    @Override
    public boolean equals(Object obj) {

        Person person = (Person) obj;

        if (this.name.equals(person.name) && this.age.equals(person.age)) {

            return true;
        } else {

            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);

        return result;
    }

    @Override
    public int compareTo(Person person) {

        //先比较字符串,拆分成成char再一个个比较ASCII码,返回差值
        int num = this.name.compareTo(person.name);
        //如果num是0,则说明字符串是一样的,接下来比较年龄,直接相减
        System.out.println(this.age - person.age);
        return num == 0 ? this.age - person.age : num;
    }


}
