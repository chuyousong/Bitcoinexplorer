package io.cys.bitcoinexplorer.api;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {

    JSONObject getBlockchaininfo() throws Throwable;

    JSONObject getRawTransaxtion(String txid) throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;

    Double getListunspent(String address) throws Throwable;

    String getBlockhashByHeight(Integer height) throws Throwable;

    JSONObject getAddressinfo(String address) throws Throwable;
}
