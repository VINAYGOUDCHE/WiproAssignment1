package com.springlab2.SpringLab2;

public class Bank {
    private int bankId;
    private String bankName;

    public Bank(int bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }
}