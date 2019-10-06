package test.collection;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Qing on 2019/9/5.
 */
public class Collections_UtilTest {

    public static void main(String[] args) {

//        test1();
        playCards();

    }

    //斗地主模拟洗牌发牌
    private static void playCards() {

        //1.做牌
        Cards cards = new Cards();
        ArrayList<String> cards54 = cards.getCards();
        //2.洗牌
        Collections.shuffle(cards54);
        //3.发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        int user = 1;
        int index = 0;
        while (index <= 53) {

            if (user == 1) {

                if (index >= 51) {
                    dipai.add(cards54.get(index));
                    index = index + 1;
                    user++;
                    continue;
                }
                player1.add(cards54.get(index));
                index = index + 1;
                user++;
            } else if (user == 2) {

                if (index >= 51) {
                    dipai.add(cards54.get(index));
                    index = index + 1;
                    user++;
                    continue;
                }
                player2.add(cards54.get(index));
                index = index + 1;
                user++;
            } else if (user == 3) {

                if (index >= 51) {
                    dipai.add(cards54.get(index));
                    index = index + 1;
                    user++;
                    continue;
                }
                player3.add(cards54.get(index));
                index = index + 1;
                user = 1;
            }

        }
        //看牌
        System.out.println("PLAYER1---"+player1.size() + "" + player1);
        System.out.println("PLAYER2---"+player2.size() + "" + player2);
        System.out.println("PLAYER3---"+player3.size() + "" + player3);
        System.out.println("底牌---"+dipai.size()+dipai);

    }

    //Collections工具类方法
    private static void test1() {
        ArrayList<String> list = new ArrayList<>();
        List list1 = new ArrayList<>();
        list1.add("1220");
        list1.add("2220");
        list1.add("3220");
        Collection coll = new ArrayList();
        coll.add("1");
        coll.add("2");
        coll.add("3");

        //排序
        Collections.sort(list);
        //二分查找,必须是有序的
        int index = Collections.binarySearch(list, "3220", new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.compareTo(o2);
                return result;
            }
        });
        //获取最大值
        Comparable max = Collections.max(coll);
        //反转
        Collections.reverse(list);
        //随机置换,洗牌
        Collections.shuffle(list);
    }
}

class Cards {

    private ArrayList<String> cards = new ArrayList<>();

    public Cards() {

        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k"};
        String[] color = {"红桃", "黑桃", "方片", "梅花"};

        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < num.length; j++) {

                cards.add(color[i] + num[j]);
            }
        }
        cards.add("大王");
        cards.add("小王");
    }

    public ArrayList<String> getCards() {

        return this.cards;
    }
}