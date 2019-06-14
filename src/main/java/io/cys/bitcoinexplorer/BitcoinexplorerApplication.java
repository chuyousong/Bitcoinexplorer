package io.cys.bitcoinexplorer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.cys.bitcoinexplorer.dao")
public class BitcoinexplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinexplorerApplication.class, args);
    }

}
