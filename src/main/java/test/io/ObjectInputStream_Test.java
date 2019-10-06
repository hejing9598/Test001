package test.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * Created by Qing on 2019/9/12.
 */
public class ObjectInputStream_Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //将序列化对象写入到文件中
        //test1();

        //从文件中读取序列化对象
        test2();

    }

    private static void test1() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Files\\object\\student.txt"));


        Student student = new Student("张三", 23);
        Student student1 = new Student("张三", 23);

        oos.writeObject(student);
        oos.writeObject(student1);

        oos.close();
    }

    private static void test2() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Files\\object\\student.txt"));
        Student student = (Student)ois.readObject();
        Student student2 = (Student)ois.readObject();


        System.out.println(student);
        System.out.println(student2);

        ois.close();
    }
}

@Data
@AllArgsConstructor
class Student implements Serializable {

    String name;
    Integer age;
}