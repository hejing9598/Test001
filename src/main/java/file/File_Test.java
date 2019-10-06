package file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Qing on 2019/9/6.
 */
public class File_Test {

    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
//        test3();
//        test4();


        File E = new File("D:\\");
        System.out.println(test5(E));


    }

    //统计文件夹下的jpg文件个数
    private static long test5(File e) {
        File[] files = e.listFiles();
        long length = 0;
        for (File file : files) {

            if (file.isFile()) {

                if (file.getName().endsWith("jpg")) {

                    length += file.length();
                }
            } else {

                if (file.canExecute() && !file.isHidden()) {

                    length += test5(file);
                }
            }
        }
        return length;
    }

    private static void test4() {
        File file = new File("Files\\txt");

        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        //获取相对路径
        System.out.println(file.getPath());
        //获取当前file的name
        System.out.println(file.getName());
        //文件大小
        System.out.println(file.length());
        //最后一次修改时间,精确到毫秒
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(file.lastModified()));
        //获取该file目录的所有文件与文件夹,以数组形式表示
        String[] list = file.list();
        //获取所有文件与文件夹以file数组表示
        File[] files = file.listFiles();
    }

    private static void test3() {
        File file = new File("Files\\txt");

        //判断是否是文件夹
        System.out.println(file.isDirectory());
        //判断是否是文件
        System.out.println(file.isFile());
        //判断是否存在
        System.out.println(file.exists());
        //判断是否可读
        System.out.println("可读" + file.canRead());
        //判断是否可写
        System.out.println("可写" + file.canWrite());
        //判断是否有权限打开(windows默认有权限,需要用linux测试)
        System.out.println(file.canExecute());
        //判断文件是否为隐藏文件
        System.out.println(file.isHidden());
    }

    private static void test2() throws IOException {
        //createNewFile()  创建文件 第一次创建返回true,第二次返回false(不会重复创建)
        File file = new File("Files\\txt\\长恨歌.txt");
        boolean b = file.createNewFile();
        System.out.println(b);

        //mkdir()创建单级文件夹,mkdirs创建多级文件夹,不能创建文件
        File file1 = new File("Files\\txt");
        //boolean mkdir = file1.mkdir();
        boolean mkdirs = file1.mkdirs();
        System.out.println(mkdirs);

        //renameTo() 路径相同是改名,路径不同是剪贴并改名
        boolean b1 = file.renameTo(new File("Files\\txt\\HELLO.txt"));
        System.out.println(b1);
        //删除,如果删除文件夹则文件夹必须是空的
        boolean delete = file.delete();
        System.out.println(delete);
    }

    private static void test1() {
        //相对路径 绝对路径
        File parent = new File("D:\\B\\Music\\XiamiMusic");
        String child = "Comforting Sounds.mp3";
        File file = new File(parent, child);
        File f2 = new File("pom.xml");

        //是否存在
        System.out.println(file.exists());
        System.out.println(f2.exists());
        System.out.println(parent.exists());
    }
}
