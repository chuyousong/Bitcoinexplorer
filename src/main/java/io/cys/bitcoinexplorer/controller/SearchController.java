package io.cys.bitcoinexplorer.controller;

import io.cys.bitcoinexplorer.dto.TransactionGetListDTO;
import io.cys.bitcoinexplorer.po.Block;
import io.cys.bitcoinexplorer.po.TransactionDetail;
import io.cys.bitcoinexplorer.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    @Autowired
    private  BlockController blockController;

    @Autowired
    private  TransactionsController transactionsController;
    @Autowired
    private  TransactionsDetailController  transactionsDetailController;

    @GetMapping("/searchAll")
    public Object search(
            @RequestParam(required = false)String searchname) throws Throwable {
        if(searchname != null){
            // 判断height的长度
            if(searchname.length()<8){
                Block byHeight = blockController.getByHeight(Integer.parseInt(searchname));
                if(byHeight != null){
                    return byHeight;
                }
                return  byHeight;
            }
            // 判读地址的长度
            if(searchname.length()>10 && searchname.length() < 50){
                List<TransactionDetail> addressByList = transactionsDetailController.getAddressByList(searchname);
                return  addressByList;
            }
            if(searchname.length()==64){
                List<TransactionGetListDTO> transactionGetListDTOS = transactionsController.transactionHash(searchname);
                if(transactionGetListDTOS  != null){
                    return  transactionGetListDTOS;
                }
            }
        }
        return null;
    }




}
