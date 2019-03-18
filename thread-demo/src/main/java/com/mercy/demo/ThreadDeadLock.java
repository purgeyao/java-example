package com.mercy.demo;

/**
 * @auther: YAO
 * @date: 2019/3/18 19:10
 */
public class ThreadDeadLock {

    public static void main(String[] args) {

        Object o1 = new Object();

        Object o2 = new Object();

        Thread thread1 = new Thread(() -> {

            synchronized (o1){
                System.out.println(Thread.currentThread() + " get o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println(Thread.currentThread() + " get o2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {

            synchronized (o2){
                System.out.println(Thread.currentThread() + " get o2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println(Thread.currentThread() + " get o1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
