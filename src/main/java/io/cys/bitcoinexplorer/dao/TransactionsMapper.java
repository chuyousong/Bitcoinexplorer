package io.cys.bitcoinexplorer.dao;

import io.cys.bitcoinexplorer.po.Transactions;

import java.util.List;

public interface TransactionsMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transactions record);

    int insertSelective(Transactions record);

    Transactions selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transactions record);

    int updateByPrimaryKey(Transactions record);

    List<Transactions> getSelectTransactions();
}