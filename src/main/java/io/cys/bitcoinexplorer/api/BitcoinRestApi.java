package io.cys.bitcoinexplorer.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BitcoinRestApi",url = "http://localhost:18332")
public interface BitcoinRestApi {

    @GetMapping("/rest/chaininfo.json")
    JSONObject getBlockChainInfo();


    @GetMapping("/rest/block/{hash}.json")
    JSONObject getBlockHash(@PathVariable String hash);

    @GetMapping("/rest/block/notxdetails/{hash}.json")
    JSONObject getBlockTxDetall(@PathVariable String hash);

    @GetMapping("/rest/headers/{count}/{hash}.json")
    JSONArray getBlockHeaders(@PathVariable Integer count, @PathVariable String hash);

    @GetMapping("/rest/tx/{hash}.json")
    JSONObject getTx(@PathVariable String hash);

    @GetMapping("/rest/blockhashbyheight/{blocks}.json")
    JSONObject getBlockByHeight(@PathVariable String blocks);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getMempoolInfo();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getContents();

    @GetMapping("/rest/getutxos/{txid}-{n}.json")
    JSONObject getUTXO(@PathVariable String txid,@PathVariable Integer n);

    @GetMapping("/rest/getutxos/checkmempool/{txid}-{n}.json")
    JSONObject getUTXOCheckMempool(@PathVariable String txid,@PathVariable Integer n);


}
