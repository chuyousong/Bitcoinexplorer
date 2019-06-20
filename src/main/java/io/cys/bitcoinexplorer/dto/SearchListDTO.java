package io.cys.bitcoinexplorer.dto;

import io.cys.bitcoinexplorer.po.Block;


import java.util.Date;

public class SearchListDTO extends  Block{

    private Integer txDetailId;

    private String txhash;

    private String address;

    private Double amount;

    private Byte type;

    private String blockhash;

    private Date time;

    private Integer size;

    private Float weight;

    private Integer confirmations;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    private Double feeperByte;

    private Double feeperWeightunit;

    private Double btctransacted;

    public Integer getTxDetailId() {
        return txDetailId;
    }

    public void setTxDetailId(Integer txDetailId) {
        this.txDetailId = txDetailId;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String getBlockhash() {
        return blockhash;
    }

    @Override
    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public Float getWeight() {
        return weight;
    }

    @Override
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
