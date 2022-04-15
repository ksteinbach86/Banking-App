package com.techelevator.tenmo.model;

public class Account {


    int accountId;
    int userId;
    Double balance;


    public Account(int accountId, int userId, Double balance) {

        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;


    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
