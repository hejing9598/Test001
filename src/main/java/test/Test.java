package test;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import java.util.Arrays;

/**
 * Created by Qing on 2019/6/17.
 */

public class Test {

    private static long[] arr;

    //1.将用户在控制台上输出的5个数字按照大小顺序存入到D:\\xx.txt中,并读出显示在控制台上
    public static void main(String[] args) throws IOException {

        //a.用户输入并倒序排序
//        long[] arr = getArr();
        //b.将数组存入files\\txt\\xx.txt文件
//        writeArr(arr);
        //c.读取files\\txt\\xx.txt文件并将内容展示在控制台
        readArr(new File("files\\txt\\xx.txt"));

    }

    private static void readArr(File file) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String txtLine = "";
        while ((txtLine = br.readLine()) != null) {

            System.out.println(txtLine);
        }

        br.close();
    }

    private static void writeArr(long[] arr) throws IOException {

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("files\\txt\\xx.txt")));

        for (long l : arr) {

            bos.write(String.valueOf(l).getBytes());
            bos.write(String.valueOf(",").getBytes());
        }
        bos.close();

    }

    public static long[] getArr() {

        Scanner sc = new Scanner(System.in);
        long[] arr = new long[5];
        System.out.println("请输入5个数字:");
        for (int i = 0; i < 5; i++) {

            String num = sc.nextLine();
            arr[i] = Long.valueOf(num);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {

            long temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}
