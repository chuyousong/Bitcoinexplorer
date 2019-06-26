package io.cys.bitcoinexplorer.controller;

import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.api.BitcoinJsonRpcApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@CrossOrigin
public class TempRpcController {
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @GetMapping("/getInfo")
    public String getInfo() throws Throwable {
        JSONObject blockchaininfo = bitcoinJsonRpcApi.getBlockchaininfo();
        return  blockchaininfo.toJSONString();
    }


    @GetMapping("/textTransaxtion")
    public String textTransaxtion() throws Throwable {
        JSONObject curltest = bitcoinJsonRpcApi.getRawTransaxtion("e70822bf60e7b7c4f6eb5ca4c1f19e8bcf7c10f5f6981a5f205ef22c8a43abe6");
        return  curltest.toJSONString();
    }

    @GetMapping("/textByHash")
    public String textByHash() throws Throwable {
        JSONObject blockByHash = bitcoinJsonRpcApi.getBlockByHash("000000000000025f54e531a47239f394e6a7f07af3b9761f279cb86c5884d763");
        return  blockByHash.toJSONString();
    }

    @GetMapping("/textListunspent")
    public Double textListunspent() throws Throwable {
        String address = "1PGFqEzfmQch1gKD3ra4k18PNj3tTUUSqg";
        Double balanceAmount = bitcoinJsonRpcApi.getListunspent(address);
        return balanceAmount;
    }


    @GetMapping("/textByHeight")
    public String textByHeight(Integer height) throws Throwable {
        JSONObject blockByHash = bitcoinJsonRpcApi.getBlockByHash("000000000000025f54e531a47239f394e6a7f07af3b9761f279cb86c5884d763");
        return  blockByHash.toJSONString();
    }

    @GetMapping("/textAddressinfo")
    public String textAddressinfo(String address) throws Throwable {
        JSONObject addressinfo = bitcoinJsonRpcApi.getAddressinfo("1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc");
        return  addressinfo.toJSONString();
    }


}
