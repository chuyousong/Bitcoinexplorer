package io.cys.bitcoinexplorer.controller;

import com.alibaba.fastjson.JSONObject;
import io.cys.bitcoinexplorer.api.BitcoinRestApi;
import io.cys.bitcoinexplorer.dto.BlockGetDTO;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.po.Block;
import io.cys.bitcoinexplorer.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinService bitcoinService;

    // 新增块的信息
    @GetMapping("/getRecentBlocks")
    public void getRecentBlocks() {
        String tempBlockhash = "000000000003122fadf6f79730acec77754e30a8d0faf5a609a6c5029a7ddd26";
        bitcoinService.syncBlock(tempBlockhash);
    }

    // 查询块的信息
    @GetMapping("/getSelectListBlocks")
    public List<BlockListDTO> getSelectListBlocks() {
        List<BlockListDTO> seleBlock = bitcoinService.getSelectListBlockhash();
        return seleBlock;
    }

}


