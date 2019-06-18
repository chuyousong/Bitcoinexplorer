package io.cys.bitcoinexplorer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BlockScheduler {
    private Logger logger  = LoggerFactory.getLogger(this.getClass());
    // 定义一个定时调度器Scheduler
    @Scheduled(fixedRate = 10*60*1000)
    public void importBlockTransaction(){
        logger.info("start block data");
    }

}
