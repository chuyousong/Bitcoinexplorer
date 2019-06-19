package io.cys.bitcoinexplorer.service;

import io.cys.bitcoinexplorer.dto.TransactionListDTO;
import io.cys.bitcoinexplorer.po.Transactions;

import java.util.List;

public interface TransactionsService {
    List<TransactionListDTO> getListByTransactions();
}
