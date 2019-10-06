package test.collection;

import java.util.*;

/**
 * Created by Qing on 2019/9/2.
 * <p>
 * HashSet无序与去重
 * 无序是不保证有序，也不保证必定无序
 * 去重:存储自定义类型时，需要重写hashCode（）与equals（）方法
 * 因为HashSet会根据对象的hashCode判断是否为同一个对象，未重写之前是调用Object的hashCode方法，判断的是地址值，new出来的对象地址值肯定不一样，然后再进行equals判断
 */
public class HashSet_Test {

    public static void main(String[] args) {

        //test1();
        //test2();
//        test3();
//        test4();

        HashSet set = new HashSet();
        set.add("AaaA");
        set.add("BbbA");
        set.add("CccA");
        set.add("DddA");

        System.out.println(set);

        for (Object o : set) {

            System.out.print(o);
        }

    }

    //复习List去重
    private static void test4() {

        ArrayList<String> list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        ArrayList<String> newList = new ArrayList();

        for (String str : list) {

            if (!newList.contains(str)) {

                newList.add(str);
            }
        }

        for (String s : newList) {

            System.out.print(s);
        }

    }

    //键盘录入并用hashset去重
    private static void test3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String next = scanner.next();
        char[] chars = next.toCharArray();

        HashSet set = new HashSet();
        for (char c : chars) {

            set.add(c);
        }

        for (Object o : set) {
            System.out.print(o + " ");
        }
    }


    //要求用HashSet储存10个随机数，最多储存10个
    private static void test2() {
        Random random = new Random();
        HashSet set = new HashSet();

        while (set.size() < 10) {

            set.add(random.nextInt(20));
        }

        for (Object o : set) {

            System.out.print(o + " ");
        }
        System.out.println("\n" + set.size());
    }

    private static void test1() {
        HashSet set = new HashSet();

        Person p1 = new Person("张三", 10);
        Person p2 = new Person("张三", 10);
        Person p3 = new Person("张三", 10);
        Person p4 = new Person("张三", 10);
        Person p5 = new Person("张三", 10);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);

        //迭代器
        Iterator it = set.iterator();
        while (it.hasNext()) {

            System.out.println(it.next());
        }

        //foreach
        for (Object o : set) {

            System.out.print(o);
        }
    }
}
