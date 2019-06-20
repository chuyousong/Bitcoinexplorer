package io.cys.bitcoinexplorer.dao;

import io.cys.bitcoinexplorer.dto.SearchListDTO;
import io.cys.bitcoinexplorer.dto.TransactionGetListDTO;
import io.cys.bitcoinexplorer.dto.TransactionListDTO;
import io.cys.bitcoinexplorer.po.Transactions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionsMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transactions record);

    int insertSelective(Transactions record);

    Transactions selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transactions record);

    int updateByPrimaryKey(Transactions record);

    List<TransactionListDTO> getTransactions();

    List<TransactionGetListDTO> getListBytransactionsHash(@Param("txhash") String txhash);
}