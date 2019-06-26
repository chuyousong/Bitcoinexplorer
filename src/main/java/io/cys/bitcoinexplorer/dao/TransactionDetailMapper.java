package io.cys.bitcoinexplorer.dao;

import io.cys.bitcoinexplorer.dto.AddressListDto;
import io.cys.bitcoinexplorer.po.TransactionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Integer txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Integer txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    List<TransactionDetail> getListransactionDetail();

    List<AddressListDto> getListBytransactionsAddress(@Param("address") String address);
}