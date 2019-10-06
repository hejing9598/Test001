package test;

/**
 * Created by Qing on 2019/8/30.
 */
public class Anonymous_Inner_Class_Test {

    public static void main(String[] args) {

        Circus circus = new Circus();
        Dog2 dog2 = new Dog2();

//        circus.show(dog2);

        //此为匿名内部类
        circus.show(new Animal2() {
            @Override
            public void show() {

                System.out.println("狗熊表演");
            }
        });

    }
}

class Circus {


    public void show(Animal2 animal2) {

        animal2.show();
    }
}


abstract class Animal2 {

    public abstract void show();
}


class Dog2 extends Animal2 {

    @Override
    public void show() {

        System.out.println("狗狗表演");
    }
}


class Cat2 extends Animal2 {

    @Override
    public void show() {

        System.out.println("猫咪表演");
    }
}