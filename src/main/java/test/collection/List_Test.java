package test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Qing on 2019/9/1.
 * 数组结构:查询快修改也快(因为索引),但是增删慢(ArrayList线程不安全效率高，Vector线程安全效率低)
 * 链表结构:增删快,修改和查询慢
 */
public class List_Test {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();

        test4();

    }

    //ListIterator()
    private static void test4() {
        List list = new ArrayList();
        Student s = new Student(11, "A");
        Student s1 = new Student(11, "B");
        Student s2 = new Student(11, "C");
        Student s3 = new Student(11, "D");

        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {

//            listIterator.add();
            Object next = listIterator.next();
        }
        //上一个循环完毕,指针已经到末尾
        while (listIterator.hasPrevious()) {

            Object previous = listIterator.previous();
        }
    }


    //遍历删除元素,如果想在遍历的过程中同时添加元素可以用list.listIterator()
    private static void test3() {
        List list = new ArrayList();
        Student s = new Student(11, "A");
        Student s1 = new Student(11, "B");
        Student s2 = new Student(11, "C");
        Student s3 = new Student(11, "D");

        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);


        //for循环删除元素
        for (int i = 0; i < list.size(); i++) {

            if (s.equals(list.get(i))) {

                //为什么要i--,因为元素被删掉之后,后面的元素会前移(相当于元素对应的索引-1,所以循环的索引也要-1)
                list.remove(i--);
            }

        }

        //迭代器删除元素一定要用迭代器自己的remove,不然会引发并发修改异常
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {

            if (s.equals(iterator.next())) {

                iterator.remove();
            }
        }

        //foreach底层依赖迭代器,但是它又不能用迭代器的方法,只能用list.remove(),所以一定会引发并发修改异常
    }

    //list集合的四种遍历方式
    private static void test2() {
        List list = new ArrayList();
        Student s = new Student(11, "A");
        Student s1 = new Student(11, "B");
        Student s2 = new Student(11, "C");
        Student s3 = new Student(11, "D");

        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        //通过list.size(),list.get()

        for (int i = 0; i < list.size(); i++) {

            Object obj = list.get(i);
//            System.out.println(obj);
        }
        //迭代器
        Iterator it = list.iterator();
        while (it.hasNext()) {

            Object next = it.next();
//            System.out.println(next);
        }
        //for循环利用迭代器
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {

            Object next = iterator.next();
        }
        //foreach
        for (Object o : list) {

//            System.out.println(o);
        }
    }

    //常用方法
    private static void test1() {
        List list = new ArrayList();

        //添加进最后一位
        list.add("A");

        //按照索引位置添加,其余元素向后移
        list.add(0, "B");

        //根据索引返回元素
        Object o = list.get(0);
        System.out.println(o.toString());

        //根据索引替换元素
        list.set(1, "C");
//        System.out.println(list);

        //remove可以根据对象删除,已可以根据索引删除,小心把数字识别成索引
        list.add(0);
        list.remove(new Integer(0));//数字需这样删除
        System.out.println(list);
    }
}
