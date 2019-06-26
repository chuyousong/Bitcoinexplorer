package io.cys.bitcoinexplorer.service;

import io.cys.bitcoinexplorer.dto.TransactionGetListDTO;
import io.cys.bitcoinexplorer.dto.TransactionListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionsService {
    List<TransactionListDTO> getListByTransactions();

    TransactionGetListDTO getListBytransactionsHash(@Param("txhash") String txhash);
}
