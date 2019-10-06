package test;

import java.util.Scanner;

/**
 * Created by Qing on 2019/8/22.
 */
public class If_Swtich {

    public static void main(String[] args) {

        If_Swtich if1 = new If_Swtich();
        if1.test3();
    }

    //语文90以上数学90以上优秀,任意一科90以上另一科60以下偏科
    private void test1() {

        int chinese = 90;
        int math = 59;

        if (chinese >= 90 & chinese <= 100 & math >= 90 & math <= 100) {

            System.out.println("优秀!!   chinese:" + chinese + " math:" + math);
        } else if ((chinese > 90 | math > 90) && chinese < 60 | math < 60) {

            System.out.println("偏科");
        }
    }

    //键盘录入x的值，计算出y的并输出。
    //  x>=3		y = 2 * x + 1;
    //  -1<x<3	y = 2 * x;
    //  x<=-1	y = 2 * x - 1;
    private void test2() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数: ");
        int x = scanner.nextInt();
        int y;

        if (x > 3) {

            System.out.println(y = 2 * x + 1);
        } else if (-1 < x && x < 3) {

            System.out.println(y = 2 * x);
        } else if (x == -1) {
            System.out.println(y = 2 * x - 1);
        } else {
            System.out.println("不在范围内");
        }

    }

    //switch
    private void test3() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int x = scanner.nextInt();

        switch (x) {

            case 1:
                System.out.println("今天是周一");
                break;
            case 2:
                System.out.println("今天是周二");
                break;
            case 3:
                System.out.println("今天是周三");
                break;
            case 4:
                System.out.println("今天是周四");
                break;
            case 5:
                System.out.println("今天是周五");
                break;
            case 6:
                System.out.println("今天是周六");
                break;
            case 7:
                System.out.println("今天是周日");
                break;

            default:
                System.out.println("没有匹配的日期.");
                break;
        }

    }

    //扩展
    private void test4() {

        boolean b = true;

        if (b == false)               // 如果是if(b=false) ? 结果是怎样的？
            System.out.println("a");
        else if (b)
            System.out.println("b");
        else if (!b)
            System.out.println("c");
        else
            System.out.println("d");

    }

}
