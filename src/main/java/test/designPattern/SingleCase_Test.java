package test.designPattern;

/**
 * Created by Qing on 2019/9/14.
 * 单例模式
 */
public class SingleCase_Test {

    public static void main(String[] args) {


    }
}

/**
 * 饿汉式 以空间换时间 没有线程安全问题
 */
class Single1 {

    /**
     * 1.私有化构造方法
     */
    private Single1() {
    }

    /**
     * 2.创建本类对象并私有化
     */
    private static Single1 single1 = new Single1();

    /**
     * 3.提供公共的访问方式
     */
    public static Single1 getSingle1() {

        return single1;
    }
}

/**
 * 懒汉式 时间换空间 有安全问题
 */
class Single2 {

    /**
     * 私有构造方法
     */
    private Single2() {
    }

    /**
     * 声明一个本类引用
     */
    private static Single2 single2;

    /**
     * 提供公共的访问方法
     *
     * @return single2
     */
    public static Single2 getSingle2() {

        if (single2 == null) {

            single2 = new Single2();
        }
        return single2;
    }
}