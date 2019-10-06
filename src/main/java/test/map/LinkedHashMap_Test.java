package test.map;

import java.util.LinkedHashMap;

/**
 * Created by Qing on 2019/9/4.
 * LinkedHashMap底层是链表实现,可以怎么存就怎么取
 */
public class LinkedHashMap_Test {

    public static void main(String[] args) {


        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();

        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");

        System.out.println(map);
    }
}
