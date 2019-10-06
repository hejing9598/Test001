package test.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Qing on 2019/9/1.
 */
public class Collection_Test {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
//        test4();




    }

    //遍历集合
    private static void test4() {
        Collection collection = new ArrayList();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        collection.add("D");

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {

            Object object = iterator.next();
            System.out.println(object.toString());
        }

        //亦可以使用数组来遍历,注意Object需要向下转型
        Object[] objects = collection.toArray();
    }

    //带All的方法测试
    private static void test3() {
        Collection collection = new ArrayList();
        Collection collection2 = new ArrayList();

        Student stu = new Student(11, "张三");
        Student stu1 = new Student(12, "李四");
        Student stu2 = new Student(13, "王五");
        Student stu3 = new Student(14, "赵六");

        collection.add(stu);
        collection.add(stu1);
        collection.add(stu2);
        collection.add(stu3);
        collection2.add(stu);
        collection2.add(stu1);
        collection2.add(stu2);
        collection2.add(stu3);

        //根据参数集合取交集
        boolean reslult = collection.retainAll(collection2);
        System.out.println(reslult);

        //将参数集合全部添加进本集合
        collection.addAll(collection2);
        System.out.println("collection" + collection);
        System.out.println("collection2" + collection2);

        //删除重复的交集,因为集合储存的是地址值,所以集合2把自己删掉了,集合1对集合2的引用也失效了
        boolean b = collection2.removeAll(collection2);
        System.out.println(b);
        System.out.println("collection" + collection);
        System.out.println("collection2" + collection2);
        System.out.println("--------------------------------------------------------------------------------------------");

        //判断是否包含参数集合
        boolean containsAll_Result = collection.containsAll(collection);
        System.out.println(containsAll_Result);
    }

    //基本方法测试
    private static void test2() {
        Collection collection = new ArrayList();

        Student student = new Student(11, "李四");

        //添加元素
        boolean add_Result = collection.add(new Student(11, "张三"));
        boolean add_Result2 = collection.add(new Student(11, "李四"));

        //移除指定元素
        boolean remove_Result = collection.remove(new Student(11, "张三"));

        //判断是否包含指定元素
        boolean contains_Result = collection.contains(new Student(11, "李四"));

        //判断集合是否为空
        boolean empty_Result = collection.isEmpty();

        //返回集合长度
        int size = collection.size();

        System.out.println(size);
        System.out.println(empty_Result);
        System.out.println(contains_Result);
        System.out.println(collection.toString());

        collection.clear();
    }

    //数组长度固定
    private static void test1() {
        Student[] students = new Student[5];
        students[0] = new Student(25, "张三");
        students[1] = new Student(21, "李四");
        students[2] = new Student(20, "王五");
        students[3] = new Student(22, "赵六");
        students[4] = new Student(20, "钱七");

        for (Student stu : students) {

            System.out.println(stu);
        }
    }
}

@Data
@AllArgsConstructor
class Student {

    private int age;
    private String name;

}