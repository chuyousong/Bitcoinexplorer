package io.cys.bitcoinexplorer.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import io.cys.bitcoinexplorer.api.BitcoinRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @GetMapping("/testChainInfo")
    public  String testChainInfo(){
        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        return blockChainInfo.toJSONString();
    }

    @GetMapping("/testHash")
    public String testHash(){
        JSONObject blockHash = bitcoinRestApi.getBlockHash("0000000009036d8b204e5a2fdee0cd5c8a5e44060bbde5e7d463435a1baa1cec");
        return blockHash.toJSONString();
    }

    @GetMapping("/textTxDetall")
    public  String textTxDetall(){
        JSONObject blockTxDetall = bitcoinRestApi.getBlockTxDetall("0000000009036d8b204e5a2fdee0cd5c8a5e44060bbde5e7d463435a1baa1cec");
        return blockTxDetall.toJSONString();
    }


    @GetMapping("/textHeaders")
    public JSONArray textHeaders(){
        JSONArray blockHeaders = bitcoinRestApi.getBlockHeaders(5, "000000009b952b584bfd9e5c4d99b907a3c204899dde3a9e18756c6260884f54");
        return  blockHeaders;
    }


    @GetMapping("/textTx")
    public String textTx(){
        JSONObject tx = bitcoinRestApi.getTx("1d566bbbf84e6e41016180279107b060bd6d6ef2574a7bf438f18c2272dfe8ad");
        return  tx.toJSONString();
    }

    @GetMapping("/textHeight")
    public String textHeight(){
        JSONObject blockByHeight = bitcoinRestApi.getBlockByHeight("1353854");
        return blockByHeight.toJSONString();
    }

    @GetMapping("/textMempool")
    public String textMempool(){
        JSONObject mempoolInfo = bitcoinRestApi.getMempoolInfo();
        return mempoolInfo.toJSONString();
    }

    @GetMapping("/textContents")
    public  String textContents(){
        JSONObject contents = bitcoinRestApi.getContents();
        return  contents.toJSONString();
    }


}