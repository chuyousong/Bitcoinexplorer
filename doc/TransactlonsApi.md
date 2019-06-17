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
    



