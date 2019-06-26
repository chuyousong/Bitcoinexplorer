package io.cys.bitcoinexplorer.service;

import io.cys.bitcoinexplorer.dto.AddressListDto;
import io.cys.bitcoinexplorer.po.TransactionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionsDetailService {
    List<TransactionDetail> getListransactionDetail();

    List<AddressListDto> getListBytransactionsAddress(@Param("address") String address);

}

