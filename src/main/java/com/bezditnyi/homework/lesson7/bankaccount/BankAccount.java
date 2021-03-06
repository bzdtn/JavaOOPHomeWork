package com.bezditnyi.homework.lesson7.bankaccount;

/**
 * @author Viktor Bezditnyi.
 */
public class BankAccount {

    public static void main(String... args) {
        Account account = new Account(100_000); // account changed

        for (int i = 0; i < 1000; i++) {
            Action action = new Action(account, 101); // withdraw
            action.start();
        }

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getAmount());
    }


    private static final class Action extends Thread {

        private final Account account;
        private final int withdraw;
        private final int limit = 100; // account minimal value

        public Action(Account account, int withdraw) {
            this.account = account;
            this.withdraw = withdraw;
        }

        public void run() {
            synchronized (account) {
                int amount = account.getAmount();
                if (amount >= withdraw + limit) { // amount - withdraw >= limit
                    account.setAmount(account.getAmount() - withdraw);
                }
            }
        }
    }

    private static final class Account {

        private int amount;

        public Account(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

}
