## 1 获取当前最新交易

method：GET  
url: /transactions/getTransactionsDto

response:
```json
  [
    {
        "txhash": "d4bc294c2d0ab1f17812d9ad43b5ff1720771130b84672e7e60f01fa326784ab",
        "time": "2019-06-14T18:09:38.000+0000",
        "amount": 0.00128782,
        "age": 490,
        "amountUSA": 3.8634600000000003
    }
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    txhash|   String |  交易hash |
|    time|   Date |  交易时间 |
|    amount|   String |  交易的量 |
|    age|   Double |  交易时间 |
|    amountUSA|   Integer |  交易的量转美元 |
    

## 2 获取当前最新详情交易

method：GET  
url: /transactions/transactionGetListDTO

response:
```json
 [
     {
         "txhash": "185b2b0a8f19300ed078e0a0e54a8eb2098f9644e62fdd8827d9af6b3f4caeca",
         "id": 1,
         "blockhash": "00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951",
         "time": "2019-06-17T02:22:08.772+0000",
         "amount": 0.00128782,
         "size": 592,
         "weight": 1396,
         "confirmations": 3521,
         "totalInput": 0.01700723,
         "totalOutput": 0.01673581,
         "fees": 0.00027142,
         "feeperByte": 43.707,
         "feeperWeightunit": 17.916,
         "btctransacted": 0.00109
     }
 ]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    txhash|   String |  交易hash |
|    id|   Integer |  交易编号 |
|    blockhash|   String |  块的hash Id |
|    time|   Date |  产出矿的时间 |
|    amount|   Double |  交易的量 |
|    size|   Integer |  交易的次数 |
|    weight|   Integer |  重量 |
|    confirmations|   Integer |  确认 |
|    totalinput|   Double |  总输入 |
|    totaloutput|   Double |  总输出 |
|    fees|   Double |  费用 |
|    feeperbyte|   Double |  字节费 |
|    feeperweightunit|   Double |  每磅收费 |
|    btctransacted|   Double |  估计BTC交易 |
    


## 3 通过交易的hash来进行页面的详情查找

method：GET  
url: /transactions/transactionHash?txhash=#{txhash}

response:
```json
 [
     {
    "txhash": "000937056492017ae1e12afa2a4c21a6f9870ba921111dfed28955e9d06a5650",
    "blockhash": "00000000000006fc84242689a0d1079a9f350395250c6d8971a8dd2aef73de1e",
    "time": "2019-06-24T10:42:19.000+0000",
    "amount": 0.031,
    "size": 245,
    "weight": 653,
    "confirmations": 6,
    "totalInput": -0.021,
    "totalOutput": 0.01,
    "fees": null,
    "feeperByte": null,
    "feeperWeightunit": null,
    "btctransacted": null
}
 ]
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    txhash|   String |  交易hash |
|    id|   Integer |  交易编号 |
|    blockhash|   String |  块的hash Id |
|    time|   Date |  产出矿的时间 |
|    amount|   Double |  交易的量 |
|    size|   Integer |  交易的次数 |
|    weight|   Integer |  重量 |
|    confirmations|   Integer |  确认 |
|    totalinput|   Double |  总输入 |
|    totaloutput|   Double |  总输出 |
|    fees|   Double |  费用 |
|    feeperbyte|   Double |  字节费 |
|    feeperweightunit|   Double |  每磅收费 |
|    btctransacted|   Double |  估计BTC交易 |

