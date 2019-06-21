package io.cys.bitcoinexplorer.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.api.BitcoinJsonRpcApi;
import io.cys.bitcoinexplorer.api.BitcoinRestApi;
import io.cys.bitcoinexplorer.dao.BlockMapper;
import io.cys.bitcoinexplorer.dao.TransactionDetailMapper;
import io.cys.bitcoinexplorer.dao.TransactionsMapper;
import io.cys.bitcoinexplorer.dto.BlockGetDTO;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.enumeration.TxDetailType;
import io.cys.bitcoinexplorer.po.Block;
import io.cys.bitcoinexplorer.po.TransactionDetail;
import io.cys.bitcoinexplorer.po.Transactions;
import io.cys.bitcoinexplorer.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @Override
    @Async
    @Transactional
    public void syncBlock(String blockhash) throws Throwable {
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
        logger.info("结束同步");
    }

    @Override
    @Transactional
    public void syncTransactions(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable {
        Transactions transactions = new Transactions();
        String txid = txJson.getString("txid");
        transactions.setTxhash(txid);
        transactions.setBlockhash(blockhash);
        transactions.setTime(time);
        transactions.setConfirmations(confirmations);
        transactions.setSize(txJson.getInteger("size"));
        transactions.setWeight(txJson.getFloat("weight"));
        transactionsMapper.insert(transactions);

        syncTxDetail(txJson,txid);
    }

    @Override
    @Transactional
    public void syncTxDetail(JSONObject txJson,String txid) throws Throwable {
        JSONArray vouts = txJson.getJSONArray("vout");
        syncTxDetailVout(vouts,txid);
        JSONArray vins = txJson.getJSONArray("vin");
        syncTxDetailVin(vins,txid);
    }

    @Override
    @Transactional
    public void syncTxDetailVout(JSONArray vouts,String txid) {
        for (Object voutObj : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) voutObj);
            TransactionDetail txDetail = new TransactionDetail();
            txDetail.setAmount(jsonObject.getDouble("value"));
            txDetail.setTxhash(txid);
            txDetail.setType((byte) TxDetailType.Receive.ordinal()); // 用枚举来展示 Type 带表 n
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray addresses = scriptPubKey.getJSONArray("addresses");
            if(addresses != null){
                txDetail.setAddress(addresses.getString(0)); // 因为addresses是数组拿取数据所以用下标
            }
            transactionDetailMapper.insert(txDetail);
        }
    }

    @Override
    @Transactional
    public void syncTxDetailVin(JSONArray vins,String txid) throws Throwable {
        for (Object vinObj : vins) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vinObj);
            String vinTxid = jsonObject.getString("txid");
            Integer n = jsonObject.getInteger("vout");

            if (vinTxid != null){
                JSONObject vinTxJson = bitcoinJsonRpcApi.getRawTransaxtion(vinTxid);
                JSONArray vouts = vinTxJson.getJSONArray("vout");
                JSONObject utxoJson = vouts.getJSONObject(n);

                TransactionDetail txDetail = new TransactionDetail();
                txDetail.setAmount(-utxoJson.getDouble("value"));
                txDetail.setTxhash(txid);
                txDetail.setType((byte) TxDetailType.Send.ordinal());
                JSONObject scriptPubKey = utxoJson.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if (addresses != null){
                    String address = addresses.getString(0);
                    txDetail.setAddress(address);
                }
                transactionDetailMapper.insert(txDetail);
            }

        }
    }








    @Override
    public List<BlockListDTO> getSelectListBlockhash() {
        return blockMapper.getSelectListBlockhash();
    }

    @Override   // 通过height来获取块的详情
    public Block getListByHeight(Integer height) {
        return blockMapper.getListByHeight(height);
    }

    @Override
    public  List<BlockGetDTO> getListByBlockhash(String blockhash) {
        return blockMapper.getListByBlockhash(blockhash);
    }


}
