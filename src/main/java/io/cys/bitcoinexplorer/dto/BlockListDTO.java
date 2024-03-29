package io.cys.bitcoinexplorer.dto;

import io.cys.bitcoinexplorer.po.Block;

import java.util.Date;

public class BlockListDTO extends Block {

    private String blockhash;

    private Integer height;

    private Date time;

    private String relayedy;

    private Integer numberOfTransactions;

    private Integer size;

    public BlockListDTO() {
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    public String getRelayedy() {
        return relayedy;
    }

    public void setRelayedy(String relayedy) {
        this.relayedy = relayedy;
    }

    public Integer getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(Integer numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
