package io.cys.bitcoinexplorer.controller;

import io.cys.bitcoinexplorer.dto.TransactionGetListDTO;
import io.cys.bitcoinexplorer.dto.TransactionListDTO;
import io.cys.bitcoinexplorer.po.Transactions;
import io.cys.bitcoinexplorer.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    // 查询交易表的详情
    @GetMapping("/transactionGetList")
    public List<TransactionListDTO>  transactionGetList(){
        List<TransactionListDTO> transactions = transactionsService.getListByTransactions();
        return transactions;
    }

    // 通过交易的hash来进行页面的详情查找
    @GetMapping("/transactionHash")
    public List<TransactionGetListDTO>  transactionHash(String txhash){
        List<TransactionGetListDTO>  transactionsHash = transactionsService.getListBytransactionsHash(txhash);
        return transactionsHash;
    }


}
