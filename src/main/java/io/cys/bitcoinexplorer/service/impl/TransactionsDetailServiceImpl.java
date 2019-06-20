package io.cys.bitcoinexplorer.service.impl;

import io.cys.bitcoinexplorer.dao.TransactionDetailMapper;
import io.cys.bitcoinexplorer.po.TransactionDetail;
import io.cys.bitcoinexplorer.service.TransactionsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsDetailServiceImpl implements TransactionsDetailService {
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Override
    public List<TransactionDetail> getListransactionDetail() {
        return transactionDetailMapper.getListransactionDetail();
    }

    @Override
    public List<TransactionDetail> getListBytransactionsAddress(String address) {
        return transactionDetailMapper.getListBytransactionsAddress(address);
    }
}
