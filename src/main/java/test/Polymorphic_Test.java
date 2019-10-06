package test;

import lombok.Data;

/**
 * Created by Qing on 2019/8/29.
 * 多态练习
 *
 * 1.要有继承关系
 * 2.要重写方法
 * 3.父类引用指向子类对象
 */
public class Polymorphic_Test {

    public static void main(String[] args) {

        Father father = new Son();


        //访问成员变量=编译看左边,运行也看左边
        System.out.println(father.age);

        //访问成员方法=编译看左边,运行看右边
        father.method();

        //访问静态成员变量=编译看左边,运行看左边
        System.out.println(father.name);

        //访问静态成员方法=编译看左边,运行看左边
        father.method1();

    }
}

@Data
class Father {

    int age = 40;
    static String name = "Father";

    public void method() {

        System.out.println("Father Method");
    }

    public static void method1() {

        System.out.println("static Father Method");
    }

}

@Data
class Son extends Father{

    int age = 10;
    static String name = "Son";

    @Override
    public void method() {

        System.out.println("Son Method");
    }

    public static void method1() {

        System.out.println("static Son Method");
    }
}