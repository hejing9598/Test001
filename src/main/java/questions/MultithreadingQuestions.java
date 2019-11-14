package questions;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Qing on 2019/10/18.
 * 多线程类练习题
 */
public class MultithreadingQuestions {

    public static void main(String[] args) {

        demo0();
    }

    /**
     * 公司组织出游活动,活动 有:"活动A","活动B","活动C","活动D",分为两个小队,飞虎队和凤凰队
     * 两个小队从活动中随机抽取2项活动,并在控制台中输出4次
     * 输出格式:xx小分队 选择 xx活动
     */
    private static void demo0() {

        new Thread("飞虎队").start();
        new Thread("凤凰队").start();
    }

    static class Team implements Runnable {

        String[] arr = {"活动A", "活动B", "活动C", "活动D"};

        @Override
        public void run() {
            System.out.println("LLLL");

            int num = 0;
            while (true) {
                synchronized (Team.class) {

                    if (num < 4) {

                        System.out.println(Thread.currentThread().getName() + arr[num]);
                        num++;
                    }
                }
            }
        }
    }


}
