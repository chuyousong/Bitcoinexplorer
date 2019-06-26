package io.cys.bitcoinexplorer.controller;

import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.api.BitcoinRestApi;
import io.cys.bitcoinexplorer.dao.BlockMapper;
import io.cys.bitcoinexplorer.dto.BlockGetDTO;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.po.Block;
import io.cys.bitcoinexplorer.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
@CrossOrigin
public class BlockController {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinService bitcoinService;
    // 新增块的信息
    @GetMapping("/getRecentBlocks")
    public void getRecentBlocks() throws Throwable {
        String tempBlockhash = "0000000000000774d581b3e1f8f06882b4d03212ddb1bfdc6cc29aa6f73a7b46";
        bitcoinService.syncBlock(tempBlockhash);
    }

    // 查询块的所以详情信息
    @GetMapping("/getSelectListBlocks")
    public List<BlockListDTO> getSelectListBlocks() {
        List<BlockListDTO> seleBlock = bitcoinService.getSelectListBlockhashs();
        return seleBlock;
    }

    // 通过高度height来进行块的详细查询
    @GetMapping("/getByHeight")
    public Block getByHeight(@RequestParam Integer height){
        Block blockGetHeight = bitcoinService.getListByHeight(height);
        return blockGetHeight;
    }
    // 通过blockhash来进行块的详细查询
    @GetMapping("/getByBlockhash")
    public BlockGetDTO getByBlockhash(@RequestParam String blockhash){
        BlockGetDTO blockGetBlockhash = bitcoinService.getListByBlockhash(blockhash);
        return blockGetBlockhash;
    }
}


