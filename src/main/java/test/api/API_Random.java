package test.api;

import java.util.Random;

/**
 * Created by Qing on 2019/8/30.
 */
public class API_Random {

    public static void main(String[] args) {

        Random random = new Random();


        //前闭后开0 -- ?
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(20));

    }
}
