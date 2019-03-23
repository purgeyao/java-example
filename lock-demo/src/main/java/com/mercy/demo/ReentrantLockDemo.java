package com.mercy.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/23
 */
@Slf4j
public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {

        // 创建自定义list
        ReentrantLockList reentrantLockList = new ReentrantLockList();

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 同时并发执行的线程数
        int threadTotal = 200;
        final Semaphore semaphore = new Semaphore(threadTotal);

        // 请求总数
        int clientTotal = 1000;
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();

                    // 添加
                    reentrantLockList.add(Thread.currentThread().getName() + " - " + String.valueOf(finalI));

                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

        System.out.println(reentrantLockList.array.size());

    }

    static class ReentrantLockList {

        /**
         * 线程不安全的list
         */
        private ArrayList<String> array = new ArrayList<>();

        /**
         * 独占锁
         */
        private volatile ReentrantLock lock = new ReentrantLock();

        /**
         * 添加元素
         *
         * @param e string
         */
        public void add(String e) {

            lock.lock();
            try {
                array.add(e);
            } finally {
                lock.unlock();
            }
        }

        /**
         * 删除元素
         *
         * @param e string
         */
        public void remove(String e) {

            lock.lock();
            try {
                array.remove(e);
            } finally {
                lock.unlock();
            }
        }

        /**
         * 获取元素
         *
         * @param index 下标
         * @return string
         */
        public String get(int index) {

            lock.lock();
            try {
                return array.get(index);
            } finally {
                lock.unlock();
            }
        }
    }


}
