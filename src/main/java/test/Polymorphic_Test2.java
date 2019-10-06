package test;

/**
 * Created by Qing on 2019/8/29.
 */
public class Polymorphic_Test2 {

    public static void main(String[] args) {

        A a = new C();
        a.show();

        //向下转型,A转成C
        C c = (C)a;

    }
}



class A {

    public void show() {

        show2();
        System.out.println("A show");
    }

    public void show2() {

        System.out.println("A show2");
    }
}



class B extends A {

    @Override
    public void show() {

        show2();
        System.out.println("B show");
    }

    @Override
    public void show2() {

        System.out.println("B show2");
    }
}



class C extends B {

    @Override
    public void show() {

        show2();
        System.out.println("C show");
    }

    @Override
    public void show2() {

        System.out.println("C show2");
    }
}


