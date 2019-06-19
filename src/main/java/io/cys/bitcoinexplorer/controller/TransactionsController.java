package io.cys.bitcoinexplorer.controller;

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

    @GetMapping("/getTransactionsDto")
    public List<TransactionListDTO> getTransactionsDto() throws ParseException {
        ArrayList<TransactionListDTO> arrayList=new ArrayList<>();

        TransactionListDTO transactionDTO = new TransactionListDTO();
        transactionDTO.setTxhash("d4bc294c2d0ab1f17812d9ad43b5ff1720771130b84672e7e60f01fa326784ab");
        transactionDTO.setAmount(0.00128782);
        transactionDTO.setAmountUSA(0.00128782*3000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("2019-06-15 02:09:38");
        transactionDTO.setTime(parse);
        long time = new Date().getTime();
        long time1 = transactionDTO.getTime().getTime();
        long cha=time - time1;
        int zhi= (int) (cha / 1000 / 60);
        transactionDTO.setAge(zhi);
        arrayList.add(transactionDTO);
        return  arrayList;
    }



    @GetMapping("/transactionGetList")
    public List<Transactions>  transactionGetList(){
        List<Transactions> transactions = transactionsService.getListByTransactions();
        return transactions;
    }


}
