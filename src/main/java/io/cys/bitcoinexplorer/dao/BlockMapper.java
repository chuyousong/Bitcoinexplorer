package io.cys.bitcoinexplorer.dao;

import io.cys.bitcoinexplorer.dto.BlockGetDTO;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import io.cys.bitcoinexplorer.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    Block getListByHeight(@Param("height") Integer height);

    List<BlockListDTO> getSelectListBlockhash();


}
