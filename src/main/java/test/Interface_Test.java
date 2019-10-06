package test;

/**
 * Created by Qing on 2019/8/29.
 *
 */
public class Interface_Test {

    public static void main(String[] args) {


    }
}


interface Abc{}
interface  Acb{}

//接口可以多继承
interface Interface_Demo extends Abc,Acb{

    //接口的成员变量必须是 public static final
    public static final int NUM = 20;

    //接口没有构造
    //接口方法是默认 public abstract 修饰
    public abstract void test();

}

class Interface_Demo_impl implements Interface_Demo{


    @Override
    public void test() {

        System.out.println("具体实现接口");
    }
}
