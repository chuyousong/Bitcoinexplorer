package io.cys.bitcoinexplorer.service;

import io.cys.bitcoinexplorer.po.Transactions;

import java.util.List;

public interface TransactionsService {
    List<Transactions> getListByTransactions();
}
