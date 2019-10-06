package test.collection;

import lombok.Data;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Qing on 2019/9/3.
 */
public class TreeSet_Test2 {

    //:键盘录入5个学生的信息(姓名,语文成绩,数学成绩,英语成绩),按照总分从高到低输出到控制台
    public static void main(String[] args) {

        test1();

    }


    //a.循环录入5个学生的成绩并存入集合
    //b.集合使用TreeSet并实现Comparator比较器接口实现compare方法(用总分排序)
    //c.遍历输出set结合
    public static void test1() {

        Scanner scanner = new Scanner(System.in);
        TreeSet<Students> set = new TreeSet<>(new Students());

        for (int i = 0; i < 5; i++) {

            Students students = new Students();
            System.out.println("请输入学生姓名:");
            students.setName(scanner.next());
            System.out.println("请输入语文成绩:");
            students.setChinese(Integer.valueOf(scanner.next()));
            System.out.println("请输入英语成绩:");
            students.setEnglish(Integer.valueOf(scanner.next()));
            System.out.println("请输入数学成绩:");
            students.setMath(Integer.valueOf(scanner.next()));
            System.out.println("-------完毕-------");
            set.add(students);
        }

        for (Students students : set) {

            System.out.println(students);
        }


    }
}

@Data
class Students implements Comparator<Students> {

    private Integer age;
    private Integer chinese;
    private Integer english;
    private Integer math;
    private String name;


    @Override
    public int compare(Students o1, Students o2) {
        int result = o2.getSum() - o1.getSum();
        return result == 0 ? 1 : result;
    }

    //获取总分
    public Integer getSum() {

        return chinese + english + math;
    }

}