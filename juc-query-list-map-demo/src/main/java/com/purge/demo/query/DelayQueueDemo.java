package com.purge.demo.query;

import lombok.ToString;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * {@link DelayQueue} 无界阻塞延迟队列
 *
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/22
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        // 创建delay队列
        DelayQueue<DelayedEle> delayQueue = new DelayQueue<>();

        // 创建延迟任务
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            DelayedEle delayedEle = new DelayedEle(random.nextInt(500), "task:" + i);
            delayQueue.offer(delayedEle);
        }

        // 依次取出任务并打印
        DelayedEle delayedEle = null;
        try {
            // 循环，如果想避免虚假唤醒，则不能把全部元素都打印出来
            for (;;){
                // 获取过期任务并打印
                while ((delayedEle=delayQueue.take())!=null){
                    // 打印结果顺序和delay时间有关，和创建任务的顺序无关
                    System.out.println(delayedEle.toString());
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @ToString
    static class DelayedEle implements Delayed {

        /**
         * 延迟时间
         */
        private final long delayTime;

        /**
         * 到期时间
         */
        private final long expire;

        /**
         * 任务名称
         */
        private final String taskName;

        public DelayedEle(long delay, String taskName) {
            delayTime = delay;
            this.taskName = taskName;
            expire = System.currentTimeMillis() + delay;
        }


        /**
         * 剩余时间 = 到期时间 - 当前时间
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MICROSECONDS);
        }

        /**
         * 优先级队列里面的优先级规则
         */
        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MICROSECONDS) - o.getDelay(TimeUnit.MICROSECONDS));
        }

    }
}
