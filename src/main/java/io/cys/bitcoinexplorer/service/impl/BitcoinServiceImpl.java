package io.cys.bitcoinexplorer.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.api.BitcoinRestApi;
import io.cys.bitcoinexplorer.dao.BlockMapper;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.po.Block;
import io.cys.bitcoinexplorer.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;


    @Override
    @Async
    public void syncBlock(String blockhash) {
        String tempBlockhash = blockhash;
        while (tempBlockhash != null && !tempBlockhash.isEmpty()) {
            JSONObject blockJson = bitcoinRestApi.getBlockHash(tempBlockhash);
            Block block = new Block();
            block.setBlockhash(blockJson.getString("hash"));
            block.setNumberOfTransactions(blockJson.getInteger("nTx"));
            block.setHeight(blockJson.getInteger("height"));
            Long time = blockJson.getLong("time");
            block.setTime(new Date(time * 1000));
            block.setDifficulty(blockJson.getDouble("difficulty"));
            block.setBits(blockJson.getString("bits"));
            block.setSize(blockJson.getInteger("size"));
            block.setWeight(blockJson.getFloat("weight"));
            block.setVersion(blockJson.getInteger("version"));
            block.setNonce(blockJson.getInteger("nonce"));
            block.setPreviousBlock(blockJson.getString("previousblockhash"));
            block.setNextBlock(blockJson.getString("nextblockhash"));
            blockMapper.insert(block);
            tempBlockhash = block.getNextBlock();
        }
    }

    @Override
    public List<BlockListDTO> getSelectListBlockhash() {

        List<BlockListDTO> blocks = blockMapper.selectBlocksList();

        return blocks;
    }
}
