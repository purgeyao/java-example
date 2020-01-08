package com.mercy.demo;

/**
 * 死锁例子
 *
 * @author purgeyao
 * @since 1.0
 */
public class ThreadDeadLock2 {

    public static Boolean result = true;

    static {
        println("static 模块");
        Thread thread = new Thread(() -> {
            println("thread run");
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    static {
//        println("static 模块");
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
////                result = false;
////                println("thread run");
//            }
//        });
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        println("main程运行");
        System.out.println(result);
    }

    private static void println(Object o) {
        System.out.printf("线程[%s] %s \n", Thread.currentThread().getName(), o);
    }
}
