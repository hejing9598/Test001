package test.api;

import java.util.Scanner;

/**
 * Created by Qing on 2019/8/30.
 */
public class API_String {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();


    }

    //二维数组转String
    private static void test9() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        String string = new String();
        for (int x = 0; x < arr.length; x++) {

            if (0 == x) {

                string = string.concat("[");
                for (int y = 0; y < arr[x].length; y++) {

                    if (y == 0) {

                        string = string.concat("[").concat(String.valueOf(arr[x][y])).concat(",");
                    } else if (y == arr[x].length - 1) {

                        string = string.concat(String.valueOf(arr[x][y])).concat("]");
                    } else {

                        string = string.concat(String.valueOf(arr[x][y])).concat(",");
                    }

                }
                string = string.concat(",");
            } else if (x == arr.length - 1) {

                for (int y = 0; y < arr[x].length; y++) {

                    if (y == 0) {

                        string = string.concat("[").concat(String.valueOf(arr[x][y])).concat(",");
                    } else if (y == arr[x].length - 1) {

                        string = string.concat(String.valueOf(arr[x][y])).concat("]");
                    } else {

                        string = string.concat(String.valueOf(arr[x][y])).concat(",");
                    }

                }
                string = string.concat("]");

            } else {
                for (int y = 0; y < arr[x].length; y++) {

                    if (y == 0) {

                        string = string.concat("[").concat(String.valueOf(arr[x][y])).concat(",");
                    } else if (y == arr[x].length - 1) {

                        string = string.concat(String.valueOf(arr[x][y])).concat("]");
                    } else {

                        string = string.concat(String.valueOf(arr[x][y])).concat(",");
                    }

                }
                string = string.concat(",");
            }
        }

        System.out.println(string);
    }

    //统计大串中小串出现的次数
    private static void test8() {
        String string = new String("123 123 123");

        String min = "12";
        int count = 0;
        int index = 0;
        while (true) {

            if (0 == count) {

                int resultIndex = string.indexOf(min);
                if (resultIndex != -1) {

                    index = resultIndex + min.length();
                    count++;
                } else {

                    break;
                }
            } else {

                int resultIndex = string.indexOf(min, index);
                if (resultIndex != -1) {

                    index = resultIndex + min.length();
                    count++;
                } else {

                    break;
                }
            }

        }

        System.out.println("字符串\"" + min + "\" 一共出现了" + count + "次");
    }

    //反转字符串
    private static void test7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入:");
        String result = scanner.next();

        char[] charArray = result.toCharArray();
        for (int x = 0; x < charArray.length / 2; x++) {

            char temp = charArray[x];
            charArray[x] = charArray[charArray.length - 1 - x];
            charArray[charArray.length - 1 - x] = temp;
        }
        System.out.println(String.valueOf(charArray));
    }

    //数组转成固定格式字符串  [1,2,3,4,5]
    private static void test6() {
        int[] arr = {1, 2, 3, 4, 5};
        String string = "";
        for (int x = 0; x < arr.length; x++) {

            if (0 == x) {

                string = string.concat("[").concat(String.valueOf(arr[x])).concat(",");
            } else if (arr.length - 1 == x) {

                string = string.concat(String.valueOf(arr[x])).concat("]");
            } else {

                string = string.concat(String.valueOf(arr[x])).concat(",");
            }
        }

        System.out.println(string);
    }


    //把一个字符串的首字母转成大写，其余为小写
    private static void test5() {
        String string = "asSSSSS123asd";

        char[] charsArr = string.toCharArray();

        for (int x = 0; x < charsArr.length; x++) {

            //如果是小写字母 或者 是大写字母
            if (('a' <= charsArr[x] && charsArr[x] <= 'z') || ('A' <= charsArr[x] && charsArr[x] <= 'Z')) {

                //字符串首位
                // 转成大写, 其余一律小写
                if (0 == x) {

                    charsArr[x] = String.valueOf(charsArr[x]).toUpperCase().charAt(0);
                } else {

                    charsArr[x] = String.valueOf(charsArr[x]).toLowerCase().charAt(0);
                }
            }
        }

        for (char c : charsArr) {

            System.out.print(c);
        }
    }

    //统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
    private static void test4() {
        String string = "ABCDEabcd123456!@#$%^";

        int big = 0;
        int small = 0;
        int other = 0;
        int num = 0;
        for (int i = 0; i < string.length(); i++) {

            char result = string.charAt(i);

            if ('A' <= result && result <= 'Z') {

                big++;
            } else if ('a' <= result && result <= 'z') {

                small++;
            } else if ('0' <= result && result <= '9') {

                num++;
            } else {

                other++;
            }
        }

        System.out.println("big:" + big + "\n" + "small:" + small + "\n" + "num:" + num + "\n" + "other" + other);
    }

    //遍历字符串
    private static void test3() {
        String string = "ABCDEFGHIJKLMN";

        System.out.println(string.length());
        for (int i = 0; i < string.length(); i++) {

            System.out.print(string.charAt(i));
        }
    }


    private static void test1() {
        String string = "   123   4567   ";
        String string2 = "abcdefg";

        System.out.println("---------------------------");
        //比较字符串的内容是否相同,区分大小写
        string.equals(string2);
        //比较字符串的内容弄是否相同,忽略大小写
        string.equalsIgnoreCase(string2);
        //判定字符串1是否包含字符串2
        string.contains(string2);
        //判断字符串是否以指定字符串开头
        string.startsWith(string2);
        //判定字符串是否以指定字符串结尾
        string.endsWith(string2);
        //判断字符串是否为空,不包含空格
        System.out.println(string.isEmpty());


        System.out.println("---------------------------");
        //获取字符串长度
        System.out.println(string.length());
        //获取指定索引位置的元素
        string.charAt(0);
        //返回指定字符在字符串中第一次出现的索引
        string.indexOf(1);
        //返回指定字符串在字符串中第一次出现的索引
        string.indexOf("1");
        string.indexOf("1", 1);//从指定索引后开始检索
        //最后一次出现的索引
        System.out.println(string.lastIndexOf("3"));
        //截取字符串(包含首不包含尾)
        System.out.println(string.substring(1, 2));

        System.out.println("---------------------------");
        //string转换成byte字节数组
        byte[] bytes = string.getBytes();
        for (byte bytes1 : bytes) {

            System.out.print(bytes1 + " | ");
        }
        //转换成字符数组
        char[] chars = string.toCharArray();
        for (char c : chars) {

            System.out.print(c + " | ");
        }
        //任意数据类型转换成字符串
        String result = String.valueOf(chars);
        //字符串转小写
        String resultLow = string.toLowerCase();
        //字符串转大写
        String resulyUp = string.toUpperCase();
        //拼接字符串
        String concat = string.concat(string2);


        System.out.println("---------------------------");
        //替换:所有的a替换成b
        System.out.println(string.replace('1', 'a'));
        //去除两端空格
        System.out.println(string.trim());

    }

    //需求：模拟登录,给三次机会,并提示还有几次。
    //用户名和密码都是admin
    private static void test2() {

        final String USER_NAME = "admin";
        final String PASSWORD = "admin";

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            System.out.println("您还有" + (3 - i) + "次登录机会.");

            System.out.println("请输入用户名:");
            String reUserName = scanner.next();
            System.out.println("请输入密码:");
            String rePassWord = scanner.next();

            if (!USER_NAME.equals(reUserName)) {

                System.out.println("对不起,用户名错误!");
            } else if (!PASSWORD.equals(rePassWord)) {

                System.out.println("对不起,密码错误!");
            } else {

                System.out.println("登录成功!");
                break;
            }

        }

    }
}
