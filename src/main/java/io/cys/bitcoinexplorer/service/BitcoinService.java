package io.cys.bitcoinexplorer.service;

import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.po.Block;

import java.util.List;

public interface BitcoinService {
    void syncBlock(String blockhash);

    List<BlockListDTO> getSelectListBlockhash();
}
