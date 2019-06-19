package io.cys.bitcoinexplorer.controller;

import io.cys.bitcoinexplorer.dao.TransactionsMapper;
import io.cys.bitcoinexplorer.dto.TransactionListDTO;
import io.cys.bitcoinexplorer.po.Transactions;
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

    @GetMapping("/transactionGetListDTO")
    public List<TransactionListDTO> transactionGetListDTO() throws ParseException {
        ArrayList<TransactionListDTO> arrayList=new ArrayList<>();
        TransactionListDTO transactionDTO = new TransactionListDTO();
        transactionDTO.setTxhash("185b2b0a8f19300ed078e0a0e54a8eb2098f9644e62fdd8827d9af6b3f4caeca");
        transactionDTO.setBlockhash("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
        transactionDTO.setId(1);
        transactionDTO.setTime(new Date());
        transactionDTO.setAmount(0.00128782);
        transactionDTO.setSize(592);
        transactionDTO.setWeight(1396);
        transactionDTO.setConfirmations(3521);
        transactionDTO.setTotalInput(0.01700723);
        transactionDTO.setTotalOutput(0.01673581);
        transactionDTO.setFees(0.00027142);
        transactionDTO.setFeeperByte(43.707 );
        transactionDTO.setFeeperWeightunit(17.916);
        transactionDTO.setBtctransacted(0.00109);
        arrayList.add(transactionDTO);
        return  arrayList;
    }

}