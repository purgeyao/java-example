package com.purge.demo.supplier;

import java.util.function.Supplier;

/**
 * {@link Supplier}
 *
 * @author purgeyao
 * @version 1.0
 * @date 2019-04-07
 */
public class SupplierDemo {


    private static void echo(String message) { // 拉的模式
        System.out.println(message);
    }

    private static void echo(Supplier<String> message) { // 推的模式
        System.out.println(message.get());
    }

    private static Supplier<String> supplierMessage() {
        return SupplierDemo::getMessage;
    }

    private static String getMessage() {
        sleep(1000);
        return "Hello,World";
    }

    /**
     * 睡眠
     *
     * @param millis 毫秒
     */
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        // 固定参数 拉
        echo("Hello,World");

        // 推
        echo(() -> {
            sleep(1000);
            return "Hello,World";
        });

        echo(SupplierDemo::getMessage);

        // 及时返回数据
        System.out.println(getMessage());

        // 待执行数据
        Supplier<String> message = supplierMessage();

        // 实际执行
        System.out.println(message.get());
    }
}
