package test;

/**
 * Created by Qing on 2019/9/5.
 */
public class Exception_Test {

    public static void main(String[] args) {

//        test1();

        try {
            test2();
        } catch (KongZhiZhenException e) {
            System.out.println(e.toString());
        }


    }

    //也可以在方法中抛出异常,一直抛出,最后谁调用谁处理try catch
    private static void test2() throws KongZhiZhenException {

        String str = null;
        str.length();
        //此处改为RunTimeException在方法声明上可以不抛出
        throw new KongZhiZhenException();
    }

    //try..catch
    private static void test1() {
        try {

            String string = null;
            string.length();

        } catch (NullPointerException e) {

            String message = e.getMessage();//获取错误信息
            String s = e.toString();//
//            e.printStackTrace(); //JVM默认处理方式,停止程序,打印错误信息

            System.out.println(message);
            System.out.println(s);
        }catch (Exception e) {

            //可以catch多个,小的在前,大的在后
        }finally {

            System.out.println("一定会执行");
        }
    }
}

//自定义异常类
class KongZhiZhenException extends Exception {

    public KongZhiZhenException(){}

    public KongZhiZhenException(String message){
        super(message);
    }
}