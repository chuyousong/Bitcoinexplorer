package io.cys.bitcoinexplorer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("io.cys.bitcoinexplorer.dao")
@EnableFeignClients("io.cys.bitcoinexplorer.api")
@EnableScheduling
public class BitcoinexplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinexplorerApplication.class, args);
    }

}
