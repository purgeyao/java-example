package com.mercy.demo;

import java.util.concurrent.*;

/**
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/22 14
 */
public class FutureTaskDemo {

//    private final static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 1L,
//            TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardPolicy());

    private final static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 1L,
            TimeUnit.MINUTES, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 添加任务one
        Future futureOne = executorService.submit(() -> {
            System.out.println("start runable one");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 添加任务two
        Future futureTwo = executorService.submit(() -> System.out.println("start runable two"));

        // 添加任务three
        Future futureThree = null;
        try {
            futureThree = executorService.submit(() -> System.out.println("start runable three"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        // 打印结果
        System.out.println("task futureOne " + futureOne.get());
        System.out.println("task futureTwo " + futureTwo.get());
        try {
            System.out.println("task futureThree " + (futureThree == null ? null : futureThree.get()));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
