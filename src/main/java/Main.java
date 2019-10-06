import test.Car;
import util.Sort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Nothing
        Main main = new Main();
        main.car();

    }

    private static void test() {

        Random random = new Random();//创建随机数对象
        int[] arr = new int[20];//创建一个长度为20的数组

        //把数组装满
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(100);
        }

        //遍历展示数组
        for (int i : arr) {
            System.out.print(i + " ");
        }

        //创建Sort类对象,并调用排序方法
        Sort sort = new Sort();
        int[] ints = sort.sort(arr);

        //展示排序后的数组
        System.out.println();
        for (int i : ints) {

            System.out.print(i + " ");
        }

    }

    private void car() {

        Car car = new Car();
        car.setName("保时捷");
        car.setMoney(200);
        car.setColor("Red");
        System.out.println(car.toString());

    }

}
