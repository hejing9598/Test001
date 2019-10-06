package test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Qing on 2019/9/10.
 */
public class InputStream_Test {

    public static void main(String[] args) throws IOException {


        test1();
    }

    public static void test1() throws IOException {

        FileInputStream fis = new FileInputStream("D:\\B\\Music\\XiamiMusic\\Comforting Sounds.mp3");
        FileOutputStream fos = new FileOutputStream("D:\\B\\Music\\XiamiMusic\\Comforting Sounds2.mp3",true);//接true可以在源文件后续写,不接就是删除原内容后写入

        //一个字节一个字节的读写,太慢
//        int bit = 0;
//        while ((bit = fis.read()) != -1) {
//
//            fos.write(bit);
//        }
        //一次读出与整个文件同样大小的数组,再写入,但是文件太大会导致内存溢出
//        byte[] arr = new byte[fis.available()];//创建与文件一样大小的数组
//        fis.read(arr);//读取整个文件内容
//        fos.write(arr);//写入整个内容

        //使用小容量数组
        byte[] arr = new byte[512];
        int n;
        while ((n = fis.read(arr)) != -1) {

            fos.write(arr);
//            fos.write(arr,0,n); //从索引0开始写到n
        }


        //关闭资源
        fis.close();
        fos.close();
    }
}
