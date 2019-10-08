package test;

/**
 * Created by Qing on 2019/10/7.
 */
public class Reflection {

    public static void main(String[] args) {

        //第一种方法(不推荐,通过对象获取class)
        Student stu1 = new Student();
        Class<? extends Student> stuClass = stu1.getClass();

        //第二种方法
        Class stu = Student.class;

        //第三种方法
        try {
            Class<?> stu2Class = Class.forName("test.Student");

        } catch (ClassNotFoundException e) {


        }


    }
}

class Student {

    private String name;

    private Integer age;

    public Student() {

        //logic
    }

}