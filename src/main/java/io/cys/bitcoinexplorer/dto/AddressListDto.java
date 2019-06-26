package io.cys.bitcoinexplorer.dto;

import io.cys.bitcoinexplorer.po.TransactionDetail;

public class AddressListDto extends TransactionDetail {

    private Integer confirmations;

    @Override
    public Integer getConfirmations() {
        return confirmations;
    }

    @Override
    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }
}
