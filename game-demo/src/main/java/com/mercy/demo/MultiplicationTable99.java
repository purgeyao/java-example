package com.mercy.demo;

/**
 * 99乘法表
 *
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/20 19
 */
public class MultiplicationTable99 {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            System.out.println();
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d \t",i, j, i*j);
            }
        }
    }
}
