package io.cys.bitcoinexplorer.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.api.BitcoinRestApi;
import io.cys.bitcoinexplorer.dao.BlockMapper;
import io.cys.bitcoinexplorer.dao.TransactionsMapper;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.po.Block;
import io.cys.bitcoinexplorer.po.Transactions;
import io.cys.bitcoinexplorer.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionsMapper transactionsMapper;

    @Override
    @Async
    @Transactional
    public void syncBlock(String blockhash) {
        logger.info("获取 blockhash {}", blockhash);
        String tempBlockhash = blockhash;
        while (tempBlockhash != null && !tempBlockhash.isEmpty()) {
            JSONObject blockJson = bitcoinRestApi.getBlockHash(tempBlockhash);
            Block block = new Block();
            block.setBlockhash(blockJson.getString("hash"));
            block.setNumberOfTransactions(blockJson.getInteger("nTx"));
            block.setHeight(blockJson.getInteger("height"));
            Long times = blockJson.getLong("time");
            Date time = new Date(times * 1000);
            block.setTime(time);
            block.setDifficulty(blockJson.getDouble("difficulty"));
            block.setBits(blockJson.getString("bits"));
            block.setSize(blockJson.getInteger("size"));
            block.setWeight(blockJson.getFloat("weight"));
            block.setVersion(blockJson.getInteger("version"));
            block.setNonce(blockJson.getInteger("nonce"));
            block.setPreviousBlock(blockJson.getString("previousblockhash"));
            block.setNextBlock(blockJson.getString("nextblockhash"));
            Integer confirmations = blockJson.getInteger("confirmations");
            blockMapper.insert(block);

            JSONArray txesArray = blockJson.getJSONArray("tx");
            for (Object txObject : txesArray) {
                JSONObject jsonObject = new JSONObject((LinkedHashMap) txObject);
                syncTransactions(jsonObject,tempBlockhash,time,confirmations);
            }
            tempBlockhash = block.getNextBlock();
        }
        logger.info("结束同化");
    }

    @Override
    public List<BlockListDTO> getSelectListBlockhash() {

        List<BlockListDTO> blocks = blockMapper.selectBlocksList();

        return blocks;
    }

    @Override
    @Transactional
    public void syncTransactions(JSONObject txJson, String blockhash, Date time, Integer confirmations) {
        Transactions transactions = new Transactions();
        transactions.setTxhash(txJson.getString("txid"));
        transactions.setBlockhash(blockhash);
        transactions.setTime(time);
        transactions.setConfirmations(confirmations);
        transactions.setSize(txJson.getInteger("size"));
        transactions.setWeight(txJson.getFloat("weight"));
        transactionsMapper.insert(transactions);
       syncTxDetail(txJson);
    }

    @Override
    public void syncTxDetail(JSONObject txJson) {
        JSONArray vouts = txJson.getJSONArray("vout");
        syncTxDetailVout(vouts);
        JSONArray vins = txJson.getJSONArray("vin");
        syncTxDetailVin(vins);
    }

    @Override
    public void syncTxDetailVout(JSONArray vouts) {
        for (Object voutObj : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) voutObj);
        }
    }

    @Override
    public void syncTxDetailVin(JSONArray vins) {

    }
}
