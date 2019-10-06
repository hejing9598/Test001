package test.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * Created by Qing on 2019/9/12.
 * 序列流,将两个输入流整合成一个,读取完第一个再读取第二个
 */
public class SequenceInputStream_Test {

    public static void main(String[] args) throws IOException{


        test1();
    }

    //
    private static void test1() throws IOException{

        FileInputStream fis1 = new FileInputStream("Files\\txt\\Test.txt");
        FileInputStream fis2 = new FileInputStream("Files\\txt\\Test2.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1,fis2);

        FileOutputStream fos = new FileOutputStream("Files\\txt\\Test3.txt");

        int b;
        while ((b = sis.read()) != -1) {

            fos.write(b);
        }

        sis.close();
        fos.close();
    }
}
