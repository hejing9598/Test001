package test;

import java.util.Scanner;

/**
 * Created by Qing on 2019/8/21.
 */
public class Scanner_Test {

    public static void main(String[] args) {
        //test

        Scanner_Test scanner1 = new Scanner_Test();
        //scanner1.test01();
        //scanner1.test02();
        //scanner1.test03();

        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();//扫描,如果你输入了会被记录到scanner对象里,next会从scanner里取值,如果没有就让你重新输入
        System.out.println(scanner.next());

    }

    //输入两个整数求和并求较大的一个
    private void test01() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个整数:");
        int x = scanner.nextInt();
        System.out.println("输入二个整数:");
        int y = scanner.nextInt();
        scanner = null;

        System.out.println("两数相加之和:" + (x + y));
        System.out.println("两数中较大的一个是:" + ((x > y) ? x : y));

    }

    //输入两个数值比较是否相等
    private void test02() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个整数:");
        int x = scanner.nextInt();
        System.out.println("输入二个整数:");
        int y = scanner.nextInt();
        scanner = null;

        if (x == y) {

            System.out.println("输入的两数相等  " + x + " = " + y);

        } else {

            System.out.println("输入的两数不相等  " + x + " != " + y);
        }
        ;
    }

    //输入三个数字并求最大数
    private void test03() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个整数:");
        int x = scanner.nextInt();
        System.out.println("输入二个整数:");
        int y = scanner.nextInt();
        System.out.println("输入三个整数:");
        int z = scanner.nextInt();
        scanner = null;

        System.out.println("最大的数是: "+ ((((x > y) ? x:y) > z) ? ((x > y) ? x:y) : z)) ;

    }

}
