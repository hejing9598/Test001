package test.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qing on 2019/9/11.
 * BufferedReader | BufferedWriter 自带缓冲区,大小是8192b
 */
public class BufferedReader_Test {

    public static void main(String[] args) throws IOException {

//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test2() throws IOException {

        FileReader fr = new FileReader("Files\\txt\\长恨歌.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("Files\\txt\\长恨歌3.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String line;

        while ((line = br.readLine()) != null) {

            bw.write(line);
            bw.newLine();
        }


        br.close();
        bw.close();
    }

    private static void test1() throws IOException {


        FileReader fr = new FileReader("Files\\txt\\长恨歌.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("Files\\txt\\长恨歌3.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        int ch;

        while ((ch = br.read()) != -1) {

            bw.write(ch);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void test3() throws IOException {

        FileReader fr = new FileReader("Files\\txt\\长恨歌.txt");
        LineNumberReader lnr = new LineNumberReader(fr);

        FileWriter fw = new FileWriter("Files\\txt\\长恨歌3.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String line;
        while ((line = lnr.readLine()) != null) {

            bw.write(lnr.getLineNumber() + line);
            bw.newLine();

        }

        lnr.close();
        bw.close();
    }

    //获取一个文本上每个字符出现的次数,将结果写在times.txt上
    private static void test4() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Files\\txt\\Test.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Files\\txt\\Test.txt", true));

        HashMap<String, Integer> map = new HashMap();
        int str;
        while ((str = br.read()) != -1) {
            char ch = (char) str;
            if (!map.containsKey(String.valueOf(ch))) {
                if (str == 10) {
                    map.put("换行", 1);
                } else if (str == 13) {
                    map.put("回车", 1);
                } else if (str == 32) {
                    map.put("空格", 1);
                } else {
                    map.put(String.valueOf(ch), 1);
                }
            } else {
                if (str == 10) {
                    map.put("换行", map.get("换行") + 1);
                } else if (str == 13) {
                    map.put("回车", map.get("回车") + 1);
                } else if (str == 32) {
                    map.put("空格", map.get("空格") + 1);
                } else {
                    map.put(String.valueOf(ch), map.get(String.valueOf(ch)) + 1);
                }
            }
        }
        bw.newLine();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.newLine();
            bw.write(" " + entry.getKey() + " " + " = " + entry.getValue());
        }


        br.close();
        bw.close();
    }
}























