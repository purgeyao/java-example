package com.purgeteam.bytecode.aspectj;

/**
 * @author purgeyao
 * @since 1.0
 */
public class Account {

    int balance = 20;

    public boolean pay(int amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
