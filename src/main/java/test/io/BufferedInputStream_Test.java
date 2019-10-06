package test.io;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Qing on 2019/9/10.
 */
public class BufferedInputStream_Test {

    public static void main(String[] args) throws IOException {

        test1();
//        test2();
//        test3();
//        test4();
    }

    private static void test2() throws IOException {

        FileInputStream fis = new FileInputStream(new File("Files\\txt\\长恨歌.txt"));
        FileOutputStream fos = new FileOutputStream(new File("Files\\txt\\长恨歌2.txt"));

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int b;
        while ((b = bis.read()) != -1) {

            bos.write(b);
            //强制把缓冲区的内容写入,不管他满没满
            bos.flush();
        }

        //只关闭最外层的装饰对象就行
        bis.close();
        bos.close();
    }

    private static void test1() throws IOException {

        FileInputStream fis = new FileInputStream(new File("Files\\txt\\Test.txt"));
        FileOutputStream fos = new FileOutputStream(new File("Files\\txt\\长恨歌2.txt"));

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] arr = new byte[1024];
        int length;
        while ((length = bis.read(arr)) != -1) {

            bos.write(arr);
        }

        bis.close();
        bos.close();
    }

    //在控制台录入一个文件的路径,将此文件拷贝到当前项目下（要求拷贝后的文件与原文件同名）
    private static void test3() throws IOException {

        //a.键盘录入,并且判断,是文件则下一步否则提示重新录入
        //b.开启IO流,进行拷贝
        //c.关闭流对象与Scanner

        Scanner scanner = new Scanner(System.in);

        File file;
        while (true) {

            System.out.println("请输入一个文件路径:");
            String next = scanner.next();
            file = new File(next);
            if (file.isFile()) {
                break;
            } else {
                System.out.println("您输入的路径不合法,重新输入!");
            }
        }

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file.getName());
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int length;
        while ((length = bis.read()) != -1) {
            bos.write(length);
        }

        bis.close();
        bos.close();
        scanner.close();
    }


    //键盘录入并写入到文件
    private static void test4() throws IOException {
        Scanner scanner = new Scanner(System.in);

        FileOutputStream fos = new FileOutputStream("Files\\txt\\Test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        while (true) {

            System.out.println("请输入:");
            String str = scanner.nextLine();
            if("quit".equals(str)) {
                break;
            }
            bos.write(str.getBytes());
            bos.write("\r\n".getBytes());
        }

        bos.close();
        scanner.close();
    }
}

































