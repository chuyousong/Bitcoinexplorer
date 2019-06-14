package io.cys.bitcoinexplorer.dao;

import io.cys.bitcoinexplorer.po.TransactionDetail;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Integer txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Integer txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);
}