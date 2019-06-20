package io.cys.bitcoinexplorer.service;

import io.cys.bitcoinexplorer.po.TransactionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionsDetailService {
    List<TransactionDetail> getListransactionDetail();

    List<TransactionDetail> getListBytransactionsAddress(@Param("address") String address);

}

