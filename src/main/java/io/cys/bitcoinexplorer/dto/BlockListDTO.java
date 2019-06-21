package io.cys.bitcoinexplorer.dto;

import io.cys.bitcoinexplorer.po.Block;



public class BlockListDTO  {

    private String blockhash;

    private Integer height;

    private Long time;

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


    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
