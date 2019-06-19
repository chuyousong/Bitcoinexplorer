package io.cys.bitcoinexplorer.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import io.cys.bitcoinexplorer.api.BitcoinJsonRpcApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Component
public class BitcoinJsonRpcApiImpl implements BitcoinJsonRpcApi {

    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoinJsonRpcApiImpl(@Value("${bitcoin.jsonrpc.username}") String username,
                                 @Value("${bitcoin.jsonrpc.password}") String password,
                                 @Value("${bitcoin.jsonrpc.url}") String url) throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s",username,password);
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url),headers);
    }

    @Override
    public JSONObject getBlockchaininfo() throws Throwable {
        JSONObject getblockchaininfo = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return getblockchaininfo;
    }

    @Override
    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        JSONObject getrawtransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return getrawtransaction;
    }

    @Override
    public JSONObject getBlockByHash(String blockhash) throws Throwable {
        JSONObject getrawtransaction = jsonRpcHttpClient.invoke("getblock", new Object[]{blockhash}, JSONObject.class);
        return getrawtransaction;
    }

    @Override
    public String getBlockhashByHeight(Integer height) throws Throwable {
        String result = jsonRpcHttpClient.invoke("getblockhash", new Object[]{height}, String.class);
        return result;
    }
// 435654322
    @Override
    public JSONObject getAddressinfo(String address) throws Throwable {
        JSONObject getblock = jsonRpcHttpClient.invoke("getaddressinfo", new Object[]{address}, JSONObject.class);
        return getblock;
    }


    @Override
    public Double getListunspent(String address) throws Throwable {
        JSONArray balances = jsonRpcHttpClient.invoke("listunspent", new Object[]{6, 999999999, new String[]{address}}, JSONArray.class);
        JSONObject jsonObject = balances.getJSONObject(0);
        Double amount = jsonObject.getDouble("amount");
        return amount;
    }


}
