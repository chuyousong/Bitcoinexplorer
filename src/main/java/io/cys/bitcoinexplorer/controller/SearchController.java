package io.cys.bitcoinexplorer.controller;

import io.cys.bitcoinexplorer.dto.BlockGetDTO;
import io.cys.bitcoinexplorer.dto.TransactionGetListDTO;
import io.cys.bitcoinexplorer.po.Block;
import io.cys.bitcoinexplorer.po.TransactionDetail;
import io.cys.bitcoinexplorer.service.BitcoinService;
import io.cys.bitcoinexplorer.service.TransactionsDetailService;
import io.cys.bitcoinexplorer.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    @Autowired
    private  BitcoinService bitcoinService;

    @Autowired
    private TransactionsService transactionsService;
    @Autowired
    private TransactionsDetailService transactionsDetailService;

    @GetMapping("/searchAll")
    public Object search(
            @RequestParam(required = false)String searchname) throws Throwable {
        if(searchname != null){
            // 判断height的长度
            if(searchname.length()<8){
                Block byHeight = bitcoinService.getListByHeight(Integer.parseInt(searchname));
                if(byHeight != null){
                    return byHeight;
                }
                return  byHeight;
            }else if(searchname.length()>10 && searchname.length() < 50){
                // 判读地址的长度
                List<TransactionDetail> addressByList = transactionsDetailService.getListBytransactionsAddress(searchname);
                return  addressByList;
            }else if(searchname.length()==64){
                // Block 的hash
                List<BlockGetDTO> byBlockhash = bitcoinService.getListByBlockhash(searchname);
                if(byBlockhash.size() != 0){
                    return  byBlockhash;
                }
                // transactions的hash
                List<TransactionGetListDTO> transactionGetListDTOS = transactionsService.getListBytransactionsHash(searchname);
                if(transactionGetListDTOS  != null){
                    return  transactionGetListDTOS;
                }
            }
        }
        return null;
    }

}
