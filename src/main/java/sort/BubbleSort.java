package sort;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Qing on 2019/10/12.
 * 冒泡排序
 */
public class BubbleSort {


    public static void reverseSort(ArrayList<Integer> list) {

        //先剔除null元素
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer sub = iterator.next();
            if (sub == null) {
                iterator.remove();
            }
        }

        //倒序排序
        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = 0; j < list.size() - 1 - i; j++) {

                if (list.get(j) < list.get(j + 1)) {

                    Integer temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

    }
}
