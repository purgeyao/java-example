package com.purge.demo.query;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * {@link PriorityBlockingQueue} 带优先级的无界阻塞队列
 *
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/22
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {

        // 创建队列
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("taskName" + i);
            priorityBlockingQueue.add(task);
        }

        // 取出执行任务
        while (!priorityBlockingQueue.isEmpty()) {
            Task task = priorityBlockingQueue.poll();
            if (null != task) {
                task.doSomeThing();
            }
        }
    }

    @Data
    static class Task implements Comparable<Task> {

        /**
         * 优先级
         */
        private int priority = 0;


        private String taskName;

        @Override
        public int compareTo(Task o) {
            if (this.priority >= o.getPriority()) {
                return 1;
            }
            return -1;
        }

        public void doSomeThing() {
            System.out.println(taskName + ":" + priority);
        }
    }
}
