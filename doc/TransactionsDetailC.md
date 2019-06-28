## 1 获取交易记录表的详细信息

method：GET  
url: /transactionsdetail/getTransactionsDetailByList

response:
```json
 [
    {
        "txDetailId": 700006,
        "txhash": "c9dd77b87ca45c8f717cefeeee9fc4e0090cea104873a58baf379316eceae86d",
        "address": "2NDhzMt2D9ZxXapbuq567WGeWP7NuDN81cg",
        "amount": 0.39213424,
        "type": 1
    },
    {
        "txDetailId": 700007,
        "txhash": "c9dd77b87ca45c8f717cefeeee9fc4e0090cea104873a58baf379316eceae86d",
        "address": null,
        "amount": 0,
        "type": 1
    },
    {
        "txDetailId": 700008,
        "txhash": "f2581c4c21a729a095fab35d49b5bfe9e8af55dd75a233fb62e875971c6751aa",
        "address": "2NFMwN6JHRWRrdiLN3SWC3LAst3GAPJwqSU",
        "amount": 778.34202573,
        "type": 1
    },
    {
        "txDetailId": 700009,
        "txhash": "f2581c4c21a729a095fab35d49b5bfe9e8af55dd75a233fb62e875971c6751aa",
        "address": "n4PRYB1pjCWxH49QgfYoiiyKeo58A4C3bu",
        "amount": 0.0429657,
        "type": 1
    }
 ]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    tx_detail_id|   Integer |  交易记录Id |
|    txhash|   String |  交易hash |
|    address|   String |  交易地址 |
|    amount|   Double |  交易的量 |
|    type|   Integer |  交易的类型（0/1） |
  


## 2 通过Address获取交易记录的信息

method：GET  
url: /transactionsdetail/getAddressByList?address=#{address}

response:
```json
[
    {
        "txDetailId": 700012,
        "txhash": "bc1112277946b49f0aa4ae0622166b21f1c529661f8456c465af833a2fd076a5",
        "address": "mhPWNvBXWEF2kZACAZfjMa5hrqW4qKqrfw",
        "amount": 0.05037959,
        "type": 1,
        "confirmations": 102
    },
    {
        "txDetailId": 702744,
        "txhash": "be0c5113b4dfcba1ce781ce649f02a5714ab0407e190c419c4e7f3a5082c9cda",
        "address": "mhPWNvBXWEF2kZACAZfjMa5hrqW4qKqrfw",
        "amount": -0.05037959,
        "type": 0,
        "confirmations": 96
    }
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    tx_detail_id|   Integer |  交易记录Id |
|    txhash|   String |  交易hash |
|    address|   String |  交易地址 |
|    amount|   Double |  交易的量 |
|    type|   Integer |  交易的类型（0/1） |
|    confirmations|   Integer |  交易的次数 |