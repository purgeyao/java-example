package com.mercy.demo.threadpool;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/30
 */
public class ScheduledThreadPoolExecutorDemo {


    @AllArgsConstructor
    private static class Task implements Runnable {

        private String name;

        @Override
        public void run() {
            try {
                System.out.println("execute:" + name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        // 创建线程池
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);

        Task task1 = new Task("Task1");
        Task task2 = new Task("Task2");

        System.out.println("The time is " + new Date());

        // 提交延迟任务
        scheduledThreadPoolExecutor.schedule(task1, 3, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.schedule(task2, 5, TimeUnit.SECONDS);


        try {
            // 阻塞当前（main）线程
            System.out.println("wait...");
            scheduledThreadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("end wait...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止线程池
        scheduledThreadPoolExecutor.shutdown();

    }
}
