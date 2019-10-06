package test.collection;


import org.apache.commons.lang3.StringUtils;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Qing on 2019/9/2.
 * TreeSet集合会实现自动排序，如果要使用自定义类型，则需要实现Comparable接口，重写compareTo()方法,是新元素比较老元素
 * compareTo()方法里定义排序规则
 * 返回0，只存储一个元素
 * 返回1，怎么存进set就怎么取出来
 * 返回-1，会将元素倒序存储
 * <p>
 * Tree是二叉树结构
 * 返回负数（小的）储存在左边，返回正数（大的）储存在右边,相等不存（0）
 */
public class TreeSet_Test {
    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
//        System.out.println(test4());

        getInt();

    }

    //键盘录入整数,遇到quit停止,并按从大到小的顺序输出
    //1.循环录入 并加以判断(要么纯整数,要么是quit)
    //2.加入进TreeSet集合并利用比较器倒序排列
    private static void getInt() {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = o2.compareTo(o1);
                return result == 0 ? 1 : result;
            }
        });

        while (true) {
            String next = scanner.next();
            if (StringUtils.isNumeric(next)) {


                char[] charArray = next.toCharArray();
                for (char c : charArray) {
                    set.add(Integer.valueOf(String.valueOf(c)));
                }
                charArray = null;
                System.out.println(set);
            } else if ("quit".equalsIgnoreCase(next)) {

                System.out.println("THE END");
                return ;
            }else {

                System.out.println("必须输入整数!");
            }
        }
    }


    //键盘录入字符串,利用集合进行排序,并返回String对象
    private static String test4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入:");
        char[] charArray = scanner.nextLine().toCharArray();
        TreeSet<Character> set = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int result = o2.compareTo(o1);
                return result == 0 ? 1 : result;
            }
        });

        for (char c : charArray) {

            set.add(c);
        }
        scanner = null;
        charArray = null;

        return String.valueOf(set);
    }


    //对ArrayList<String>进行字典排序
    public static ArrayList<String> compare(ArrayList<String> arrayList) {

        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.compareTo(o2);
                if (result != 0) {
                    return result;
                } else {
                    return 1;
                }
            }
        });

        treeSet.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(treeSet);
        return arrayList;
    }


    //用比较器进行排序
    private static void test3() {
        TreeSet set = new TreeSet(new MyComparetor());
        set.add("aaa");
        set.add("aaaa");
        set.add("aaaa");
        set.add("aaaa");
        set.add("a");
        set.add("bbbb");
        set.add("bbbbbb");
        set.add("b");
        set.add("cccc");
        set.add("cccc");
        set.add("c");
        set.add("dd");
//        System.out.println(set);

        //用匿名内部类:在此处相当于创建了Comparator接口的子类实例
        TreeSet set2 = new TreeSet(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                //优先按照字典排序
                return o1.compareTo(o2) == 0 ? 1 : o1.compareTo(o2);
            }
        });

        set2.add("aaa");
        set2.add("aaaa");
        set2.add("aaaa");
        set2.add("aaaa");
        set2.add("a");
        set2.add("bbbb");
        set2.add("bbbbbb");
        set2.add("b");
        set2.add("cccc");
        set2.add("cccc");
        set2.add("c");
        set2.add("dd");

        System.out.println(set2);
    }

    //储存自定义元素
    private static void test2() {
        TreeSet set = new TreeSet();
        Person person = new Person("张三", 10);
        Person person1 = new Person("张三", 11);

        set.add(person);
        set.add(person1);

        System.out.println(set);
    }

    //TreeSet自动排序
    private static void test1() {
        TreeSet<String> set = new TreeSet();
        set.add("DDD");
        set.add("CCC");
        set.add("BBB");
        set.add("AAA");

        for (String str : set) {

            System.out.println(str);
        }
    }
}


//自定义比较器
class MyComparetor implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //优先按照string字符串的长度做排序,长的靠后.其次按照字典排序
        //如果字符串完全一样,保留
        int one = o1.length() - o2.length();
        int two = o1.compareTo(o2);
        if (one != 0) {

            return one;
        } else {

            if (two != 0) {

                return two;
            }
        }

        return 1;
    }
}