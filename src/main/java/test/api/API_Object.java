package test.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Qing on 2019/8/30.
 */
public class API_Object {

    public static void main(String[] args) {

        Object object = new Object();
        Object object2 = object;

        //返回对象的哈希码值,根据对象的地址值计算,返回int
        System.out.println(object.hashCode());


        System.out.println(object.getClass());
        //获取字节码文件
        Class clazz = object.getClass();
        System.out.println(clazz.getName());


        System.out.println(object.toString());


        //equals重写前比较的是地址值  ==比较的是的基本数据类型
        A a = new A("ABC");
        A a1 = new A("ABC");
        System.out.println(a == a1);
        System.out.println(a.equals(a1));

    }
}

@Data
@AllArgsConstructor
class A {

    String name;
}