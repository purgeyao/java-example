package com.mercy.demo.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 线程池使用
 *
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/20 19
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(java.lang.Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }

}
