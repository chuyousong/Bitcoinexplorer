## 1 获取当前最新区块

method：GET  
url: /block/getRecentBlocks

response:
```json
[
    {
        "blockhash": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
        "height": 580644,
        "time": "2019-06-15T00:26:37.349+0000",
        "relayedy": "AntPool",
        "numberOfTransactions": 2867,
        "size": 1257767
    },
    {
        "blockhash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
        "height": 580643,
        "time": "2019-06-15T00:26:37.349+0000",
        "relayedy": null,
        "numberOfTransactions": 538,
        "size": 1322496
    }
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|   Date |  出块时间 |
|    relayedy|   Short |  转播 |
|    numberOfTransactions|   Short |  交易数量 |
|    size|   Integer |  区块大小 |

  
  
## 2 根据区块hash获取区块详情

method：GET  
url: /block/getByBlockhash?blockhash={blockhash}

response:
```json
[
    {
        "blockhash": "00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951",
        "bid": 1,
        "numberOfTransactions": 2867,
        "outputTotal": 14903.18388402,
        "estimatedTransactionVolume": 1114,
        "transactionFees": 0.8105428,
        "height": 580770,
        "time": "2019-06-15T01:31:46.679+0000",
        "relayedy": "SlushPool",
        "difficulty": 7409399249090.25,
        "bits": 388365571,
        "size": 1225464,
        "weight": 3993.093,
        "version": "0x2000E000",
        "nonce": 576074419,
        "blockReward": 12.5,
        "previousBlock": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "nextBlock": null
    },
    {
        "blockhash": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "bid": 2,
        "numberOfTransactions": 538,
        "outputTotal": 1647.45939539,
        "estimatedTransactionVolume": 96,
        "transactionFees": 0.18751074,
        "height": 580769,
        "time": "2019-06-15T01:31:46.679+0000",
        "relayedy": "AntPool",
        "difficulty": 7409399249090.25,
        "bits": 388365571,
        "size": 1773224,
        "weight": 3992.765,
        "version": "0x20400000",
        "nonce": 657882304,
        "blockReward": 12.5,
        "previousBlock": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
        "nextBlock": "00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951"
    }
]

```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    numberoftransactions|   Integer |  交易的数量 |
|    outputtotal|   Double | 输出的总计 |
|    estimatedtransactionvolume|   Integer |  预估交易量 |
|    transactionfees|   Double |  交易的费用 |
|    height|   Integer |  块的高度 |
|    time|   Date |  出块时间 |
|    Relayedy|   String |  转播 |
|    difficulty|   Double |  产出矿的困难度 |
|    bits|   Integer |  矿的排位 |
|    size|   Integer |  区块大小 |
|    weight|   Float |  块的重量 |
|    version|   String |  版本 |
|    nonce|   Integer |  现时标志 |
|    blockreward|   Double |  块奖励 |
|    previousblock|   String |  以前的块 |
|    nextblock|   String |  下一个块 |
  

## 3 根据区块高度获取区块详情

method：GET  
url: /block/getByHeight?height={height}

response:
```json
 
[
    {
        "blockhash": "00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951",
        "bid": 1,
        "numberOfTransactions": 2867,
        "outputTotal": 14903.18388402,
        "estimatedTransactionVolume": 1114,
        "transactionFees": 0.8105428,
        "height": 580770,
        "time": "2019-06-15T01:35:59.816+0000",
        "relayedy": "SlushPool",
        "difficulty": 7409399249090.25,
        "bits": 388365571,
        "size": 1225464,
        "weight": 3993.093,
        "version": "0x2000E000",
        "nonce": 576074419,
        "blockReward": 12.5,
        "previousBlock": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "nextBlock": null
    },
    {
        "blockhash": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "bid": 2,
        "numberOfTransactions": 538,
        "outputTotal": 1647.45939539,
        "estimatedTransactionVolume": 96,
        "transactionFees": 0.18751074,
        "height": 580769,
        "time": "2019-06-15T01:35:59.816+0000",
        "relayedy": "AntPool",
        "difficulty": 7409399249090.25,
        "bits": 388365571,
        "size": 1773224,
        "weight": 3992.765,
        "version": "0x20400000",
        "nonce": 657882304,
        "blockReward": 12.5,
        "previousBlock": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
        "nextBlock": "00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951"
    }
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    numberoftransactions|   Integer |  交易的数量 |
|    outputtotal|   Double | 输出的总计 |
|    estimatedtransactionvolume|   Integer |  预估交易量 |
|    transactionfees|   Double |  交易的费用 |
|    height|   Integer |  块的高度 |
|    time|   Date |  出块时间 |
|    Relayedy|   String |  转播 |
|    difficulty|   Double |  产出矿的困难度 |
|    bits|   Integer |  矿的排位 |
|    size|   Integer |  区块大小 |
|    weight|   Float |  块的重量 |
|    version|   String |  版本 |
|    nonce|   Integer |  现时标志 |
|    blockreward|   Double |  块奖励 |
|    previousblock|   String |  以前的块 |
|    nextblock|   String |  下一个块 |
    



