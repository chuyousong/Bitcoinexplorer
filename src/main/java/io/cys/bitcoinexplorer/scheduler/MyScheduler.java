package io.cys.bitcoinexplorer.scheduler;

import io.cys.bitcoinexplorer.controller.TransactionsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private TransactionsController transactionsController;

    @Scheduled(fixedRate = 3000)
    public void  sendData(){

        logger.info("begin to send data {}", transactionsController.transactionGetList());
        simpMessagingTemplate.convertAndSend("/mytopic/greetings",transactionsController.transactionGetList());
    }






}
