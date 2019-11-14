package questions;

import com.sun.org.apache.xpath.internal.SourceTree;
import sort.BubbleSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Qing on 2019/10/11.
 *
 * String类练习题
 */
public class StringQuestions {

    public static void main(String[] args) throws IOException {


        demo15();
    }

    /**
     * 编写一个程序，这个程序把一个整数数组中的每个元素用逗号连接成一个字符串，
     * //例如，根据内容为[1][2][3]的数组形成内容为"1,2,3"的字符串。
     */
    private static void demo1() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        String str = "";

        for (int i = 0; i < arr.length; i++) {

            if (i == arr.length - 1) {

                str += arr[i];
            } else {

                str += arr[i] + ",";
            }
        }

        System.out.println(str);

    }

    /**
     * 从键盘输入一个值,根据值进行判断如果是小于60则输出sorry,如果是包含60分以上则输出ok
     */
    private static void demo2() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个整数:");
        String inStr = scanner.nextLine();
        String regex = "^[\\d,\\+,-]\\d*";//正则表达式:全部是数字
        if (!inStr.matches(regex)) {//不是整数则提示用户输入错误并推出

            System.out.println("您输入的不是整数!");
            return;
        }

        //用户输入的数字
        Integer inNum = Integer.parseInt(inStr);
        if (inNum < 60) {
            System.out.println("sorry");
        } else {
            System.out.println("OK");
        }

        scanner.close();
    }

    /**
     * 将用户在控制台上输出的5个数字按照大小顺序存入到D:\\xx.txt中,并读出显示在控制台上
     */
    private static void demo3() throws IOException {

        //a.用户输入5个数字,并从小到大排序
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入5个整数,以逗号隔开");
        String newLine = scanner.nextLine();
        newLine = newLine.trim();
        String[] split = newLine.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String sub : split) {
            list.add(Integer.parseInt(sub));
        }
        Collections.sort(list);

        scanner.close();

        //b.写入到文件中
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Files\\txt\\xx.txt", true));
        bos.write("\r\n".getBytes());
        for (Integer sub : list) {

            bos.write(sub.toString().getBytes());
            bos.write(" ".getBytes());
        }
        bos.close();

        //c.读取文件并展示在控制台
        BufferedReader br = new BufferedReader(new FileReader("Files\\txt\\xx.txt"));
        String txtLine = "";
        while ((txtLine = br.readLine()) != null) {

            System.out.println(txtLine);
        }
        br.close();
    }


    /**
     * 从键盘接受多个int型的整数,直到用户输入end结束
     * 把所有的整数按倒序写到D:\\number.txt中
     */
    private static void demo4() throws IOException {

        ArrayList<Integer> list = new ArrayList<>();

        //a.键盘循环录入并校验.检测到end结束录入
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {

                System.out.println("请输入一个整数:");
                String nextLine = scanner.nextLine();
                if ("end".equals(nextLine)) {
                    System.out.println("--结束录入--");
                    break;
                }
                if (nextLine.matches("\\d{1,}")) {

                    list.add(Integer.parseInt(nextLine.trim()));
                } else {
                    System.out.println("输入有误,请重新输入!");
                }

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        scanner.close();

        //b.倒序排序并写入到Files\txt\xx.txt
        BubbleSort.reverseSort(list);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Files\\txt\\xx.txt", true));

        bos.write("\r\n".getBytes());
        bos.write(list.toString().getBytes());

        bos.close();
    }

    /**
     * 将每一个单词首字母变成大写,后边的变成小写
     */
    private static void demo5() {

        //a.用户录入几个单词并存入集合
        Scanner sc = new Scanner(System.in);
        ArrayList<StringBuffer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("请输入单词:");

            String trim = sc.nextLine().trim();
            if (!trim.matches("[a-zA-Z]+")) {

                System.out.println("输入错误!");
                continue;
            }
            list.add(new StringBuffer(trim));
        }
        sc.close();
        //b.转换大小写

        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {

            StringBuffer sub = list.get(i);
            StringBuffer newSub = new StringBuffer();
            newSub.append(sub.substring(0, 1).toUpperCase()).append(sub.substring(1).toLowerCase());

            list.set(i, newSub);
        }

        System.out.println("List" + list);

    }


    /**
     * 有一个字符串"wojavaaijavahahajavajavaaiwo"删除该字符串中所有的"java"并且统计删除了多少个“java”
     */
    private static void demo6() {

        //a.匹配所有的"java"并替换成空串 执行一次替换则cont+1
        String str = "wojavaaijavahahajavajavaaiwo";
        String regex = "java";
        long cont = 0;
        while (str.contains(regex)) {

            str = str.replaceFirst(regex, "");
            cont++;
        }

        System.out.println(cont);
    }

    /**
     * 编写一个校验用户名的程序,检测键盘录入的用户名是否合法
     * 要求:用户名必须是6-10位之间的字母或数字,并且不能以数字开头
     */
    private static void demo7() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String nextLine = sc.nextLine();
        String regex = "[a-zA-Z][a-zA-Z0-9]{5,9}";
        if (nextLine.matches(regex)) {
            System.out.println("用户名合法!");
        } else {
            System.out.println("用户名不合法!");
        }
        sc.close();
    }

    /**
     * 输入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量
     */
    private static void demo8() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段内容:");
        String nextLine = scanner.nextLine();
        scanner.close();

        char[] arr = nextLine.toCharArray();

        int enNUM = 0;//英文字母
        int num = 0;//数字
        int spaceNUM = 0;//空格
        int otherNUM = 0;//其余字符

        for (char sub : arr) {

            if ((sub > 'a' && sub < 'z') || (sub > 'A' && sub < 'Z')) {

                enNUM++;
            } else if (sub > '0' && sub < '9') {

                num++;
            } else if (sub == ' ') {

                spaceNUM++;
            } else {

                otherNUM++;
            }
        }

        System.out.println("英文字母" + enNUM + "个");
        System.out.println("数字" + num + "个");
        System.out.println("空格" + spaceNUM + "个");
        System.out.println("其他字符" + otherNUM + "个");
    }


    /**
     * 从控制台接受一串字符串(8分)
     * (1)将该字符串转换成字符数组(2分)
     * (2)将该字符数组下标为偶数的字符打印倒控制台(3分)//偶数包括0
     * (3)将该字符数组的第一个元素与最后一个元素互换(3分)
     */
    private static void demo9() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段内容:");
        String nextLine = scanner.nextLine();
        scanner.close();

        char[] arr = nextLine.toCharArray();
        for (int i = 0; i < arr.length; i++) {

            if (i % 2 == 0) {

                System.out.print(arr[i]);
            }
        }

        char temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        System.out.println(String.valueOf(arr));
    }


    /**
     * 1.模拟验证手机号的过程，按照以下要求实现相关代码（友情提示：不一定要用正则）
     * a.	提示用户在控制台输入手机号，用一个字符串对其进行保存
     * b.	判断该手机号位数是否是11位
     * c.	判断该手机号，是否都是数字
     * d.	判断改手机号最后3为数字如果是相同数字则认为是靓号
     */
    private static void demo10() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的手机号:");
        String nextLine = scanner.nextLine();
        scanner.close();

        String regexNUM = "1[3578]\\d{9}";
        if (!nextLine.matches(regexNUM)) {

            System.out.println("只能输入数字!");
            return;
        }

        int length = nextLine.length();
        if (nextLine.charAt(length - 1) == nextLine.charAt(length - 2)
                && (nextLine.charAt(length - 1) == nextLine.charAt(length - 3))) {

            System.out.println("您的手机号是靓号!");
        } else {

            System.out.println("您的手机号是普通号码.");
        }
    }


    /**
     * 从键盘接受一个数字,将这个十进制的数字转换成二进制并输出
     * 到控制台,当输入"end"时,结束.
     */
    private static void demo11() {

        Scanner scanner = new Scanner(System.in);
        String regex = "\\d+";//纯数字,最少一位

        while (true) {

            System.out.println("请输入一个数字:");
            String nextLine = scanner.nextLine();

            if ("end".equals(nextLine)) {

                break;
            }
            if (!nextLine.matches(regex)) {
                System.out.println("必须是纯数字!");
                continue;
            }

            String binaryString = Integer.toBinaryString(Integer.parseInt(nextLine));
            System.out.println("二进制:" + binaryString);
        }
        scanner.close();
    }

    /**
     * 录入一个浮点数,例如3.1415926,只获取小数点后两位,只打印3.14
     */
    private static void demo12() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个浮点数:");
        String nextLine = scanner.nextLine();
        String regex = "\\d+\\.\\d+";
        if (!nextLine.matches(regex)) {
            System.out.println("您输入的不是小数!");
            return;
        }

        String[] split = nextLine.split("\\.");
        if (split[1].length() < 2) {

            System.out.println(nextLine);
            return;
        }

        String substring = split[1].substring(0, 2);
        System.out.println(split[0] + "." + substring);

        scanner.close();
    }

    /**
     * 从控制台接收一串字符串,完成以下要求 (共10分)
     * a,求出该字符串的长度并输出到控制台,如字符串长度为:X
     * b,将该字符串转为数组(toCharArray),判断(if)该数组第一个字符(arr[0])和最后一个字符(arr[arr.length-1])是否相同,不相同则交换(想第三方变量)
     * c,统计出数组中的每个字符出现的次数,然后自然排序(Tree树结构)后按指定格式输出到控制台,如a=3,b=4,c=5
     * d,将第二步互换后的数组角标为奇数的字符用”*”号替换,然后遍历输出
     * e,将数组中元素重新拼接成字符串,最后截取第一个'*'到第三个'*'之间的数据输出(注意:两边都包含'*')
     * <p>
     * 例如输入字符串:aaabbbbccccdddeef 打印台输出效果如下:
     * 该字符串的长度为:17
     * <p>
     * 每个字符出现的次数为:a=3,b=4,c=4,d=3,e=2,f=1
     * 被替换后的数组元素为:f*a*b*b*c*c*d*e*a
     * 第一个*到第三个*之间的数据为:*a*b*
     */
    private static void demo13() {

        //a.录入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段文字:");
        String nextLine = scanner.nextLine();
        scanner.close();
        //b.输出字符串长度
        System.out.println("字符串长度为:" + nextLine.length());
        //c.交换位置
        char[] arr = nextLine.toCharArray();
        if (arr[0] != arr[arr.length - 1]) {

            char temp = arr[0];
            arr[0] = arr[arr.length - 1];
            arr[arr.length - 1] = temp;
        }
        //d.自然排序
        TreeMap<Character, Integer> map = new TreeMap();
        for (char sub : arr) {

            map.put(sub, map.containsKey(sub) ? map.get(sub) + 1 : 1);
        }
        System.out.println(map);
        //e.奇数下标元素用*代替
        for (int i = 0; i < arr.length - 1; i++) {

            if (i % 2 != 0) {

                arr[i] = '*';
            }
        }
        for (char sub : arr) {
            System.out.print(sub);
        }
        //f.第一个*到第三个*之间的数据
        String valueOf = String.valueOf(arr);
        String substring = valueOf.substring(1, 6);
        System.out.println("\r\n" + "第一个*到第三个*之间的数据:" + substring);
    }

    /**
     * 接收用户输入的一句英文，将其中的单词以反序输出
     * <p>
     * i love you  -->  you love i
     */
    private static void demo14() {

        String str = "where are you from?";
        String[] arr = str.split(" ");

        for (int i = 0; i < arr.length / 2; i++) {

            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        for (String sub : arr) {

            System.out.print(sub + " ");
        }
    }

    /**
     * 编写一个可以获取文件扩展名的函数。形参接收一个文件名字符串，返回一个扩展字符串。
     */
    private static int demo15() {

        String fileName = "h.e.l.l.o.t.x.t.";
        String[] arr = fileName.split("\\.");

        if (arr.length < 2) {
            System.out.println("文件名不合法!");
        }

        System.out.println(arr[arr.length-1]);

        return 1;
    }




}



















