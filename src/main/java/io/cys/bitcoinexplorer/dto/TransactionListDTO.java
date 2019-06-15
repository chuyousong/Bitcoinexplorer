package io.cys.bitcoinexplorer.dto;

import io.cys.bitcoinexplorer.po.Transactions;

public class TransactionListDTO extends Transactions{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private double amountUSA;

    public double getAmountUSA() {
        return amountUSA;
    }

    public void setAmountUSA(double amountUSA) {
        this.amountUSA = amountUSA;
    }
}
