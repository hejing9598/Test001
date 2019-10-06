package test.math;

import java.math.BigInteger;

/**
 * Created by Qing on 2019/9/9.
 * 加法add, 减法subtract, 乘法multiply, 相除取整divide, 取余remainder,
 */
public class BigInteger_Test {
    public static void main(String[] args) {

        BigInteger x = new BigInteger("21");
        BigInteger y = new BigInteger("3908");
        BigInteger z = new BigInteger("2");

        System.out.println(caseBillion(x).subtract(caseMillion(y)).divide(caseMillion(z)));

    }


    /**
     * 将千作为单位的数字转成基本形式5k -- 5000
     * original: 需要转换的数字
     */
    public static BigInteger caseThousand(BigInteger original) {

        BigInteger complete = new BigInteger("-1");
        if (original == null) {
            return complete;
        }
        complete = original.multiply(new BigInteger("1000"));

        return complete;
    }

    /**
     * 将单位是百万的转换成基本形式
     *
     * @param original
     * @return
     */
    public static BigInteger caseMillion(BigInteger original) {

        BigInteger complete = new BigInteger("-1");
        if (original == null) {
            return complete;
        }
        complete = original.multiply(new BigInteger("1000000"));

        return complete;
    }

    /**
     * 将单位是百万的转换成基本形式
     *
     * @param original
     * @return
     */
    public static BigInteger caseBillion(BigInteger original) {

        BigInteger complete = new BigInteger("-1");
        if (original == null) {
            return complete;
        }
        complete = original.multiply(new BigInteger("1000000000"));

        return complete;
    }

}
