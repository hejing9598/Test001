package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Qing on 2019/10/7.
 */
public class Reflection {

    public static void main(String[] args) throws Exception {

        //第一种方法(不推荐,通过对象获取class字节码文件是多此一举,本末倒置)
        Student stu1 = new Student();
        Class<? extends Student> clazz = stu1.getClass();

        //第二种方法(不推荐,这个需要导包,不导包就会编译错误,依赖太强)
        Class clazz1 = Student.class;

        //第三种方法(推荐用这种)
        Class<?> clazz2 = Class.forName("test.Student");

        //判断是否为clazz2类的实例
        boolean b = new Student() instanceof test.Student;
        System.out.println(clazz2.isInstance(new Student()));

        //创建实例对象
        //a.(缺点:不能选择空参或是有参)
        Student stu = (Student) clazz2.newInstance();
        //b.(获取构造方法对象,可以选择参数)
        Constructor<?> constructor = clazz2.getConstructor(String.class, Integer.class);
        Student student = (Student) constructor.newInstance("张三", 13);

        System.out.println("---------------------------------------------------------------");

        //获取字段
        Class clazz3 = Class.forName("test.Student");//获取字节码文件对象
        Constructor constructor3 = clazz3.getConstructor(String.class, Integer.class);//获取构造方法对象
        Student stu3 = (Student) constructor3.newInstance("张三", 13);
        //a.获取公共字段(不能获取私有字段)
        Field student_Name = clazz3.getDeclaredField("name");//参数写字段名称
        //b.获取所有字段包括私有的
        Field student_Age = clazz3.getDeclaredField("age");
        System.out.println(stu3.toString());
        student_Name.set(stu3, "李四");//设置参数
        System.out.println(stu3.toString());
        student_Age.setAccessible(true);//破除私有权限
        student_Age.set(stu3, 14);
        System.out.println(stu3.toString());

        System.out.println("-----------------------------获取方法----------------------------------");

        //获取方法
        Class clazz4 = Class.forName("test.Student");
        Constructor constructor4 = clazz4.getConstructor(String.class, Integer.class);
        Student stu4 = (Student) constructor4.newInstance("张三", 13);
        //获取公共方法(必须写方法名,后面跟方法的形式参数class)
        Method stu4_eat = clazz4.getMethod("eat", String.class);
        stu4_eat.invoke(stu4,"10");
        //获取私有方法
        Method stu4_learn = clazz4.getDeclaredMethod("learn");
        stu4_learn.setAccessible(true);//解除私有权限
        stu4_learn.invoke(stu4);

        demo1();
    }


    /**
     * 反射越过泛型给ArrayList添加数据
     */
    private static void demo1() throws Exception {

        ArrayList<String> list = new ArrayList<>();
        list.add("ABC");
        System.out.println(list.toString());

        Class clazz = Class.forName("java.util.ArrayList");
        Method method_Add = clazz.getMethod("add", Object.class);
        method_Add.invoke(list,true);

        System.out.println(list.toString());
    }
}

class Student {

    String name;

    private Integer age;

    public Student() {

        //logic
    }

    public Student(String name, Integer age) {

        this.name = name;
        this.age = age;
    }

    public void eat() {

        System.out.println("学生要吃饭");
    }

    public void eat(String kg) {

        System.out.println("学生一顿饭吃"+kg+"kg的食物");
    }

    public static void run() {

        System.out.println("学生要跑步");
    }

    private void learn() {

        System.out.println("学生要学习");
    }

    private static void sleep() {

        System.out.println("学生要睡觉");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}