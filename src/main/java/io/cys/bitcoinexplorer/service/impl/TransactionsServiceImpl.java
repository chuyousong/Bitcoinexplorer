package io.cys.bitcoinexplorer.service.impl;

import io.cys.bitcoinexplorer.dao.TransactionsMapper;
import io.cys.bitcoinexplorer.po.Transactions;
import io.cys.bitcoinexplorer.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsMapper transactionsMapper;

    @Override
    public List<Transactions> getListByTransactions() {
        List<Transactions> transactionsList = transactionsMapper.getTransactions();
        return transactionsList;
    }
}
