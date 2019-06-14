package io.cys.bitcoinexplorer.dao;

import io.cys.bitcoinexplorer.po.Transactions;

public interface TransactionsMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transactions record);

    int insertSelective(Transactions record);

    Transactions selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transactions record);

    int updateByPrimaryKey(Transactions record);
}