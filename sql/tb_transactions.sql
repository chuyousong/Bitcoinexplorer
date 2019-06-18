SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_transactions
-- ----------------------------
DROP TABLE IF EXISTS `tb_transactions`;
CREATE TABLE `tb_transactions`
(
  `txhash`  char(64) NOT NULL,
  `blockhash`  char(64) NOT NULL,
  `time`       datetime,
  `amount`    double ,
  `size`       int(20),
  `weight`     float,
  `confirmations` int(20),
  `total_input`     double ,
  `total_output`     double ,
  `fees` double,
  `feeper_byte` double,
  `feeper_weightunit` double,
  `btctransacted` double,
  PRIMARY KEY (`txhash`),
  index `idx_blockhash` (`blockhash`),
  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
