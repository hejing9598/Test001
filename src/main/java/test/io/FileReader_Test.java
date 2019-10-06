package test.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Qing on 2019/9/10.
 */
public class FileReader_Test {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("Files\\txt\\长恨歌.txt");
        FileWriter fw = new FileWriter("Files\\txt\\长恨歌2.txt");

        int x;

        while ((x = fr.read()) != -1) {
            fw.write(x);
        }

        fr.close();
        fw.close();
    }
}
