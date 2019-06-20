package io.cys.bitcoinexplorer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.dto.BlockGetDTO;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.dto.SearchListDTO;
import io.cys.bitcoinexplorer.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BitcoinService {
    void syncBlock(String blockhash) throws Throwable;

    List<BlockGetDTO> getSelectListBlockhash();

    void syncTransactions(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable;

    void syncTxDetail(JSONObject txJson,String txid) throws Throwable;

    void syncTxDetailVout(JSONArray vouts,String txid);

    void syncTxDetailVin(JSONArray vins,String txid) throws Throwable;

    Block getListByHeight(@Param("height") Integer height);

    List<SearchListDTO> getSearchByTransactionDetail(@Param("height") Integer height,@Param("txhash") String txhash,@Param("address") String address);
}




