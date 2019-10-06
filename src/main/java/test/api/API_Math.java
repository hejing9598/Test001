package test.api;

/**
 * Created by Qing on 2019/8/30.
 */
public class API_Math {

    public static void main(String[] args) {

        //绝对值
        Math.abs(-24);
        //向上取整
        Math.ceil(0.222);
        //向下取整
        Math.floor(0.011);
        //两数中的最大值
        Math.max(11, 22);
        //两数中的最小值
        Math.min(11, 22);
        //a的b次幂
        System.out.println(Math.pow(2, 4));
        //生成0.0 --- 1.0 之间的随机数
        Math.random();
        //四舍五入
        System.out.println(Math.round(989.222));
        //开平方(根号)
        System.out.println(Math.sqrt(0.22));
    }
}

