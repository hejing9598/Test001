package util;

import java.util.Arrays;

/**
 * Created by Qing on 2019/8/24.
 */
public class ArrayTool {

    public static void main(String[] args) {

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        sort2(arr2);
        System.out.println(binary_Search(arr2, 1));


//        ergodic(arr2);
//        min(new int[]{-2,1,2,3,4,5,6,9,7});
//        max(new int[]{1,2,3,4,5,6,7,8,9});
//        reverse(arr);
//        System.out.println(Arrays.toString(arr));
    }

    //数组排序
    private static void sort(Integer[] arr) {

        if (arr == null) {

            System.out.println("数组为null");
            return;
        } else if (arr.length == 0) {

            System.out.println("数组没有元素");
            return;
        }

        for (int x = 0; x < arr.length - 1; x++) {

            for (int y = 0; y < arr.length - 1 - x; y++) {

                //若果数组中任意一个元素是null值,会崩溃
                if (arr[y] == null || arr[y + 1] == null) {
                    System.out.println("数组元素为空,index = " + y + " | " + (y + 1));
                    return;
                }
                if (arr[y] > arr[y + 1]) {

                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }
        return;
    }

    //选择排序
    private static void sort2(Integer[] arr) {

        for (int x = 0; x < arr.length; x++) {
            for (int y = x + 1; y < arr.length; y++) {

                if (arr[x] > arr[y]) {

                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
    }

    //遍历数组
    public static void ergodic(Object[] arr) {

        if (arr == null || arr.length == 0) {

            System.out.println("数组为Null | 数组长度为0");
            return;
        }

        for (int x = 0; x < arr.length; x++) {

            if (arr[x] == null) {

                continue;
            }
            System.out.print(arr[x].toString() + "-");
        }
    }

    //找出最小值
    private static void min(int[] arr) {

        int temp = 0;
        for (int x : arr) {

            if (x <= temp) {

                temp = x;
            }
        }

        System.out.println(temp);
    }

    //找出最大值
    private static void max(int[] arr) {

        int temp = 0;
        for (int x : arr) {

            if (x >= temp) {

                temp = x;
            }
        }

        System.out.println(temp);
    }

    //反转数组
    private static void reverse(Object[] arr) {

        for (int x = 0; x < arr.length / 2; x++) {

            Object temp = arr[x];
            arr[x] = arr[arr.length - 1 - x];
            arr[arr.length - 1 - x] = temp;
        }

    }

    //二分查找法
    private static int binary_Search(Integer[] arr, int value) {

        //上限 下限  中间值
        int max = arr.length - 1;
        int min = 0;
        int mid = (max + min) / 2;

        //循环找值,中间值等于value吗?
        while (value != arr[mid]) {

            //如果mid比value大.则上限与mid需要从新定位
            if (arr[mid] > value) {

                max = mid - 1;
            } else if (arr[mid] < value) {
                //如果mid比value小,则min需要重新定位
                min = mid + 1;
            }

            //重新定位mid
            mid = (max + min) / 2;

            //如果数组里没有这个数就会死循环
            if (min > max) {
                return -1;
            }
        }

        return mid;
    }

}
