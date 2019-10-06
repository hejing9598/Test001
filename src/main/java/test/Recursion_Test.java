package test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Qing on 2019/9/12.
 * 递归
 */
public class Recursion_Test {
    public static void main(String[] args) throws IOException {

//        copyDirectory(new File("Files\\txt"),new File("Files\\txt2"));
//        deleteDirectory();
//        System.out.println(fibonacci(7));
//        factorial();
        System.out.println(factorialRecursion(11));
    }

    //统计指定目录的大小
    private static long test1(File parentFile) {
        long length = 0;
        File[] fileArr = parentFile.listFiles();

        for (int x = 0; x < fileArr.length; x++) {

            if (fileArr[x].isFile()) {

                length = length + fileArr[x].length();
            } else {

                length = length + test1(fileArr[x]);

            }

        }
        return length;
    }


    /**
     * 从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java文件名
     *
     * @return
     */
    private static long test2() {

        //a.键盘录入,进而判断
        //b.合法则递归调用,不合法则提示重新输入

        long cont = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {

            String StringPath = sc.next();
            File file = new File(StringPath);
            if (file.isFile()) {
                System.out.println("请输入一个文件夹路径!而不是文件路径!");
            } else if (file.exists() && file.isDirectory()) {

                cont += contJava(file);
                break;
            }
        }

        return cont;
    }

    private static long contJava(File file) {
        long cont = 0;
        File[] fileArr = file.listFiles();
        for (File fileing : fileArr) {

            if (fileing.isFile()) {

                if (file.getName().endsWith("java")) {

                    cont++;
                }
            } else {

                cont += contJava(fileing);
            }
        }
        return cont;
    }


    /**
     * 把一个文件夹拷贝到另外一个文件夹下(包括所有文件及子文件夹)
     *
     * @param originalFile
     * @param targetFile
     * @throws IOException
     */
    private static void copyDirectory(File originalFile, File targetFile) throws IOException {
        //1.在目标文件夹中创建根文件夹
        File rootFile = new File(targetFile, originalFile.getName());
        rootFile.mkdir();
        //2.获取原文件夹中所有的元素,储存在File数组中
        File[] fileArr = originalFile.listFiles();
        //3.遍历数组
        for (File subFile : fileArr) {

            if (subFile.isFile()) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(rootFile, subFile.getName())));

                int b;
                while ((b = bis.read()) != -1) {

                    bos.write(b);
                }
                bis.close();
                bos.close();
            } else {

                copyDirectory(subFile, rootFile);
            }
        }


    }

    /**
     * 从键盘接收一个文件夹路径,删除该文件夹
     */
    public static void deleteDirectory() {

        //a.键盘录入一个路径,并验证是否合法
        Scanner scanner = new Scanner(System.in);
        File inputFile;
        while (true) {

            System.out.println("请输入你要删除的文件夹路径:");
            String strFile = scanner.next();
            inputFile = new File(strFile);
            if (inputFile.exists()) {
                if (!inputFile.isFile()) {
                    System.out.println("------Loading------");
                    break;
                } else {
                    System.out.println("您输入的是一个文件路径,请重新输入!");
                }
            } else {
                System.out.println("您输入的路径不存在,请重新输入!");
            }

        }
        scanner.close();
        //b.获取路径下的所有元素,文件直接删除,文件夹则递归调用
        deleteFile(inputFile);
        System.out.println("删除文件夹: " + inputFile.getName());
        System.out.println("-----删除完毕-----");
    }

    /**
     * 删除指定文件夹(包含其所有的子文件夹及文件)
     *
     * @param file
     */
    private static void deleteFile(File file) {

        File[] fileArr = file.listFiles();
        for (File subFile : fileArr) {

            if (subFile.isFile()) {
                subFile.delete();
                System.out.println("删除文件: " + subFile.getName());
            } else {
                deleteFile(subFile);
                subFile.delete();
                System.out.println("删除文件夹: " + subFile.getName());
            }
        }
        file.delete();
    }

    /**
     * 斐波那契数列
     * 假设一对刚出生的小兔一个月后就能长成大兔，再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，一年内没有发生死亡，
     * 问：一对刚出生的兔子，一年内繁殖成多少对兔子?
     * n是几个月,返回的是n个月之后有多少对兔子
     * <p>
     * 核心就是,从第3项开始，每一项都等于前两项之和
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584，4181
     */
    private static int fibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void factorial() {

        long num = 1;
        for (int x = 2; x <= 11; x++) {

            num = num * x;
        }
        System.out.println(num);
    }


    /**
     * @param n N的阶乘
     */
    private static int factorialRecursion(int n) {
        if(n == 0) {

            return 1;
        }

        return factorialRecursion(n - 1) * n;
    }
}














