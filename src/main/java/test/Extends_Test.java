package test;

import lombok.Data;

/**
 * Created by Qing on 2019/8/27.
 */
public class Extends_Test {

    public static void main(String[] args) {

//        Zi zi = new Zi();
//        zi.show();


    }


}

@Data
class Fu {
    public int num = 10;

    public Fu() {
        System.out.println("fu");
    }
}

class Zi extends Fu {
    public int num = 20;

    public Zi() {
        super();
        System.out.println("zi");
    }

    public void show() {
        int num = 30;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
}

