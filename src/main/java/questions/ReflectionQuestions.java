package questions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Qing on 2019/10/18.
 */
public class ReflectionQuestions {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        demo0();
    }

    /**
     * ArrayList<Integer> list = new ArrayList<Integer>();
     * 在这个泛型为Integer的ArrayList中存放一个String类型的对象
     *
     * @throws Exception
     */
    private static void demo0() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ArrayList<Integer> list = new ArrayList<>();

        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list,"HelloWorld");

        System.out.println(list.toString());


    }
}
