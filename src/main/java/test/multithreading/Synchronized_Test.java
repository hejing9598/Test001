package test.multithreading;

/**
 * Created by Qing on 2019/9/14.
 * <p>
 * synchronized同步代码
 */
public class Synchronized_Test {

    public static String s2 = "右筷子";
    public static String s1 = "左筷子";

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
        test4();

    }

    /**
     * 两个线程通信 wait() notify()
     */
    private static void test4() {
        MyThread2 mt2 = new MyThread2();

        new Thread() {

            @Override
            public void run() {
                try {
                    while (true) {

                        mt2.test1();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {

            @Override
            public void run() {
                try {
                    while (true) {

                        mt2.test2();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 死锁,互相占用对方想要的锁资源,导致死锁
     */
    private static void test3() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (s1) {
                        System.out.println("拿到了" + s1 + "等待左筷子");
                        synchronized (s2) {
                            System.out.println("拿到了" + s2 + "可以吃饭了");
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (s2) {
                        System.out.println("拿到了" + s2 + "等待右筷子");
                        synchronized (s1) {
                            System.out.println("拿到了" + s1 + "可以吃饭了");
                        }
                    }
                }
            }
        }.start();
    }

    private static void test2() {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.start();
        t2.start();
    }

    /**
     * 同步代码块
     */
    private static void test1() {
        MyThread mt = new MyThread();
        MyThread mt1 = new MyThread();

        mt.start();
        mt1.start();
    }

}


/**
 * 火车票 卖票案例
 * 使用多线程与同步代码
 */
class Ticket implements Runnable {

    //共有100张票
    static int tickets = 100;

    @Override
    public void run() {
//        synchronized (Ticket.class) {
        sellTicket();
//        }
    }

    private static void sellTicket() {

        synchronized (Ticket.class) {
            while (tickets > 0) {

                System.out.println(tickets + "号票");
                tickets--;
            }
        }
    }
}

class MyThread2 {

    private int flag = 1;

    public void test1() throws InterruptedException {
        synchronized (this) {
            if (flag != 1) {

                this.wait();
            }
            System.out.println("1");
            flag = 2;
            this.notify();
        }
    }

    void test2() throws InterruptedException {
        synchronized (this) {
            if (flag != 2) {

                this.wait();
            }
            System.out.println("2");
            flag = 1;
            this.notify();
        }
    }

}