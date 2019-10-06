package test.multithreading;

/**
 * Created by Qing on 2019/9/14.
 * <p>
 * Thread调用start()方法,start()再调用native方法start0()创建线程,然后会调用run()方法,检查是否有Runnable的对象,有就调用runnable
 * 子类对象重写的run()方法.若是继承Thread类,则直接调用子类的start()方法
 * 新生 > 就绪 > 运行 > 阻塞 > 死亡
 */
public class Thread_Test {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();

    }

    /**
     * 设置线程优先级
     */
    private static void test5() {
        Thread t1 = new Thread() {

            @Override
            public void run() {

                System.out.println("Run");
            }
        };

        t1.start();
        //设置线程优先级MAX-最大, MIN-最小, NORM-标准
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.NORM_PRIORITY);
    }

    private static void test4() throws InterruptedException {
        MyThread1 mt1 = new MyThread1();
        Thread thread = new Thread(mt1);
        thread.start();

        //休眠20毫秒,会自动醒来
        Thread.sleep(20);
        //命令你停止,没有我的命令你不准动(这里的代码会报错,因为该线程已经结束了)
        thread.wait();
        //唤醒线程
        thread.notify();
        //设置守护线程(当其他非守护线程都执行结束后, 自动退出)
        thread.setDaemon(true);
        //插队(被插队的当前线程会停止,等待下面的thread线程完毕后再运行)
        thread.join();
        //礼让(没卵用),当前线程会让出cpu,不过没卵用
        Thread.yield();
    }

    private static void test3() {
        MyThread1 mt1 = new MyThread1();
        //可以在这里给线程设置名字
        Thread thread = new Thread(mt1, "新县城");
        thread.start();

        //main方法是一条线程,thread.start()是另外一条线程,所以控制台的结果不会按照代码顺序来
        System.out.println(thread.getName());
        thread.setName("线程0");
        System.out.println(thread.getName());

        //获取当前线程对象(此处获取的是main方法主线程)
        Thread thread1 = Thread.currentThread();
    }

    //匿名内部类实现启动线程
    private static void test2() {
        new Thread() {

            @Override
            public void run() {
                System.out.println("Run");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        }
        ) {
        }.start();
    }

    /**
     * 启动线程的两种方法
     */
    private static void test1() {
        //启动线程的方式一
        //此处新启动了一个线程
        MyThread mt = new MyThread();
        mt.start();//不可重复调用start()方法,会出现异常
        //启动线程的方式二
        MyThread1 mt1 = new MyThread1();
        Thread thread = new Thread(mt1);
        thread.start();
    }
}

/**
 * 实现多线程的方法一:
 * 继承Thread类,重写run()方法,把代码写在run方法里
 * new本类对象,调用start()方法,start()会调用run()
 */
class MyThread extends Thread {

    @Override
    public void run() {

        System.out.println("Hello World");
        test1();
    }

    private void test1() {

        //加锁,锁对象可以是任何对象
        //同步代码,这个代码块只有被当前线程执行完毕后其他线程才能执行该代码块
        //非静态代码的锁对象是this,当前对象.静态代码是本类的字节码对象 MyThread.class
        //如果几个同步代码快使用的是同一个锁对象,那么就是同步的
        synchronized (this) {

            System.out.println("王");
            System.out.println("者");
            System.out.println("荣");
            System.out.println("耀");
        }
    }
}

class MyThread1 implements Runnable {

    @Override
    public void run() {

        System.out.println("Hello World");
    }
}