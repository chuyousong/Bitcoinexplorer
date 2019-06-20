package io.cys.bitcoinexplorer.service.impl;

import io.cys.bitcoinexplorer.dao.TransactionsMapper;
import io.cys.bitcoinexplorer.dto.TransactionGetListDTO;
import io.cys.bitcoinexplorer.dto.TransactionListDTO;
import io.cys.bitcoinexplorer.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsMapper transactionsMapper;

    @Override
    public List<TransactionListDTO> getListByTransactions() {
        List<TransactionListDTO> transactionsList = transactionsMapper.getTransactions();
        return transactionsList;
    }

    @Override
    public List<TransactionGetListDTO> getListBytransactionsHash(String txhash) {
        return transactionsMapper.getListBytransactionsHash(txhash);
    }

}
