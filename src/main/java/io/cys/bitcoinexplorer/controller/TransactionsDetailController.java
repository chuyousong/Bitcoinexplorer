package io.cys.bitcoinexplorer.controller;

import io.cys.bitcoinexplorer.dto.TransactionGetListDTO;
import io.cys.bitcoinexplorer.po.TransactionDetail;
import io.cys.bitcoinexplorer.service.TransactionsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactionsdetail")
@CrossOrigin
public class TransactionsDetailController {

    @Autowired
    private TransactionsDetailService transactionsDetailService;

    // 获取交易详情表的所以数据
    @GetMapping("/getTransactionsDetailByList")
    public List<TransactionDetail> getTransactionsDetailByList(){
        List<TransactionDetail> transactionDetails = transactionsDetailService.getListransactionDetail();
        return transactionDetails;
    }

    // 通过Address查询交易详情表的所以数据
    @GetMapping("/getAddressByList")
    public List<TransactionDetail> getAddressByList(String address){
        List<TransactionDetail> transactionsAddress = transactionsDetailService.getListBytransactionsAddress(address);
        return transactionsAddress;
    }

}
