package test;

import org.apache.commons.lang3.SystemUtils;

/**
 * Created by Qing on 2019/8/22.
 */
public class Arrays {

    public static void main(String[] args) {


        Arrays arrays = new Arrays();
        arrays.test3(5);

    }

    private void test1() {

        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = arr;

        for (int x : arr) {
            System.out.println(x);
        }

        for (int x : arr2) {
            System.out.println(x);
        }

    }

    //反转数组
    private void test2() {

        int[] arr = new int[]{1, 2, 3, 4, 5};

        for (int x = 0; x < arr.length / 2; x++) {

            int temp = arr[x];
            arr[x] = arr[arr.length - 1 - x];
            arr[arr.length - 1 - x] = temp;
        }

        System.out.println(java.util.Arrays.toString(arr));

        System.out.println(SystemUtils.OS_NAME);
        System.out.println(SystemUtils.OS_VERSION);
        System.out.println(SystemUtils.OS_ARCH);
//        System.out.println(SystemUtils.JAVA_CLASS_PATH);
        System.out.println(SystemUtils.JAVA_CLASS_VERSION);
        System.out.println(SystemUtils.USER_TIMEZONE);

    }

    //查找第一个元素第一次出现的索引
    private void test3(int num) {

        int[] arr = {0,8,7,5,5,4};
        for(int x = 0 ; x < arr.length -1 ;x++) {

            if(num == arr[x]) {

                System.out.println(x);
                return;
            }
        }
    }
}
