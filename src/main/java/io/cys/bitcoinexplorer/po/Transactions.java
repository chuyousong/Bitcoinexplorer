package io.cys.bitcoinexplorer.po;

import java.util.Date;

public class Transactions {
    private String txhash;

    private String blockhash;

    private Date time;

    private Double amount;

    private Integer size;

    private Float weight;

    private Integer confirmations;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    private Double feeperByte;

    private Double feeperWeightunit;

    private Double btctransacted;

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Double getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(Double totalInput) {
        this.totalInput = totalInput;
    }

    public Double getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(Double totalOutput) {
        this.totalOutput = totalOutput;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Double getFeeperByte() {
        return feeperByte;
    }

    public void setFeeperByte(Double feeperByte) {
        this.feeperByte = feeperByte;
    }

    public Double getFeeperWeightunit() {
        return feeperWeightunit;
    }

    public void setFeeperWeightunit(Double feeperWeightunit) {
        this.feeperWeightunit = feeperWeightunit;
    }

    public Double getBtctransacted() {
        return btctransacted;
    }

    public void setBtctransacted(Double btctransacted) {
        this.btctransacted = btctransacted;
    }
}