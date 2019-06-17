package io.cys.bitcoinexplorer.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {

    JSONObject getBlockchaininfo() throws Throwable;

    JSONObject getRawTransaxtion(String txid) throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;

   // Double getBalance(String address) throws Throwable;

    String getBlockhashByHeight(Integer height) throws Throwable;
}
