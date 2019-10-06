package test.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Qing on 2019/9/17.
 */
public class BigDecimal_Test {

    public static void main(String[] args) {

        //计算需要的秒数
        String strResult = computingTime().toString();

        //以小数点分割
        String[] split = strResult.split("\\.");

        //将秒数转换成 时.分.秒
        calculationTime(new BigInteger(split[0]));
    }

    /**
     * 将秒数格式化成  hh时 : mm分 : ss秒
     */
    private static void calculationTime(BigInteger num) {

        final BigInteger SIXTY = new BigInteger("60");

        BigInteger second = num.remainder(SIXTY);
        BigInteger minute = num.divide(SIXTY).remainder(SIXTY);
        BigInteger hour = num.divide(SIXTY).divide(SIXTY);
        System.out.println("还需要  " + hour.toString() + "时 : " + minute.toString() + "分 : " + second.toString() + "秒");
    }


    /**
     * 输入物品价格,现有金币,金币增长速度(每秒),求出需要多少秒后现有金币才能达到物品价格所需金币
     */
    public static BigDecimal computingTime() {
        //键盘录入数据
        Scanner scanner = new Scanner(System.in);
        //a.录入物品价格并识别单位
        System.out.println("请输入物品价格:");
        String strPrice = scanner.next().trim();
        BigDecimal price;
        price = matchingUnit(strPrice);

        //b.录入现有金币并识别单位
        System.out.println("请输入现有金币:");
        String strGods = scanner.next().trim();
        BigDecimal gods;
        gods = matchingUnit(strGods);

        //c.录入金币获取速度(每秒)并识别单位
        System.out.println("请输入金币获取速度:");
        String strGodsByMinute = scanner.next().trim();
        BigDecimal godsByMinute;
        godsByMinute = matchingUnit(strGodsByMinute);

        //d.进行计算
        //物品价格减现有金币除以金币获取速度
        BigDecimal result = price.subtract(gods).divide(godsByMinute, 0);
        System.out.println("需要" + price);
        System.out.println("现有" + gods);
        System.out.println("相差" + price.subtract(gods));
        return result;
    }

    /**
     * 根据数字的单位(k,w,m,b)计算基本形式并返回Bigdecimal对象
     *
     * @param num
     */
    private static BigDecimal matchingUnit(String num) {
        BigDecimal price;
        if (num.endsWith("k") || num.endsWith("K")) {
            price = caseTousand(BigDecimal.valueOf(Double.valueOf(num.substring(0, num.length() - 1))));
        } else if (num.endsWith("m") || num.endsWith("M")) {
            price = caseMillion(BigDecimal.valueOf(Double.valueOf(num.substring(0, num.length() - 1))));
        } else if (num.endsWith("b") || num.endsWith("B")) {
            price = caseBillion(BigDecimal.valueOf(Double.valueOf(num.substring(0, num.length() - 1))));
        } else if (num.endsWith("t") || num.endsWith("T")) {
            price = caseTrillion(BigDecimal.valueOf(Double.valueOf(num.substring(0, num.length() - 1))));
        } else if (num.endsWith("aa") || num.endsWith("AA")) {
            price = caseThousandTrillions(BigDecimal.valueOf(Double.valueOf(num.substring(0, num.length() - 2))));
        } else {
            price = BigDecimal.valueOf(Double.valueOf(num));
        }
        return price;
    }


    //************************************************************************************************************************************************************************************************************


    /**
     * 千 k
     *
     * @param in
     * @return
     */
    public static BigDecimal caseTousand(BigDecimal in) {

        final BigDecimal ONE_THOUSAND = BigDecimal.valueOf(1000);
        return in.multiply(ONE_THOUSAND);
    }

    /**
     * 百万 m
     *
     * @param in
     * @return
     */
    public static BigDecimal caseMillion(BigDecimal in) {

        final BigDecimal ONE_MILLION = BigDecimal.valueOf(1000000L);
        return in.multiply(ONE_MILLION);
    }

    /**
     * 十亿 b
     *
     * @param in
     * @return
     */
    public static BigDecimal caseBillion(BigDecimal in) {

        final BigDecimal ONE_BILLION = BigDecimal.valueOf(1000000000L);
        return in.multiply(ONE_BILLION);
    }

    /**
     * 万亿 t
     *
     * @param in
     * @return
     */
    public static BigDecimal caseTrillion(BigDecimal in) {

        final BigDecimal ONE_Trillion = BigDecimal.valueOf(1000000000000L);
        return in.multiply(ONE_Trillion);
    }

    /**
     * 千万亿 aa
     *
     * @param in
     * @return
     */
    public static BigDecimal caseThousandTrillions(BigDecimal in) {

        final BigDecimal ONE_Trillion = BigDecimal.valueOf(1000000000000000L);
        return in.multiply(ONE_Trillion);
    }
}
