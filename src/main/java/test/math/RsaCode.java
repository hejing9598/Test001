package test.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Qing on 2019/9/8.
 */
public class RsaCode {

    public static void main(String[] args) {

        int q = 97;
        int p = 103;

        int euler = euler(p, q);
        System.out.println("euler: " + euler);

        int e = getE(q, p, euler);
        System.out.println("e: " + e);

        //e的 φ(N)-1 次方 就是 e的 模反元素
        rex(1213, euler);

    }

    //求e,条件是:1< e < φ(n)，且e与φ(n) 互质。
    private static int getE(int q, int p, int euler) {

        ArrayList list = new ArrayList();

        for (int x = 3; x < euler; x += 2) {

            if (isPrime(x)) {

                list.add(x);
            }
        }
        if (list.size() == 0) {
            return -1;
        }
        Collections.shuffle(list);
        return (int) list.get(0);
    }


    //求φ(N):小于或等于N的正整数中与N互质的数的数目
    private static int euler(int p, int q) {

        if (isPrime(q) && isPrime(p)) {

            int euler = (p - 1) * (q - 1);
            return euler;
        }
        return -1;
    }

    //测试一个正整数是不是素数
    private static boolean isPrime(int num) {

        //求平方根
        double sqrt = Math.sqrt(num);
        //过滤,3及以下没有意义
        if (num < 2) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        // 先判断是否为偶数，若偶数就直接结束程序
        if (num % 2 == 0) {
            return false;
        }

        //循环从3开始,步长是2(避免偶数)
        //为什么要求num的开平方;因为如果一个数不是素数是合数，那么一定可以由两个自然数相乘得到，其中一个大于或等于它的平方根，一个小于或等于它的平方根。并且成对出现
        for (int i = 3; i <= sqrt; i += 2) {
            //对奇数进行取余,若是没有余数则不是素数
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int rex(int e, int euler) {

        //  e * x - euler * y = 1
        HashMap map = new HashMap();

        BigInteger be = BigInteger.valueOf(e);
        BigInteger beuler = BigInteger.valueOf(euler);
        BigInteger bx = BigInteger.valueOf(0);
        BigInteger by = BigInteger.valueOf(0);


        for (int x = 0; ; x++) {
            //求得20个解后结束循环
            if (map.size() >= 20) {
                break;
            }
            bx = BigInteger.valueOf(x);
            for (int y = -10000; y <= 10000; y++) {
//            System.out.println("第"+x+"循环");

                by = BigInteger.valueOf(y);
                if ((be.multiply(bx).subtract(beuler.multiply(by))).equals(1)) {

                    System.out.println("x: " + bx);
                    System.out.println("y: " + by);
                    map.put(bx, by);
                } else {

                    bx = bx.add(BigInteger.valueOf(1));
                    by = by.subtract(BigInteger.valueOf(1));
                }
            }
        }

        System.out.println(map);
        return -1;
    }
}


