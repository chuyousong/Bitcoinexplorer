SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_block
-- ----------------------------
DROP TABLE IF EXISTS `tb_block`;
CREATE TABLE `tb_block`
(
  `blockhash`  char(64) NOT NULL,
  `number_of_transactions` int(20),
  `output_total`    double ,
  `estimated_transaction_volume` double ,
  `transaction_fees`     double ,
  `height`     int(11) NOT NULL,
  `time`       datetime,
  `relayedy`     varchar(50) ,
  `difficulty` double,
  `bits`     int(30),
  `size`       int(30),
  `weight`     float,
  `version` varchar(155),
  `nonce` int(20),
  `block_reward` double,
  `previous_block` char(64),
  `next_block` char(64),
  PRIMARY KEY (`blockhash`),
  index `idx_height` (`height`),
  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
