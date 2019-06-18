package io.cys.bitcoinexplorer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.po.Block;

import java.util.Date;
import java.util.List;

public interface BitcoinService {
    void syncBlock(String blockhash);

    List<BlockListDTO> getSelectListBlockhash();

    void syncTransactions(JSONObject txJson, String blockhash, Date time, Integer confirmations);

    void syncTxDetail(JSONObject txJson);

    void syncTxDetailVout(JSONArray vouts);

    void syncTxDetailVin(JSONArray vins);


}
