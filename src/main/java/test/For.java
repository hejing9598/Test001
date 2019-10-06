package test;

/**
 * Created by Qing on 2019/8/22.
 */
public class For {

    public static void main(String[] args) {

        For aFor = new For();
        aFor.test7();
    }

    private void test1() {

        for (int x = 1; x < 11; x++) {

            System.out.print(x + " ");
        }

        for (int x = 10; x > 0; x--) {

            System.out.print(x + " ");
        }
    }

    private void test2() {

        for (char x = 'a'; x <= 'z'; x++) {

            System.out.println(x);
        }
    }

    //1-10之和
    private void test3() {

        int sum = 0;
        for (int x = 1; x < 11; x++) {

            sum = sum + x;
        }
        System.out.println(sum);
    }

    //1-100奇数/偶数之和
    private void test4() {

        int sum = 0;
        int sum2 = 0;
        for (int x = 1; x < 101; x++) {

            if (x % 2 != 0) {

                sum = sum + x;
            } else if (x % 2 == 0) {

                sum2 = sum2 + x;
            }
        }

        System.out.println("奇数和:" + sum + "---" + "偶数和:" + sum2);
    }

    //100-999水仙花数 一个三位数,各位数的立方和等于本身
    private void test5() {

        int count = 0;
        for (int x = 100; x < 1000; x++) {

            int ge = x % 10;
            int shi = x / 10 % 10;
            int bai = x / 100;

            //if(ge*ge*ge + shi*shi*shi + bai*bai*bai == x) {
            if(Math.pow(ge,3) + Math.pow(shi,3) + Math.pow(bai,3) == x) {
                System.out.println(x);
                count++;
            }
        }
            System.out.println(count + " 个");
    }

    //while
    private void test6() {

        int x = 1;
        while (x < 101) {

            System.out.print (x +"-");
            x++;
        }
    }

    //do-while
    private void test7() {

        int x = 1;
        do {
            System.out.println(x);
            x++;
        }while (x < 101);
    }

}
