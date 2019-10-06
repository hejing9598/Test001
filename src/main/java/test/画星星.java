package test;

/**
 * Created by Qing on 2019/8/22.
 */
public class 画星星 {

    public static void main(String[] args) {

        画星星 画星星 = new 画星星();
        画星星.test4();
    }

    //正方形
    private void test1() {

        for (int x = 0; x < 4; x++) {

            for (int y = 0; y < 5; y++) {


                System.out.print(" * ");
            }

            System.out.println();
        }
    }

    //直角三角形
    private void test2() {

        for (int x = 0; x < 6; x++) {

            for (int y = 0; y < x; y++) {

                System.out.print(" * ");
            }

            System.out.print(" ");
            System.out.println();
        }
    }

    //控制语句
    private void test3() {

        for (int x = 0; x < 10; x++) {

            System.out.println(x);
            continue;
//            break;
//            return;

        }
    }

    //99乘法表
    private void test4() {

        for (int x = 1; x < 10; x++) {

            for (int y = 1; y <= x; y++) {

                System.out.print(y + " * " + x + " = " + x * y + "  ");
            }
            System.out.println();
        }
    }


}
