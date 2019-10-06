package test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

/**
 * Created by Qing on 2019/8/24.
 */
public class StringTest {

    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        String line = sc.nextLine();
        int num = Integer.parseInt(line);

        String s = convert(num);
        System.out.println(s);
    }

    private static final char[] data = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    private static final char[] units = {'圆','拾','佰','仟','万','拾','佰','仟','亿','拾','佰','仟'};

    private static void test1() {


        Scanner scanner = new Scanner(System.in);
        try {

            while (true) {
                System.out.println("\r输入:");
                String string = scanner.next();
                //检测到exit就退出
                if ("exit".equals(string)) return;
                char[] chars = string.toCharArray();

                String string2 = new String();
                for (int x = 0; x < chars.length; x++) {

                    if (chars.length - 1 - x == 0) {

//                    System.out.print(chars[x]);
                        string2 = string2 + chars[x];
                        continue;
                    }
//                System.out.print(chars[x] + "-");
                    string2 = string2 + chars[x] + "-";
                }
                test2(string2);
                System.gc();
            }
        } finally {

            scanner = null;
        }
    }

    private static void test2(String str) {

        //获取系统剪切板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //设置字符串
//        String str = "测试设置String到剪切板";
        //构建String数据类型
        StringSelection selection = new StringSelection(str);
        //添加文本到系统剪切板
        clipboard.setContents(selection, null);
    }

    private static String convert(int money) throws Exception{//6000
        StringBuilder sb = new StringBuilder();
        int uint = 0;
        while(money!=0){
            sb.insert(0, units[uint++]);
            sb.insert(0, data[(int)(money%10)]);
            money = money / 10;
        }

        System.out.println(sb);

        return sb.toString().replaceAll("零[仟佰拾]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零圆", "圆");
    }
}
