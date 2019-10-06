package test;

/**
 * Created by Qing on 2019/8/29.
 * 抽象类练习
 *
 * 抽象类不能被实例化
 * 抽象类未必有抽象方法
 * 有抽象方法的一定是抽象类
 * 抽象类的抽象方法由子类去具体实现,或者继续抽象
 */
public class Abstract_Test {

    public static void main(String[] args) {

        Animal animal = new Cat();
        animal.eat();
    }
}

abstract class Animal {


    public abstract void eat();

}


class Dog extends Animal {

    @Override
    public void eat() {

        System.out.println("狗吃狗粮");
    }
}


class Cat extends Animal {

    @Override
    public void eat() {

        System.out.println("猫吃猫粮");
    }
}