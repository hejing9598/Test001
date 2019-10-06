package test.collection;

import java.util.LinkedList;

/**
 * Created by Qing on 2019/9/2.
 */
public class LinkedList_Test {

    public static void main(String[] args) {

//        test1();



    }

    //基本方法
    private static void test1() {
        LinkedList linkedList = new LinkedList();
        //普通添加
        linkedList.add("A");
        //添加至首位，其余元素向后位移
        linkedList.addFirst("B");
        //添加至最后一位
        linkedList.addLast("C");
        linkedList.add("D");
        linkedList.add("E");

        //获取首位元素
        System.out.println(linkedList.getFirst());
        //获取末尾元素
        System.out.println(linkedList.getLast());
        //删除首位元素
        System.out.println(linkedList.removeFirst());
        //删除末尾元素
        System.out.println(linkedList.removeLast());
        //根据索引获取元素
        System.out.println(linkedList.get(0));

        System.out.println(linkedList.toString());
    }
}

//使用linkedList模拟栈结构（先进后出）---队列结构:先进先出
class LinkedList_Stack {

    private LinkedList list = new LinkedList();

    public LinkedList_Stack() {
    }

    public LinkedList getList() {
        return list;
    }

    //普通添加
    public boolean add(Object object) {

        return list.add(object);
    }

    //模拟栈结构，后添加的先被删除
    public boolean remove() {

        return list.removeLast() == null ? false : true;
    }


}